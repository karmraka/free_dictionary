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


@WebServlet("/EditWord")
public class EditWordController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wordIdStr = request.getParameter("wordId");
		String dictionaryIdStr = request.getParameter("dictionaryId");
		
		int wordId = Integer.parseInt(wordIdStr);
		int dictionaryId = Integer.parseInt(dictionaryIdStr);
		
		WordDAO wordDAO = new WordDAO();
		WordDTO word = wordDAO.selectByWordId(wordId);
		
		DictionaryDAO dictDAO = new DictionaryDAO();
		DictionaryDTO dictionary = dictDAO.selectByDictionaryId(dictionaryId);
		
		request.setAttribute("word", word);
		request.setAttribute("dictionary", dictionary);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editWord.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
