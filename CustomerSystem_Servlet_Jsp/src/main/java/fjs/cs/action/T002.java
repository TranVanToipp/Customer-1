package fjs.cs.action;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fjs.cs.common.Constants;
import fjs.cs.dao.T002Dao;
import fjs.cs.dto.T002Dto;

/**
 * Servlet implementation class T002
 */
@WebServlet("/T002")
public class T002 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public T002() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		
		int index = Integer.parseInt(indexPage);
		request.setAttribute("tag", index);
		T002Dao dao = new T002Dao();
		
		
		//get data search
		List<T002Dto> list = dao.getData();
		
		request.setAttribute("listData", list);
		//page 
		int count = dao.getDataPage();
		//trang cuoi cùng
		int endpage = count/3;
		if (count % 3 != 0) {
			endpage++;
		}
		
		List<T002Dto> listPage = dao.pagingData(index);
		request.setAttribute("ListA", listPage);
		request.setAttribute("endP", endpage);
		request.getRequestDispatcher(Constants.T002_SEARCH);
		
		
				//request.getRequestDispatcher("/WEB-INF/jsp/T002.jsp").forward(request, response);
		RequestDispatcher myRD = null;
		// Hien thi man hinh Login
		myRD = request.getRequestDispatcher(Constants.T002_SEARCH);
		myRD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String name = request.getParameter("txtCustomerName");
			String sex = request.getParameter("browser");
			String birthdayFrom = request.getParameter("txtBirthdayFromName");
			String birthdayTo = request.getParameter("txtBirthdayToName");

			
				
			
			
//			if (name == null || name.trim().isEmpty()) {
//			    name = null;
//			}
//			if (sex == null || sex.trim().isEmpty()) {
//			    sex = null;
//			}
//			if (birthdayFrom == null || birthdayFrom.trim().isEmpty()) {
//			    birthdayFrom = null;
//			}
//			if (birthdayTo == null || birthdayTo.trim().isEmpty()) {
//			    birthdayTo = null;
//			}

			T002Dao daoSearch = new T002Dao();
			
			List<T002Dto> resultSearch = daoSearch.getDataSearch(name, sex, birthdayFrom, birthdayTo);
			
//			String page = request.getParameter("pagepage");
//			if (page == null) {
//				page = "1";
//			}
			int page = 2;
			int recordsPerPage = 5; // số phần tử hiển thị trên mỗi trang
			int startIndex = (page - 1) * recordsPerPage; // vị trí bắt đầu của trang hiện tại
			int endIndex = startIndex + recordsPerPage; // vị trí kết thúc của trang hiện tại
			int totalRecords = resultSearch.size(); // tổng số phần tử của danh sách
			int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage); // tổng số trang
			List<T002Dto> resultPaginated = resultSearch.subList(startIndex, Math.min(endIndex, totalRecords));
			request.setAttribute("listDataSearch", resultPaginated);
			request.setAttribute("currentPage", page);
			request.setAttribute("recordsPerPage", recordsPerPage);
			request.setAttribute("totalRecords", totalRecords);
			request.setAttribute("totalPages", totalPages);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/T002.jsp");
			rd.forward(request, response);
//			request.setAttribute("ListA", resultPaginated);
//			request.setAttribute("tag", Integer.parseInt(page));
//			request.setAttribute("endP", totalPages);

			
			String[] ids = request.getParameterValues("selectedValues");
			if (ids != null && ids.length > 0) {
			    String idList = String.join(",", ids);
			   
			    // Loại bỏ các dấu ngoặc kép trong chuỗi
			    idList = idList.replace("[\"", "").replace("\"]", "");
			    String result = idList.replaceAll("[^\\d,]", "").replace("\"", "");
			    String[] result2 = result.split(",");
			    for (int i = 0;i< result2.length; i++) {		
			    	daoSearch.deleteData(result2);
			    }
			}
			T002Dao dao = new T002Dao();
			List<T002Dto> list = dao.getData();
			request.setAttribute("listData", list);

			// Chuyển hướng request và response đến trang jsp
			RequestDispatcher rdr = request.getRequestDispatcher("/WEB-INF/jsp/T002.jsp");
			rdr.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
private boolean isValidDate(String txtDate) {
	    
	    String rxDatePattern = "^(\\d{4})(\\/|-)(\\d{1,2})(\\/|-)(\\d{1,2})$";
	    Pattern pattern = Pattern.compile(rxDatePattern);
	    Matcher matcher = pattern.matcher(txtDate);
	    if (!matcher.matches()) {
	        return false;
	    }
	    int dtMonth = Integer.parseInt(matcher.group(3));
	    int dtDay = Integer.parseInt(matcher.group(5));
	    int dtYear = Integer.parseInt(matcher.group(1));
	    if (dtMonth < 1 || dtMonth > 12) {
	        return false;
	    } else if (dtDay < 1 || dtDay > 31) {
	        return false;
	    } else if ((dtMonth == 4 || dtMonth == 6 || dtMonth == 9 || dtMonth == 11) && dtDay == 31) {
	        return false;
	    } else if (dtMonth == 2) {
	        boolean isLeap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
	        if (dtDay > 29 || (dtDay == 29 && !isLeap)) {
	            return false;
	        }
	    }
	    return true;
	}

}
