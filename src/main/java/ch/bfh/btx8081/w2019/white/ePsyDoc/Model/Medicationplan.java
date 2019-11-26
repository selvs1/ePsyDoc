package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;

public class Medicationplan {
	
	private String wirkstoffname;
	private String handelsname;
	private String stärke;
	private String form;
	private String morgen;
	private String mittag;
	private String abend;
	private String nacht;
	private String einheit;
	private String hinweis;
	private String grund;
	
	ArrayList<Medicationplan> mediplan = new ArrayList<Medicationplan>();
	
	public Medicationplan(String wirkstoffname, String handelsname, String stärke, String form, String morgen,
			String mittag, String abend, String nacht, String einheit, String hinweis, String grund) {
		this.wirkstoffname = wirkstoffname;
		this.handelsname = handelsname;
		this.stärke = stärke;
		this.form = form;
		this.morgen = morgen;
		this.mittag = mittag;
		this.abend = abend;
		this.nacht = nacht;
		this.einheit = einheit;
		this.hinweis = hinweis;
		this.grund = grund;
	}

	public String getWirkstoffname() {
		return wirkstoffname;
	}

	public void setWirkstoffname(String wirkstoffname) {
		this.wirkstoffname = wirkstoffname;
	}

	public String getHandelsname() {
		return handelsname;
	}

	public void setHandelsname(String handelsname) {
		this.handelsname = handelsname;
	}

	public String getStärke() {
		return stärke;
	}

	public void setStärke(String stärke) {
		this.stärke = stärke;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getMorgen() {
		return morgen;
	}

	public void setMorgen(String morgen) {
		this.morgen = morgen;
	}

	public String getMittag() {
		return mittag;
	}

	public void setMittag(String mittag) {
		this.mittag = mittag;
	}

	public String getAbend() {
		return abend;
	}

	public void setAbend(String abend) {
		this.abend = abend;
	}

	public String getNacht() {
		return nacht;
	}

	public void setNacht(String nacht) {
		this.nacht = nacht;
	}

	public String getEinheit() {
		return einheit;
	}

	public void setEinheit(String einheit) {
		this.einheit = einheit;
	}

	public String getHinweis() {
		return hinweis;
	}

	public void setHinweis(String hinweis) {
		this.hinweis = hinweis;
	}

	public String getGrund() {
		return grund;
	}

	public void setGrund(String grund) {
		this.grund = grund;
	}
	
	

}
