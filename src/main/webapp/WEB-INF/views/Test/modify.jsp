<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-08-05(005)
  Time: 오후 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .BigBox{width: 500px; height: 500px; border: 1px solid black;}
        #box1{width : 150px; height: 50px; border: 1px solid black;
            display:table-cell; vertical-align: middle;
        }
        #box2{width : 350px; height: 50px; border: 1px solid black;
            display:table-cell; vertical-align: middle;}
        #box3{width : 500px; height: 400px; border: 1px solid black;
            vertical-align: middle;}
        #box4{width : 500px; height: 50px; border: 5px solid black;}

    </style>


</head>
<body>

<form action="modify" name="modifyForm" method="post">


    <jsp:useBean id="now" class="java.util.Date" />
    <fmt:formatDate value="${detail.writeDate}" pattern="yyyy/MM/dd" var="writeDate" />
    <div class="BigBox">
        <div id="box1">글쓴이:<input type="text" name="writer" value="${detail.writer}"></div>
        <div id="box2">글제목:<input type="text" name="title" value="${detail.title}"></div>
        <div id="box4">작성일:<fmt:formatDate value="${detail.writeDate}"/></div>
        <div id="box3"><textarea name="content" cols="70" rows="25">${detail.content}</textarea></div>
        <input type="hidden" name="boardNum" value="${detail.boardNum}">
    </div>
    <input type="submit" value="수정">
    <a href="delete?boardNum=${detail.boardNum}" >삭제</a>
    <a href="#" onclick="history.back(); return false;">목록</a>

</form>


</body>
</html>
