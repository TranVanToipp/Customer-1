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
import fjs.cs.dao.T001Dao;
import fjs.cs.dto.T001Dto;

/**
 * Servlet implementation class T001
 */
@WebServlet("/T001")
public class T001 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T001() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher myRD = null;
		//hiển thị màn hình login
		myRD = request.getRequestDispatcher(Constants.T001_LOGIN);
		myRD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String user = request.getParameter("userName");
			String pass = request.getParameter("password");
			T001Dao loginDao = new T001Dao();
			T001Dto result = loginDao.checkLogin(user, pass);
			if (result != null) {
				HttpSession session = request.getSession();
			    session.setAttribute("psnCd", result.getPSN_CD());
				response.sendRedirect("/CustomerSystem_Servlet_Jsp/T002");
			}else {
				String messageError = Constants.MESSAGE_ERROR_USER_NOT_EXIST;
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/T001.jsp");
				dispatcher.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
