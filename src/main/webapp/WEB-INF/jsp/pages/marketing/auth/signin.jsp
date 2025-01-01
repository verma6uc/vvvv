<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In - Yuvi</title>
    
    <!-- Styles -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/styles.css">
    
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

    <style>
        /* Page-specific styles */
        .auth-container {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 2rem;
        }

        .auth-box {
            background: var(--bg-elevated);
            border-radius: 8px;
            padding: 2rem;
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        .auth-logo {
            width: 120px;
            margin-bottom: 2rem;
        }

        .auth-title {
            font-size: 1.75rem;
            margin-bottom: 1.5rem;
        }

        .auth-form {
            text-align: left;
        }

        .auth-separator {
            margin: 1.5rem 0;
            display: flex;
            align-items: center;
            text-align: center;
            color: var(--text-secondary);
        }

        .auth-separator::before,
        .auth-separator::after {
            content: '';
            flex: 1;
            border-bottom: 1px solid var(--border-color);
        }

        .auth-separator span {
            padding: 0 1rem;
        }

        .social-buttons {
            display: grid;
            gap: 1rem;
            margin-bottom: 1.5rem;
        }

        .btn-social {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
            width: 100%;
            padding: 0.75rem;
            border: 1px solid var(--border-color);
            border-radius: 4px;
            background: var(--bg-secondary);
            color: var(--text-primary);
            text-decoration: none;
            transition: all 0.2s;
        }

        .btn-social:hover {
            border-color: var(--accent-color);
            background: var(--bg-elevated);
        }

        .auth-footer {
            margin-top: 1.5rem;
            color: var(--text-secondary);
        }
    </style>
</head>
<body>
    <div class="auth-container">
        <div class="auth-box">
            <img src="/images/logo.svg" alt="Yuvi" class="auth-logo">
            <h1 class="auth-title">Welcome Back</h1>

            <div class="social-buttons">
                <a href="#" class="btn-social">
                    <i data-feather="github"></i>
                    Continue with GitHub
                </a>
                <a href="#" class="btn-social">
                    <i data-feather="gitlab"></i>
                    Continue with GitLab
                </a>
                <a href="#" class="btn-social">
                    <i data-feather="box"></i>
                    Continue with Bitbucket
                </a>
            </div>

            <div class="auth-separator">
                <span>or continue with email</span>
            </div>

            <form class="auth-form">
                <div class="form-group">
                    <label for="email" class="form-label">Email address</label>
                    <input type="email" id="email" class="form-control" placeholder="Enter your email">
                </div>

                <div class="form-group">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" class="form-control" placeholder="Enter your password">
                </div>

                <div class="form-group d-flex justify-content-between align-items-center">
                    <div class="form-check">
                        <input type="checkbox" id="remember" class="form-check-input">
                        <label for="remember" class="form-check-label">Remember me</label>
                    </div>
                    <a href="/forgot-password" class="text-primary">Forgot your password?</a>
                </div>

                <button type="submit" class="btn btn-primary w-100">Sign in</button>
            </form>

            <div class="auth-footer">
                Don't have an account? <a href="/signup">Sign Up</a>
            </div>
        </div>
    </div>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            feather.replace();
        });
    </script>
</body>
</html>
