package ai.yuvi.servlet.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {
    "/signin/*",
    "/signup/*",
    "/forgot-password/*"
})
public class AuthServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(AuthServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String jspPath;

        // Handle main auth pages
        switch (servletPath) {
            case "/signin":
                if (pathInfo == null || pathInfo.equals("/")) {
                    jspPath = "/WEB-INF/jsp/pages/marketing/auth/signin.jsp";
                } else {
                    // Handle OAuth providers
                    switch (pathInfo) {
                        case "/github":
                            jspPath = "/WEB-INF/jsp/pages/marketing/auth/oauth/github.jsp";
                            break;
                        case "/gitlab":
                            jspPath = "/WEB-INF/jsp/pages/marketing/auth/oauth/gitlab.jsp";
                            break;
                        case "/bitbucket":
                            jspPath = "/WEB-INF/jsp/pages/marketing/auth/oauth/bitbucket.jsp";
                            break;
                        default:
                            response.sendError(HttpServletResponse.SC_NOT_FOUND);
                            return;
                    }
                }
                break;

            case "/signup":
                if (pathInfo == null || pathInfo.equals("/")) {
                    jspPath = "/WEB-INF/jsp/pages/marketing/auth/signup.jsp";
                } else {
                    // Handle OAuth signup
                    switch (pathInfo) {
                        case "/github":
                            jspPath = "/WEB-INF/jsp/pages/marketing/auth/oauth/github-signup.jsp";
                            break;
                        case "/gitlab":
                            jspPath = "/WEB-INF/jsp/pages/marketing/auth/oauth/gitlab-signup.jsp";
                            break;
                        case "/bitbucket":
                            jspPath = "/WEB-INF/jsp/pages/marketing/auth/oauth/bitbucket-signup.jsp";
                            break;
                        case "/verify":
                            jspPath = "/WEB-INF/jsp/pages/marketing/auth/verify.jsp";
                            break;
                        default:
                            response.sendError(HttpServletResponse.SC_NOT_FOUND);
                            return;
                    }
                }
                break;

            case "/forgot-password":
                if (pathInfo == null || pathInfo.equals("/")) {
                    jspPath = "/WEB-INF/jsp/pages/marketing/auth/forgot-password.jsp";
                } else {
                    switch (pathInfo) {
                        case "/reset":
                            jspPath = "/WEB-INF/jsp/pages/marketing/auth/reset-password.jsp";
                            break;
                        case "/success":
                            jspPath = "/WEB-INF/jsp/pages/marketing/auth/reset-success.jsp";
                            break;
                        default:
                            response.sendError(HttpServletResponse.SC_NOT_FOUND);
                            return;
                    }
                }
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
        }

        logger.info("Serving auth page: " + servletPath + (pathInfo != null ? pathInfo : ""));
        request.getRequestDispatcher(jspPath).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Handle form submissions
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();

        switch (servletPath) {
            case "/signin":
                // Handle sign in form submission
                handleSignIn(request, response);
                break;

            case "/signup":
                // Handle sign up form submission
                handleSignUp(request, response);
                break;

            case "/forgot-password":
                // Handle password reset request
                handlePasswordReset(request, response);
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void handleSignIn(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement sign in logic
        response.sendRedirect("/dashboard");
    }

    private void handleSignUp(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement sign up logic
        response.sendRedirect("/signup/verify");
    }

    private void handlePasswordReset(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement password reset logic
        response.sendRedirect("/forgot-password/success");
    }
}
