<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberVo memVo = (MemberVo) request.getAttribute("memVo");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>ID:</td>
			<td><%=memVo.getMemId() %></td>
		</tr>
		<tr>
			<td>이름:</td>
			<td><%=memVo.getMemName() %></td>
		</tr>
		<tr>
			<td>전화번호:</td>
			<td><%=memVo.getMemTel() %></td>
		</tr>
		<tr>
			<td>주소:</td>
			<td><%=memVo.getMemAddr() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="list">[목록]</a>
				<a href="update?memId=<%=memVo.getMemId() %>">[회원정보 수정]</a>
				<a href="delete?memId=<%=memVo.getMemId() %>">[회원정보 삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>