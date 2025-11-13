package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout.do")
public class UserLogoutCon extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserLogoutCon() {
        super();
    }

    /**
     * 공통 요청 처리 메서드  
     * 로그인 세션을 종료하고 로그인 페이지로 이동한다.
     */
    protected void doProc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect(request.getContextPath() + "/login.do");
    }

    /**
     * GET 요청 처리  
     * 로그아웃 실행
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProc(request, response);
    }

    /**
     * POST 요청 처리  
     * GET 방식과 동일하게 로그아웃 수행
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProc(request, response);
    }
}
