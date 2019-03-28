package fr.hoc.dap.swingcli;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauMail extends JPanel implements ActionListener {

    protected JLabel ecritureMail = new JLabel();

    /**
     * 
     */
    private static final long serialVersionUID = -4066656853651611838L;

    protected final String HOST = "http://localhost:8080/";

    protected String user = "Mathieu";
    protected String appData = App.getData(HOST + "email/nbunread?userKey=" + user);

    protected PanneauMail() throws IOException {

        Font police = new Font("Arial", Font.BOLD, 20);
        ecritureMail = new JLabel("Vous avez : " + appData + " emails non lus");
        ecritureMail.setFont(police);
        ecritureMail.setHorizontalAlignment(JLabel.CENTER);

        this.add(ecritureMail);
        this.setBackground(Color.WHITE);

    }

    private void refreshPanneauMail() {
        try {
            appData = App.getData(HOST + "email/nbunread?userKey=" + user);

            ecritureMail.setText("Vous avez : " + appData + " emails non lus");

        } catch (IOException e) {
            ecritureMail.setText("error");
        }
    }

    public void actionPerformed(ActionEvent e) {
        refreshPanneauMail();
    }

}
