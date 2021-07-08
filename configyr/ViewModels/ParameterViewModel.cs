using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.Json;
using System.Text.Json.Serialization;
using configyr.Models;
using configyr.ViewModels;
using System.Collections.ObjectModel;
using System.IO;

namespace configyr.ViewModels
{
    public class ParameterViewModel
    {
        public ObservableCollection<UTAUParameterEntry> UTAUParameterEntry { get; }

        public ParameterViewModel()
        {
            MainWindowViewModel mainWindowViewModel = new MainWindowViewModel();
            string TargetFile = mainWindowViewModel.TargetFile;

            UTAUParameterEntry = new ObservableCollection<UTAUParameterEntry>(GenerateParameterTable());
        }

        public IEnumerable<UTAUParameterEntry> GenerateParameterTable()
        {
            // Get target file
            MainWindowViewModel mainWindowViewModel = new MainWindowViewModel();
            string TargetFile = mainWindowViewModel.TargetFile;
            FileData fileData = JsonSerializer.Deserialize<FileData>(TargetFile);

            // Deserialize project file
            string jsonString = File.ReadAllText(TargetFile);

            var tableParams = new List<UTAUParameterEntry>()
            {
                // Example parameter entry

                /*
                new UTAUParameterEntry()
                {
                    File = "test",
                    Offset = "100",
                    Overlap = "50",
                    Preutterance = "25",
                    Consonant = "150",
                    Cutoff = "500",
                    Alias = "ka"
                }
                */
            };
            return tableParams;
        }
    }
}
