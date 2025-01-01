# Yuvi Web Application

A Java web application using servlets, PostgreSQL, and various utility libraries. This application provides a foundation for building web services with database connectivity, email capabilities, and proper configuration management.

## Features

### Backend
- Pure Servlet-based web application (no Spring/Jersey)
- PostgreSQL database integration with C3P0 connection pooling
- Email support via JavaMail API
- JSON processing with Gson
- Logging with java.util.logging and SLF4J
- Health check endpoint
- Security headers and encoding filters
- Error pages and proper exception handling

### Frontend
- Modern, responsive UI with Bootstrap 5
- Dark theme support with CSS variables
- jQuery for DOM manipulation and AJAX
- Feather Icons for consistent iconography
- Full-width layout with responsive breakpoints
- Custom CSS with modern best practices:
  * CSS Grid and Flexbox for layouts
  * CSS Variables for theming
  * Mobile-first approach
  * Smooth transitions and animations

## Prerequisites

### Backend Requirements
- Java 11 or higher
- PostgreSQL database
- Maven 3.6 or higher
- Servlet container (e.g., Tomcat 9.x)

### Frontend Dependencies
```html
<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- Bootstrap 5 Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- Feather Icons -->
<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
```

### Theme Configuration
The application uses a customizable dark theme with CSS variables:
```css
:root {
  /* Dark theme colors */
  --bg-primary: #1a1a1a;
  --bg-secondary: #2c3e50;
  --text-primary: #ffffff;
  --text-secondary: #b3b3b3;
  --accent-color: #08A0F8;
  
  /* Layout */
  --header-height: 60px;
  --sidebar-width: 250px;
  --content-max-width: 1440px;
}
```

## Configuration

Copy `src/main/resources/application.properties.template` to `src/main/resources/application.properties` and configure your settings. The application uses this properties file for configuration. Key configuration areas include:

### Database Configuration
```properties
database.url=jdbc:postgresql://your-host:5432/your-db
database.username=your-username
database.password=your-password
database.timezone=Asia/Kolkata
```

### Connection Pool Settings
```properties
c3p0.minPoolSize=5
c3p0.maxPoolSize=100
c3p0.acquireIncrement=10
c3p0.maxIdleTime=1800
c3p0.unreturnedConnectionTimeout=30
```

### Email Configuration
```properties
mail.smtp.host=your-smtp-host
mail.smtp.port=465
mail.smtp.auth=true
mail.smtp.ssl.enable=true
mail.smtp.username=your-username
mail.smtp.password=your-password
mail.smtp.from=your-from-address
```

## Building the Application

```bash
mvn clean package
```

This will create a WAR file in the `target` directory.

## Deployment

1. Deploy the WAR file to your servlet container
2. Ensure `application.properties` is properly configured
3. Start the servlet container
4. Access the application at `http://localhost:8080/yuvi-web`

## Health Check

The application provides a health check endpoint at `/health` that returns:
- Overall application status
- Build number
- Database connection status

Example response:
```json
{
    "status": "UP",
    "buildNumber": "1.0.0",
    "components": {
        "database": "UP"
    }
}
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── ai/
│   │       └── yuvi/
│   │           ├── config/
│   │           │   ├── AppConfig.java
│   │           │   ├── ApplicationContextListener.java
│   │           │   └── DatabaseConfig.java
│   │           └── servlet/
│   │               └── HealthCheckServlet.java
│   ├── resources/
│   │   ├── application.properties
│   │   └── logging.properties
│   └── webapp/
│       ├── WEB-INF/
│       │   └── web.xml
│       ├── error/
│       │   ├── 404.html
│       │   └── 500.html
│       └── index.html
```

## Logging

The application uses java.util.logging configured via `logging.properties`. Logs include:
- Application startup/shutdown
- Database connection pool events
- Health check status
- Error conditions

## Security

The application implements several security measures:
- HTTP Security Headers (HSTS, X-Frame-Options, etc.)
- Secure session configuration
- HTTP-only cookies
- Character encoding filters

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
