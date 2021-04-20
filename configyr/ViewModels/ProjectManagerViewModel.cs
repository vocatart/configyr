using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ReactiveUI;

namespace configyr.ViewModels
{
    public class ProjectManagerViewModel : ViewModelBase
    {
        private string? extension;
        private string? _projectName;

        public string? ProjectName
        {
            get => _projectName;
            set => this.RaiseAndSetIfChanged(ref _projectName, value);
        }

        public string? FullProjectName
        {
            get => _projectName;
            set => this.RaiseAndSetIfChanged(ref _projectName, value + ".cfgyr");
        }
    }

}
