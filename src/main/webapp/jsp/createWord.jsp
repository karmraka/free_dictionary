<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>単語をつくる</title>
</head>

<body>
<h1>辞書『${dictionary.dictionaryName}』に単語をつくる</h1>
    <c:if test="${errorMsg.size() > 0 }">
         <li style = "color:red;">${msg}</li>
    </c:if>
    
    <c:if test="${wordError !=null}">
        <div style="color:red";>
            <p>${wordError}</p>
        </div>
     </c:if>
     
     <form action ="/free_dictionary/CreateWord" method="post">
         <table>
         <tr>
         <th>単語名</th>
            <td><input type="text" name="wordName" placeholder="単語を1～50文字"></td>
         </tr>
            
         <tr>   
         <th>意味</th>
            <td><textarea name="wordDefinition" rows="12" cols="80" placeholder="単語の説明"></textarea></td>
         </tr>
         
         <tr>
         <th>参照</th>
            <td><textarea name="wordReference" rows="6" cols="80" placeholder="参照"></textarea></td>
         </tr>
         
         <tr>
         <th>タグ</th>
            <td><input type="text" name="tag" placeholder="タグ"></td>
         </tr>
         
         <tr>  
            <td><input type="hidden" name="dictionaryId" value="${dictionary.dictionaryId}"></td>
            <!-- <td><input type="hidden" name="wordPoint" value="${dictionary.dictionaryId}"></td> -->
         </tr>
            
         <tr>
            <td><input type="submit" value="この単語を登録する"></td>
         </tr>
         </table>
        
        </form>
        
        <p><a href="/free_dictionary/home">ホームにもどる</a></p>
     

</body>
</html>