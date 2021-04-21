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
        }

        private string? _projectName;

        public string? ProjectName
        {
            get => _projectName;
            set => this.RaiseAndSetIfChanged(ref _projectName, value);
        }
    }
}
