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
    
    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js" defer></script>
</head>
<body>
    <header class="header">
        <div class="container-fluid">
            <div class="header-content">
                <a href="/" class="logo-link">
                    <img src="/images/logo.svg" alt="Yuvi" class="logo">
                </a>
                
                <nav class="nav-links">
                    <a href="/features" class="nav-link">Features</a>
                    <a href="/solutions" class="nav-link">Solutions</a>
                    <a href="/agents" class="nav-link">Agents</a>
                    <a href="/docs" class="nav-link">Docs</a>
                    <div class="nav-buttons">
                        <a href="/signin" class="btn btn-outline">Sign In</a>
                        <a href="/signup" class="btn btn-primary">Sign Up</a>
                    </div>
                </nav>

                <button class="mobile-menu-toggle" aria-label="Toggle menu">
                    <i data-feather="menu"></i>
                </button>
            </div>
        </div>
    </header>

    <!-- Mobile Navigation -->
    <div class="mobile-nav">
        <div class="mobile-nav-content">
            <div class="mobile-nav-header">
                <img src="/images/logo.svg" alt="Yuvi" class="logo">
                <button class="mobile-nav-close" aria-label="Close menu">
                    <i data-feather="x"></i>
                </button>
            </div>
            <nav class="mobile-nav-links">
                <a href="/features" class="nav-link">Features</a>
                <a href="/solutions" class="nav-link">Solutions</a>
                <a href="/agents" class="nav-link">Agents</a>
                <a href="/docs" class="nav-link">Docs</a>
            </nav>
            <div class="mobile-nav-buttons">
                <a href="/signin" class="btn btn-outline w-100 mb-2">Sign In</a>
                <a href="/signup" class="btn btn-primary w-100">Sign Up</a>
            </div>
        </div>
    </div>

    <script>
        // Mobile menu functionality
        document.addEventListener('DOMContentLoaded', () => {
            const mobileMenuToggle = document.querySelector('.mobile-menu-toggle');
            const mobileNavClose = document.querySelector('.mobile-nav-close');
            const mobileNav = document.querySelector('.mobile-nav');

            mobileMenuToggle?.addEventListener('click', () => {
                mobileNav?.classList.add('active');
                document.body.style.overflow = 'hidden';
            });

            mobileNavClose?.addEventListener('click', () => {
                mobileNav?.classList.remove('active');
                document.body.style.overflow = '';
            });

            // Initialize Feather Icons
            feather.replace();
        });
    </script>
</body>
</html>
