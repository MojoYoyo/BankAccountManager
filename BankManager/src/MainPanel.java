import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private static JFrame frame = new JFrame();
    private JPanel panel1;
    private JButton withdrowButton;
    private JButton addFoundsButton;
    private JButton chceckBalanceButton;
    private JButton manageAccountButton;

    public MainPanel(int user_id) {
        withdrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrowBox.WithdrowFrame(user_id);
            }
        });
        addFoundsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InserBox.InsertFrame(user_id);
            }
        });
        chceckBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Your current balance is: " + Select.getBalance(user_id));
            }
        });
        manageAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagePanel.ManageFrame(user_id);
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

    public static void MainFrame(int user_id) {
        frame.setContentPane(new MainPanel(user_id).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
