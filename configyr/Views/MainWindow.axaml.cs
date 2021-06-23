using System.Linq;
using System.Reactive;
using System.Threading.Tasks;
using Avalonia;
using Avalonia.Controls;
using Avalonia.Markup.Xaml;
using Avalonia.ReactiveUI;
using configyr.ViewModels;
using ReactiveUI;

namespace configyr.Views
{
    public class MainWindow : ReactiveWindow<MainWindowViewModel>
    {
        public MainWindow()
        {
            InitializeComponent();
#if DEBUG
            this.AttachDevTools();
#endif
            this.WhenActivated(d => d(ViewModel.ShowNewProjectDialog.RegisterHandler(DoShowDialogAsync)));

            // When the window is activated, registers a handler for the ShowOpenFileDialog interaction.
            this.WhenActivated(d => d(ViewModel.ShowOpenFileDialog.RegisterHandler(ShowOpenFileDialog)));
        }

        // async
        private async Task DoShowDialogAsync(InteractionContext<ProjectManagerViewModel, NewProjectWindowViewModel?> interaction)
        {
            var dialog = new NewProjectWindow();
            dialog.DataContext = interaction.Input;

            var result = await dialog.ShowDialog<NewProjectWindowViewModel?>(this);
            interaction.SetOutput(result);
        }

        private void InitializeComponent()
        {
            AvaloniaXamlLoader.Load(this);
        }
        private async Task ShowOpenFileDialog(InteractionContext<Unit, string?> interaction)
        {
            var dialog = new OpenFileDialog();

            // configyr project file
            dialog.Filters.Add(
                new FileDialogFilter()
                {
                    Name = "configyr project file",
                    Extensions = { "cfgyr" }
                });
            dialog.AllowMultiple = false;

            var result = await dialog.ShowAsync(this);
            interaction.SetOutput(result.FirstOrDefault());
        }
    }
}
