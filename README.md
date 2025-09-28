# ZIDIOConnect - Internship & Job Portal Backend

A comprehensive, production-ready backend for ZIDIOConnect - a modern internship and job portal platform connecting students, recruiters, and companies. Built with Spring  Boot, featuring robust security, real-time notifications, and advanced analytics.

## 🚀 Features
 ### 🔐 Authentication & Authorization
   1. JWT-based authentication with refresh tokens

   2. Role-based access control (Student, Recruiter, Admin)

   3. Secure password encryption with BCrypt

   4. Session management with token expiration

 ### 👥 User Management
   1. Student Profiles: Resume upload, skills management, application tracking

   2. Recruiter Profiles: Company information, job posting management

   3. Admin Dashboard: User management, content moderation, analytics

 ### 💼 Job & Internship System
   1. Advanced job posting with rich text descriptions

   2. Smart search and filtering (location, salary, job type)

   3. Application tracking with status updates

   4. Bookmarking and recommendation system

 ### 💳 Payment & Subscription System
   1. Multiple subscription plans (Free, Premium, Enterprise)

   2. Secure payment processing

   3. Invoice generation and download

   4. Subscription status tracking
  
 ### 📊 Analytics & Dashboard
   1. Real-time application statistics

   2. User activity tracking

   3. Weekly application trends

   4. Admin reporting system

 ### 📧 Notification System
   1. Email notifications for application updates

   2. Registration confirmations

   3. System announcements

   4. Customizable email templates

 ### 🛡️ Security Features
   1. SQL injection prevention

   2. XSS protection

   3. CORS configuration

   4. Input validation and sanitization

   5. Secure file uploads

 ### 🛠️ Technology Stack
   1. Backend Framework: Spring Boot 2.7.0

   2. Security: Spring Security + JWT

   3. Database: MySQL 8.0 with Spring Data JPA

   4. File Storage: Cloudinary Integration

   5. Email: Spring Mail with SMTP

   6. PDF Generation: iText PDF

   7. Build Tool: Maven

   8. Java Version: 11+

## 📋 Prerequisites
   ### Before running this application, ensure you have:

   1. Java 11 or higher

   2. MySQL 8.0 or higher

   3. Maven 3.6 or higher

   4. Cloudinary account (for file uploads)

   5. SMTP server (Gmail, Outlook, etc.)

## ⚙️ Installation & Setup
   ### Clone the Repository
    git clone https://github.com/yourusername/ZidioConnect.git
    cd zidioconnect-backend
   ### Database Setup
    sql
    CREATE DATABASE zidioconnect;
    CREATE USER 'zidioconnect_user'@'localhost' IDENTIFIED BY 'your_password';
    GRANT ALL PRIVILEGES ON zidioconnect.* TO 'zidioconnect_user'@'localhost';
    FLUSH PRIVILEGES;
   ### Configuration
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
## Build and Run
   
   ### Build the project
    mvn clean install

   ### Run the application
    mvn spring-boot:run
   
   ### Or run the JAR file
    java -jar target/zidioconnect-1.0.0.jar
    The application will start on http://localhost:8080
 

## 📄 License
This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgments
   1. Spring Boot community

   2. MySQL documentation

   3. Cloudinary for file storage

   4. All contributors and testers

## 📞 Support
   For support, email palmiasaksham@gmail.com or create an issue in the repository.


## 🔗 Related Projects
ZIDIOConnect Frontend - React.js frontend application ( IN WORK ) 🚀

If you find this project helpful, please give it a ⭐ on GitHub!
