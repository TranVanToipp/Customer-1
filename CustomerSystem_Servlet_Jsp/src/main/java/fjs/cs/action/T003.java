package fjs.cs.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fjs.cs.common.Constants;
import fjs.cs.dao.T003Dao;
import fjs.cs.dto.T003Dto;

/**
 * Servlet implementation class T003
 */
@WebServlet("/T003")
public class T003 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T003() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher myRD = null;
		String customerId = request.getParameter("id");
		T003Dto dto = T003Dao.getCustomerById(Integer.parseInt(customerId));
		request.setAttribute("dto", dto);


		
		
		// Hien thi man hinh Login
		myRD = request.getRequestDispatcher(Constants.T003_EDIT);
		myRD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String id = request.getParameter("customerId");
	        String name = request.getParameter("customerName");
	        String sex = request.getParameter("sex");
	        String birthday = request.getParameter("birthday");
	        String email = request.getParameter("email");
	        String address = request.getParameter("address");
	        
	        T003Dto dto = new T003Dto();
	        dto.setCUSTOMER_ID(Integer.parseInt(id));
	        dto.setCUSTOMER_NAME(name);
	        dto.setSEX(sex);
	        dto.setBIRTHDAY(birthday);
	        dto.setEMAIL(email);
	        dto.setADDRESS(address);
	        
	        HttpSession session = request.getSession();
	        session.getAttribute("psnCd");
	        T003Dao dao = new T003Dao();
	        int status = dao.update(dto, session);
	        if (status > 0) {
	            // cập nhật thành công, chuyển hướng về trang thông báo thành công
	            response.sendRedirect("/CustomerSystem_Servlet_Jsp/T002");
	        } else {
	            // cập nhật không thành công, chuyển hướng về trang thông báo lỗi
	            response.sendRedirect("error.jsp");
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        // nếu có lỗi xảy ra, chuyển hướng về trang thông báo lỗi
	        response.sendRedirect("error.jsp");
	    }
	}

}
