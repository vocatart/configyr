using System;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reactive.Concurrency;
using System.Reactive.Linq;
using System.Windows.Input;
using System.IO;
using ReactiveUI;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Collections.Generic;

namespace configyr.ViewModels
{
    public class FileData
    {
        public string version { get; set; }
        public string projectName { get; set; }
        public string voicebankPath { get; set; }
        public string paramFilePath { get; set; }
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
            BrowseProjectPath = ReactiveCommand.Create(() =>
            {
                // get project path from a dialog
            });

            BrowseVoicebankPath = ReactiveCommand.Create(() =>
            {
                // get voicebank path from a dialog
            });

            BrowseParamFilePath = ReactiveCommand.Create(() =>
            {
                // get parameter file path from dialog
            });

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
                    File.WriteAllText(ProjectName + ".cfgyr", json);

                    successfulBox.Show();
                }
            });
        }

        public ICommand BrowseProjectPath { get; }
        public ICommand BrowseVoicebankPath { get; }
        public ICommand BrowseParamFilePath { get; }
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
