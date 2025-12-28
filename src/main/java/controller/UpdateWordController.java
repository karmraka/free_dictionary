package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WordDAO;


@WebServlet("/UpdateWord")
public class UpdateWordController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int wordId = Integer.parseInt(request.getParameter("wordId"));
		int dictionaryId = Integer.parseInt(request.getParameter("dictionaryId"));
		String wordName = request.getParameter("wordName");
		String wordDefinition = request.getParameter("wordDefinition");
		String wordReference = request.getParameter("wordReference");
		String tag = request.getParameter("tag");
		
		WordDAO dao = new WordDAO();
		
		boolean result = dao.updateWord(wordId,wordName,wordDefinition,wordReference,tag);
		
		if(!result) {
			request.setAttribute("errorMsg", "単語の編集に失敗");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/editWord.jsp");
			rd.forward(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath() + "/SelectWord?dictionaryId="+ dictionaryId);
	}

}
