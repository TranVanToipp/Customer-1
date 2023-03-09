package fjs.cs.dto;

public class T002Dto {
public String CUSTOMER_ID, CUSTOMER_NAME, SEX, BIRTHDAY, ADDRESS;
	
	public T002Dto() {
		
	}
	
	public T002Dto(String cUSTOMER_ID, String cUSTOMER_NAME, String sEX, String bIRTHDAY, String aDDRESS) {
		super();
		CUSTOMER_ID = cUSTOMER_ID;
		CUSTOMER_NAME = cUSTOMER_NAME;
		SEX = sEX;
		BIRTHDAY = bIRTHDAY;
		ADDRESS = aDDRESS;
	}

	public String getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}

	public void setCUSTOMER_ID(String cUSTOMER_ID) {
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
