<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>単語登録完了</title>
</head>

<body>
    <h2>辞書『${dictionary.dictionaryName}』に単語『${word.wordName}』を登録しました</h2>
    <!--
    <div>
    <a href="/free_dictionary/CreateWord?dictionaryId=${dictionary.dictionaryId}">この辞書に単語を登録する</a> dictionaryIdをcontrollerへリクエストで送る 
    </div>
    
    <div>
    <a href="/free_dictionary/SelectWord?dictionaryId=${dicitonary.dictionaryId}">この辞書の単語をえらぶ</a>
    </div>
    -->
    
    <div>
    <a href= "/free_dictionary/SelectDictionary">辞書をえらぶ</a>
    </div>
</body>
</html>