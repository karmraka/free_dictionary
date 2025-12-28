<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>単語をつくるの確認</title>
</head>

<body>
<p>確認したら登録ボタンを押してください</p>
<form action="/free_dictionary/CreateWordConfirm" method = "post">
    <table>
    <tr>
        <th>辞書『${dictionary.dictionaryName}』の単語登録</th>
        
    </tr>
    <tr>
        <th>単語名</th>
        <td><input type="hidden" name="wordName" value="${word.wordName}">${word.wordName}</td>
        
    </tr>
    <tr>
        <th>意味</th>
        <td><input type="hidden" name="wordDefinition" value="${word.wordDefinition}">${word.wordDefinition}</td>
        
    </tr>    
    <tr>
        <th>参照</th>
        <td><input type="hidden" name="wordReference" value="${word.wordReference}">${word.wordReference}</td>
        
    </tr>    
    <tr>    
        <th>タグ</th>
        <td><input type="hidden" name="tag" value="${word.tag}">${word.tag}</td>
        
    </tr>   
    
    <td><input type="hidden" name="dictionaryId"  value="${word.dictionaryId}"</td>
    
    <tr>
        <td><input type="submit" value="単語を登録"></td>
    </tr> 
       
    </table>
</form>

</body>
</html>