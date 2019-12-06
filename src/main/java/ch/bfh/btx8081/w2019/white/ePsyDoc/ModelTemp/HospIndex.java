package ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp;

import java.util.ArrayList;

public class HospIndex {
	public static ArrayList<Drug> druglist = new ArrayList<Drug>();

	public HospIndex() {
		druglist.add(new Drug("Ibuprofen 400mg", "IBUPROFEN AL akut 400mg Film-coated-tablet", "400mg",
				"Film-coated-tablet","Pcs","Take with a glas of water","Pain"));
		druglist.add(new Drug("Ibuprofen 200mg", "IBUPROFEN AL akut 200mg Film-coated-tablet", "200mg",
				"Film-coated-tablet","Pcs","Take with a glas of water","Pain"));
		druglist.add(new Drug("Ibuprofen 600mg", "IBUPROFEN AL akut 600mg Film-coated-tablet", "600mg",
				"Film-coated-tablet","Pcs","Take with a glas of water","Pain"));
	}
	
	public ArrayList<Drug> getDrugList() {
		return druglist;
	}
}
