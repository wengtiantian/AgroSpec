# AgroSpec
Rural Characteristic Industry: Standardized Production Service Norms and Quality Evaluation System
# AgroSpec: Rural Characteristic Industry Standardization System
A comprehensive standardized production service and quality evaluation system for rural characteristic industries, built on the **RuoYi-Vue3** framework (Spring Boot + Vue3 + Element Plus). It integrates production standardization management, service specification, and quality evaluation to empower the digital transformation of rural industries.


## Project Overview
AgroSpec focuses on solving pain points in rural characteristic industries (e.g., agricultural products, rural services) such as non-uniform production standards, opaque service processes, and inefficient quality evaluation. The system provides end-to-end support from production supervision to quality assessment, helping governments, enterprises, and farmers achieve standardized operations and data-driven decision-making.

### Core Objectives
- Unify production standards for rural characteristic industries
- Standardize service processes (e.g., technical guidance, quality inspection)
- Realize visualized quality evaluation and data statistics
- Simplify industry management with low-code tools (code generator)


## Tech Stack
The system adopts a **前后端分离 (separated front-end and back-end)** architecture for flexibility and scalability.

| Layer       | Technology Stack                                                                 |
|-------------|----------------------------------------------------------------------------------|
| Backend     | Spring Boot 2.7.x, Spring Security, JWT, MyBatis-Plus, Redis, MySQL 8.0          |
| Frontend    | Vue 3, Vue Router 4, Vuex 4, Element Plus, Axios, Vite                          |
| DevOps      | Git, Maven, Docker, Nginx, Pagoda Panel (for server management)                  |
| Tools       | Ruoyi Code Generator (auto-generates CRUD code), Navicat (database management)    |


## System Structure
### 1. Repository Division
This project is split into two independent repositories for clear maintenance:
- **Backend**: [AgroSpec-backend](https://github.com/wengtiantian/AgroSpec-backend) (core business logic, API, data access)
- **Frontend**: [AgroSpec-frontend](https://github.com/wengtiantian/AgroSpec-frontend) (user interface, interactive logic)


### 2. Core Modules
#### Backend Modules (Based on RuoYi Framework)
| Module          | Responsibility                                                                 |
|-----------------|---------------------------------------------------------------------------------|
| `ruoyi-admin`   | Backend entry (controller layer, global configuration)                          |
| `ruoyi-system`  | Core business (user/role/menu management, rural industry data models)           |
| `ruoyi-common`  | Universal tools (utils, exceptions, annotations, global constants)              |
| `ruoyi-framework`| Framework core (security, cache, data source configuration)                    |
| `ruoyi-generator`| Low-code tool (auto-generates front/backend CRUD code from database tables)     |


#### Frontend Modules
| Directory       | Responsibility                                                                 |
|-----------------|---------------------------------------------------------------------------------|
| `src/api`       | API request encapsulation (e.g., industry standards, quality evaluation)        |
| `src/views`     | Page components (production supervision, service management, quality dashboard) |
| `src/components`| Reusable components (tables, forms, charts for rural industry data)             |
| `src/store`     | Global state management (user login status, permission control)                 |
| `src/router`    | Route configuration (permission-based route interception)                       |


## Quick Start
### 1. Prerequisites
Ensure the following tools are installed:
- JDK 1.8+, Maven 3.6+
- MySQL 8.0+, Redis 6.0+
- Node.js 16+, Npm 8+
- Git, IDE (IntelliJ IDEA/Vscode)


### 2. Backend Deployment
1. **Clone the repository**
   ```bash
   git clone https://github.com/wengtiantian/AgroSpec-backend.git
   cd AgroSpec-backend
   ```

2. **Configure the database**
   - Create a MySQL database (name: `agrospec`, charset: `utf8mb4`)
   - Import SQL files from the `sql/` directory:
     - `ry_20240529.sql` (system core tables)
   - Modify database configuration in `ruoyi-admin/src/main/resources/application-druid.yml`:
     ```yaml
     spring:
       datasource:
         druid:
           master:
             url: jdbc:mysql://localhost:3306/agrospec?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
             username: your_mysql_username
             password: your_mysql_password
     ```

3. **Start Redis**  
   Ensure Redis is running locally (default port: 6379) or modify Redis configuration in `application.yml`.

4. **Run the backend**
   - Open the project with IntelliJ IDEA
   - Run `com.ruoyi.RuoYiApplication` (main class)
   - Verify: Access `http://localhost:8080` (backend API base URL)


### 3. Frontend Deployment
1. **Clone the repository**
   ```bash
   git clone https://github.com/wengtiantian/AgroSpec-frontend.git
   cd AgroSpec-frontend
   ```

2. **Install dependencies**
   ```bash
   npm install --registry=https://registry.npmmirror.com  # Use Alibaba mirror for speed
   ```

3. **Configure backend API address**
   Modify `src/utils/request.js` to point to your backend service:
   ```javascript
   const service = axios.create({
     baseURL: import.meta.env.VITE_APP_BASE_API || 'http://localhost:8080', // Backend URL
     timeout: 10000
   })
   ```

4. **Start the frontend**
   ```bash
   npm run dev
   ```
   - Access `http://localhost:5270` (default frontend port)

## Server Deployment (Production Environment)
For public access, deploy the system to a cloud server (e.g., Alibaba Cloud) using **Pagoda Panel**:

### 1. Backend Deployment
1. Package the backend into a JAR file:
   ```bash
   mvn clean package -DskipTests  # Output: ruoyi-admin/target/ruoyi-admin.jar
   ```
2. Upload the JAR file to the server (path: `/www/wwwroot/agrospec/backend`)
3. In Pagoda Panel:
   - Install "Java Environment Manager" and JDK 1.8
   - Create a Java project (path: `/www/wwwroot/agrospec/backend/ruoyi-admin.jar`, port: 8080)
   - Start the project and verify port 8080 is open


### 2. Frontend Deployment
1. Build the frontend for production:
   ```bash
   npm run build:prod  # Output: dist/ directory
   ```
2. Compress `dist/` into `dist.zip` and upload to the server (path: `/www/wwwroot/agrospec/frontend`)
3. Unzip `dist.zip` and configure Nginx:
   ```nginx
   server {
     listen 80;  # Public access port
     server_name your_domain.com;  # Your server domain/IP

     root /www/wwwroot/agrospec/frontend/dist;
     index index.html;

     # Reverse proxy for backend API
     location /prod-api/ {
       proxy_pass http://127.0.0.1:8080/;
       proxy_set_header Host $host;
     }

     # Support Vue Router history mode
     try_files $uri $uri/ /index.html;
   }
   ```
4. Restart Nginx and access the system via your domain/IP.


## Usage Guide
### 1. Initial Configuration
After the first login (admin account), complete these steps:
1. **Role Management**: Define roles (e.g., "Supervisor", "Service Provider") and assign permissions.
2. **User Management**: Add system users and bind roles/departments.
3. **Standard Library Setup**: Import industry standards (e.g., planting technical standards) into the system.


### 2. Common Operations
- **Service Subject Access**: Click "Subject Application" on the website's homepage.
- **Evaluate Quality**: Go to "Quality Evaluation" → Select indicators → Generate evaluation reports.
- **Generate Code**: Use "System Tools" → "Code Generator" to auto-generate CRUD code for new business tables.


## Contribution
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m "Add: your feature description"`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request


## License
No licensed.


## Contact
For questions or suggestions, please contact:
- GitHub Issues: [Submit an Issue](https://github.com/wengtiantian/AgroSpec-backend/issues)
- Email: wtt20020105@qq.com
