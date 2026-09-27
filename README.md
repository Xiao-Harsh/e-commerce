# 👟 Soltrix — Modern Footwear E-Commerce Platform

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-green?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-19-blue?style=for-the-badge&logo=react)](https://react.dev)
[![Vite](https://img.shields.io/badge/Vite-8-purple?style=for-the-badge&logo=vite)](https://vite.dev)
[![Tailwind CSS](https://img.shields.io/badge/Tailwind%20CSS-4-38bdf8?style=for-the-badge&logo=tailwindcss)](https://tailwindcss.com)
[![Docker](https://img.shields.io/badge/Docker-Ready-blue?style=for-the-badge&logo=docker)](https://www.docker.com)

**Soltrix** is a full-stack, responsive e-commerce web application designed for footwear. Built with a modern **React 19** frontend and a self-contained **Spring Boot 3** REST API.

---

## ✨ Features

- **Cinematic Experience**: Nike-inspired hero slider, dynamic shoe platform showcase, and smooth micro-animations.
- **Product Catalog**: Live search, category filters (Sneakers, Running, Casual, Formal), and detailed product pages.
- **Cart & Checkout**: Interactive cart drawer, size selection, quantity controls, and multi-step checkout.
- **Wishlist & Favorites**: Heart icons with instant state updates across all product cards and a dedicated wishlist page.
- **User Authentication**: Secure JWT-based login and registration with customer and administrator roles.
- **Admin Dashboard**: Full inventory management — add, edit, or delete shoes, and manage customer orders.
- **Self-Contained Backend**: In-memory data storage with automatic data seeding on startup (zero external database setup required).

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| **Frontend** | React 19, Vite, Tailwind CSS v4, Lucide Icons, Axios |
| **Backend** | Spring Boot 3.3, Spring Security, JJWT (Token Authentication) |
| **Data Storage** | Thread-safe in-memory storage (Zero DB configuration needed) |
| **Deployment** | Vercel (Frontend) & Render via Docker (Backend) |

---

## 🚀 Quick Start (Run Locally)

### 1. Start the Backend
Open a terminal and run:
```bash
cd backend
./mvnw spring-boot:run
```
*(On Windows Command Prompt, use `mvnw spring-boot:run`)*  
The API server will start on **`http://localhost:8080`** and automatically seed 13 initial shoes, categories, and test accounts.

### 2. Start the Frontend
Open a second terminal and run:
```bash
cd frontend
npm install
npm run dev
```
Open **`http://localhost:5173`** in your browser.

---

## 🔑 Demo Login Accounts

The system automatically creates these test accounts on startup:

| Role | Email | Password | Permissions |
|---|---|---|---|
| **Customer** | `test1@gmail.com` | `customer123` | Browse, search, add to cart, wishlist, checkout |
| **Admin** | `test@gmail.com` | `admin123` | Manage inventory (add/edit/delete shoes), track orders |

---

## 🌐 Deployment Guide

### Deploy Frontend to [Vercel](https://vercel.com)
1. Import this repository into Vercel.
2. Set the **Root Directory** to `frontend`.
3. In **Environment Variables**, add:
   - `VITE_API_BASE_URL`: `https://your-backend.onrender.com/api/v1`
4. Click **Deploy**.

### Deploy Backend to [Render](https://render.com)
1. Create a new **Web Service** on Render and connect this repository.
2. Set the **Root Directory** to `backend`.
3. Choose **Docker** as the runtime (Render will use `backend/Dockerfile`).
4. In **Environment Variables**, add:
   - `PORT`: `8080`
   - `CORS_ALLOWED_ORIGINS`: `https://your-frontend.vercel.app,https://*.vercel.app,http://localhost:5173`
5. Click **Create Web Service**.

---

## 📁 Project Structure

```
soltrix/
├── frontend/                # React 19 SPA (Vite + Tailwind CSS)
│   ├── src/
│   │   ├── components/      # UI components (Navbar, Footer, ProductCard, etc.)
│   │   ├── context/         # Auth and Cart state
│   │   ├── pages/           # Home, Shop, ProductDetails, Checkout, Admin...
│   │   └── services/        # Axios API client
│   └── vercel.json          # Vercel SPA routing fallback
│
├── backend/                 # Spring Boot REST API
│   ├── Dockerfile           # Multi-stage production container build
│   └── src/main/java/com/soltrix/
│       ├── controller/      # REST API endpoints (/auth, /products, /cart, /orders...)
│       ├── entity/          # Clean Java data models
│       ├── repository/      # In-memory storage repositories
│       ├── security/        # JWT authentication filter & security config
│       └── service/         # Business logic layer
│
└── README.md
```

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
