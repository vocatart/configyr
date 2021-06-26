using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.Json;
using System.Text.Json.Serialization;
using configyr.Models;
using System.Collections.ObjectModel;

namespace configyr.ViewModels
{
    public class ParameterViewModel
    {
        public ObservableCollection<UTAUParameterEntry> UTAUParameterEntry { get; }

        public ParameterViewModel()
        {
            UTAUParameterEntry = new ObservableCollection<UTAUParameterEntry>(GenerateParameterTable());
        }

        public IEnumerable<UTAUParameterEntry> GenerateParameterTable()
        {
            var tableParams = new List<UTAUParameterEntry>()
            {
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
            };
            return tableParams;
        }
    }
}
