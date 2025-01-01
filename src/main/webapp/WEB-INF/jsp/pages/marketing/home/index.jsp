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

    <!-- Hero Section -->
    <section class="hero">
        <div class="container-fluid">
            <h1 class="animate-fade-in">
                Your Vision,<br>Our AI Agents
            </h1>
            <p class="animate-fade-in">
                Transform your ideas into production-ready applications in 96 hours with our AI-powered development platform.
            </p>
            <div class="hero-buttons animate-fade-in">
                <a href="/start-building" class="btn btn-primary">Start Building</a>
                <a href="#how-it-works" class="btn btn-outline">See How It Works</a>
            </div>

            <!-- Code Window -->
            <div class="code-window animate-fade-in">
                <div class="code-dots">
                    <span class="code-dot red"></span>
                    <span class="code-dot yellow"></span>
                    <span class="code-dot green"></span>
                </div>
                <pre><code>
// Your idea
const productIdea = "A Pharma CRM for doctor management, sample tracking";

// Yuvi transform() into reality
const product = await Yuvi.build({
    idea: productIdea,
    timeline: "96 hours",
    requirements: "specification-ready"
});

// Development progress logs
console.log("Specification-ready");
                </code></pre>
            </div>
        </div>
    </section>

    <!-- Process Section -->
    <section class="process" id="how-it-works">
        <div class="container-fluid">
            <h2 class="section-title text-center">From Spark to Launch</h2>
            <p class="section-subtitle text-center">Watch your idea transform through our streamlined development process</p>
            
            <div class="process-steps">
                <div class="process-line"></div>
                <div class="process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="search"></i>
                    </div>
                    <h3>Research</h3>
                    <p>Market & User Analysis</p>
                </div>
                <div class="process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="file-text"></i>
                    </div>
                    <h3>Blueprint</h3>
                    <p>Technical Planning</p>
                </div>
                <div class="process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="layout"></i>
                    </div>
                    <h3>Visual PRD</h3>
                    <p>Interactive Design</p>
                </div>
                <div class="process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="code"></i>
                    </div>
                    <h3>Development</h3>
                    <p>AI-Powered Coding</p>
                </div>
                <div class="process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="send"></i>
                    </div>
                    <h3>Launch</h3>
                    <p>Production Deploy</p>
                </div>
            </div>
        </div>
    </section>

    <!-- Features Section -->
    <section class="features">
        <div class="container-fluid">
            <h2 class="section-title text-center">Why Choose Yuvi?</h2>
            <p class="section-subtitle text-center">Transform your development workflow with our AI-powered platform</p>
            
            <div class="features-grid">
                <div class="feature-card animate-fade-in">
                    <i data-feather="zap" class="feature-icon"></i>
                    <h3>Rapid Development</h3>
                    <p>From concept to production in 96 hours</p>
                </div>
                <div class="feature-card animate-fade-in">
                    <i data-feather="users" class="feature-icon"></i>
                    <h3>AI-Powered Teams</h3>
                    <p>Specialized agents working in harmony</p>
                </div>
                <div class="feature-card animate-fade-in">
                    <i data-feather="check-circle" class="feature-icon"></i>
                    <h3>Code Quality</h3>
                    <p>Production-ready, maintainable code</p>
                </div>
                <div class="feature-card animate-fade-in">
                    <i data-feather="settings" class="feature-icon"></i>
                    <h3>Smart Automation</h3>
                    <p>Automated testing and deployment</p>
                </div>
                <div class="feature-card animate-fade-in">
                    <i data-feather="eye" class="feature-icon"></i>
                    <h3>Full Transparency</h3>
                    <p>Clear progress tracking and updates</p>
                </div>
                <div class="feature-card animate-fade-in">
                    <i data-feather="dollar-sign" class="feature-icon"></i>
                    <h3>Cost Effective</h3>
                    <p>Reduce development costs significantly</p>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <jsp:include page="../common/footer.jsp" />

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            feather.replace();
        });
    </script>
</body>
</html>
