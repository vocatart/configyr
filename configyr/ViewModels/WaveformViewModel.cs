using Avalonia.Controls;
using Avalonia.Input;
using configyr.Views;
using ReactiveUI;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;
using System.Drawing;
using ScottPlot.Avalonia;
using ScottPlot;
using System.IO;

namespace configyr.ViewModels
{
    public class WaveformViewModel : ViewModelBase
    {
        private readonly IView _view;
        public WaveformViewModel() { }

        public WaveformViewModel(IView view)
        {

            // waveform plot using ScottPlott. Referenced from akorin
            var waveform = ((Window)_view).Find<AvaPlot>("WaveformPlot");
            waveform.Plot.YAxis.Grid(false);
            waveform.Plot.YAxis.Ticks(false);
            waveform.Plot.XAxis.Grid(false);
            waveform.Plot.XAxis.Ticks(false);
            waveform.Plot.Frame(false);
            waveform.Plot.Layout(25, 0, 0, 0, 0);
            waveform.Configuration.Pan = false;
            waveform.Configuration.Zoom = false;
        }

        public void WavToPlot()
        {

        }
    }
}
