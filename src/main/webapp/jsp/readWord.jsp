<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>辞書を読む</title>
</head>

<body>
<p> <a href="/free_dictionary/home">ホームにもどる</a> / 
    <a href="${pageContext.request.contextPath}/SelectDictionary">辞書を選ぶ</a> / 
    <a href="${pageContext.request.contextPath}/SelectWord?dictionaryId=${word.dictionaryId}">単語を選ぶ</a> / 
    <a href="${pageContext.request.contextPath}/FreeIndex?wordId=${word.dictionaryId}">自由に目次を作る</a>
    </p>
<h2>辞書『${dictionary.dictionaryName}』</h2>
     <p>単語名：${word.wordName}</p>
     <p>意味：${word.wordDefinition}</p>
     <p>参照：${word.wordReference}</p>
     <p>タグ：${word.tag}</p>
</body>
</html>