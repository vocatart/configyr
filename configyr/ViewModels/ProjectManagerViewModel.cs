using System;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reactive.Concurrency;
using System.Reactive.Linq;
using System.Windows.Input;
using ReactiveUI;

namespace configyr.ViewModels
{
    public class ProjectManagerViewModel : ViewModelBase
    {

        private string? _projectName;
        private string? _fullProjectName;
        private string? _projectPath;
        private string? _voicebankPath;
        private string? _paramFilePath;

        public ProjectManagerViewModel()
        {
        }

        public string? ProjectName
        {
            get => _projectName;
            set => this.RaiseAndSetIfChanged(ref _projectName, value);
        }

        public string? FullProjectName
        {
            get => _fullProjectName + ".cfgyr";
            set => this.RaiseAndSetIfChanged(ref _fullProjectName, value);
        }

        public string? ProjectPath
        {
            get => _projectPath;
            set => this.RaiseAndSetIfChanged(ref _projectPath, value);
        }

        public string? VoicebankPath
        {
            get => _voicebankPath;
            set => this.RaiseAndSetIfChanged(ref _voicebankPath, value);
        }

        public string? ParamFilePath
        {
            get => _paramFilePath;
            set => this.RaiseAndSetIfChanged(ref _paramFilePath, value);
        }
    }
}
