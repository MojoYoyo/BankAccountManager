import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel {
    private static JFrame frame = new JFrame();
    String login;
    String password;
    int user_id = 0;
    private JPanel panel1;
    private JButton OKButton;
    private JButton registerButton;
    private JTextField loginField;
    private JPasswordField passwordField;

    public FirstPanel() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = loginField.getText();
                password = passwordField.getText();
                if (Select.getUser(login, password)) {
                    user_id = Select.getUserId(login);
                    MainPanel.MainFrame(user_id);
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect login or password");
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterPanel.registerFrame();
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

    public static void firstFrame() {
        frame.setContentPane(new FirstPanel().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
