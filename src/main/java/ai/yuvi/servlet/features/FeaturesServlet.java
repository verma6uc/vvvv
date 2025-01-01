package ai.yuvi.servlet.features;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/features/*")
public class FeaturesServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(FeaturesServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String jspPath;

        if (pathInfo == null || pathInfo.equals("/")) {
            // Main features page
            jspPath = "/WEB-INF/jsp/pages/marketing/features/index.jsp";
        } else {
            // Handle sub-pages
            switch (pathInfo) {
                case "/ai-driven-lifecycle":
                    jspPath = "/WEB-INF/jsp/pages/marketing/features/ai-driven-lifecycle.jsp";
                    break;
                case "/agentic-workflows":
                    jspPath = "/WEB-INF/jsp/pages/marketing/features/agentic-workflows.jsp";
                    break;
                case "/multi-tenant":
                    jspPath = "/WEB-INF/jsp/pages/marketing/features/multi-tenant.jsp";
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
            }
        }

        logger.info("Serving features page: " + (pathInfo != null ? pathInfo : "/"));
        request.getRequestDispatcher(jspPath).forward(request, response);
    }
}
