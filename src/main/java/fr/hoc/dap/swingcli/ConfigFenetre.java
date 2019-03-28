/**
 * 
 */
package fr.hoc.dap.swingcli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author house
 *
 */
public class ConfigFenetre extends JFrame implements ActionListener {

    private JPanel container = new JPanel();

    private JTextField jtfUserKey = new JTextField("");
    private JLabel userKey = new JLabel("Veuillez inscrire votre userKey !");
    private JButton okUserKey = new JButton("ok");

    private JTextField jtfCreateUserKey = new JTextField("");
    private JLabel creerUserKey = new JLabel("Veuillez créer votre userKey ! ");
    private JButton okCreerUserKey = new JButton("ok");

    /** serialVersionUID. */
    private static final long serialVersionUID = -3648195547192955638L;

    protected final String HOST = "http://localhost:8080/";

    public ConfigFenetre() throws IOException {
        this.setTitle("Interface appliation");
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setAlwaysOnTop(true);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        JPanel top = new JPanel();

        Font police = new Font("Arial", Font.BOLD, 14);
        jtfUserKey.setFont(police);
        jtfUserKey.setPreferredSize(new Dimension(150, 30));
        jtfUserKey.setForeground(Color.BLUE);

        okUserKey.addActionListener(this);

        top.add(userKey);
        top.add(jtfUserKey);
        top.add(okUserKey);

        container.add(top, BorderLayout.NORTH);

        JPanel bot = new JPanel();

        Font police1 = new Font("Arial", Font.BOLD, 14);
        jtfCreateUserKey.setFont(police1);
        jtfCreateUserKey.setPreferredSize(new Dimension(150, 30));
        jtfCreateUserKey.setForeground(Color.BLUE);

        okCreerUserKey.addActionListener(this);

        bot.add(creerUserKey);
        bot.add(jtfCreateUserKey);
        bot.add(okCreerUserKey);

        container.add(bot, BorderLayout.SOUTH);

        setContentPane(container);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String creerUserKey = jtfCreateUserKey.getText();
        String userKey = jtfUserKey.getText();

        if (e.getSource() == okUserKey) {

            System.out.println("TEXT : userKey " + userKey);

            String nbUnread = null;
            String lastEvent = null;

            try {
                nbUnread = App.getData(HOST + "email/nbunread?userKey=" + userKey);
            } catch (IOException e1) {
            }
            System.out.println("Nombre email non lus : " + nbUnread);

            try {
                lastEvent = App.getData(HOST + "event/nextString?userKey=" + userKey);
            } catch (IOException e1) {

            }
            System.out.println("Votre prochain événement : " + lastEvent);

        } else {
            System.out.println("Action [" + jtfCreateUserKey.getText() + "] non reconnue");

        }

        if (e.getSource() == okCreerUserKey) {

            try {
                System.out.println("TEXT : userKey " + creerUserKey);
                Desktop.getDesktop().browse(new URI("http://localhost:8080/account/add/" + creerUserKey));
            } catch (IOException e1) {
                System.out.println("TEXT : userKey Not found ");
            } catch (URISyntaxException e1) {

            }

        }
    }
}
