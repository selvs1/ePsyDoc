package ch.bfh.btx8081.w2019.white.ePsyDoc.database;

import ch.bfh.btx8081.w2019.white.ePsyDoc.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.entity.DoctorException;
import com.sun.source.doctree.DocCommentTree;

import javax.persistence.Query;
import java.util.List;

/**
 * Class for login service.
 *
 * @author Sugeelan Selvasingham
 */
public class LoginService {

    private Doctor model;

    public LoginService(Doctor model) {
        this.model = model;
    }

    public Doctor findByAttribute(String attribute, Object value) throws DoctorException {

        List l = getQuery(attribute, value).setMaxResults(1).getResultList();
        if (l.size() == 0) {
            System.out.println("Benutzer wurde nicht gefunden"); //todo: zeile löschen
            throw new DoctorException("user not found");
        }
        return (Doctor) l.get(0); // the first result
    }

    private Query getQuery(String attribute, Object value) {
        return Database.getCurrentEntityManager().createQuery("select d from " + model.getClass().getSimpleName().toLowerCase() + " d where d." + attribute + " = :value").setParameter("value", value);
    }


    public static void main(String[] args) {
        //todo: test löschen

        LoginService test = new LoginService(new Doctor());

        try {

            test.findByAttribute("username", "selvs1");
        } catch (DoctorException e) {
            System.out.println(e.getMessage());
        }

    }
}
