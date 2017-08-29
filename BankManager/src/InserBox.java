import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserBox {
    private static JFrame frame = new JFrame();
    private static int ammount = 0;
    private JButton OKButton;
    private JPanel panel1;
    private JTextField insertField;
    private JTextField moneyField;

    public InserBox(int user_id) {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ammount = Integer.parseInt(insertField.getText());
                ManageAccount.updateBalance(user_id, ammount, 2);
                frame.setVisible(false);
                frame.dispose();
                MainPanel.MainFrame(user_id);
            }
        });
    }

    public static void InsertFrame(int user_id) {
        frame.setContentPane(new InserBox(user_id).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
