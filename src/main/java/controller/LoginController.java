package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.UserLoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//ここでフォワードされてログインjspがブラウザに表示される
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		UserLoginService loginService = new UserLoginService();//パスワードなどチェックするクラスをインスタンス化
		User user = loginService.loginCheck(loginId, password);//フォームから得た情報をチェックしてドメインクラスへ渡す。
		
		if(user != null) {//ログイン成功したら
			HttpSession session = request.getSession();//セッションスコープ取得
			session.setAttribute("user",user); //インスタンス化したドメインクラスをキーワードuserでセッションスコープにセット
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/home.jsp");
			rd.forward(request, response);//セットしたセッションスコープをhome画面へフォワード
		}else {
			request.setAttribute("loginError", "ログインIDまたはパスワードが間違っています");//loginerroでメッセージをリクエストスコープにセット
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
			rd.forward(request, response);//リクエストスコープにセットしたエラーメッセージをログイン画面へフォワード
		}
	}

}
