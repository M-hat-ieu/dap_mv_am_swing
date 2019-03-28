package fr.hoc.dap.swingcli;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauEvent extends JPanel implements ActionListener {

    protected JLabel ecritureEvent = new JLabel();

    /**  serialVersionUID   */

    private static final long serialVersionUID = -6453222373137724556L;

    protected final String HOST = "http://localhost:8080/";

    protected String user = "Mathieu";
    protected String appData = App.getData(HOST + "event/nextString?userKey=" + user);

    public PanneauEvent() throws IOException {

        Font police1 = new Font("Arial", Font.BOLD, 17);
        ecritureEvent = new JLabel("Votre prochain événement sera : " + appData);
        ecritureEvent.setFont(police1);
        ecritureEvent.setHorizontalAlignment(JLabel.RIGHT);

        this.add(ecritureEvent);
        this.setBackground(Color.cyan);

    }

    public void refreshPanneauEvent() {
        try {
            appData = App.getData(HOST + "event/nextString?userKey=" + user);

            ecritureEvent.setText("Votre prochain événement sera : " + appData);

        } catch (IOException e) {
            ecritureEvent.setText("error");
        }

    }

    public void actionPerformed(ActionEvent e) {
        refreshPanneauEvent();

    }
}