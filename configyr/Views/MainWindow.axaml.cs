using System.Threading.Tasks;
using Avalonia;
using Avalonia.Controls;
using Avalonia.Markup.Xaml;
using configyr.ViewModels;
using Avalonia.ReactiveUI;
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
    }
}
