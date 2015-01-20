import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by art on 1/19/15.
 */
public class MainForm extends JFrame {
    private JTextField accountField;
    private JButton button1;
    private JPasswordField passwordField;
    private JPanel rootPanel;
    private JButton loginButton;

    public MainForm() {
        super("FakeQQ");

        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String qqID = accountField.getText();
                String pw = String.valueOf(passwordField.getPassword());
                if (!qqID.isEmpty() && !pw.isEmpty()) {
                    try {
                        if (DBManager.getInstance().queryDB(qqID, pw)) {
                            System.out.println(accountField.getText() + " 登陆成功");
                        } else {
                            System.out.println(accountField.getText() + " 不存在");
                        }
                    } catch (Exception exception) {
                        System.err.println(exception);
                    }
                }
            }
        });

        setVisible(true);
    }
}
