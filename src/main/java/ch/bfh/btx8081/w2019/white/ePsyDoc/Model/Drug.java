package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

public class Drug {
	
	private String wirkstoffname;
	private String handelsname;
	private String stärke;
	private String form;

	public Drug(String wirkstoffname, String handelsname, String stärke, String form) {
		setHandelsname(handelsname);
		setWirkstoffname(wirkstoffname);
		setStärke(stärke);
		setForm(form);
		
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

	@Override
	public String toString() {
		return "drug [wirkstoffname=" + wirkstoffname + ", handelsname=" + handelsname + ", stärke=" + stärke
				+ ", form=" + form + "]";
	}
	
	public String wirkstoffnameToString() {
		return this.getWirkstoffname();
	}
	
	
	
	

}
