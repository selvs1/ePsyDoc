package ch.bfh.btx8081.w2019.white.ePsyDoc.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ch.bfh.btx8081.w2019.white.ePsyDoc.exceptions.DoctorException;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;

/**
 * Generic class for db service. Don't touch!!
 *
 * @param <GenericModel> Is the entity model used for our database.
 * @author Sugeelan Selvasingham
 */
public class Service<GenericModel> {
	private GenericModel model;
	private EntityManager em;
	private String dbTableName;

	public Service(GenericModel model) {
		this.model = model;
		em = Database.createEntityManager();
		dbTableName = model.getClass().getSimpleName(); // classname same as table name of db
	}

	/**
	 * Dynamic database searching with attribute.
	 *
	 * @param attribute Attribute e.g. "username", "firstname".
	 * @param value     Value e.g. "selvs1", "password1234".
	 * @return Returns only the first successfully found Doctor object.
	 * @throws DoctorException Will be thrown if username doesnt exist.
	 */
	public GenericModel findByAttributeFirstElem(String attribute, Object value) throws EntityNotFoundException {

		List list = getQuery(attribute, value).setMaxResults(1).getResultList();
		if (list.size() == 0) {
			throw new EntityNotFoundException("not found");
		}
		return (GenericModel) list.get(0);
	}

	public List<GenericModel> getAppointmentPatient(Object value) throws EntityNotFoundException {
		List list = appointmentPatients(value).getResultList();
		return (List<GenericModel>) list;
	}

	public List<GenericModel> findByAttributFull(String attribut, Object value) throws EntityNotFoundException {
		List list = getQuery(attribut, value).getResultList();
		return (List<GenericModel>) list;
	}

	public List<GenericModel> findByAttributFullDESC(String attribut, Object value, String sortAttribute)
			throws EntityNotFoundException {
		List list = getQueryDESC(attribut, value, sortAttribute).getResultList();
		return (List<GenericModel>) list;
	}

	public List<GenericModel> remove(String attribut, Object value) throws EntityNotFoundException {
		List list = removeQuery(attribut, value).getResultList();
		return (List<GenericModel>) list;
	}

	public GenericModel findLastElem(String attribut, Object value) {
		List list = getLastQuery(attribut, value).setMaxResults(1).getResultList();
		if (list.size() == 0) {
			throw new EntityNotFoundException("not found");
		}
		return (GenericModel) list.get(0);
	}
	
	public void updatePatientCaseReport(Object patientCaseID, Object report) throws EntityNotFoundException {
		updateReport(patientCaseID, report);
	}

	// CRUD
	// Read
	public List<GenericModel> getEntityTable() {
		String q = "select x from " + dbTableName + " x";
		return em.createQuery(q).getResultList();
	}

	// Create
	public List<GenericModel> createEntityTable() {
		String q = "instert into " + dbTableName + " x";
		return em.createQuery(q).getResultList();
	}

	// Update
	public List<GenericModel> updateEntityTable() {
		String q = "update " + dbTableName + " x";
		return em.createQuery(q).getResultList();
	}

	// Delete
	public List<GenericModel> deleteEntityTable() {
		String q = "delete from " + dbTableName + " x";
		return em.createQuery(q).getResultList();
	}

	/*public void deleteEntityRow(int id) {
		this.em.getTransaction().begin();

		GenericModel entity = this.findById(id);
		this.em.remove(entity);
		this.em.flush();
		this.em.getTransaction().commit();
	}*/

	/**
	 * Methode with "where" search. Don't touch!!.
	 *
	 * @param attribute Attribute of database table.
	 * @param value     Value for attribute.
	 * @return A Query object.
	 */

	// Dynamic
	private Query getQuery(String attribute, Object value) {
		return Database.getEntityManager()
				.createQuery("SELECT x FROM " + dbTableName + " x WHERE x." + attribute + " = :value")
				.setParameter("value", value);
	}

	private Query getLastQuery(String attribute, Object value) {
		return Database.getEntityManager().createQuery("SELECT x FROM " + dbTableName + " x WHERE x." + attribute
				+ " = :value ORDER BY x." + attribute + " DESC LIMIT 1").setParameter("value", value);
	}

	private Query getQueryDESC(String attribute, Object value, String sortAttribute) {
		return Database.getEntityManager().createQuery("SELECT x FROM " + dbTableName + " x WHERE x." + attribute
				+ " = :value ORDER BY x." + sortAttribute + " DESC").setParameter("value", value);
	}

	private Query removeQuery(String attribute, Object value) {
		return Database.getEntityManager()
				.createQuery("DELETE FROM " + dbTableName + " x where x." + attribute + " = :value")
				.setParameter("value", value);
	}

	// Static
	
	private void updateReport(Object patientCaseID, Object report) {
		em.getTransaction().begin();
		Query query = em.createQuery(
				"UPDATE PatientCase p SET p.report = :report WHERE p.patientCaseID = :patientCaseID");
		query.setParameter("report", report).setParameter("patientCaseID", patientCaseID).executeUpdate();
		em.flush();
		em.getTransaction().commit();
	}

	private Query appointmentPatients(Object value) {
		Query query = em.createQuery(
				"SELECT a FROM Appointment  a, Patient p WHERE a.appointmentDate = :value GROUP BY a.appointmentID ORDER BY  a.appointmentTime ASC");
		query.setParameter("value", value);
		return query;
	}

	private Query insertPatientCase(String attribute, Object value) {
		return Database.getEntityManager()
				.createQuery("DELETE FROM " + dbTableName + " x where x." + attribute + " = :value")
				.setParameter("value", value);
	}

	/**
	 * This methode is only for testing.
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		Service<Patient> test = new Service<>(new Patient());

		try {
			test.findByAttributeFirstElem("firstname", "toni");
			System.out.println("yuhu");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}