package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DictionaryDAO;


@WebServlet("/DeleteDictionary")
public class DeleteDictionaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	int dictionaryId = Integer.parseInt(request.getParameter("dictionaryId"));
	
	DictionaryDAO dictdao = new DictionaryDAO();
	int result = dictdao.deleteDictionary(dictionaryId);//リクエストから受けたdictIDのデータをでーたべーすでさくじょする
	
	if(result == 1) {
		response.sendRedirect(request.getContextPath() + "/SelectDictionary");//getContextPath()はfree_dictionary/と同義。アプリ名コンテキストパスの取得。
	}else {
		request.setAttribute("deleteDictErrorMsg", "辞書の削除に失敗しました");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/selectDictionary.jsp");
		rd.forward(request, response);
		
	
	}
	}

}
