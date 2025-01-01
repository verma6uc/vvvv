package ai.yuvi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/")
public class MarketingPageServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(MarketingPageServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String servletPath = request.getServletPath();
        String jspPath;

        // Handle root path
        if (servletPath.equals("/") && (pathInfo == null || pathInfo.equals("/"))) {
            jspPath = "/WEB-INF/jsp/pages/marketing/home/index.jsp";
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        logger.info("Serving marketing page: " + servletPath + (pathInfo != null ? pathInfo : ""));
        request.getRequestDispatcher(jspPath).forward(request, response);
    }
}
