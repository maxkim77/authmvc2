package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.UserBean;

@WebServlet("/profile.do")
public class UserProfileCon extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /** 기본 생성자 */
    public UserProfileCon() {
        super();
    }

    /**
     * 공통 요청 처리 메서드  
     * GET/POST 요청 모두 로그인 여부를 확인하고  
     * 로그인된 사용자에게 프로필 페이지를 전달한다.
     */
    protected void doProc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        UserBean loginUser = (session == null) ? null : (UserBean) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login.do");
            return;
        }

        request.setAttribute("user", loginUser);
        request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
    }

    /**
     * GET 요청 처리  
     * 프로필 화면 출력
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProc(request, response);
    }

    /**
     * POST 요청 처리  
     * GET 방식과 동일하게 동작
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProc(request, response);
    }
}
