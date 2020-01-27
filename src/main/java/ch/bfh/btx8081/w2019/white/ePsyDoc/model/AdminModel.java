package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;


public class AdminModel {

    Service<Doctor> service = new Service<>(new Doctor());


    public void createUser(String username, String password) {
        service.createEntityRow(
                new Doctor(username, password)
        );

    }

}
