package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * UserLogoutCon
 * - 로그아웃 처리를 담당하는 컨트롤러(Servlet)
 * - "/logout.do" 요청 시 로그인 세션을 종료하고 로그인 페이지로 이동
 */
public class UserLogoutCon extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserLogoutCon() {
        super();
    }

    protected void doProc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect(request.getContextPath() + "/login.do");
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
