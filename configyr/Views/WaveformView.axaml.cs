using Avalonia;
using Avalonia.Controls;
using Avalonia.Markup.Xaml;

namespace configyr.Views
{
    public partial class WaveformView : UserControl
    {
        public WaveformView()
        {
            InitializeComponent();
        }

        private void InitializeComponent()
        {
            AvaloniaXamlLoader.Load(this);
        }
    }
}
