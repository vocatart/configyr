using System;
using System.Reactive.Linq;
using System.Windows.Input;
using System.IO;
using ReactiveUI;
using System.Text.Json;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Reactive;

namespace configyr.ViewModels
{

    public class FileData
    {
        public string? version { get; set; }
        public string? projectName { get; set; }
        public string? voicebankPath { get; set; }
        public string? paramFilePath { get; set; }
    }
    public class ProjectManagerViewModel : ViewModelBase
    {
        private string? _projectName;
        private string? _fullProjectName;
        private string? _projectPath;
        private string? _voicebankPath;
        private string? _paramFilePath;

        public ProjectManagerViewModel()
        {
            // Interactions for file and folder dialogs
            ShowOpenFolderDialog = new Interaction<Unit, string?>();
            ShowOpenFileDialog = new Interaction<Unit, string?>();

            // Get voicebank path from dialog
            BrowseVoicebankPath = ReactiveCommand.CreateFromTask(VoicebankPathDialog);

            // Get project path from dialog. Inherits from VoicebankPath
            BrowseProjectPath = ReactiveCommand.CreateFromTask(ProjectPathDialog);

            // Get parameter file path from dialog. Inherits from VoicebankPath + parameter file string
            BrowseParamFilePath = ReactiveCommand.CreateFromTask(ParamFileDialog);

            // Create project logic
            CreateProject = ReactiveCommand.Create(() =>
            {
                /*---------------------------
                    CONFIGYR PROJECT FILE

                File Extension - .cfgyr
                File Type - Plain Text
                File Format - JSON
                Filetype Version - 0.1.0
                ---------------------------*/

                var exceptionBox = MessageBox.Avalonia.MessageBoxManager
                .GetMessageBoxStandardWindow("Error", "One or more required parameters is empty.");

                var successfulBox = MessageBox.Avalonia.MessageBoxManager
                .GetMessageBoxStandardWindow("Project Manager", "Project Created Successfully!");

                var serializerOptions = new JsonSerializerOptions
                {
                    WriteIndented = true,
                };

                if (String.IsNullOrEmpty(ProjectName) | String.IsNullOrEmpty(ProjectPath) | String.IsNullOrEmpty(ParamFilePath))
                {
                    exceptionBox.Show();
                }
                else
                {
                    List<FileData> _fileData = new List<FileData>();
                    _fileData.Add(new FileData()
                    {
                        version = "0.1.0",
                        projectName = ProjectName,
                        voicebankPath = VoicebankPath,
                        paramFilePath = ParamFilePath
                    });

                    string json = JsonSerializer.Serialize(_fileData, serializerOptions);
                    File.WriteAllText(ProjectPath + "\\" + ProjectName + ".cfgyr", json);

                    successfulBox.Show();
                }
            });
        }

        private async Task VoicebankPathDialog()
        {
            var result = await ShowOpenFolderDialog.Handle(Unit.Default);

            if (result is object)
            {
                VoicebankPath = result;

                ParamFilePath = VoicebankPath + "\\oto.ini";
            }
        }

        private async Task ProjectPathDialog()
        {
            var result = await ShowOpenFolderDialog.Handle(Unit.Default);

            if (result is object)
            {
                ProjectPath = VoicebankPath = result;

                ParamFilePath = VoicebankPath + "\\oto.ini";
            }
        }

        private async Task ParamFileDialog()
        {
            var result = await ShowOpenFileDialog.Handle(Unit.Default);

            if (result is object)
            {
                ParamFilePath = result;
            }
        }

        public Interaction<Unit, string?> ShowOpenFileDialog { get; }
        public Interaction<Unit, string?> ShowOpenFolderDialog { get; }
        public ReactiveCommand<Unit, Unit> BrowseVoicebankPath { get; }
        public ReactiveCommand<Unit, Unit> BrowseProjectPath { get; }
        public ReactiveCommand<Unit, Unit> BrowseParamFilePath { get; }
        public ICommand CreateProject { get; }

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
