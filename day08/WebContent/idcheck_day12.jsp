<%@page import="com.koreait.daoday12.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		String userid = request.getParameter("userid");
		MemberDAO mdao = new MemberDAO();
		if(!mdao.checkId(userid)){
			// 중복된 아이디가 없을경우
			out.print("ok");
			
		}else{
			// 중복된 아이디가 있을경우
			out.print("not-ok");
		}
	%>
