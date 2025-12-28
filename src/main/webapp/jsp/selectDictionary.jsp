<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    .dictionary-item{
        display: flex;
        align-items: center;
        gap: 20px;
        margin: 10px 0;
        }
</style>

<title>辞書を選ぶ</title>
</head>
<body>

<c:if test="${not empty deleteDictErrorMsg}">
    <p style="color:red;">${deleteDictErrorMsg}</p>
</c:if>
<p><a href="/free_dictionary/home">ホームにもどる</a></p>
<h1> 辞書を選ぶ</h1>

<p><a href="/free_dictionary/jsp/createDictionary.jsp">辞書をつくる</a></p>


<!--<c:forEach var="name" items="${dictionaryNames}">
<p>${name}</p>
</c:forEach>-->

<c:forEach var="dictionary" items="${dictionaryinfo}">
    <div class="dictionary-item">
    
        <a href="${pageContext.request.contextPath}/SelectWord?dictionaryId=${dictionary.dictionaryId}">
            ${dictionary.dictionaryName}
        </a>
        
        <a href="${pageContext.request.contextPath}/EditDictionary?dictionaryId=${dictionary.dictionaryId}">
        編集</a>
    
 
        <!--  <a href="/free_dictionary/SelectWord">${dictionary.dictionaryName}</a> -->
        
        <form action="${pageContext.request.contextPath}/DeleteDictionary" method="post" style="display:inline;">
            <input type="hidden" name="dictionaryId"  value="${dictionary.dictionaryId}">
            <input type="submit" value="削除" onclick="return confirm('本当に削除しますか？');">
        </form>
    </div>
           
</c:forEach>

</body>
</html>