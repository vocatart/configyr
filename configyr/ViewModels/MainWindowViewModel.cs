using System;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reactive.Concurrency;
using System.Reactive.Linq;
using System.Reactive;
using System.Threading.Tasks;
using System.Windows.Input;
using System.IO;
using ReactiveUI;
using configyr.Views;
using Avalonia.Controls;
using System.Text.Json;

namespace configyr.ViewModels
{

    public class MainWindowViewModel : ViewModelBase
    {
        private string? _targetFile;

        public MainWindowViewModel()
        {
            // Interactions for folder dialog
            ShowOpenFileDialog = new Interaction<Unit, string?>();

            // Interaction for new project dialog
            ShowNewProjectDialog = new Interaction<ProjectManagerViewModel, NewProjectWindowViewModel?>();

            CreateProject = ReactiveCommand.CreateFromTask(async () =>
            {
                // Create configyr project
                var newProject = new ProjectManagerViewModel();
                var result = await ShowNewProjectDialog.Handle(newProject);
            });

            OpenProject = ReactiveCommand.CreateFromTask(ProjectFileDialog);
        }
        public async Task ProjectFileDialog()
        {
            var result = await ShowOpenFileDialog.Handle(Unit.Default);

            if (result is object)
            {
                // Get target file
                // This file will be deserialized in WaveformWindow and ParameterWindow
                TargetFile = result;

                // Open waveform and parameter windows
                var waveformWindow = new configyr.Views.WaveformWindow();
                var parameterWindow = new configyr.Views.ParameterWindow();

                parameterWindow.DataContext = new configyr.ViewModels.ParameterViewModel();
                waveformWindow.DataContext = new configyr.ViewModels.WaveformViewModel();

                parameterWindow.Show();
                waveformWindow.Show();
            }
        }

        public ICommand CreateProject { get; }
        public ICommand OpenProject { get; }
        public Interaction<ProjectManagerViewModel, NewProjectWindowViewModel?> ShowNewProjectDialog { get; }
        public Interaction<Unit, string?> ShowOpenFileDialog { get; }
        public string? TargetFile
        {
            get => _targetFile;
            set => this.RaiseAndSetIfChanged(ref _targetFile, value);
        }
    }
}
