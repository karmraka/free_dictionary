package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Dictionary;
import service.DictionaryCreateService;

@WebServlet("/CreateDictionaryConfirmController")
public class CreateDictionaryConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	String dictionaryName = request.getParameter("dictionaryName");
	int id = Integer.parseInt(request.getParameter("id"));
	
	Dictionary dictionary = new Dictionary(id,dictionaryName);//ドメインへセット
	
	DictionaryCreateService dc = new DictionaryCreateService();//ｄｂへinsert
	boolean result = dc.dictionaryEntryDo(dictionary);
	//DictionaryDTO createdDic = dc.dictionaryEntryDo(dictionary);
	
	/*if(createdDic != null) {
		HttpSession session = request.getSession();
		session.setAttribute("dictionary", createdDic);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/createDictionaryDone.jsp");
		rd.forward(request, response);
	}*/
	
	if(result == true) {
		
		HttpSession session = request.getSession();
		session.setAttribute("dictionary",dictionary);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/createDictionaryDone.jsp");
		rd.forward(request, response);
		
	}else {
		request.setAttribute("dictionaryError","辞書作成できませんでした");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/createDictionary.jsp");
		rd.forward(request, response);
	}
	
	}

}
