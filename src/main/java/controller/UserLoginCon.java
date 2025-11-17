package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.UserBean;
import model.UserDAO;

/**
 * UserLoginCon
 * - 로그인 요청을 처리하는 컨트롤러(Servlet)
 * - "/login.do" URL로 들어오는 GET/POST 요청을 처리
 */
public class UserLoginCon extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UserDAO userDAO = new UserDAO();

    public UserLoginCon() {
        super();
    }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProc(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProc(request, response);
    }
}
