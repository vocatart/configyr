import java.util.Scanner;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.formdev.flatlaf.FlatDarkLaf;

public class CocoaAutoOTO
{
    public static void main() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        FlatDarkLaf.install();
        JFrame frame = new JFrame("CocoaAutOTO");
        
        int otoLineCount = 0;
        String otoLine = "";
        Object[] options = {"BPM", "Custom Settings"};

        JOptionPane.showMessageDialog(frame, "Choose an OTO file to generate an OTO from.");
        JFileChooser otoChooser = new JFileChooser();
        otoChooser.showOpenDialog(frame);
        File oto = otoChooser.getSelectedFile();
        Scanner otoScanner = new Scanner(oto);

        JOptionPane.showMessageDialog(frame, "Choose an OTO file to save the generated OTO to.");
        otoChooser.showOpenDialog(frame);
        File otoDestination = otoChooser.getSelectedFile();
        FileWriter otoFileWriter = new FileWriter(otoDestination);
        PrintWriter otoWriter = new PrintWriter(otoFileWriter);

        int bpmChoice = JOptionPane.showOptionDialog(frame, "Would you like to generate the OTO based on your BPM\nor enter custom settings?"
            , "CocoaAutOTO" ,JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (bpmChoice == 1)
        {
            JTextField leftBlankModShortField = new JTextField(5);
            JTextField overlapModShortField = new JTextField(5);
            JTextField consonantModShortField = new JTextField(5);
            JTextField rightBlankModShortField = new JTextField(5);
            JTextField leftBlankModLongField = new JTextField(5);
            JTextField overlapModLongField = new JTextField(5);
            JTextField consonantModLongField = new JTextField(5);
            JTextField rightBlankModLongField = new JTextField(5);

            JPanel panel = new JPanel();
            panel.add(new JLabel("How many milliseconds before the preutterance the left blank should be for a short consonant:"));
            panel.add(leftBlankModShortField);

            panel.add(Box.createVerticalStrut(15));
            panel.add(new JLabel("\nHow many milliseconds before the preutterance the overlap should be for a short consonant:"));
            panel.add(overlapModShortField);

            panel.add(Box.createVerticalStrut(15));
            panel.add(new JLabel("How many milliseconds after the preutterance the consonant should be for a short consonant:"));
            panel.add(consonantModShortField);

            panel.add(Box.createVerticalStrut(15));
            panel.add(new JLabel("How many milliseconds after the preutterance the right blank should be for a short consonant:"));
            panel.add(rightBlankModShortField);

            panel.add(Box.createVerticalStrut(15));
            panel.add(new JLabel("How many milliseconds before the preutterance the left blank should be for a long consonant:"));
            panel.add(leftBlankModLongField);

            panel.add(Box.createVerticalStrut(15));
            panel.add(new JLabel("How many milliseconds before the preutterance the overlap should be for a long consonant:"));
            panel.add(overlapModLongField);

            panel.add(Box.createVerticalStrut(15));
            panel.add(new JLabel("How many milliseconds after the preutterance the consonant should be for a long consonant:"));
            panel.add(consonantModLongField);

            panel.add(Box.createVerticalStrut(15));
            panel.add(new JLabel("How many milliseconds after the preutterance the right blank should be for a long consonant:"));
            panel.add(rightBlankModLongField);

            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "CocoaAutOTO", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION)
            {
                while(otoScanner.hasNextLine())
                {
                    otoLine = otoScanner.nextLine();

                    String[] otoEqualSplit = otoLine.split("=");
                    String[] otoCommaSplit = otoEqualSplit[1].split(",");
                    if (otoCommaSplit[0].contains("\u3055") || otoCommaSplit[0].contains("\u3056") || otoCommaSplit[0].contains("\u3057")
                    || otoCommaSplit[0].contains("\u3058") || otoCommaSplit[0].contains("\u3059") || otoCommaSplit[0].contains("\u305A")
                    || otoCommaSplit[0].contains("\u305B") || otoCommaSplit[0].contains("\u305C") || otoCommaSplit[0].contains("\u305D")
                    || otoCommaSplit[0].contains("\u305E") || otoCommaSplit[0].contains("\u306A") || otoCommaSplit[0].contains("\u306B")
                    || otoCommaSplit[0].contains("\u306C") || otoCommaSplit[0].contains("\u306D") || otoCommaSplit[0].contains("\u306E")
                    || otoCommaSplit[0].contains("\u306F") || otoCommaSplit[0].contains("\u3072") || otoCommaSplit[0].contains("\u3075")
                    || otoCommaSplit[0].contains("\u3078") || otoCommaSplit[0].contains("\u307B") || otoCommaSplit[0].contains("\u307E")
                    || otoCommaSplit[0].contains("\u307F") || otoCommaSplit[0].contains("\u3080") || otoCommaSplit[0].contains("\u3081")
                    || otoCommaSplit[0].contains("\u3082") || otoCommaSplit[0].contains("\u3083") || otoCommaSplit[0].contains("\u3084")
                    || otoCommaSplit[0].contains("\u3085") || otoCommaSplit[0].contains("\u3086") || otoCommaSplit[0].contains("\u3087")
                    || otoCommaSplit[0].contains("\u3088") || otoCommaSplit[0].contains("\u308E") || otoCommaSplit[0].contains("\u308F")
                    || otoCommaSplit[0].contains("\u3090") || otoCommaSplit[0].contains("\u3091") || otoCommaSplit[0].contains("\u3092")
                    || otoCommaSplit[0].contains("\u3094") || otoCommaSplit[0].contains("\u30B5") || otoCommaSplit[0].contains("\u30B6")
                    || otoCommaSplit[0].contains("\u30B7") || otoCommaSplit[0].contains("\u30B8") || otoCommaSplit[0].contains("\u30B9")
                    || otoCommaSplit[0].contains("\u30BA") || otoCommaSplit[0].contains("\u30BB") || otoCommaSplit[0].contains("\u30BC")
                    || otoCommaSplit[0].contains("\u30BD") || otoCommaSplit[0].contains("\u30BE") || otoCommaSplit[0].contains("\u30CA")
                    || otoCommaSplit[0].contains("\u30CB") || otoCommaSplit[0].contains("\u30CC") || otoCommaSplit[0].contains("\u30CD")
                    || otoCommaSplit[0].contains("\u30CE") || otoCommaSplit[0].contains("\u30CF") || otoCommaSplit[0].contains("\u30D2")
                    || otoCommaSplit[0].contains("\u30D5") || otoCommaSplit[0].contains("\u30D8") || otoCommaSplit[0].contains("\u30DB")
                    || otoCommaSplit[0].contains("\u30DE") || otoCommaSplit[0].contains("\u30DF") || otoCommaSplit[0].contains("\u30E0")
                    || otoCommaSplit[0].contains("\u30E1") || otoCommaSplit[0].contains("\u30E2") || otoCommaSplit[0].contains("\u30E3")
                    || otoCommaSplit[0].contains("\u30E4") || otoCommaSplit[0].contains("\u30E5") || otoCommaSplit[0].contains("\u30E6")
                    || otoCommaSplit[0].contains("\u30E7") || otoCommaSplit[0].contains("\u30E8") || otoCommaSplit[0].contains("\u30EE")
                    || otoCommaSplit[0].contains("\u30EF") || otoCommaSplit[0].contains("\u30F0") || otoCommaSplit[0].contains("\u30F1")
                    || otoCommaSplit[0].contains("\u30F2") || otoCommaSplit[0].contains("\u30F3") || otoCommaSplit[0].contains("\u30F4")
                    || otoCommaSplit[0].contains("\u30F5") || otoCommaSplit[0].contains("\u30F6") || otoCommaSplit[0].contains("\u30F7")
                    || otoCommaSplit[0].contains("\u30F8") || otoCommaSplit[0].contains("\u30F9") || otoCommaSplit[0].contains("\u30FA")
                    || otoCommaSplit[0].contains("\u30AC") || otoCommaSplit[0].contains("\u30AE") || otoCommaSplit[0].contains("\u30B0")
                    || otoCommaSplit[0].contains("\u30B2") || otoCommaSplit[0].contains("\u30B4") || otoCommaSplit[0].contains("l")
                    || otoCommaSplit[0].contains("m") || otoCommaSplit[0].contains("n") || otoCommaSplit[0].contains("w")
                    || otoCommaSplit[0].contains("y") || otoCommaSplit[0].contains("h") || otoCommaSplit[0].contains("ch")
                    || otoCommaSplit[0].contains("sh") || otoCommaSplit[0].contains("my") || otoCommaSplit[0].contains("ny")
                    || otoCommaSplit[0].contains("ry") || otoCommaSplit[0].contains("ky") || otoCommaSplit[0].contains("gy")
                    || otoCommaSplit[0].contains("by") || otoCommaSplit[0].contains("py") || otoCommaSplit[0].contains("hy")
                    || otoCommaSplit[0].contains("ty") || otoCommaSplit[0].contains("dy") || otoCommaSplit[0].contains("fy")
                    || otoCommaSplit[0].contains("f") || otoCommaSplit[0].contains("ng") || otoCommaSplit[0].contains("j")
                    || otoCommaSplit[0].contains("ts") || otoCommaSplit[0].contains("s") || otoCommaSplit[0].contains("z")
                    || otoCommaSplit[0].contains("zh") || otoCommaSplit[0].contains("v"))
                    {
                        int leftBlankMod = Integer.parseInt(leftBlankModLongField.getText());
                        int overlapMod = Integer.parseInt(overlapModLongField.getText());
                        int consonantMod = Integer.parseInt(consonantModLongField.getText());
                        int rightBlankMod = Integer.parseInt(rightBlankModLongField.getText());

                        double tempPreutt = Double.parseDouble(otoCommaSplit[4]);

                        int preutt = (int) tempPreutt;

                        double tempLeftBlank = Double.parseDouble(otoCommaSplit[1]);

                        int leftBlank = (int) tempLeftBlank;

                        otoCommaSplit[1] = String.valueOf((preutt + leftBlank) - leftBlankMod);

                        int tempTempLeftBlank = Integer.parseInt(otoCommaSplit[1]);

                        preutt = preutt + (leftBlank - tempTempLeftBlank);

                        otoCommaSplit[2] = String.valueOf(preutt + consonantMod);

                        otoCommaSplit[3] = String.valueOf(-(preutt + rightBlankMod));

                        otoCommaSplit[5] = String.valueOf(preutt - overlapMod);

                        String finalOtoLine = otoEqualSplit[0] + "=" + otoCommaSplit[0]
                            + "," + otoCommaSplit[1] + "," + otoCommaSplit[2] + ","
                            + otoCommaSplit[3] + "," + preutt + "," + otoCommaSplit[5]; 

                        otoWriter.print(finalOtoLine + "\n");
                        otoWriter.close();
                    }

                    else if (otoCommaSplit[0].contains("\u304B") || otoCommaSplit[0].contains("\u304C") || otoCommaSplit[0].contains("\u304D")
                    || otoCommaSplit[0].contains("\u304E") || otoCommaSplit[0].contains("\u304F") || otoCommaSplit[0].contains("\u3050")
                    || otoCommaSplit[0].contains("\u3051") || otoCommaSplit[0].contains("\u3052") || otoCommaSplit[0].contains("\u3053")
                    || otoCommaSplit[0].contains("\u3054") || otoCommaSplit[0].contains("\u305F") || otoCommaSplit[0].contains("\u3060")
                    || otoCommaSplit[0].contains("\u3061") || otoCommaSplit[0].contains("\u3062") || otoCommaSplit[0].contains("\u3063")
                    || otoCommaSplit[0].contains("\u3064") || otoCommaSplit[0].contains("\u3065") || otoCommaSplit[0].contains("\u3066")
                    || otoCommaSplit[0].contains("\u3067") || otoCommaSplit[0].contains("\u3068") || otoCommaSplit[0].contains("\u3069")
                    || otoCommaSplit[0].contains("\u3070") || otoCommaSplit[0].contains("\u3071") || otoCommaSplit[0].contains("\u3073")
                    || otoCommaSplit[0].contains("\u3074") || otoCommaSplit[0].contains("\u3076") || otoCommaSplit[0].contains("\u3077")
                    || otoCommaSplit[0].contains("\u3079") || otoCommaSplit[0].contains("\u307A") || otoCommaSplit[0].contains("\u307C")
                    || otoCommaSplit[0].contains("\u307D") || otoCommaSplit[0].contains("\u3089") || otoCommaSplit[0].contains("\u308A")
                    || otoCommaSplit[0].contains("\u308B") || otoCommaSplit[0].contains("\u308C") || otoCommaSplit[0].contains("\u308D")
                    || otoCommaSplit[0].contains("\u3093") || otoCommaSplit[0].contains("\u30AB") || otoCommaSplit[0].contains("\u30AD")
                    || otoCommaSplit[0].contains("\u30AF") || otoCommaSplit[0].contains("\u30B1") || otoCommaSplit[0].contains("\u30B3")
                    || otoCommaSplit[0].contains("\u30BF") || otoCommaSplit[0].contains("\u30C0") || otoCommaSplit[0].contains("\u30C1")
                    || otoCommaSplit[0].contains("\u30C2") || otoCommaSplit[0].contains("\u30C3") || otoCommaSplit[0].contains("\u30C4")
                    || otoCommaSplit[0].contains("\u30C5") || otoCommaSplit[0].contains("\u30C6") || otoCommaSplit[0].contains("\u30C7")
                    || otoCommaSplit[0].contains("\u30C8") || otoCommaSplit[0].contains("\u30C9") || otoCommaSplit[0].contains("\u30D0")
                    || otoCommaSplit[0].contains("\u30D1") || otoCommaSplit[0].contains("\u30D3") || otoCommaSplit[0].contains("\u30D4")
                    || otoCommaSplit[0].contains("\u30D6") || otoCommaSplit[0].contains("\u30D7") || otoCommaSplit[0].contains("\u30D9")
                    || otoCommaSplit[0].contains("\u30DA") || otoCommaSplit[0].contains("\u30DC") || otoCommaSplit[0].contains("\u30DD")
                    || otoCommaSplit[0].contains("\u30E9") || otoCommaSplit[0].contains("\u30EA") || otoCommaSplit[0].contains("\u30EB")
                    || otoCommaSplit[0].contains("\u30EC") || otoCommaSplit[0].contains("\u30ED") || otoCommaSplit[0].contains("k")
                    || otoCommaSplit[0].contains("t") || otoCommaSplit[0].contains("p") || otoCommaSplit[0].contains("g")
                    || otoCommaSplit[0].contains("d") || otoCommaSplit[0].contains("b") || otoCommaSplit[0].contains("r"))
                    {
                        int leftBlankMod = Integer.parseInt(leftBlankModShortField.getText());
                        int overlapMod = Integer.parseInt(overlapModShortField.getText());
                        int consonantMod = Integer.parseInt(consonantModShortField.getText());
                        int rightBlankMod = Integer.parseInt(rightBlankModShortField.getText());

                        double tempPreutt = Double.parseDouble(otoCommaSplit[4]);

                        int preutt = (int) tempPreutt;

                        double tempLeftBlank = Double.parseDouble(otoCommaSplit[1]);

                        int leftBlank = (int) tempLeftBlank;

                        otoCommaSplit[1] = String.valueOf((preutt + leftBlank) - leftBlankMod);

                        int tempTempLeftBlank = Integer.parseInt(otoCommaSplit[1]);

                        preutt = preutt + (leftBlank - tempTempLeftBlank);

                        otoCommaSplit[2] = String.valueOf(preutt + consonantMod);

                        otoCommaSplit[3] = String.valueOf(-(preutt + rightBlankMod));

                        otoCommaSplit[5] = String.valueOf(preutt - overlapMod);

                        String finalOtoLine = otoEqualSplit[0] + "=" + otoCommaSplit[0]
                            + "," + otoCommaSplit[1] + "," + otoCommaSplit[2] + ","
                            + otoCommaSplit[3] + "," + preutt + "," + otoCommaSplit[5]; 

                        otoWriter.print(finalOtoLine + "\n");
                        otoWriter.close();
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(frame, "No valid consonant was detected!");
                    }
                }
            }
        }

        if (bpmChoice == 0)
        {
            JTextField bpmField = new JTextField(5);

            JPanel panel = new JPanel();
            panel.add(new JLabel("BPM:"));
            panel.add(bpmField);

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "CocoaAutOTO", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION)
            {
                while (otoScanner.hasNextLine())
                {
                    otoLine = otoScanner.nextLine();

                    String[] otoEqualSplit = otoLine.split("=");
                    String[] otoCommaSplit = otoEqualSplit[1].split(",");
                    if (otoCommaSplit[0].contains("\u3055") || otoCommaSplit[0].contains("\u3056") || otoCommaSplit[0].contains("\u3057")
                    || otoCommaSplit[0].contains("\u3058") || otoCommaSplit[0].contains("\u3059") || otoCommaSplit[0].contains("\u305A")
                    || otoCommaSplit[0].contains("\u305B") || otoCommaSplit[0].contains("\u305C") || otoCommaSplit[0].contains("\u305D")
                    || otoCommaSplit[0].contains("\u305E") || otoCommaSplit[0].contains("\u306A") || otoCommaSplit[0].contains("\u306B")
                    || otoCommaSplit[0].contains("\u306C") || otoCommaSplit[0].contains("\u306D") || otoCommaSplit[0].contains("\u306E")
                    || otoCommaSplit[0].contains("\u306F") || otoCommaSplit[0].contains("\u3072") || otoCommaSplit[0].contains("\u3075")
                    || otoCommaSplit[0].contains("\u3078") || otoCommaSplit[0].contains("\u307B") || otoCommaSplit[0].contains("\u307E")
                    || otoCommaSplit[0].contains("\u307F") || otoCommaSplit[0].contains("\u3080") || otoCommaSplit[0].contains("\u3081")
                    || otoCommaSplit[0].contains("\u3082") || otoCommaSplit[0].contains("\u3083") || otoCommaSplit[0].contains("\u3084")
                    || otoCommaSplit[0].contains("\u3085") || otoCommaSplit[0].contains("\u3086") || otoCommaSplit[0].contains("\u3087")
                    || otoCommaSplit[0].contains("\u3088") || otoCommaSplit[0].contains("\u308E") || otoCommaSplit[0].contains("\u308F")
                    || otoCommaSplit[0].contains("\u3090") || otoCommaSplit[0].contains("\u3091") || otoCommaSplit[0].contains("\u3092")
                    || otoCommaSplit[0].contains("\u3094") || otoCommaSplit[0].contains("\u30B5") || otoCommaSplit[0].contains("\u30B6")
                    || otoCommaSplit[0].contains("\u30B7") || otoCommaSplit[0].contains("\u30B8") || otoCommaSplit[0].contains("\u30B9")
                    || otoCommaSplit[0].contains("\u30BA") || otoCommaSplit[0].contains("\u30BB") || otoCommaSplit[0].contains("\u30BC")
                    || otoCommaSplit[0].contains("\u30BD") || otoCommaSplit[0].contains("\u30BE") || otoCommaSplit[0].contains("\u30CA")
                    || otoCommaSplit[0].contains("\u30CB") || otoCommaSplit[0].contains("\u30CC") || otoCommaSplit[0].contains("\u30CD")
                    || otoCommaSplit[0].contains("\u30CE") || otoCommaSplit[0].contains("\u30CF") || otoCommaSplit[0].contains("\u30D2")
                    || otoCommaSplit[0].contains("\u30D5") || otoCommaSplit[0].contains("\u30D8") || otoCommaSplit[0].contains("\u30DB")
                    || otoCommaSplit[0].contains("\u30DE") || otoCommaSplit[0].contains("\u30DF") || otoCommaSplit[0].contains("\u30E0")
                    || otoCommaSplit[0].contains("\u30E1") || otoCommaSplit[0].contains("\u30E2") || otoCommaSplit[0].contains("\u30E3")
                    || otoCommaSplit[0].contains("\u30E4") || otoCommaSplit[0].contains("\u30E5") || otoCommaSplit[0].contains("\u30E6")
                    || otoCommaSplit[0].contains("\u30E7") || otoCommaSplit[0].contains("\u30E8") || otoCommaSplit[0].contains("\u30EE")
                    || otoCommaSplit[0].contains("\u30EF") || otoCommaSplit[0].contains("\u30F0") || otoCommaSplit[0].contains("\u30F1")
                    || otoCommaSplit[0].contains("\u30F2") || otoCommaSplit[0].contains("\u30F3") || otoCommaSplit[0].contains("\u30F4")
                    || otoCommaSplit[0].contains("\u30F5") || otoCommaSplit[0].contains("\u30F6") || otoCommaSplit[0].contains("\u30F7")
                    || otoCommaSplit[0].contains("\u30F8") || otoCommaSplit[0].contains("\u30F9") || otoCommaSplit[0].contains("\u30FA")
                    || otoCommaSplit[0].contains("\u30AC") || otoCommaSplit[0].contains("\u30AE") || otoCommaSplit[0].contains("\u30B0")
                    || otoCommaSplit[0].contains("\u30B2") || otoCommaSplit[0].contains("\u30B4") || otoCommaSplit[0].contains("l")
                    || otoCommaSplit[0].contains("m") || otoCommaSplit[0].contains("n") || otoCommaSplit[0].contains("w")
                    || otoCommaSplit[0].contains("y") || otoCommaSplit[0].contains("h") || otoCommaSplit[0].contains("ch")
                    || otoCommaSplit[0].contains("sh") || otoCommaSplit[0].contains("my") || otoCommaSplit[0].contains("ny")
                    || otoCommaSplit[0].contains("ry") || otoCommaSplit[0].contains("ky") || otoCommaSplit[0].contains("gy")
                    || otoCommaSplit[0].contains("by") || otoCommaSplit[0].contains("py") || otoCommaSplit[0].contains("hy")
                    || otoCommaSplit[0].contains("ty") || otoCommaSplit[0].contains("dy") || otoCommaSplit[0].contains("fy")
                    || otoCommaSplit[0].contains("f") || otoCommaSplit[0].contains("ng") || otoCommaSplit[0].contains("j")
                    || otoCommaSplit[0].contains("ts") || otoCommaSplit[0].contains("s") || otoCommaSplit[0].contains("z")
                    || otoCommaSplit[0].contains("zh") || otoCommaSplit[0].contains("v"))
                    {
                        int bpm = Integer.parseInt(bpmField.getText());
                        int leftBlankMod = (bpm / 120) * 50;
                        int overlapMod = (bpm / 120) * 25;
                        int consonantMod = (bpm / 120) * 75;
                        int rightBlankMod = (bpm / 120) * 350;

                        double tempPreutt = Double.parseDouble(otoCommaSplit[4]);

                        int preutt = (int) tempPreutt;

                        double tempLeftBlank = Double.parseDouble(otoCommaSplit[1]);

                        int leftBlank = (int) tempLeftBlank;

                        otoCommaSplit[1] = String.valueOf((preutt + leftBlank) - leftBlankMod);

                        int tempTempLeftBlank = Integer.parseInt(otoCommaSplit[1]);

                        preutt = preutt + (leftBlank - tempTempLeftBlank);

                        otoCommaSplit[2] = String.valueOf(preutt + consonantMod);

                        otoCommaSplit[3] = String.valueOf(-(preutt + rightBlankMod));

                        otoCommaSplit[5] = String.valueOf(preutt - overlapMod);

                        String finalOtoLine = otoEqualSplit[0] + "=" + otoCommaSplit[0]
                            + "," + otoCommaSplit[1] + "," + otoCommaSplit[2] + ","
                            + otoCommaSplit[3] + "," + preutt + "," + otoCommaSplit[5]; 

                        otoWriter.print(finalOtoLine + "\n");
                        otoWriter.close();
                    }

                    else if (otoCommaSplit[0].contains("\u304B") || otoCommaSplit[0].contains("\u304C") || otoCommaSplit[0].contains("\u304D")
                    || otoCommaSplit[0].contains("\u304E") || otoCommaSplit[0].contains("\u304F") || otoCommaSplit[0].contains("\u3050")
                    || otoCommaSplit[0].contains("\u3051") || otoCommaSplit[0].contains("\u3052") || otoCommaSplit[0].contains("\u3053")
                    || otoCommaSplit[0].contains("\u3054") || otoCommaSplit[0].contains("\u305F") || otoCommaSplit[0].contains("\u3060")
                    || otoCommaSplit[0].contains("\u3061") || otoCommaSplit[0].contains("\u3062") || otoCommaSplit[0].contains("\u3063")
                    || otoCommaSplit[0].contains("\u3064") || otoCommaSplit[0].contains("\u3065") || otoCommaSplit[0].contains("\u3066")
                    || otoCommaSplit[0].contains("\u3067") || otoCommaSplit[0].contains("\u3068") || otoCommaSplit[0].contains("\u3069")
                    || otoCommaSplit[0].contains("\u3070") || otoCommaSplit[0].contains("\u3071") || otoCommaSplit[0].contains("\u3073")
                    || otoCommaSplit[0].contains("\u3074") || otoCommaSplit[0].contains("\u3076") || otoCommaSplit[0].contains("\u3077")
                    || otoCommaSplit[0].contains("\u3079") || otoCommaSplit[0].contains("\u307A") || otoCommaSplit[0].contains("\u307C")
                    || otoCommaSplit[0].contains("\u307D") || otoCommaSplit[0].contains("\u3089") || otoCommaSplit[0].contains("\u308A")
                    || otoCommaSplit[0].contains("\u308B") || otoCommaSplit[0].contains("\u308C") || otoCommaSplit[0].contains("\u308D")
                    || otoCommaSplit[0].contains("\u3093") || otoCommaSplit[0].contains("\u30AB") || otoCommaSplit[0].contains("\u30AD")
                    || otoCommaSplit[0].contains("\u30AF") || otoCommaSplit[0].contains("\u30B1") || otoCommaSplit[0].contains("\u30B3")
                    || otoCommaSplit[0].contains("\u30BF") || otoCommaSplit[0].contains("\u30C0") || otoCommaSplit[0].contains("\u30C1")
                    || otoCommaSplit[0].contains("\u30C2") || otoCommaSplit[0].contains("\u30C3") || otoCommaSplit[0].contains("\u30C4")
                    || otoCommaSplit[0].contains("\u30C5") || otoCommaSplit[0].contains("\u30C6") || otoCommaSplit[0].contains("\u30C7")
                    || otoCommaSplit[0].contains("\u30C8") || otoCommaSplit[0].contains("\u30C9") || otoCommaSplit[0].contains("\u30D0")
                    || otoCommaSplit[0].contains("\u30D1") || otoCommaSplit[0].contains("\u30D3") || otoCommaSplit[0].contains("\u30D4")
                    || otoCommaSplit[0].contains("\u30D6") || otoCommaSplit[0].contains("\u30D7") || otoCommaSplit[0].contains("\u30D9")
                    || otoCommaSplit[0].contains("\u30DA") || otoCommaSplit[0].contains("\u30DC") || otoCommaSplit[0].contains("\u30DD")
                    || otoCommaSplit[0].contains("\u30E9") || otoCommaSplit[0].contains("\u30EA") || otoCommaSplit[0].contains("\u30EB")
                    || otoCommaSplit[0].contains("\u30EC") || otoCommaSplit[0].contains("\u30ED") || otoCommaSplit[0].contains("k")
                    || otoCommaSplit[0].contains("t") || otoCommaSplit[0].contains("p") || otoCommaSplit[0].contains("g")
                    || otoCommaSplit[0].contains("d") || otoCommaSplit[0].contains("b") || otoCommaSplit[0].contains("r"))
                    {
                        int bpm = Integer.parseInt(bpmField.getText());
                        int leftBlankMod = (bpm / 120) * 50;
                        int overlapMod = (bpm / 120) * 25;
                        int consonantMod = (bpm / 120) * 75;
                        int rightBlankMod = (bpm / 120) * 350;

                        double tempPreutt = Double.parseDouble(otoCommaSplit[4]);

                        int preutt = (int) tempPreutt;

                        double tempLeftBlank = Double.parseDouble(otoCommaSplit[1]);

                        int leftBlank = (int) tempLeftBlank;

                        otoCommaSplit[1] = String.valueOf((preutt + leftBlank) - leftBlankMod);

                        int tempTempLeftBlank = Integer.parseInt(otoCommaSplit[1]);

                        preutt = preutt + (leftBlank - tempTempLeftBlank);

                        otoCommaSplit[2] = String.valueOf(preutt + consonantMod);

                        otoCommaSplit[3] = String.valueOf(-(preutt + rightBlankMod));

                        otoCommaSplit[5] = String.valueOf(preutt - overlapMod);

                        String finalOtoLine = otoEqualSplit[0] + "=" + otoCommaSplit[0]
                            + "," + otoCommaSplit[1] + "," + otoCommaSplit[2] + ","
                            + otoCommaSplit[3] + "," + preutt + "," + otoCommaSplit[5]; 

                        otoWriter.print(finalOtoLine + "\n");
                        otoWriter.close();
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(frame, "No valid consonant was detected!");
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(frame, "Done!");
        otoScanner.close();
    }

    public static void calculate(String otoLine, int leftBlankMod, int overlapMod, int consonantMod, int rightBlankMod) throws IOException
    {

    }
}
