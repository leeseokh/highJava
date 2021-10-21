<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/lib/jquery-3.6.0.js"></script>
<script type="text/javascript">
	
	
</script>
</head>
<body>
	<form method="post" enctype="multipart.form-data" action="<%=request.getContextPath() %>/search/search.do">
		<table border="0">
			<tbody>
				<tr>
					<th>이름</th>
					<td><input type="text" name="memName" required></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="memTel" required></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td align="center" colspan="2"><input type="submit" value="찾기">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	<!-- error에 대한 처리 -->
    <%if(request.getParameter("error") != null){ %>
    <h6>해당하는 정보로 아이디를 찾지 못했습니다</h6>
    <%} %>
</body>
</html>