package ch.bfh.btx8081.w2019.white.ePsyDoc.database;

import ch.bfh.btx8081.w2019.white.ePsyDoc.exceptions.DoctorException;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;


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
            throw new EntityNotFoundException("user not found");
        }
        return (GenericModel) list.get(0); // the first result
    }


    public List<GenericModel> findByAttributFull(String attribut, Object value) throws EntityNotFoundException {
        List list = getQuery(attribut, value).getResultList();
        return (List<GenericModel>) list;
    }


    //CRUD
    //Read
    public List<GenericModel> getEntityTable() {
        String q = "select x from " + dbTableName + " x";
        return em.createQuery(q).getResultList();
    }


    //Create



    //Update

    //Delete









    /**
     * Methode with "where" search. Don't touch!!.
     *
     * @param attribute Attribute of database table.
     * @param value     Value for attribute.
     * @return A Query object.
     */
    private Query getQuery(String attribute, Object value) {
        return Database.getEntityManager().createQuery("select x from " + dbTableName + " x where x." + attribute + " = :value").setParameter("value", value);
    }












    /**
     * This methode is only for testing.
     *
     * @param args
     */
    public static void main(String[] args) {
        //todo: delete this main methode after testing

//        LoginService test = new LoginService(new Doctor());
//
//        try {
//
//            test.findByAttribute("password", "0000");
//        } catch (EntityNotFoundException e) {
//            System.out.println(e.getMessage());
//        }


        Service<Patient> test = new Service<>(new Patient());

        try {
            test.findByAttributeFirstElem("firstname", "toni");
            System.out.println("yuhu");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }

}
