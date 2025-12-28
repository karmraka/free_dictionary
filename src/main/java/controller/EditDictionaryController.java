package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DictionaryDAO;
import dto.DictionaryDTO;


@WebServlet("/EditDictionary")
public class EditDictionaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		String dictionaryIdStr = request.getParameter("dictionaryId");
		int dictionaryId = Integer.parseInt(dictionaryIdStr);
		
		DictionaryDAO dao = new DictionaryDAO();
		DictionaryDTO dictionary = dao.selectByDictionaryId(dictionaryId);
		
		request.setAttribute("dictionary", dictionary);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editDictionary.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
