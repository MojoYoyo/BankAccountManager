import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrowBox {
    private static JFrame frame = new JFrame();
    private static int ammount;
    private JPanel panel1;
    private JButton OKButton;
    private JTextField withdrowField;

    public WithdrowBox(int user_id) {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ammount = Integer.parseInt(withdrowField.getText());
                ManageAccount.updateBalance(user_id, ammount, 1);

                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

    public static void WithdrowFrame(int user_id) {
        frame.setContentPane(new WithdrowBox(user_id).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
