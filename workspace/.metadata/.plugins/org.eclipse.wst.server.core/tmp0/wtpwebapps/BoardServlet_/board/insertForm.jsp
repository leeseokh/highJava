<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신규글 등록</title>
</head>
<body>
	<form  method="post" action="<%=request.getContextPath()%>/board/insert">
		<table>
			<tr>
				<td>번호</td>
				<td><input type="text" name="boardNo"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle"></td>
			</tr>
			<tr>
				<td>작성자ㅣ</td>
				<td><input type="text" name="boardWriter"></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td><textarea name="boardDate"></textarea></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="boardContent"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="신규 글등록">
	</form>
</body>
</html>