package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.UserBean;

/**
 * UserProfileCon
 * - 로그인된 사용자의 프로필 정보를 표시하는 컨트롤러(Servlet)
 * - "/profile.do" 요청을 처리하며, GET/POST 방식 모두 공통 로직(doProc)으로 처리
 */
public class UserProfileCon extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserProfileCon() {
        super();
    }
    protected void doProc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        UserBean loginUser = null;

        if (session != null) {
            loginUser = (UserBean) session.getAttribute("loginUser");
        }

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login.do");
            return;
        }

        request.setAttribute("user", loginUser);
        request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
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
