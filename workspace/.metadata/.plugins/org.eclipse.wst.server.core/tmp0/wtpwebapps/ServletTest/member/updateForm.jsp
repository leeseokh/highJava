<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   MemberVo memVo = (MemberVo)request.getAttribute("memVo");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정</title>
</head>
<body>
   <!-- <form> 태그의 action 속성은 폼 데이터(form data)를 서버로 보낼 때 해당 데이터가 도착할 URL을 명시합니다. -->
   <form method="post" action="<%=request.getContextPath() %>/member/update"><!--"< %=request.getContextPath() %>써주면 컨텍스트패스경로가 나온다(/ServletTest)  -->    
                                                <!-- 절대경로로 쓰면 상위주소 이름을 바꾸면 에러가 떠서 상대경로 써주는게 좋다 -->
      <table>
         <tr>
            <td>ID:</td>
            <td><%=memVo.getMemId() %>
               <input type="hidden" name="memId" value="<%=memVo.getMemId() %>">
            </td>
         </tr>
         <tr>
            <td>이름:</td>
            <td><input type="text" name="memName" value="<%=memVo.getMemName() %>"></td>
         </tr>
         <tr>
            <td>전화번호:</td>
            <td><input type="text" name="memTel" value="<%=memVo.getMemTel() %>"></td>
         </tr>
         <tr>
            <td>주소:</td>
            <td><textarea name="memAddr">value="<%=memVo.getMemAddr() %>"</textarea> </td>
         </tr>
      </table>
      <input type="submit" value="회원 정보 수정">
   </form>
</body>
</html>