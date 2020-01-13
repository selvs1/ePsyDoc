package ch.bfh.btx8081.w2019.white.ePsyDoc.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;

/**
 * Service class connection to database.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
public class Service<GenericModel> {
	private GenericModel model;
	private EntityManager em;
	private String dbTableName;

	/**
	 * Constructor of Service.
	 * 
	 * @param model get model.
	 */
	public Service(GenericModel model) {
		this.model = model;
		em = Database.createEntityManager();
		dbTableName = model.getClass().getSimpleName();
	}

	/**
	 * Get first element.
	 * 
	 * @param attribute name of attribute.
	 * @param value     value of attribute.
	 * @return First element of list.
	 * @throws EntityNotFoundException throw exception on failure.
	 */
	public GenericModel findByAttributeFirstElem(String attribute, Object value) throws EntityNotFoundException {
		List list = getQuery(attribute, value).setMaxResults(1).getResultList();
		if (list.size() == 0) {
			throw new EntityNotFoundException("not found");
		}
		return (GenericModel) list.get(0);
	}

	/**
	 * Get appointment from date.
	 * 
	 * @param value appointment date.
	 * @return List.
	 * @throws EntityNotFoundException throw exception on failure.
	 */
	public List<GenericModel> getAppointmentPatient(Object value) throws EntityNotFoundException {
		List list = appointmentPatients(value).getResultList();
		return (List<GenericModel>) list;
	}

	/**
	 * Get all entry.
	 * 
	 * @param attribute name of attribute.
	 * @param value     value of attribute.
	 * @return List.
	 * @throws EntityNotFoundException throw exception on failure.
	 */
	public List<GenericModel> findByAttributFull(String attribute, Object value) throws EntityNotFoundException {
		List list = getQuery(attribute, value).getResultList();
		return (List<GenericModel>) list;
	}

	/**
	 * Get all entry DESC.
	 * 
	 * @param attribute     name of attribute.
	 * @param value         value of attribute.
	 * @param sortAttribute name of sorting attribute.
	 * @return List.
	 * @throws EntityNotFoundException throw exception on failure.
	 */
	public List<GenericModel> findByAttributFullDESC(String attribute, Object value, String sortAttribute)
			throws EntityNotFoundException {
		List list = getQueryDESC(attribute, value, sortAttribute).getResultList();
		return (List<GenericModel>) list;
	}

	/**
	 * Remove element.
	 * 
	 * @param attribute name of attribute.
	 * @param value     value of attribute.
	 * @return List.
	 * @throws EntityNotFoundException throw exception on failure.
	 */
	public List<GenericModel> remove(String attribute, Object value) throws EntityNotFoundException {
		List list = removeQuery(attribute, value).getResultList();
		return (List<GenericModel>) list;
	}

	/**
	 * Get last entry.
	 * 
	 * @param attribute name of attribute.
	 * @param value     value of attribute.
	 * @return First element from list.
	 */
	public GenericModel findLastElem(String attribute, Object value) {
		List list = getLastQuery(attribute, value).setMaxResults(1).getResultList();
		if (list.size() == 0) {
			throw new EntityNotFoundException("not found");
		}
		return (GenericModel) list.get(0);
	}

	/**
	 * Update patient case.
	 * 
	 * @param patientCaseID get patient case ID.
	 * @param report        get report.
	 * @throws EntityNotFoundException throw exception on failure.
	 */
	public void updatePatientCaseReport(Object patientCaseID, Object report) throws EntityNotFoundException {
		updateReport(patientCaseID, report);
	}

	/**
	 * Select from table.
	 * 
	 * @return Selection.
	 */
	public List<GenericModel> getEntityTable() {
		String q = "select x from " + dbTableName + " x";
		return em.createQuery(q).getResultList();
	}

	// Dynamic
	/**
	 * Select statement.
	 * 
	 * @param attribute name of attribute.
	 * @param value     value of attribute.
	 * @return Query.
	 */
	private Query getQuery(String attribute, Object value) {
		return Database.getEntityManager()
				.createQuery("SELECT x FROM " + dbTableName + " x WHERE x." + attribute + " = :value")
				.setParameter("value", value);
	}

	/**
	 * Get last element.
	 * 
	 * @param attribute name of attribute.
	 * @param value     value of attribute.
	 * @return Query.
	 */
	private Query getLastQuery(String attribute, Object value) {
		return Database.getEntityManager().createQuery("SELECT x FROM " + dbTableName + " x WHERE x." + attribute
				+ " = :value ORDER BY x." + attribute + " DESC LIMIT 1").setParameter("value", value);
	}

	/**
	 * Get Selection DESC.
	 * 
	 * @param attribute     name of attribute.
	 * @param value         value of attribute.
	 * @param sortAttribute name of sort attribute.
	 * @return Query.
	 */
	private Query getQueryDESC(String attribute, Object value, String sortAttribute) {
		return Database.getEntityManager().createQuery("SELECT x FROM " + dbTableName + " x WHERE x." + attribute
				+ " = :value ORDER BY x." + sortAttribute + " DESC").setParameter("value", value);
	}

	/**
	 * Remove query.
	 * 
	 * @param attribute name of attribute.
	 * @param value     value of attribute.
	 * @return Query.
	 */
	private Query removeQuery(String attribute, Object value) {
		return Database.getEntityManager()
				.createQuery("DELETE FROM " + dbTableName + " x where x." + attribute + " = :value")
				.setParameter("value", value);
	}

	// Static
	/**
	 * Update report in patient case.
	 * 
	 * @param patientCaseID get patient case ID.
	 * @param report        get report.
	 */
	private void updateReport(Object patientCaseID, Object report) {
		em.getTransaction().begin();
		Query query = em
				.createQuery("UPDATE PatientCase p SET p.report = :report WHERE p.patientCaseID = :patientCaseID");
		query.setParameter("report", report).setParameter("patientCaseID", patientCaseID).executeUpdate();
		em.flush();
		em.getTransaction().commit();
	}

	/**
	 * Get appointment from date.
	 * 
	 * @param value date of appointment.
	 * @return Patient list.
	 */
	private Query appointmentPatients(Object value) {
		Query query = em.createQuery(
				"SELECT a FROM Appointment  a, Patient p WHERE a.appointmentDate = :value GROUP BY a.appointmentID ORDER BY  a.appointmentTime ASC");
		query.setParameter("value", value);
		return query;
	}

	/**
	 * Add medication.
	 * 
	 * @param medication get medication.
	 */
	public void addMedication(Medication medication) {
		em.getTransaction().begin();
		em.persist(medication);
		em.flush();
		em.getTransaction().commit();
	}

	/**
	 * Add diagnosis.
	 * 
	 * @param diagnosis get diagnosis.
	 */
	public void addDiagnosis(Diagnosis diagnosis) {
		em.getTransaction().begin();
		em.persist(diagnosis);
		em.flush();
		em.getTransaction().commit();
	}

	/**
	 * Remove diagnosis.
	 * 
	 * @param diagnosis get diagnosis.
	 */
	public void removeDiagnosis(Diagnosis diagnosis) {
		em.getTransaction().begin();
		Diagnosis d = em.find(Diagnosis.class, diagnosis.getDiagnosisID());
		em.remove(d);
		em.flush();
		em.getTransaction().commit();
	}

	/**
	 * Remove medication.
	 * 
	 * @param medication get medication.
	 */
	public void removeMedication(Medication medication) {
		em.getTransaction().begin();
		Medication m = em.find(Medication.class, medication.getMedicationID());
		em.remove(m);
		em.flush();
		em.getTransaction().commit();
	}

	/**
	 * Remove patient Case with patient case IDs.
	 * 
	 * @param patientCaseID get patient case ID.
	 */
	public void removePatientCase(int patientCaseID) {
		em.getTransaction().begin();
		PatientCase pc = em.find(PatientCase.class, patientCaseID);
		em.remove(pc);
		em.flush();
		em.getTransaction().commit();
	}

	/**
	 * Add Patient Case.
	 * 
	 * @param patientCase get patient case.
	 * @return id of new generated patient case.
	 */
	public int addPatientCase(PatientCase patientCase) {
		em.getTransaction().begin();
		em.persist(patientCase);
		em.flush();
		em.getTransaction().commit();
		return patientCase.getPatientcaseID();
	}
}