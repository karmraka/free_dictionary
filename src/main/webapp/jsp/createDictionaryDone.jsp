<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>辞書作成完了</title>
</head>

<body>
  
    <h2>新しい辞書『${dictionary.dictionaryName}』が作成されました。<!-- dictionaryのdictId: ${dictionary.dictionaryId} dictionarysessionのdictionaryId: ${dictionaryses.dictionaryId}--></h2>
    
    <div>
    <!-- <a href="/free_dictionary/CreateWord">この辞書に単語をつくる</a>
    <a href="${pageContext.request.contextPath}/CreateWord?dictionaryId=${dictionaryId}">補足　アプリ名変更でも通用させる場合 -->
    
    <!--  <a href="/free_dictionary/CreateWord?dictionaryId=${dictionary.dictionaryId}">この辞書に単語を登録する</a>-->
    <!--  <a href="/free_dictionary/CreateWord?dictionaryId=${dictionary.dictionaryId}">この辞書に単語を登録する</a> <!-- dictionaryIdをcontrollerへリクエストで送る -->
    </div>
    
    <div>
    <a href= "/free_dictionary/SelectDictionary">辞書をえらぶ</a>
    </div>
    
</body>
</html>