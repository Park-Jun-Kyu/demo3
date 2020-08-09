<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-08-04(004)
  Time: 오후 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Canvas</title>
    <style type="text/css">
        body{
            line-height:2em;
            font-family:"맑은 고딕";
        }
        ul, li{
            list-style:none;
            text-align:center;
            padding:0;
            margin:0;
        }

        #mainWrapper{
            width: 800px;
            margin: 0 auto; /*가운데 정렬*/
        }

        #mainWrapper > ul > li:first-child {
            text-align: center;
            font-size:14pt;
            height:40px;
            vertical-align:middle;
            line-height:30px;
        }

        #ulTable {margin-top:10px;}


        #ulTable > li:first-child > ul > li {
            background-color:#c9c9c9;
            font-weight:bold;
            text-align:center;
        }

        #ulTable > li > ul {
            clear:both;
            padding:0px auto;
            position:relative;
            min-width:40px;
        }
        #ulTable > li > ul > li {
            float:left;
            font-size:10pt;
            border-bottom:1px solid silver;
            vertical-align:baseline;
        }

        #ulTable > li > ul > li:first-child               {width:10%;} /*No 열 크기*/
        #ulTable > li > ul > li:first-child +li           {width:45%;} /*제목 열 크기*/
        #ulTable > li > ul > li:first-child +li+li        {width:20%;} /*작성일 열 크기*/
        #ulTable > li > ul > li:first-child +li+li+li     {width:15%;} /*작성자 열 크기*/
        #ulTable > li > ul > li:first-child +li+li+li+li{width:10%;} /*조회수 열 크기*/

        #divPaging {
            clear:both;
            margin:0 auto;
            width:220px;
            height:50px;
        }

        #divPaging > div {
            float:left;
            width: 30px;
            margin:0 auto;
            text-align:center;
        }

        #liSearchOption {clear:both;}
        #liSearchOption > div {
            margin:0 auto;
            margin-top: 30px;
            width:auto;
            height:100px;

        }

        .left {
            text-align : left;
        }

        a:link { color: red; text-decoration: none;}

        table.type11 {
            border-collapse: separate;
            border-spacing: 1px;
            text-align: center;
            line-height: 1.5;
            margin: 20px 10px;
        }
        table.type11 th {
            width: 155px;
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
            color: #fff;
            background: #ce4869 ;
        }
        table.type11 td {
            width: 155px;
            padding: 10px;
            vertical-align: top;
            border-bottom: 1px solid #ccc;
            background: #eee;
        }


    </style>

</head>
<body>
<div id="mainWrapper">

    <ul>
        <!-- 게시판 제목 -->
        <li>게시판 Title </li>

        <!-- 게시판 목록  -->

        <jsp:useBean id="now" class="java.util.Date"/>


        <table class="type11">
            <thead>


            <tr>
                <th scope="cols">No</th>
                <th scope="cols">제목</th>
                <th scope="cols">작성일</th>
                <th scope="cols">작성자</th>
                <th scope="cols">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="list" items="${list}">
                <fmt:formatDate value="${list.writeDate}" pattern="yyyy/MM/dd" var="writeDate"/>
            <tr>
                <td>${list.boardNum}</td>
                <td><a href="detail?boardNum=${list.boardNum}">${list.title}</a></td>
                <td><fmt:formatDate value="${list.writeDate}" pattern="yyyy/MM/dd"/></td>
                <td>${list.writer}</td>
                <td>${list.hit}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>




        <a href="writeView"> <input type='button' value='글쓰기'/></a>

        <!-- 게시판 페이징 영역 -->
        <li>


    <div class="allPageMoving1">
        <c:if test="${pDto.listCnt ne 0}">
        <a href="list?curPage=1&search=${sv.search}&boardNum=${sv.boardNum}" class="n">◀</a>
        <c:if test="${pDto.prev_page}">

            <a href="list?curPage=${pDto.start_page-1}&search=${sv.search}&boardNum=${sv.boardNum}">이전</a>
        </c:if>

        <c:forEach begin="${pDto.start_page}" end="${pDto.end_page}" step="1" var="index">
            <c:if test="${pDto.curPage eq index}">
                <a  href="list?curPage=${index}&search=${sv.search}&boardNum=${sv.boardNum}">${index}</a>
            </c:if>
            <c:if test="${pDto.curPage ne index}">
                <a href="list?curPage=${index}&search=${sv.search}&boardNum=${sv.boardNum}">${index}</a>


            </c:if>
        </c:forEach>

        <c:if test="${pDto.next_page}">
            <a href="list?curPage=${pDto.end_page+1}&search=${sv.search}&boardNum=${sv.boardNum}" class="next">다음</a>
        </c:if>


        <a href="list?curPage=${pDto.page_cnt}&search=${sv.search}&boardNum=${sv.boardNum}" class="n">▶</a>

        </c:if>
    </div>

            <!-- //페이징이동1 -->
        </li>

        <!-- 검색 폼 영역 -->
        <li id='liSearchOption'>
            <div>
                <select id='search' >
                    <option value='A'>제목+내용</option>
                    <option value='T'>제목</option>
                    <option value='C'>내용</option>
                </select>
                <input id='txtKeyWord' />
                <input type='button' value='검색'/>
            </div>
        </li>

    </ul>
</div>
</body>
</html>


