using Avalonia;
using Avalonia.Controls;
using Avalonia.Markup.Xaml;

namespace configyr.Views
{
    public partial class ParameterView : UserControl
    {
        public ParameterView()
        {
            InitializeComponent();
        }

        private void InitializeComponent()
        {
            AvaloniaXamlLoader.Load(this);
        }
    }
}
