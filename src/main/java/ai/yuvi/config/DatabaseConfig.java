package ai.yuvi.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;
import java.io.InputStream;

public class DatabaseConfig {
    private static final Logger logger = Logger.getLogger(DatabaseConfig.class.getName());
    private static ComboPooledDataSource dataSource;
    private static Properties properties;

    static {
        try {
            loadProperties();
        } catch (Exception e) {
            logger.severe("Failed to load application properties: " + e.getMessage());
            throw new RuntimeException("Failed to load application properties", e);
        }
    }

    private static void loadProperties() throws Exception {
        properties = new Properties();
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new Exception("Unable to find application.properties");
            }
            properties.load(input);
        }
    }

    public static DataSource getDataSource() {
        if (dataSource == null) {
            initializeDataSource();
        }
        return dataSource;
    }

    private static synchronized void initializeDataSource() {
        if (dataSource == null) {
            try {
                dataSource = new ComboPooledDataSource();
                
                // JDBC configuration
                dataSource.setDriverClass("org.postgresql.Driver");
                dataSource.setJdbcUrl(properties.getProperty("database.url"));
                dataSource.setUser(properties.getProperty("database.username"));
                dataSource.setPassword(properties.getProperty("database.password"));
                
                // Pool configuration
                dataSource.setMinPoolSize(Integer.parseInt(properties.getProperty("c3p0.minPoolSize", "5")));
                dataSource.setMaxPoolSize(Integer.parseInt(properties.getProperty("c3p0.maxPoolSize", "100")));
                dataSource.setAcquireIncrement(Integer.parseInt(properties.getProperty("c3p0.acquireIncrement", "10")));
                dataSource.setMaxIdleTime(Integer.parseInt(properties.getProperty("c3p0.maxIdleTime", "1800")));
                dataSource.setUnreturnedConnectionTimeout(
                    Integer.parseInt(properties.getProperty("c3p0.unreturnedConnectionTimeout", "30")));
                dataSource.setDebugUnreturnedConnectionStackTraces(
                    Boolean.parseBoolean(properties.getProperty("c3p0.debugUnreturnedConnectionStackTraces", "true")));

                // Set timezone if specified
                String timezone = properties.getProperty("database.timezone");
                if (timezone != null && !timezone.isEmpty()) {
                    dataSource.setProperties(new Properties() {{
                        setProperty("TimeZone", timezone);
                    }});
                }

                logger.info("Database connection pool initialized successfully");
            } catch (Exception e) {
                logger.severe("Failed to initialize database connection pool: " + e.getMessage());
                throw new RuntimeException("Failed to initialize database connection pool", e);
            }
        }
    }

    public static void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();
            logger.info("Database connection pool closed");
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
