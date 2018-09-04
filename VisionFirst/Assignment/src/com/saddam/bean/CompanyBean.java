package com.saddam.bean;

public class CompanyBean {
	private int sno;
	private String companyName;
	private String createdBy;
	private String companyAddress;
	private String actions;
	
	public CompanyBean() {
		super();
	}

	public CompanyBean(int sno, String companyName, String companyAddress,String createdBy,  String actions) {
		super();
		this.sno = sno;
		this.companyName = companyName;
		this.createdBy = createdBy;
		this.companyAddress = companyAddress;
		this.actions = actions;
	}

	public CompanyBean(String companyName, String companyAddress, String createdBy, String actions) {
		this.companyName = companyName;
		this.createdBy = createdBy;
		this.companyAddress = companyAddress;
		this.actions = actions;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}
	
}
