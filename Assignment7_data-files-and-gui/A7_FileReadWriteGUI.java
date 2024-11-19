import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class A7_FileReadWriteGUI extends JFrame {
    private JTextField fileNameInput, newFileNameInput;
    private JTextArea fileReadOutput, fileWritePreview;
    private JButton readButton, writeButton;
    private ArrayList<String> fileLines = new ArrayList<>();

    public A7_FileReadWriteGUI() {
        setTitle("File Reader and Writer");
        setLayout(new FlowLayout());

        // File name input field (Text Box 1) - Set to "annual.csv" by default
        fileNameInput = new JTextField("annual.csv", 20);
        fileNameInput.setToolTipText("Enter Input Filename");
        add(fileNameInput);

        // Read Button
        readButton = new JButton("Read from File");
        add(readButton);

        // File Read Output (Text Box 2) - Adjusted to show 6 lines
        fileReadOutput = new JTextArea(8, 30); // Set to 6 rows
        fileReadOutput.setEditable(false);
        add(new JScrollPane(fileReadOutput));

        // New File Name Input (Text Box 3)
        newFileNameInput = new JTextField("output.csv", 20);
        newFileNameInput.setToolTipText("Enter Output Filename");
        add(newFileNameInput);

        // Write Button
        writeButton = new JButton("Write to File");
        add(writeButton);

        // File Write Preview (Text Box 4) - Adjusted to show 6 lines
        fileWritePreview = new JTextArea(8, 30); // Set to 6 rows
        fileWritePreview.setEditable(false);
        add(new JScrollPane(fileWritePreview));

        // Add button listeners
        readButton.addActionListener(new ReadButtonListener());
        writeButton.addActionListener(new WriteButtonListener());

        // Set window size large enough to fit everything
        setSize(600, 400); // Adjusted window size to fit the content properly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Inner class to handle reading
    private class ReadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fileName = fileNameInput.getText();
            fileLines.clear();
            fileReadOutput.setText("");
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                int count = 0;
                while ((line = br.readLine()) != null && count < 5) {
                    fileLines.add(line);
                    fileReadOutput.append(line + "\n");
                    count++;
                }
            } catch (IOException ex) {
                fileReadOutput.setText("Error reading file.");
            }
        }
    }

    // Inner class to handle writing
    private class WriteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String newFileName = newFileNameInput.getText();
            fileWritePreview.setText("");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                for (String line : fileLines) {
                    // Assuming the CSV has comma-separated values
                    String[] fields = line.split(",");  // Adjust delimiter if needed
                    // Parsing the first three fields (assuming they exist)
                    if (fields.length >= 3) {
                        String parsedLine = fields[0] + "," + fields[1] + "," + fields[2];
                        bw.write(parsedLine + "\n");
                        fileWritePreview.append(parsedLine + "\n");
                    }
                }
            } catch (IOException ex) {
                fileWritePreview.setText("Error writing to file.");
            }
        }
    }

    public static void main(String[] args) {
        new A7_FileReadWriteGUI();
    }
}
