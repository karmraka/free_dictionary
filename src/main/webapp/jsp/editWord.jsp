<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>単語を編集</title>
</head>
<body>
<h1>辞書『${dictionary.dictionaryName}』の単語『${word.wordName}』の編集</h1>

<form action="${pageContext.request.contextPath}/UpdateWord" method="post">
    <input type="hidden" name="wordId" value="${word.wordId}">
    
    <table>
         <tr>
         <th>単語名</th>
            <td><input type="text" name="wordName" value="${word.wordName}"></td>
         </tr>
            
         <tr>   
         <th>意味</th>
            <td><textarea name="wordDefinition" rows="12" cols="80">${word.wordDefinition}</textarea></td>
         </tr>
         
         <tr>
         <th>参照</th>
            <td><textarea name="wordReference" rows="12" cols="80">${word.wordReference}</textarea></td>
         </tr>
         
         <tr>
         <th>タグ</th>
            <td><input type="text" name="tag" value="${word.tag}"></td>
         </tr>
         
         <tr>  
            <td><input type="hidden" name="dictionaryId" value="${dictionary.dictionaryId}"></td>
         </tr>
            
         <tr>
            <td><input type="submit" value="変更"></td>
         </tr>
         </table>
</form>
<p><a href="${pageContext.request.contextPath}/SelectDictionary">辞書を選ぶに戻る</a></p>
<p><a href="/free_dictionary/home">ホームにもどる</a></p>

</body>
</html>