using System;
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
    public class NewProjectWindow : ReactiveWindow<ProjectManagerViewModel>
    {
        public NewProjectWindow()
        {
            InitializeComponent();
#if DEBUG
            this.AttachDevTools();
#endif
            // When the window is activated, registers a handler for the ShowOpenFileDialog interaction.
            this.WhenActivated(d => d(ViewModel.ShowOpenFolderDialog.RegisterHandler(ShowOpenFolderDialog)));
        }

        private void InitializeComponent()
        {
            AvaloniaXamlLoader.Load(this);
        }

        private async Task ShowOpenFolderDialog(InteractionContext<Unit, string?> interaction)
        {
            var dialog = new OpenFolderDialog();
            var result = await dialog.ShowAsync(this);
            interaction.SetOutput(result);
        }
    }
}
