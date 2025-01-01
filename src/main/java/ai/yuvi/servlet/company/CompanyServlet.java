package ai.yuvi.servlet.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {
    "/about/*",
    "/careers/*",
    "/contact/*"
})
public class CompanyServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CompanyServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String jspPath;

        switch (servletPath) {
            case "/about":
                if (pathInfo == null || pathInfo.equals("/")) {
                    jspPath = "/WEB-INF/jsp/pages/marketing/company/about/index.jsp";
                } else {
                    switch (pathInfo) {
                        case "/team":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/about/team.jsp";
                            break;
                        case "/mission":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/about/mission.jsp";
                            break;
                        case "/values":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/about/values.jsp";
                            break;
                        default:
                            response.sendError(HttpServletResponse.SC_NOT_FOUND);
                            return;
                    }
                }
                break;

            case "/careers":
                if (pathInfo == null || pathInfo.equals("/")) {
                    jspPath = "/WEB-INF/jsp/pages/marketing/company/careers/index.jsp";
                } else {
                    switch (pathInfo) {
                        case "/engineering":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/careers/engineering.jsp";
                            break;
                        case "/design":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/careers/design.jsp";
                            break;
                        case "/product":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/careers/product.jsp";
                            break;
                        case "/apply":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/careers/apply.jsp";
                            break;
                        default:
                            response.sendError(HttpServletResponse.SC_NOT_FOUND);
                            return;
                    }
                }
                break;

            case "/contact":
                if (pathInfo == null || pathInfo.equals("/")) {
                    jspPath = "/WEB-INF/jsp/pages/marketing/company/contact/index.jsp";
                } else {
                    switch (pathInfo) {
                        case "/sales":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/contact/sales.jsp";
                            break;
                        case "/support":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/contact/support.jsp";
                            break;
                        case "/press":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/contact/press.jsp";
                            break;
                        case "/success":
                            jspPath = "/WEB-INF/jsp/pages/marketing/company/contact/success.jsp";
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

        logger.info("Serving company page: " + servletPath + (pathInfo != null ? pathInfo : ""));
        request.getRequestDispatcher(jspPath).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();

        switch (servletPath) {
            case "/careers":
                if ("/apply".equals(pathInfo)) {
                    handleJobApplication(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
                break;

            case "/contact":
                if (pathInfo == null || pathInfo.equals("/")) {
                    handleContactForm(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void handleJobApplication(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement job application handling
        response.sendRedirect("/careers/apply/success");
    }

    private void handleContactForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement contact form handling
        response.sendRedirect("/contact/success");
    }
}
