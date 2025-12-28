<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>辞書をつくる</title>
</head>

<body>
<h1>辞書をつくる</h1>
    
        <c:if test="${errorMsg.size() > 0 }">
        <ul>
            <c:forEach var="msg" items="${errorMsg}">
                <li style = "color:red;">${msg}</li>
            </c:forEach>
        </ul>
        </c:if>
        
        <c:if test="${ dictionaryError != null}">
             <div style="color:red";>
                 <p>${dictionaryError}</p>
             </div>
         </c:if>
    
        
        <form action ="/free_dictionary/DictionaryCreateController" method= "post">
            <table>
            <tr>
            <th>辞書名</th>
            <td><input type="text" name="dictionaryName" placeholder="1～50文字"></td>
            <!-- <th>${user.id}</th> -->
            <td><input type="hidden" name="id" value="${user.id}"></td>
            <td><input type="submit" value="この名前で辞書をつくる"></td>
            </tr>
            </table>
        
        </form>
        
        <p><a href="/free_dictionary/home">ホームにもどる</a></p>
  

</body>
</html>