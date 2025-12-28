<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>辞書名を編集</title>
</head>
<body>
<h1>辞書『${dictionary.dictionaryName}』の名前の変更</h1>

<form action="${pageContext.request.contextPath}/UpdateDictionary" method="post">
    <input type="hidden" name="dictionaryId" value="${dictionary.dictionaryId}">
    
    <p>新しい辞書名</p>
    <p><input type="text" name="dictionaryName" placeholder="1～50文字"></p>
    <p><input type="submit" value="変更"></p>
     
</form>
<p><a href="${pageContext.request.contextPath}/SelectDictionary">辞書を選ぶに戻る</a></p>
<p><a href="/free_dictionary/home">ホームにもどる</a></p>

</body>
</html>