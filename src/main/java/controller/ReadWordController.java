package controller;

import java.io.IOException;

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


@WebServlet("/ReadWord")
public class ReadWordController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String wordIdStr = request.getParameter("wordId");
		int wordId = Integer.parseInt(wordIdStr);
		String dictionaryIdStr =  request.getParameter("dictionaryId");
		int dictionaryId = Integer.parseInt(dictionaryIdStr);
		
		WordDAO wordDAO = new WordDAO();
		WordDTO dto = wordDAO.selectByWordId(wordId);
		
		DictionaryDAO dictionaryDAO = new DictionaryDAO();
		DictionaryDTO dictionary = dictionaryDAO.selectByDictionaryId(dictionaryId);
		
		request.setAttribute("word", dto);
		request.setAttribute("dictionary", dictionary);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/readWord.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
