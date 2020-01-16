package ch.bfh.btx8081.w2019.white.ePsyDoc.model.database;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 * 
 *          This static class helps persisting entity models into database. A
 *          side effect is also reducing the same code block for each entity
 *          model through centralization.
 *
 */
//todo: maybe singleton?
public class Database {
	private static EntityManager em = createEntityManager();
	private static final String PERSISTENCE_UNIT_NAME = "ePsyDoc";

	/**
	 * Create EntityManager with basic predefined PU name.
	 * 
	 * @return EntityManager object with predefined PU name e.g. ePsyDoc.
	 */
	public static EntityManager createEntityManager() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	/**
	 * Return the current previously created EntityManager object.
	 * 
	 * @return EntityManager object.
	 */
	public static EntityManager getEntityManager() {
		return em;
	}
}