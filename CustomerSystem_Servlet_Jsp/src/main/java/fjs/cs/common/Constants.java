package fjs.cs.common;

public class Constants {
	/* List Man Hinh */
	// T001(Login)
	public static final String USER = "root";
    public static final String PASS = "";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/customsystem";
	 public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String T001_LOGIN = "/WEB-INF/jsp/T001.jsp";
	// T002(Search)
	public static final String T002_SEARCH = "/WEB-INF/jsp/T002.jsp";
	// T002(Edit)
	public static final String T003_EDIT = "/WEB-INF/jsp/T003.jsp";
	// Thong bao loi
	public static final String MESSAGE_ERROR_USER_NOT_EXIST = "ユーザーIDまたはパスワードが不正です。";
	
	public static final String MESSAGE_CHECKOFF = "行を選択してください。";
	
	public static final String userNotERROR = "ユーザーIDを入力してください。";
	
	public static final String MESSAGE_TO_SMALL_FROM = "There is an error in the range input of Birthday";
	
	public static final String MESSAGE_ERROR_FROM = "Invalid Birthday (From).";
	public static final String MESSAGE_ERROR_TO = "Invalid Birthday (To).";
}
