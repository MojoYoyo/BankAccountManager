import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel {
    private static JFrame frame = new JFrame();
    String password;
    String login;
    String email;
    private JPanel panel1;
    private JButton OKButton;
    private JTextField registerLoginField;
    private JTextField registerEmailField;
    private JPasswordField registerPasswordField;

    public RegisterPanel() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = registerLoginField.getText();
                password = registerPasswordField.getText();
                email = registerEmailField.getText();
                Insert.insertNew(login, password, email);
                JOptionPane.showMessageDialog(null, "Account created!");
                frame.setVisible(false);
                frame.dispose();
                FirstPanel.firstFrame();
            }
        });
    }

    public static void registerFrame() {
        frame.setContentPane(new RegisterPanel().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
