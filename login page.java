
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ShowPasswordExample implements ActionListener {
    private static JLabel lab;
    private static JLabel tab;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordField;
    private static JTextField passwordTextField; // For showing password
    private static JButton button;
    private static JLabel success;
    private static JCheckBox showPasswordCheckBox;

    public static void main(String[] args) {

        
        JPanel pan = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pan);
        pan.setLayout(null);
       
        lab = new JLabel("User  ");
        lab.setBounds(10, 20, 80, 25);
        pan.add(lab);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 30);
        pan.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 30);
        pan.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 30);
        pan.add(passwordField);

        // TextField to show password
        passwordTextField = new JTextField();
        passwordTextField.setBounds(100, 50, 165, 30);
        passwordTextField.setVisible(false); // Initially hidden
        pan.add(passwordTextField);

        // Checkbox to show/hide password
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(100, 80, 150, 25);
        showPasswordCheckBox.addActionListener(new ShowPasswordAction());
        pan.add(showPasswordCheckBox);

        button = new JButton("Login");
        button.setBounds(10, 110, 80, 25);
        button.addActionListener(new ShowPasswordExample());
        pan.add(button);

        success = new JLabel();
        success.setBounds(10, 140, 300, 25);
        pan.add(success);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String pass = new String(passwordField.getPassword());

        if (user.equals("prince") && pass.equals("student")) {
            success.setText("Congratulations!");
        } else {
            success.setText("fools ");
        }
    }

    // ActionListener for the show password checkbox
    private static class ShowPasswordAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (showPasswordCheckBox.isSelected()) {
                // Show password
                passwordField.setVisible(false);
                passwordTextField.setVisible(true);
                passwordTextField.setText(new String(passwordField.getPassword()));
            } else {
                // Hide password
                passwordField.setVisible(true);
                passwordTextField.setVisible(false);
                passwordField.setText(""); // Clear the text field
            }
        }
    }
}