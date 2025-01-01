package ai.yuvi.servlet;

import ai.yuvi.config.AppConfig;
import ai.yuvi.config.DatabaseConfig;
import com.google.gson.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

@WebServlet("/health")
public class HealthCheckServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(HealthCheckServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        JsonObject health = new JsonObject();
        boolean isHealthy = true;
        String dbStatus = "UP";

        // Check database connection
        try (Connection conn = DatabaseConfig.getDataSource().getConnection()) {
            if (!conn.isValid(5)) {
                dbStatus = "DOWN";
                isHealthy = false;
            }
        } catch (Exception e) {
            logger.severe("Database health check failed: " + e.getMessage());
            dbStatus = "DOWN - " + e.getMessage();
            isHealthy = false;
        }

        // Build response
        health.addProperty("status", isHealthy ? "UP" : "DOWN");
        health.addProperty("buildNumber", AppConfig.getBuildNumber());
        
        JsonObject components = new JsonObject();
        components.addProperty("database", dbStatus);
        health.add("components", components);

        // Send response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(health.toString());
    }
}
