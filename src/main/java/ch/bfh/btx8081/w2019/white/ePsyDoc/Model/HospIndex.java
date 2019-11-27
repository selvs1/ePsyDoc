package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;

public class HospIndex {
	public static ArrayList<Drug> druglist = new ArrayList<Drug>();
	
	public HospIndex() {
	}
	
	public void addToHospIndex(Drug drug){
		druglist.add(drug);
	}
	

}
