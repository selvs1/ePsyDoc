package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SugiTest {
	@Id
	@GeneratedValue
	int id;
	
	String name;
	String Vorname;
	
	int ahv;
	

}
