<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<footer class="footer">
    <div class="container-fluid">
        <div class="footer-content">
            <div class="footer-logo">
                <img src="/images/logo.svg" alt="Yuvi" class="logo">
            </div>
            <div class="footer-links">
                <div class="footer-section">
                    <h4>Product</h4>
                    <a href="/features">Features</a>
                    <a href="/solutions">Solutions</a>
                    <a href="/agents">Agents</a>
                    <a href="/pricing">Pricing</a>
                </div>
                <div class="footer-section">
                    <h4>Resources</h4>
                    <a href="/docs">Documentation</a>
                    <a href="/blog">Blog</a>
                    <a href="/support">Support</a>
                </div>
                <div class="footer-section">
                    <h4>Company</h4>
                    <a href="/about">About</a>
                    <a href="/careers">Careers</a>
                    <a href="/contact">Contact</a>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2024 Yuvi. All rights reserved.</p>
        </div>
    </div>
</footer>

<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
<script>
    // Initialize Feather Icons
    document.addEventListener('DOMContentLoaded', () => {
        feather.replace();
    });

    // Smooth scroll for anchor links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });
</script>
