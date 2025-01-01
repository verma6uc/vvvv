package ai.yuvi.servlet.solutions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/solutions/*")
public class SolutionsServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(SolutionsServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String jspPath;

        if (pathInfo == null || pathInfo.equals("/")) {
            // Main solutions page
            jspPath = "/WEB-INF/jsp/pages/marketing/solutions/index.jsp";
        } else {
            // Handle sub-pages
            switch (pathInfo) {
                // Industry Solutions
                case "/enterprise":
                    jspPath = "/WEB-INF/jsp/pages/marketing/solutions/industries/enterprise.jsp";
                    break;
                case "/startups":
                    jspPath = "/WEB-INF/jsp/pages/marketing/solutions/industries/startups.jsp";
                    break;
                case "/ecommerce":
                    jspPath = "/WEB-INF/jsp/pages/marketing/solutions/industries/ecommerce.jsp";
                    break;
                case "/healthcare":
                    jspPath = "/WEB-INF/jsp/pages/marketing/solutions/industries/healthcare.jsp";
                    break;

                // Case Studies
                case "/case-studies/pharma":
                    jspPath = "/WEB-INF/jsp/pages/marketing/solutions/case-studies/pharma.jsp";
                    break;
                case "/case-studies/ecommerce":
                    jspPath = "/WEB-INF/jsp/pages/marketing/solutions/case-studies/ecommerce.jsp";
                    break;
                case "/case-studies/hr":
                    jspPath = "/WEB-INF/jsp/pages/marketing/solutions/case-studies/hr.jsp";
                    break;
                case "/case-studies/finance":
                    jspPath = "/WEB-INF/jsp/pages/marketing/solutions/case-studies/finance.jsp";
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
            }
        }

        logger.info("Serving solutions page: " + (pathInfo != null ? pathInfo : "/"));
        request.getRequestDispatcher(jspPath).forward(request, response);
    }
}
