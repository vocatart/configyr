using Avalonia;
using Avalonia.Controls;
using Avalonia.Markup.Xaml;

namespace configyr.Views
{
    public partial class WaveformWindow : Window, IView
    {
        public WaveformWindow()
        {
            InitializeComponent();
#if DEBUG
            this.AttachDevTools();
#endif
        }

        private void InitializeComponent()
        {
            AvaloniaXamlLoader.Load(this);
        }
    }
}
