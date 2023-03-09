package fjs.cs.dto;

public class T001Dto {
	public String USERID, PASSWORD, PSN_CD;

	public T001Dto() {

	}

	public T001Dto(String uSERID, String pASSWORD, String pSN_CD) {
		super();
		USERID = uSERID;
		PASSWORD = pASSWORD;
		PSN_CD = pSN_CD;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getPSN_CD() {
		return PSN_CD;
	}

	public void setPSN_CD(String pSN_CD) {
		PSN_CD = pSN_CD;
	}
}
