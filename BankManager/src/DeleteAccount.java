import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAccount {
    private static JFrame frame = new JFrame();
    private JPanel panel1;
    private JButton yesButton;
    private JButton noButton;

    public DeleteAccount(int user_id) {
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageAccount.deleteAccount(user_id);
                frame.setVisible(false);
                frame.dispose();
                FirstPanel.firstFrame();
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

    public static void deelteFrame(int user_id) {
        frame.setContentPane(new DeleteAccount(user_id).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
