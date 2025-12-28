<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<style>
    .word-item{
        display: flex;
        align-items: center;
        gap: 20px;
        margin: 10px 0;
        }
</style>

<title>単語を選ぶ</title>
</head>

<body>

    <p><a href="/free_dictionary/home">ホームにもどる</a> / 
    <!-- <p><a href="/free_dictionary/jsp/createWord.jsp">単語をつくる</a></p> <!-- dictionaryIdのゲットの書き換えが必要 -->
    <a href="${pageContext.request.contextPath}/SelectDictionary">辞書を選ぶに戻る</a></p>
    <!-- param. はurlにかかれているdictionaryIdを取得する -->
   

    <h1>辞書『${dictionary.dictionaryName}』の単語を選ぶ</h1>
    <p><a href="${pageContext.request.contextPath}/CreateWord?dictionaryId=${param.dictionaryId}">
        単語をつくる</a></p>
    
    <c:forEach var="word" items="${wordinfo}">
    <div class="word-item">
        <p>
            <a href="${pageContext.request.contextPath}/ReadWord?wordId=${word.wordId}&dictionaryId=${param.dictionaryId}">
                ${word.wordName}
            </a>
        </p>
        
        <a href="${pageContext.request.contextPath}/EditWord?wordId=${word.wordId}&dictionaryId=${param.dictionaryId}">
        編集</a>
        
        <p>
            <form action="${pageContext.request.contextPath}/DeleteWord" method="post" style="display:inline;">
                <input type="hidden" name="wordId" value="${word.wordId}">
                <input type="hidden" name="dictionaryId" value="${param.dictionaryId}"> <!-- 単語を選ぶボタンからコントローラをとおしてurlにdictionaryIdが乗る、そこから取得 -->
                <input type="submit" value="削除" onclick="return confirm('本当に削除しますか？');">
            </form>
        </p>
        </div>
    </c:forEach>



</body>
</html>