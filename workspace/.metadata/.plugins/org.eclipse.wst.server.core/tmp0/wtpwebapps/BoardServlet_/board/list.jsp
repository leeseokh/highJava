<%@page import="vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>내용</td>
		</tr>
		
	<% 
		int boardSize = boardList.size();
		
		if(boardSize > 0) {
			for(int i=0; i<boardSize; i++){
	%>	
		<tr>
			<td><%= boardList.get(i).getBoardNo() %></td>
			<td><a href="detail?boardNo=<%= boardList.get(i).getBoardNo() %>"><%= boardList.get(i).getBoardTitle() %></a></td>
			<td><%= boardList.get(i).getBoardWriter() %></td>
			<td><%= boardList.get(i).getBoardDate() %></td>
			<td><%= boardList.get(i).getBoardContent() %></td>
		</tr>
	<%
			}
		}else{ // 회원정보가 존재하지 않으면...
	%>
		
		<tr>
			<td colspan="5">게시글 정보가 없습니다.</td>
		</tr>
	
	<%
		}
	%>
		<tr align="center">
			<td colspan="5"><a href="insert">[게시글 등록]</a></td>
		</tr>
	
	</table>

</body>
</html>