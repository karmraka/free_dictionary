package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserRegisterService;


@WebServlet("/registerConfirm")
public class RegisterConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		User user = new User(loginId,password,name); //confirmからのリクエスト情報をドメインに登録
		
		UserRegisterService userRegister = new UserRegisterService();
		boolean result = userRegister.userEntryDo(user);//userドメインをdbに登録するメソッド
		
		if(result == true) {//dbに問題なく登録できたら登録完了画面へ
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/registerDone.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("registerError", "登録に失敗しました。");
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
			rd.forward(request, response);
		  	
		}
	}

}
