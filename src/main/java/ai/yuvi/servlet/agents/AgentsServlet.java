package ai.yuvi.servlet.agents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/agents/*")
public class AgentsServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(AgentsServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String jspPath;

        if (pathInfo == null || pathInfo.equals("/")) {
            // Main agents page
            jspPath = "/WEB-INF/jsp/pages/marketing/agents/index.jsp";
        } else {
            // Handle sub-pages
            switch (pathInfo) {
                // Individual Agent Pages
                case "/reading-agent":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/profiles/reading-agent.jsp";
                    break;
                case "/writing-agent":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/profiles/writing-agent.jsp";
                    break;
                case "/planning-agent":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/profiles/planning-agent.jsp";
                    break;
                case "/search-agent":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/profiles/search-agent.jsp";
                    break;

                // Agent Capabilities
                case "/capabilities/text-analysis":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/capabilities/text-analysis.jsp";
                    break;
                case "/capabilities/content-generation":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/capabilities/content-generation.jsp";
                    break;
                case "/capabilities/strategic-planning":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/capabilities/strategic-planning.jsp";
                    break;
                case "/capabilities/data-discovery":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/capabilities/data-discovery.jsp";
                    break;

                // Workflow Examples
                case "/workflows/memory-blueprint":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/workflows/memory-blueprint.jsp";
                    break;
                case "/workflows/visual-prd":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/workflows/visual-prd.jsp";
                    break;
                case "/workflows/collaborative":
                    jspPath = "/WEB-INF/jsp/pages/marketing/agents/workflows/collaborative.jsp";
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
            }
        }

        logger.info("Serving agents page: " + (pathInfo != null ? pathInfo : "/"));
        request.getRequestDispatcher(jspPath).forward(request, response);
    }
}
