<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Yuvi - Transform Ideas into Intelligent Applications</title>
    
    <!-- Styles -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/styles.css">
    
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Header -->
    <jsp:include page="../common/header.jsp" />

    <!-- Main Content -->
    <main>
        <!-- Hero Section -->
        <jsp:include page="sections/hero.jsp" />

        <!-- Features Section -->
        <jsp:include page="sections/features.jsp" />

        <!-- Agents Section -->
        <jsp:include page="sections/agents.jsp" />

        <!-- CTA Section -->
        <jsp:include page="sections/cta.jsp" />
    </main>

    <!-- Footer -->
    <jsp:include page="../common/footer.jsp" />
</body>
</html>
