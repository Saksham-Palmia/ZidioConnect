ZIDIOConnect - Internship & Job Portal Backend
https://img.shields.io/badge/Spring%2520Boot-2.7.0-brightgreen
https://img.shields.io/badge/Java-11-blue
https://img.shields.io/badge/MySQL-8.0-orange
https://img.shields.io/badge/JWT-Security-yellow
https://img.shields.io/badge/License-MIT-green
A comprehensive, production-ready backend for ZIDIOConnect - a modern internship and job portal platform connecting students, recruiters, and companies. Built with Spring Boot, featuring robust security, real-time notifications, and advanced analytics.

🚀 Features
🔐 Authentication & Authorization
 -JWT-based authentication with refresh tokens
 -Role-based access control (Student, Recruiter, Admin)
 -Secure password encryption with BCrypt
 -Session management with token expiration

👥 User Management
 -Student Profiles: Resume upload, skills management, application tracking
 -Recruiter Profiles: Company information, job posting management
 -Admin Dashboard: User management, content moderation, analytics

💼 Job & Internship System
 -Advanced job posting with rich text descriptions
 -Smart search and filtering (location, salary, job type)
 -Application tracking with status updates
 -Bookmarking and recommendation system

💳 Payment & Subscription System
 -Multiple subscription plans (Free, Premium, Enterprise)
 -Secure payment processing
 -Invoice generation and download
 -Subscription status tracking

📊 Analytics & Dashboard
 -Real-time application statistics
 -User activity tracking
 -Weekly application trends
 -Admin reporting system

📧 Notification System
 -Email notifications for application updates
 -Registration confirmations
 -System announcements
 -Customizable email templates

🛡️ Security Features
 -SQL injection prevention
 -XSS protection
 -CORS configuration
 -Input validation and sanitization
 -Secure file uploads

🛠️ Technology Stack
 -Backend Framework: Spring Boot 2.7.0
 -Security: Spring Security + JWT
 -Database: MySQL 8.0 with Spring Data JPA
 -File Storage: Cloudinary Integration
 -Email: Spring Mail with SMTP
 -PDF Generation: iText PDF
 -Build Tool: Maven
 -Java Version: 11+

📋 Prerequisites
 -Before running this application, ensure you have:
 -Java 11 or higher
 -MySQL 8.0 or higher
 -Maven 3.6 or higher
 -Cloudinary account (for file uploads)
 -SMTP server (Gmail, Outlook, etc.)

⚙️ Installation & Setup
1. Clone the Repository
 bash
 git clone https://github.com/yourusername/zidioconnect-backend.git
 cd zidioconnect-backend
2. Database Setup
 sql
 CREATE DATABASE zidioconnect;
 CREATE USER 'zidioconnect_user'@'localhost' IDENTIFIED BY 'your_password';
 GRANT ALL PRIVILEGES ON zidioconnect.* TO 'zidioconnect_user'@'localhost';
 FLUSH PRIVILEGES;
3. Configuration
 Update src/main/resources/application.properties with your configurations:

properties
 # Database Configuration
  spring.datasource.url=jdbc:mysql://localhost:3306/zidioconnect
  spring.datasource.username=your_username
  spring.datasource.password=your_password

 # JPA Configuration
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true

 # JWT Configuration
  jwt.secret=your_jwt_secret_key_here
  jwt.expiration=86400000

 # Email Configuration
  spring.mail.host=smtp.gmail.com
  spring.mail.port=587
  spring.mail.username=your_email@gmail.com
  spring.mail.password=your_app_password

 # Cloudinary Configuration
  cloudinary.cloud_name=your_cloud_name
  cloudinary.api_key=your_api_key
  cloudinary.api_secret=your_api_secret
4. Build and Run
 bash
 # Build the project
  mvn clean install

 # Run the application
  mvn spring-boot:run

 # Or run the JAR file
  java -jar target/zidioconnect-1.0.0.jar
  The application will start on http://localhost:8080

📞 Support
For support, email palmiasaksham@gmail.com or create an issue in the repository.

🔗 Related Projects
ZIDIOConnect Frontend - In Work

If you find this project helpful, please give it a ⭐ on GitHub!
