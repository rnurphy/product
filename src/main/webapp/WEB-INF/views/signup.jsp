<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	// 내장 객체
	
	// 저장소
	
	// application 객체 저장소(=ServletContext, 서블릿의 핵심, 심장, 모든 설정)
	// 생명주기: 서버가 켜지고 꺼질 때까지 저장 공간이 살아있다.
	
	// request 객체 저장소
	// 생명주기: 요청이 들어오고 응답이 될 때까지 저장 공간이 살아있다.
	
	// session 객체 저장소
	// 생명주기: 서버가 켜지고 꺼질 때까지 또는 세션 만료 시간까지 저장 공간이 살아있다.
	
	// 동일 key 값에서 무엇을 먼저 가져오는가? 우선순위
	// 1. request > 2. session > 3. application

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<input type="text" placeholder="username">
	<input type="password" placeholder="password">
	<input type="text" placeholder="name">
	<input type="email" placeholder="email">
	
	<button onclick="handleSignupSumbit();">회원가입</button>
	<img src="/product/hellotest/image.png">
	<script src="/product/static/js/signup.js"></script>
</body>
</html>























