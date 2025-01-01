package ai.yuvi.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;

public class AppConfig {
    private static final Logger logger = Logger.getLogger(AppConfig.class.getName());
    private static final Properties properties = new Properties();
    private static Session mailSession;

    static {
        loadProperties();
        initializeMailSession();
    }

    private static void loadProperties() {
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find application.properties");
            }
            properties.load(input);
            logger.info("Application properties loaded successfully");
        } catch (IOException e) {
            logger.severe("Failed to load application properties: " + e.getMessage());
            throw new RuntimeException("Failed to load application properties", e);
        }
    }

    private static void initializeMailSession() {
        Properties mailProps = new Properties();
        mailProps.put("mail.smtp.host", properties.getProperty("mail.smtp.host"));
        mailProps.put("mail.smtp.port", properties.getProperty("mail.smtp.port"));
        mailProps.put("mail.smtp.auth", properties.getProperty("mail.smtp.auth"));
        mailProps.put("mail.smtp.ssl.enable", properties.getProperty("mail.smtp.ssl.enable"));

        mailSession = Session.getInstance(mailProps, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    properties.getProperty("mail.smtp.username"),
                    properties.getProperty("mail.smtp.password")
                );
            }
        });
        logger.info("Mail session initialized successfully");
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static Session getMailSession() {
        return mailSession;
    }

    public static String getOpenAIKey() {
        return properties.getProperty("openai.api.key");
    }

    public static String getAntropicKey() {
        return properties.getProperty("antropic_key");
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getBuildNumber() {
        return properties.getProperty("build.number", "1.0.0");
    }
}
