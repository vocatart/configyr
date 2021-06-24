using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace configyr.Models
{
    public class ParameterEntry
    {
        public string File { get; set; }
        public string Offset { get; set; }
        public string Overlap { get; set; }
        public string Preutterance { get; set; }
        public string Consonant { get; set; }
        public string Cutoff { get; set; }
        public string Alias { get; set; }
    }
}
