import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagePanel {
    private static JFrame frame = new JFrame();
    private JPanel panel1;
    private JButton changeLoginButton;
    private JButton changePasswordButton;
    private JButton changeEmailButton;
    private JButton deleteAccountButton;
    private JTextField passwordField;
    private JTextField loginField;
    private JTextField emailField;
    private int operation_number;
    private String data;

    public ManagePanel(int user_id) {
        changeLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation_number = 1;
                data = loginField.getText();
                ManageAccount.updateInfo(user_id, data, operation_number);
                JOptionPane.showMessageDialog(null, "Login changed successfully");
                loginField.setText("");
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation_number = 2;
                data = passwordField.getText();
                ManageAccount.updateInfo(user_id, data, operation_number);
                JOptionPane.showMessageDialog(null, "Password changed successfully!");
                passwordField.setText("");
            }
        });
        changeEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation_number = 3;
                data = emailField.getText();
                ManageAccount.updateInfo(user_id, data, operation_number);
                JOptionPane.showMessageDialog(null, "Email changed successfully!");
                emailField.setText("");
            }
        });
        deleteAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteAccount.deelteFrame(user_id);
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

    public static void ManageFrame(int user_id) {
        frame.setContentPane(new ManagePanel(user_id).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
