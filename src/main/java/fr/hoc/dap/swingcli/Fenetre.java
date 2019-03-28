/**
 * .
 */
package fr.hoc.dap.swingcli;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author house
 *
 */
public class Fenetre extends JFrame {

    public JPanel container = new JPanel();

    private PanneauMail panneauMail = new PanneauMail();
    private PanneauMenu panneauMenu = new PanneauMenu();
    private PanneauEvent panneauEvent = new PanneauEvent();

    /**
     * Version UID de la fenetre .
     */
    private static final long serialVersionUID = 5259252364163777224L;

    /**
     * Définis le constructeur de l'interface.
     * @throws IOException 
     */
    public Fenetre() throws IOException {

        final Integer x = 800;
        final Integer y = 800;

        this.setTitle("Interface appliation");
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);

        initFenetre();
        setContentPane(container);
        this.setVisible(true);

    }

    public void initFenetre() throws IOException {

        container.setLayout(new BorderLayout());

        panneauMenu.registerRefresh(panneauMail);

        panneauMenu.registerRefresh(panneauEvent);

        container.add(panneauMail, BorderLayout.CENTER);

        container.add(panneauEvent, BorderLayout.SOUTH);

        container.add(panneauMenu, BorderLayout.WEST);

    }

}
