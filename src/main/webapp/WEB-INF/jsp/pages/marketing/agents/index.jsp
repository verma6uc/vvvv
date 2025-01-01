<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AI Agents - Yuvi</title>
    
    <!-- Styles -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/styles.css">
    
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

    <style>
        /* Page-specific styles */
        .workflow-diagram {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 2rem;
            margin: 3rem 0;
        }

        .workflow-circle {
            width: 120px;
            height: 120px;
            border-radius: 50%;
            border: 2px solid var(--border-color);
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            background: var(--bg-elevated);
            position: relative;
        }

        .workflow-circle.active {
            border-color: var(--accent-color);
            box-shadow: 0 0 20px rgba(8, 160, 248, 0.2);
        }

        .processing-indicator {
            position: absolute;
            bottom: -25px;
            font-size: 0.875rem;
            color: var(--accent-color);
        }

        .capability {
            margin: 1rem 0;
        }

        .progress-bar {
            height: 6px;
            background: var(--bg-elevated);
            border-radius: 3px;
            margin-top: 0.5rem;
            position: relative;
        }

        .progress-bar::after {
            content: '';
            position: absolute;
            left: 0;
            top: 0;
            height: 100%;
            width: var(--progress);
            background: var(--accent-gradient);
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <jsp:include page="../common/header.jsp" />

    <!-- Main Content -->
    <main>
        <!-- Hero Section -->
        <jsp:include page="sections/hero.jsp" />

        <!-- Agent List Section -->
        <jsp:include page="sections/agent-list.jsp" />

        <!-- CTA Section -->
        <jsp:include page="../home/sections/cta.jsp" />
    </main>

    <!-- Footer -->
    <jsp:include page="../common/footer.jsp" />
</body>
</html>
