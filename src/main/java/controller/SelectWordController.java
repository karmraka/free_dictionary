package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DictionaryDAO;
import dao.WordDAO;
import dto.DictionaryDTO;
import dto.WordDTO;


@WebServlet("/SelectWord")
public class SelectWordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
		
		String dictionaryIdStr = request.getParameter("dictionaryId");
		System.out.println("dictionaryIdStr = " + dictionaryIdStr); 
		int dictionaryId = Integer.parseInt(dictionaryIdStr);
		
		DictionaryDAO dictDAO = new DictionaryDAO();
		DictionaryDTO dictionary = dictDAO.selectByDictionaryId(dictionaryId);
		request.setAttribute("dictionary", dictionary);
		
		WordDAO wordDAO= new WordDAO();
		List<WordDTO> wordList = wordDAO.selectByDictionaryId(dictionaryId);
		
		System.out.println("wordList.size()="+ wordList.size());
		
		request.setAttribute("wordinfo", wordList);
	
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/selectWord.jsp");
		rd.forward(request, response);	
		
	}


	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}*/

}
