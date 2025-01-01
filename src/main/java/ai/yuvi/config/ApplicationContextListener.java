package ai.yuvi.config;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(ApplicationContextListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // Initialize configurations
            AppConfig.getProperty("build.number"); // This will trigger static initialization
            DatabaseConfig.getDataSource(); // Initialize database connection pool
            logger.info("Application initialized successfully. Build: " + AppConfig.getBuildNumber());
        } catch (Exception e) {
            logger.severe("Failed to initialize application: " + e.getMessage());
            throw new RuntimeException("Application initialization failed", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            // Cleanup resources
            DatabaseConfig.closeDataSource();
            logger.info("Application shutdown completed successfully");
        } catch (Exception e) {
            logger.severe("Error during application shutdown: " + e.getMessage());
        }
    }
}
