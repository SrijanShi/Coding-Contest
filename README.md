# 🧩 Coding Contest Platform

A full-stack platform designed to host and manage online coding contests with an intuitive user interface and efficient backend processing.
This project consists of two main parts:
- **Backend:** Developed using **Spring Boot**, containerized via **Docker**.
- **Frontend:** Built using **React.js** for a smooth and dynamic user experience.

The platform allows users to register, log in, participate in contests, and submit coding problems — similar to online coding platforms like Codeforces or LeetCode.

---

## 🚀 1. Prerequisites

Before you begin, make sure you have the following installed:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Node.js](https://nodejs.org/) and [npm](https://www.npmjs.com/)
- Java 17 or later (only needed if running backend manually)

---

### 🚀 2. Clone the Repository

```bash
git clone [https://github.com/your-username/Coding-Contest-Platform.git](https://github.com/your-username/Coding-Contest-Platform.git)
cd Coding-Contest-Platform

```

### 3. Backend Setup (Spring Boot + Docker)

The backend is containerized using Docker for consistent setup across environments.

Run the following commands to start the backend:

```bash
cd backend
docker-compose up --build
````

This will:

* Build a Docker image of the Spring Boot application.
* Start a container exposing the backend API on port **8080**.

Once started, the backend should be accessible at:

```
http://localhost:8080
```

You can test if the backend is running by hitting:

```
http://localhost:8080/api/health
```

---

### 4. Frontend Setup (React.js)

The frontend is not containerized to keep development faster and simpler.

To set up and start the frontend:

```bash
cd ../shodh-a-code-frontend
npm install
npm start
```

This will start the frontend development server on:

```
http://localhost:3000
```

Ensure your backend container (from Docker) is running before launching the frontend to avoid API connection errors.

---

### 5. Optional: Run Backend Without Docker

If you prefer running the backend manually:

```bash
cd backend
./mvnw spring-boot:run
```

This will start the server on port **8080** as well.

---

## 🧠 API Design

The backend follows a **RESTful API** architecture. Below are a few main endpoints for demonstration purposes (you can extend this list as needed):

| Endpoint             | Method | Description                              | Request Example                                                      | Response Example                               |
| -------------------- | ------ | ---------------------------------------- | -------------------------------------------------------------------- | ---------------------------------------------- |
| `/api/auth/register` | `POST` | Register a new user                      | `{ "name": "John", "email": "john@email.com", "password": "12345" }` | `{ "id": 1, "email": "john@email.com" }`       |
| `/api/auth/login`    | `POST` | Authenticate user and return a JWT token | `{ "email": "john@email.com", "password": "12345" }`                 | `{ "token": "jwt-token-value" }`               |
| `/api/contests`      | `GET`  | Retrieve list of active contests         | —                                                                    | `[ { "id": 1, "title": "Weekly Challenge" } ]` |
| `/api/submissions`   | `POST` | Submit code for a problem                | `{ "problemId": 1, "code": "print('Hello')" }`                       | `{ "status": "Accepted" }`                     |

> 🔐 **Note:** Some endpoints are protected and require a valid JWT token in the `Authorization` header.

---

## 🧩 Design Choices & Justifications

### 🧱 Backend Architecture (Spring Boot)

Organized using a **Controller-Service-Repository** pattern:

* **Controller:** Handles HTTP requests and responses.
* **Service:** Contains the core business logic.
* **Repository:** Manages database operations using Spring Data JPA.

Other design considerations:

* **Entity-DTO Pattern:** Used to ensure a clean separation between persistence models and data transfer objects.
* **Security:** Implemented using **JWT-based authentication** for stateless session management.
* **Validation:** Uses Spring’s built-in validation annotations for cleaner and more reliable request handling.

---

### 🖥️ Frontend Architecture (React.js)

* Built with **React.js**, using **React Router** for navigation between pages.
* State management handled using **Context API** (or Redux if integrated later).
* **Axios** (or Fetch API) used for HTTP requests to communicate with the backend.
* Clean component-based structure ensuring scalability and reusability.

---

### 🐳 Docker & Deployment

The backend is fully containerized with **Docker** for:

* Consistent runtime environment.
* Easy setup using a single `docker-compose.yml` file.

The **Dockerfile** handles:

* Building the Spring Boot `.jar` file.
* Running the application on port **8080**.

The **docker-compose.yml** handles:

* Building the Docker image.
* Mapping ports (`8080:8080`).
* Managing environment variables if needed (like database config).

> ⚡ The frontend is **not containerized** intentionally to allow rapid local development and hot reloading.

---

### ⚙️ Example `docker-compose.yml`

```yaml
version: '3.8'
services:
  backend:
    build: .
    container_name: coding-contest-backend
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=dev
    restart: always
```

---

### ⚖️ Trade-offs and Challenges

| Challenge                | Description                                             | Solution / Trade-off                                           |
| ------------------------ | ------------------------------------------------------- | -------------------------------------------------------------- |
| **Docker networking**    | Ensuring Spring Boot container is accessible on host    | Exposed port `8080` in `docker-compose.yml`                    |
| **Token expiration**     | Managing JWT token lifecycle in frontend                | Added frontend interceptors to handle expiry and redirect      |
| **Frontend build speed** | Docker build for frontend was slower during development | Decided to run frontend outside Docker for faster dev workflow |

---

## 🧪 Testing

You can run backend unit tests using:

```bash
./mvnw test
```

Or if the container is running:

```bash
docker exec -it coding-contest-backend ./mvnw test
```

---

## 📁 Project Structure

```
Coding-Contest-Platform/
│
├── backend/                 # Spring Boot backend
│   ├── src/main/java/...    # Application source code
│   ├── pom.xml              # Maven dependencies
│   ├── Dockerfile           # Backend Docker configuration
│   └── docker-compose.yml   # Docker setup file
│
├── shodh-a-code-frontend/   # React frontend
│   ├── src/                 # UI components and pages
│   ├── package.json         # Frontend dependencies
│   └── public/              # Static files
│
├── .gitignore
├── package-lock.json
└── README.md
```

---

## 💡 Future Improvements

* Add an **admin panel** to manage contests and problems.
* Integrate **code execution API** (like Judge0) for real-time submission evaluation.
* Implement **leaderboards** and **contest analytics**.
* Add **Docker support for frontend** for complete containerization in production.

---

## 🧔 Author

**Srijan Shitashma**
📧 Email: [22ucc103@lnmiit.ac.in](mailto:22ucc103@lnmiit.ac.in)
📍 LNMIIT Jaipur

---

## 🏁 Conclusion

This project demonstrates a full-stack approach combining **Spring Boot**, **React**, and **Docker**.
The use of Docker simplifies backend deployment, while the separation of frontend and backend layers ensures scalability, maintainability, and cleaner development flow.


