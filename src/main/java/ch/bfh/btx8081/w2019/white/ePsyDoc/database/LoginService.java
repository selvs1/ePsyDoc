package ch.bfh.btx8081.w2019.white.ePsyDoc.database;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.entity.DoctorException;

import javax.persistence.Query;
import java.util.List;

/**
 * Class for login service.
 * @author Sugeelan Selvasingham
 * @deprecated This class will be soon replaced by "Service" generic class.
 */
public class LoginService {

    private Doctor model;

    public LoginService(Doctor model) {
        this.model = model;
    }

    // todo: convert this class into a generic class in order to reduce code

    /**
     * Dynamic database searching with attribute.
     * @param attribute Attribute e.g. "username", "firstname".
     * @param value Value e.g. "selvs1", "password1234".
     * @return Returns only the first successfully found Doctor object.
     * @throws DoctorException Will be thrown if username doesnt exist.
     */
    public Doctor findByAttribute(String attribute, Object value) throws DoctorException {

        List l = getQuery(attribute, value).setMaxResults(1).getResultList();
        if (l.size() == 0) {
            System.out.println("Benutzer wurde nicht gefunden"); //todo: zeile löschen
            throw new DoctorException("user not found");
        }
        return (Doctor) l.get(0); // the first result
    }

    /**
     * Methode with where search.
     * @param attribute Attribute of database table.
     * @param value Value for attribute.
     * @return A Query object.
     */
    private Query getQuery(String attribute, Object value) {
        return Database.getCurrentEntityManager().createQuery("select d from " + model.getClass().getSimpleName() + " d where d." + attribute + " = :value").setParameter("value", value);
    }











    /**
     * This methode is only for testing.
     * @param args
     */
    public static void main(String[] args) {
        //todo: delete this main methode after testing

        LoginService test = new LoginService(new Doctor());

        try {

            test.findByAttribute("password", "0000");
        } catch (DoctorException e) {
            System.out.println(e.getMessage());
        }

    }

}
