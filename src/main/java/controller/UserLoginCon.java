package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.UserBean;
import model.UserDAO;

@WebServlet("/login.do")
public class UserLoginCon extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UserDAO userDAO = new UserDAO();

    public UserLoginCon() {
        super();
    }

    /** 
     * 공통 요청 처리 메서드 
     * - GET 요청 시 로그인 화면을 출력
     * - POST 요청 시 로그인 검증을 수행
     */
    protected void doProc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String method = request.getMethod();

        if ("GET".equalsIgnoreCase(method)) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                   .forward(request, response);
            return;
        }

        request.setCharacterEncoding("EUC-KR");

        String username = request.getParameter("user-id");
        String password = request.getParameter("user-pw");

        if (username == null || username.trim().isEmpty()
         || password == null || password.trim().isEmpty()) {

            request.setAttribute("error", "아이디와 비밀번호를 모두 입력해주세요");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                   .forward(request, response);
            return;
        }

        UserBean userBean = userDAO.login(username, password);

        if (userBean != null) {
            try {
                request.changeSessionId();
            } catch (Throwable e) {}

            HttpSession session = request.getSession(true);
            session.setAttribute("loginUser", userBean);

            response.sendRedirect(request.getContextPath() + "/profile.do");
        } else {
            request.setAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                   .forward(request, response);
        }
    }

    /** 
     * GET 요청 처리: 로그인 화면 출력
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProc(request, response);
    }

    /** 
     * POST 요청 처리: 로그인 검증
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProc(request, response);
    }
}
