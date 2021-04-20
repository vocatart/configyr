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

        public ProjectManagerViewModel()
        {
            ProjectType = ReactiveCommand.CreateFromTask(async () =>
            {
                // get project type
                // 1 - .cfgyr (Configyr Project File)

                int projectTypeFromCombo;
            });
        }

        private string? _projectName;

        public string? ProjectName
        {
            get => _projectName;
            set => this.RaiseAndSetIfChanged(ref _projectName, value);
        }

        public ICommand ProjectType { get; }

        public string configyrProject = ".cfgyr (Configyr Project FIle)";
    }

}
