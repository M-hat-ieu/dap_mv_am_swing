package fr.hoc.dap.swingcli;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauMenu extends JPanel implements ActionListener {

    /** serialVersionUID. */
    private static final long serialVersionUID = 6818776458425739464L;

    private JButton refreshButon = new JButton("Rafraichir");
    private JButton configButon = new JButton("Config");
    private JButton saveButon = new JButton("Sauvegarder");

    public PanneauMenu() {

        configButon.addActionListener(this);
        this.setLayout(new GridLayout(3, 0));
        this.add(refreshButon);
        this.add(configButon);
        this.add(saveButon);
    }

    public void registerRefresh(ActionListener panneauMail) {
        refreshButon.addActionListener(panneauMail);
    }

    private void onNewConfig() {
        try {
            new ConfigFenetre();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == configButon) {
            onNewConfig();
        }

    }
}
