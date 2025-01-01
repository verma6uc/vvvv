package ai.yuvi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {
    "/", 
    "/features", 
    "/solutions", 
    "/agents", 
    "/docs",
    "/pricing",
    "/signin",
    "/signup",
    "/blog",
    "/support",
    "/about",
    "/careers",
    "/contact",
    "/forgot-password"
})
public class MarketingPageServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(MarketingPageServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String path = request.getServletPath();
        String jspPath;

        switch (path) {
            case "/":
                jspPath = "/WEB-INF/jsp/pages/marketing/home/index.jsp";
                break;
            case "/features":
                jspPath = "/WEB-INF/jsp/pages/marketing/features/index.jsp";
                break;
            case "/solutions":
                jspPath = "/WEB-INF/jsp/pages/marketing/solutions/index.jsp";
                break;
            case "/agents":
                jspPath = "/WEB-INF/jsp/pages/marketing/agents/index.jsp";
                break;
            case "/pricing":
                jspPath = "/WEB-INF/jsp/pages/marketing/pricing/index.jsp";
                break;
            case "/docs":
                jspPath = "/WEB-INF/jsp/pages/marketing/docs/index.jsp";
                break;
            case "/blog":
                jspPath = "/WEB-INF/jsp/pages/marketing/blog/index.jsp";
                break;
            case "/support":
                jspPath = "/WEB-INF/jsp/pages/marketing/support/index.jsp";
                break;
            case "/about":
                jspPath = "/WEB-INF/jsp/pages/marketing/company/about.jsp";
                break;
            case "/careers":
                jspPath = "/WEB-INF/jsp/pages/marketing/company/careers.jsp";
                break;
            case "/contact":
                jspPath = "/WEB-INF/jsp/pages/marketing/company/contact.jsp";
                break;
            case "/signin":
                jspPath = "/WEB-INF/jsp/pages/marketing/auth/signin.jsp";
                break;
            case "/signup":
                jspPath = "/WEB-INF/jsp/pages/marketing/auth/signup.jsp";
                break;
            case "/forgot-password":
                jspPath = "/WEB-INF/jsp/pages/marketing/auth/forgot-password.jsp";
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
        }

        logger.info("Serving marketing page: " + path);
        request.getRequestDispatcher(jspPath).forward(request, response);
    }
}
