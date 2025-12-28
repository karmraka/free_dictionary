package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WordDAO;


@WebServlet("/DeleteWord")
public class DeleteWordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int wordId = Integer.parseInt(request.getParameter("wordId"));
		int dictionaryId = Integer.parseInt(request.getParameter("dictionaryId"));
		
		WordDAO wordDAO = new WordDAO();
		int result = wordDAO.deleteWord(wordId);
		
		if(result == 1) {
			response.sendRedirect(request.getContextPath() + "/SelectWord?dictionaryId="  + dictionaryId);
		}else {
			request.setAttribute("deleteWordErrorMsg", "単語の削除に失敗しました");
			
			request.setAttribute("dictionaryId", dictionaryId);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/selectWord.jsp");
			rd.forward(request, response);
			
		}
	}

}
