package fjs.cs.dto;

public class T003Dto {
	public int CUSTOMER_ID;
	public String CUSTOMER_NAME, SEX, EMAIL, BIRTHDAY, ADDRESS;

	public T003Dto() {
		
	}
	public T003Dto(int cUSTOMER_ID, String cUSTOMER_NAME, String sEX, String eMAIL, String bIRTHDAY,
			String aDDRESS) {
		super();
		CUSTOMER_ID = cUSTOMER_ID;
		CUSTOMER_NAME = cUSTOMER_NAME;
		SEX = sEX;
		EMAIL = eMAIL;
		BIRTHDAY = bIRTHDAY;
		ADDRESS = aDDRESS;
	}
	public int getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(int cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public String getSEX() {
		return SEX;
	}
	public void setSEX(String sEX) {
		SEX = sEX;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getBIRTHDAY() {
		return BIRTHDAY;
	}
	public void setBIRTHDAY(String bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
}
