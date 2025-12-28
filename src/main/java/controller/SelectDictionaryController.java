package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DictionaryDAO;
import domain.User;
import dto.DictionaryDTO;

/**
 * Servlet implementation class SelectDictionaryController
 */
@WebServlet("/SelectDictionary")
public class SelectDictionaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		User sessionUser = (User)session.getAttribute("user");
		int id = sessionUser.getId();
		
		
		DictionaryDAO dictDAO= new DictionaryDAO();
		List<String> dictionaryNames = dictDAO.selectAllDictionaryNameByUserId(id);
		 
		 List<DictionaryDTO> dictionaryinfo = dictDAO.selectAllDictionaryInfoByUserId(id); 
		
		 request.setAttribute("dictionaryNames", dictionaryNames);
		 session.setAttribute("dictionaryinfo", dictionaryinfo);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/selectDictionary.jsp");
		rd.forward(request, response);
		
		
		
		
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
