import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A6_WeightedGradesGUI extends JFrame {

    private JTextField totalPointsField;
    private JTextField earnedPointsField;
    private JTextField percentageField;
    private JLabel weightedScoreLabel;

    public A6_WeightedGradesGUI() {
        // Set up the frame
        setTitle("Weighted Grades Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Use GridBagLayout for better control of spacing

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around elements

        // Add input labels and fields
        JLabel totalPointsLabel = new JLabel("Total Points:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(totalPointsLabel, gbc);

        totalPointsField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(totalPointsField, gbc);

        JLabel earnedPointsLabel = new JLabel("Earned Points:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(earnedPointsLabel, gbc);

        earnedPointsField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(earnedPointsField, gbc);

        JLabel percentageLabel = new JLabel("Percentage (without % sign):");

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(percentageLabel, gbc);
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));


        percentageField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(percentageField, gbc);


        // Add the Calculate button
        JButton calculateButton = new JButton("Calculate Weighted Score");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(calculateButton, gbc);

        // Add the weighted score label (non-editable)
        JLabel weightedScoreTextLabel = new JLabel("Weighted Score:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(weightedScoreTextLabel, gbc);

        weightedScoreLabel = new JLabel("---"); // Display the score here
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(weightedScoreLabel, gbc);

        // Add action listener for button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateWeightedScore();
            }
        });

        // Set the window to be visible
        setVisible(true);
    }

    private void calculateWeightedScore() {
        try {
            double totalPoints = Double.parseDouble(totalPointsField.getText());
            double earnedPoints = Double.parseDouble(earnedPointsField.getText());
            double percentage = Double.parseDouble(percentageField.getText());

            // Calculate the weighted score
            double weightedScore = (earnedPoints / totalPoints) * percentage;
            weightedScoreLabel.setText(String.format("%.2f", weightedScore));

        } catch (NumberFormatException ex) {
            // Handle any invalid input
            weightedScoreLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new A6_WeightedGradesGUI();
    }
}
