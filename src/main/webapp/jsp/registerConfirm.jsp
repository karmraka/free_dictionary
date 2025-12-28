<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ユーザー登録確認</title>
</head>

<body>
    
    <h1>ユーザー登録確認</h1>
    <p>下記の登録内容に誤りがなければ登録ボタンを押してください</p>
    <form action="/free_dictionary/registerConfirm" method="post"> <!-- フォーム内容をregisterconfirmcontrollerへリクエストを送る -->
        <table border="1">
            <tr>
                <th>ユーザーID</th>
                <td><input type="hidden" name="loginId" value="${user.loginId}">${user.loginId}</td> <!-- registercontrollerでrequestscopeにkey userでセットしたloginIdを取得 -->
            </tr>
            <tr>
                <th>氏名</th>
                <td><input type="hidden" name="name" value="${user.name}">${user.name}</td>
            </tr>
            <tr>
                <th>パスワード</th>
                <td><input type="hidden" name="password" value="${user.password}">${user.password}</td>
         </table>
         <input type="submit" value="登録">
    </form>
  
</body>
</html>