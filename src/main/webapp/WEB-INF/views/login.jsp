<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

	<%@ include file ="header.jsp" %>
    <!-- main -->
    <main class="login">
        <h2 class="main-title">로그인</h2>
        <p class="main-desc">아이디와 비밀번호를 입력하고 로그인하세요</p>

        <!-- 에러 메시지 (있으면 출력, 없으면 빈 문자열) -->
        <p style="color:red;">${error}</p>

        <form id="main-form" method="post" action="${pageContext.request.contextPath}/login.do">
            <div class="flex-input">
                <label class="user-id">아이디</label>
                <input class="user-id" name="user-id" type="text" required />
            </div>
            <div class="flex-input">
                <label class="user-pw">비밀번호</label>
                <input class="user-pw" name="user-pw" type="password" required />
            </div>
            <button class="login-btn" type="submit">로그인</button>
        </form>
    </main>
	<%@ include file ="footer.jsp" %>

