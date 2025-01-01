package ai.yuvi.servlet.resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {
    "/docs/*",
    "/blog/*",
    "/support/*"
})
public class ResourcesServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ResourcesServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String jspPath;

        switch (servletPath) {
            case "/docs":
                if (pathInfo == null || pathInfo.equals("/")) {
                    jspPath = "/WEB-INF/jsp/pages/marketing/resources/docs/index.jsp";
                } else {
                    switch (pathInfo) {
                        case "/getting-started":
                            jspPath = "/WEB-INF/jsp/pages/marketing/resources/docs/getting-started.jsp";
                            break;
                        case "/api":
                            jspPath = "/WEB-INF/jsp/pages/marketing/resources/docs/api.jsp";
                            break;
                        case "/tutorials":
                            jspPath = "/WEB-INF/jsp/pages/marketing/resources/docs/tutorials.jsp";
                            break;
                        case "/integrations":
                            jspPath = "/WEB-INF/jsp/pages/marketing/resources/docs/integrations.jsp";
                            break;
                        default:
                            response.sendError(HttpServletResponse.SC_NOT_FOUND);
                            return;
                    }
                }
                break;

            case "/blog":
                if (pathInfo == null || pathInfo.equals("/")) {
                    jspPath = "/WEB-INF/jsp/pages/marketing/resources/blog/index.jsp";
                } else {
                    if (pathInfo.startsWith("/category/")) {
                        String category = pathInfo.substring("/category/".length());
                        jspPath = "/WEB-INF/jsp/pages/marketing/resources/blog/category.jsp";
                        request.setAttribute("category", category);
                    } else if (pathInfo.startsWith("/tag/")) {
                        String tag = pathInfo.substring("/tag/".length());
                        jspPath = "/WEB-INF/jsp/pages/marketing/resources/blog/tag.jsp";
                        request.setAttribute("tag", tag);
                    } else if (pathInfo.startsWith("/author/")) {
                        String author = pathInfo.substring("/author/".length());
                        jspPath = "/WEB-INF/jsp/pages/marketing/resources/blog/author.jsp";
                        request.setAttribute("author", author);
                    } else {
                        // Assume it's a blog post URL
                        String postSlug = pathInfo.substring(1); // Remove leading slash
                        jspPath = "/WEB-INF/jsp/pages/marketing/resources/blog/post.jsp";
                        request.setAttribute("postSlug", postSlug);
                    }
                }
                break;

            case "/support":
                if (pathInfo == null || pathInfo.equals("/")) {
                    jspPath = "/WEB-INF/jsp/pages/marketing/resources/support/index.jsp";
                } else {
                    switch (pathInfo) {
                        case "/faq":
                            jspPath = "/WEB-INF/jsp/pages/marketing/resources/support/faq.jsp";
                            break;
                        case "/knowledge-base":
                            jspPath = "/WEB-INF/jsp/pages/marketing/resources/support/knowledge-base.jsp";
                            break;
                        case "/community":
                            jspPath = "/WEB-INF/jsp/pages/marketing/resources/support/community.jsp";
                            break;
                        case "/ticket":
                            jspPath = "/WEB-INF/jsp/pages/marketing/resources/support/ticket.jsp";
                            break;
                        case "/status":
                            jspPath = "/WEB-INF/jsp/pages/marketing/resources/support/status.jsp";
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

        logger.info("Serving resources page: " + servletPath + (pathInfo != null ? pathInfo : ""));
        request.getRequestDispatcher(jspPath).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();

        switch (servletPath) {
            case "/support":
                if ("/ticket".equals(pathInfo)) {
                    handleSupportTicket(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void handleSupportTicket(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement support ticket handling
        response.sendRedirect("/support/ticket/success");
    }
}
