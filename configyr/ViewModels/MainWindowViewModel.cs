using System;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reactive.Concurrency;
using System.Reactive.Linq;
using System.Windows.Input;
using ReactiveUI;

namespace configyr.ViewModels
{
    public class MainWindowViewModel : ViewModelBase
    {

        public MainWindowViewModel()
        {
            ShowNewProjectDialog = new Interaction<ProjectManagerViewModel, NewProjectWindowViewModel?>();

            CreateProject = ReactiveCommand.CreateFromTask(async () =>
            {
                // Create configyr project
                var newProject = new ProjectManagerViewModel();
                var result = await ShowNewProjectDialog.Handle(newProject);
            });

            OpenProject = ReactiveCommand.Create(() =>
            { 
                // Open configyr project
            });
        }
        public ICommand CreateProject { get; }
        public ICommand OpenProject { get; }
        public Interaction<ProjectManagerViewModel, NewProjectWindowViewModel?> ShowNewProjectDialog { get; }
    }
}
