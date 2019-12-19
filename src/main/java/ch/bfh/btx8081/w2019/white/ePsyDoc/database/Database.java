package ch.bfh.btx8081.w2019.white.ePsyDoc.database;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * This static class helps persisting entity models into database. A side effect is also reducing the same code block for each entity model through centralization.
 *
 * @author Sugeelan Selvasingham
 */

public class Database {

    private static EntityManager em = createEntityManager();
    private static final String PERSISTENCE_UNIT_NAME = "ePsyDoc";

    /**
     * Create EntityManager with basic predefined PU name.
     * @return EntityManager objekt with predefined PU name e.g. ePsyDoc.
     */
    public static EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    /**
     * Return the current previously created EntityManager object.
     * @return EntityManager object.
     */
    public static EntityManager getEntityManager() {
        return em;
    }


}
