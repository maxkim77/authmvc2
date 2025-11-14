<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>DCU STUDY - 로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
    <!-- header -->
    <header class="layout-header">
        <h1><a href="${pageContext.request.contextPath}/">DCU STUDY</a></h1>

        <div>
            <a href="${pageContext.request.contextPath}/profile.do">프로필</a>
            <a href="${pageContext.request.contextPath}/login.do">로그인</a>
            <a href="${pageContext.request.contextPath}/logout.do">
                <button type="button">로그아웃</button>
            </a>
        </div>
    </header>
