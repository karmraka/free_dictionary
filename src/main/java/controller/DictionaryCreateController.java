package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Dictionary;
import service.DictionaryCreateService;
import validation.Validation;


@WebServlet("/DictionaryCreateController")
public class DictionaryCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String dictionaryName = request.getParameter("dictionaryName");
		
		Validation validation = new Validation();
		validation.isBlank("辞書名", dictionaryName);
		validation.length("辞書名", dictionaryName, 1, 50);
		
		if(validation.hasErrorMsg()) {
			request.setAttribute("errorMsg", validation.getErrorMsgList());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/createDictionary.jsp");
			rd.forward(request, response);
		}
		
		Dictionary dictionary = new Dictionary(id, dictionaryName);
		
		DictionaryCreateService dcs = new DictionaryCreateService();
		boolean result = dcs.dictionaryCreateConfirm(dictionary);
		
		if(result == true) {
			request.setAttribute("dictionary", dictionary);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/createDictionaryConfirm.jsp");
			rd.forward(request, response);
			
		}else {
			validation.addErrorMsg("辞書名" + dictionaryName + "は登録済みです");
			request.setAttribute("errorMsg", validation.getErrorMsgList());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/createDictionary.jsp");
			rd.forward(request, response);
		}
		
	}
	
	

}

