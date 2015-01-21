import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by art on 1/20/15.
 */
public class Chat extends JFrame {


    private JLabel IP;
    private JPanel rootPanel;
    private JFormattedTextField formattedTextField1;
    private JList chatList;
    private JButton sendButton;
    private JTextField textField1;

    public Chat() {
        super("Chat");

        this.setSize(600,500);
        rootPanel.setSize(600, 500);

        IP.setText(getHostIP());

        setContentPane(rootPanel);
//        pack();

        Client client = new Client("192.168.1.100");
        Thread clientThread = new Thread(client);
        clientThread.run();

        setVisible(true);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private String getHostIP () {
        String ip = "127.0.0.1";

        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        } catch (UnknownHostException e) {

        }

        return ip;
    }
}
