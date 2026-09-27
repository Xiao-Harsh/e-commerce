# 👟 Soltrix — Backend API

A clean and lightweight REST API built with **Spring Boot 3.3**, **Spring Security**, and **JJWT** for secure token-based authentication. Features self-contained in-memory data storage with zero external database requirements.

---

## 🛠️ Tech Stack & Key Libraries

* **Framework**: Spring Boot 3.3
* **Security**: Spring Security & JJWT (JSON Web Token) v0.12.5
* **Storage**: In-Memory Thread-Safe Repositories
* **Build Tool**: Maven Wrapper (`mvnw`)
* **Container**: Docker (Multi-stage build)

---

## 📁 Package Structure

```text
backend/src/main/java/com/soltrix/
├── config/                 # Security, CORS, and password encoders
├── controller/             # REST endpoints (/auth, /products, /cart, /orders, /wishlist...)
├── dto/                    # Data Transfer Objects for request/response serialization
├── entity/                 # Clean Java data models
├── exception/              # Global custom exception handling
├── repository/             # In-memory storage repositories
├── security/               # JWT authentication filter & UserDetailsService
├── service/                # Business logic layer
├── DatabaseSeeder.java     # Seeds sample products, categories, and test accounts on startup
└── SoltrixApplication.java # Spring Boot application entry point
```

---

## ⚙️ Core REST API Endpoints

| Endpoint | Method | Access | Description |
| :--- | :---: | :---: | :--- |
| `/api/v1/auth/login` | `POST` | Public | Authenticate user and receive JWT |
| `/api/v1/auth/signup` | `POST` | Public | Register a new customer account |
| `/api/v1/products` | `GET` | Public | List products (supports `?search=` and `?category=`) |
| `/api/v1/products/{id}` | `GET` | Public | Get detailed specifications of a product |
| `/api/v1/cart` | `GET` | Customer | Get current user's shopping cart |
| `/api/v1/cart/items` | `POST` | Customer | Add product to cart with size and quantity |
| `/api/v1/cart/items/{id}` | `PUT` / `DELETE` | Customer | Update quantity or remove cart item |
| `/api/v1/orders` | `POST` | Customer | Place an order with shipping address |
| `/api/v1/orders` | `GET` | Customer | View customer order history |
| `/api/v1/wishlist` | `GET` | Customer | View favorited shoes |
| `/api/v1/wishlist/add/{id}` | `POST` | Customer | Add shoe to wishlist |
| `/api/v1/wishlist/remove/{id}` | `DELETE` | Customer | Remove shoe from wishlist |
| `/api/v1/admin/**` | `ALL` | Admin | Full product CRUD and order status management |

---

## ⚡ Running Locally

```bash
# Start backend using Maven wrapper
./mvnw spring-boot:run
```
*(On Windows Command Prompt, use `mvnw spring-boot:run`)*

The server will start on **`http://localhost:8080`**.

---

## 🐳 Docker Build

```bash
docker build -t soltrix-backend .
docker run -p 8080:8080 soltrix-backend
```
