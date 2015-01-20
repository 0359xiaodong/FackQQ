import javax.swing.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by art on 1/20/15.
 */
public class Chat extends JFrame {


    private JLabel IP;
    private JPanel rootPanel;
    private JFormattedTextField formattedTextField1;
    private JList chatList;

    public Chat() {
        super("Chat");

        this.setSize(600,500);
        rootPanel.setSize(600, 500);

        IP.setText(getHostIP());

        setContentPane(rootPanel);
//        pack();


        setVisible(true);
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

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
