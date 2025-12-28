<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>home</title>
</head>

<body>
    <div style="text-align: center"><h1><ホーム></h1></div>
    <p style="text-align: right">${user.name} さん 入会日時:${user.createdAtStr}</p>
    <p style="text-align: right"><a href="/free_dictionary/logout">ログアウト</a></p>
    <p style="text-align: right"><a href="/free_dictionary/useredit">アカウントの変更</a></p>
    <p style="text-align: right"><a href="/free_dictionary/userdelete">退会する</a></p>

    <h2>フリー辞書</h2>
    <p><a href="/free_dictionary//SelectDictionary">辞書を選ぶ</a></p>
    <p><a href="/free_dictionary/FreeIndex">自由に目次をつくる</a></p>
   
    
</body>
</html>