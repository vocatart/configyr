using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace configyr.Models
{
    // UTAU Parameter Entry. UTAU-Editor style names
    public class UTAUParameterEntry
    {
        public string File { get; set; }
        public string Offset { get; set; }
        public string Overlap { get; set; }
        public string Preutterance { get; set; }
        public string Consonant { get; set; }
        public string Cutoff { get; set; }
        public string Alias { get; set; }
    }

    // Unused Parameter Entries

    // DeepVocal CV Parameter Entry
    public class DeepVocalParameterEntryCV
    {
        public string File { get; set; }
        public string ConnectPoint { get; set; }
        public string Preutterance { get; set; }
        public string VowelStartPoint { get; set; }
        public string VowelEndPoint { get; set; }
    }

    // DeepVocal Other Parameter Entry
    public class DeepVocalParameterEntryOther
    {
        public string File { get; set; }
        public string StartPoint { get; set; }
        public string EndPoint { get; set; }
    }

    // NIAONiao Parameter Entry
    public class NiaoNiaoParameterEntry
    {
        public string File { get; set; }
        public string Start { get; set; }
        public string Initial { get; set; }
        public string LastFrame { get; set; }
        public string End { get; set; }
        public string Pitch { get; set; }
        public string Volume { get; set; }
        public string VolumeChange { get; set; }
    }
}
