<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   BoardVO boardVO = (BoardVO)request.getAttribute("boardVO");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
   <form method="post" action="<%=request.getContextPath() %>/board/update"><!--"< %=request.getContextPath() %>써주면 컨텍스트패스경로가 나온다(/ServletTest)  -->    
                                                
      <table>
         <tr>
            <td>제목</td>
            <td><input type="text" name="boardTitle" value="<%=boardVO.getBoardTitle() %>"></td>
         </tr>
         <tr>
            <td>내용</td>
            <td><textarea name="boardContent">value="<%=boardVO.getBoardContent() %>"</textarea> </td>
         </tr>
      </table>
      <input type="submit" value="회원 정보 수정">
   </form>
</body>
</html>