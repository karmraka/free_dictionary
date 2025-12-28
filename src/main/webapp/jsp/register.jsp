<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
</head>

<body>
    <h1>新規ユーザー登録</h1>
    
    <!--  エラーメッセージ表示 一つでもあれば errormsgはregistercontrollerからフォワードされている -->
    <c:if test="${errorMsg.size()>0 }">
        <ul>
            <c:forEach var="msg" items="${errorMsg}"><!-- errormsglistをmsgに取り出す拡張for文 -->
                <li style="color:red;">${msg}</li> <!-- スコープから取り出したエラーメッセージを赤字で表示 -->
            </c:forEach>
        </ul>
    </c:if>
    
    <c:if test="${registerError != null}"> <!--registererrorはregisterconfirmcontrollerからフォワードされている -->
        <div style="color:red;">
            <p>${registerError}</p>
        </div>
    </c:if>
    
    <h2>ユーザー登録</h2>
    <form action="/free_dictionary/register" method="post"> <!--  フォームの内容リクエストobjをregistercontrollerへpost -->
        <table border="1">
            <tr>
                <th>ユーザーID</th>
                <td><input type="text" name="loginId" placeholder="1～10文字"</td>
            </tr>
            
            <tr>
                <th>パスワード</th>
                <td><input type="text" name="password" placeholder="4～10文字"</td>
            </tr>
            
            <tr>
                <th>氏名</th>
                <td><input type="text" name="name" placeholder="1～30文字"</td>
            </tr>
        </table>
        
        <input type="submit" value="登録">
    
    </form>
    
    <p><a href="/free_dictionary/login">登録済みの方はこちら</a>   
    
</body>
</html>