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
import validation.Validation;


@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		//validationクラスで規定の条件に合わないとエラーメッセージが追加されていく
		Validation validation = new Validation();
		validation.isBlank("ユーザーID", loginId);
		validation.isBlank("パスワード", password);
		validation.isBlank("お名前", name);
		
		validation.length("ユーザーID", loginId, 1, 10);
		validation.length("パスワード", password, 4, 10);
		validation.length("お名前", name, 1, 30);
		
		//エラーが１以上でtrueを返すメソッドの呼び出し
		if(validation.hasErrorMsg()) {
			request.setAttribute("errorMsg", validation.getErrorMsgList());//エラーあれば、スコープにバリデーションのエラーメッセージをセット
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");//レジスターページにリクエストをフォワード（エラーメッセージ）
			rd.forward(request, response);
		}
		
		User user = new User(loginId, password, name);//ドメインにセット
		
		UserRegisterService registerService = new UserRegisterService();
		boolean result = registerService.userEntryConfirm(user);//ユーザーがすでにDBにないかチェック
		
		if(result == true) {//ユーザーチェックがtrueなら
			
			request.setAttribute("user", user);//ドメインをスコープにセットしてregisterconfirm画面へフォワード
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/registerConfirm.jsp");
			rd.forward(request, response);
		}else {//ユーザーがすでに登録されていたら
			validation.addErrorMsg(loginId + "は既につかわれています");//validationクラスにエラーメッセージを追加
			request.setAttribute("errorMsg", validation.getErrorMsgList());//validationクラスからエラーメッセージを取得しリクエストスコープにセット
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");//register画面へエラーメッセ時の格納されたスコープをフォワード
			rd.forward(request, response);
		}
	}

}
