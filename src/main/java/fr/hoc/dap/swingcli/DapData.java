/**
 * 
 */
package fr.hoc.dap.swingcli;

/**
 * @author house
 *
 */
public class DapData {

    /**constrcteur privé */
    private DapData() {

    }

    /** Instance unique non préinitialisée */
    private static DapData INSTANCE = null;

    /** Point d'accès pour l'instance unique du singleton */
    public static synchronized DapData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DapData();
        }
        return INSTANCE;
    }
}
