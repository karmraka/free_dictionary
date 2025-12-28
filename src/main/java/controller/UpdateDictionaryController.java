package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DictionaryDAO;

/**
 * Servlet implementation class UpdateDictionaryController
 */
@WebServlet("/UpdateDictionary")
public class UpdateDictionaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String dictionaryIdStr = request.getParameter("dictionaryId");
		int dictionaryId = Integer.parseInt(dictionaryIdStr);
		
		String dictionaryName = request.getParameter("dictionaryName");
		
		
		DictionaryDAO dao = new DictionaryDAO();
		boolean result = dao.updateDictionaryName(dictionaryId, dictionaryName);
		
		if(!result) {
			request.setAttribute("errorMsg", "辞書名が変更できません");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/editDictionary.jsp");
			rd.forward(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/SelectDictionary");
		
		
	}

}
