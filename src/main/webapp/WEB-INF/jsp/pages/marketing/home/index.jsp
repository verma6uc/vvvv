<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<main class="main">
    <!-- Hero Section -->
    <section class="hero">
        <div class="container-fluid">
            <div class="hero-content">
                <h1 class="hero-title animate-fade-in">
                    Transform Ideas into
                    <span class="gradient-text">Intelligent Applications</span>
                </h1>
                <p class="hero-subtitle animate-fade-in">
                    Design, build, and deploy advanced software with AI Agents, all in one streamlined platform.
                </p>
                <div class="hero-buttons animate-fade-in">
                    <a href="/start-building" class="btn btn-primary">
                        <i data-feather="zap"></i>
                        Get Started
                    </a>
                    <a href="#how-it-works" class="btn btn-outline">
                        <i data-feather="play-circle"></i>
                        See How It Works
                    </a>
                </div>

                <!-- Code Window -->
                <div class="glass-card code-window animate-fade-in">
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
        </div>
    </section>

    <!-- Features Section -->
    <section class="features" id="features">
        <div class="container-fluid">
            <div class="section-header text-center">
                <h2 class="section-title gradient-text">Why Choose Yuvi?</h2>
                <p class="section-subtitle">Transform your development workflow with our AI-powered platform</p>
            </div>
            
            <div class="features-grid">
                <div class="glass-card highlight-blue animate-fade-in">
                    <i data-feather="zap" class="feature-icon"></i>
                    <h3>Rapid Development</h3>
                    <p>From concept to production in 96 hours</p>
                </div>
                <div class="glass-card highlight-purple animate-fade-in">
                    <i data-feather="users" class="feature-icon"></i>
                    <h3>AI-Powered Teams</h3>
                    <p>Specialized agents working in harmony</p>
                </div>
                <div class="glass-card highlight-blue animate-fade-in">
                    <i data-feather="check-circle" class="feature-icon"></i>
                    <h3>Code Quality</h3>
                    <p>Production-ready, maintainable code</p>
                </div>
                <div class="glass-card highlight-purple animate-fade-in">
                    <i data-feather="settings" class="feature-icon"></i>
                    <h3>Smart Automation</h3>
                    <p>Automated testing and deployment</p>
                </div>
                <div class="glass-card highlight-blue animate-fade-in">
                    <i data-feather="eye" class="feature-icon"></i>
                    <h3>Full Transparency</h3>
                    <p>Clear progress tracking and updates</p>
                </div>
                <div class="glass-card highlight-purple animate-fade-in">
                    <i data-feather="dollar-sign" class="feature-icon"></i>
                    <h3>Cost Effective</h3>
                    <p>Reduce development costs significantly</p>
                </div>
            </div>
        </div>
    </section>

    <!-- Process Section -->
    <section class="process" id="how-it-works">
        <div class="container-fluid">
            <div class="section-header text-center">
                <h2 class="section-title">From <span class="gradient-text blue">Spark</span> to <span class="gradient-text purple">Launch</span></h2>
                <p class="section-subtitle">Watch your idea transform through our streamlined development process</p>
            </div>
            
            <div class="process-steps">
                <div class="process-line"></div>
                <div class="glass-card process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="search"></i>
                    </div>
                    <h3>Research</h3>
                    <p>Market & User Analysis</p>
                </div>
                <div class="glass-card process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="file-text"></i>
                    </div>
                    <h3>Blueprint</h3>
                    <p>Technical Planning</p>
                </div>
                <div class="glass-card process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="layout"></i>
                    </div>
                    <h3>Visual PRD</h3>
                    <p>Interactive Design</p>
                </div>
                <div class="glass-card process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="code"></i>
                    </div>
                    <h3>Development</h3>
                    <p>AI-Powered Coding</p>
                </div>
                <div class="glass-card process-step animate-fade-in">
                    <div class="process-icon">
                        <i data-feather="send"></i>
                    </div>
                    <h3>Launch</h3>
                    <p>Production Deploy</p>
                </div>
            </div>
        </div>
    </section>

    <!-- CTA Section -->
    <section class="cta">
        <div class="container-fluid">
            <div class="glass-card cta-content text-center">
                <h2 class="gradient-text">Ready to Transform Your Ideas?</h2>
                <p>Join the future of software development with AI-powered automation.</p>
                <div class="cta-buttons">
                    <a href="/signup" class="btn btn-primary">Start Building Now</a>
                    <a href="/contact" class="btn btn-outline">Contact Sales</a>
                </div>
            </div>
        </div>
    </section>
</main>

<script>
    document.addEventListener('DOMContentLoaded', () => {
        // Initialize Feather Icons
        feather.replace();

        // Intersection Observer for fade-in animations
        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    entry.target.classList.add('visible');
                }
            });
        }, {
            threshold: 0.1
        });

        document.querySelectorAll('.animate-fade-in').forEach(el => {
            observer.observe(el);
        });
    });
</script>
