<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	// ���� ��ü
	
	// �����
	
	// application ��ü �����(=ServletContext, ������ �ٽ�, ����, ��� ����)
	// �����ֱ�: ������ ������ ���� ������ ���� ������ ����ִ�.
	
	// request ��ü �����
	// �����ֱ�: ��û�� ������ ������ �� ������ ���� ������ ����ִ�.
	
	// session ��ü �����
	// �����ֱ�: ������ ������ ���� ������ �Ǵ� ���� ���� �ð����� ���� ������ ����ִ�.
	
	// ���� key ������ ������ ���� �������°�? �켱����
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
	
	<button onclick="handleSignupSumbit();">ȸ������</button>
	<img src="/product/hellotest/image.png">
	<script src="/product/static/js/signup.js"></script>
</body>
</html>























