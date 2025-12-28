<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>辞書をつくるの確認</title>
</head>
<body>

<p>確認したら登録ボタンを押してください</p>
<form action="/free_dictionary/CreateDictionaryConfirmController" method ="post">
    <table>
    <tr>
        <th>辞書名</th>
        <td><input type="hidden" name="dictionaryName" value="${dictionary.dictionaryName}">${dictionary.dictionaryName}</td>
        <td><input type="hidden" name="id" value="${dictionary.id}"></td>
        <td><input type="submit" value="辞書を登録"></td>
    </tr>
    </table>

</form>

</body>
</html>