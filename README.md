# 🚀 Spring Boot CI/CD with GitHub Actions & AWS ECR

This project demonstrates a complete CI/CD pipeline using **GitHub Actions** to build, test, lint, and deploy a Spring Boot application to **AWS Elastic Container Registry (ECR)**.

---

## 🧱 Tech Stack

- **Spring Boot 3 (Java 21)**
- **Maven**
- **JUnit 5**
- **Checkstyle**
- **Docker**
- **GitHub Actions**
- **AWS ECR**

---

## 🛠️ Features

- REST API endpoints (`/hello`, `/status`, `/echo`, `/version`)
- CI pipeline with:
  - ✅ Build
  - ✅ Test (4+ unit tests)
  - ✅ Lint (Checkstyle)
  - ✅ Docker image build & push
- Multi-environment deployment:
  - ✅ `develop` → tagged as `:dev`
  - ✅ `main` → tagged as `:latest`

---

## 📂 Folder Structure

```
springboot-ci-ecr-pipeline/
├── .github/workflows/ci.yml     # CI/CD pipeline
├── workflow/                    # Spring Boot project
│   ├── Dockerfile               # Docker build config
│   ├── src/...                  # Source code & tests
│   ├── pom.xml                  # Maven config
```

---

## 🚦 CI/CD Pipeline

This repository uses GitHub Actions to automate the following:

| Stage     | Description                               |
| --------- | ----------------------------------------- |
| 🛠️ Build  | Compile project with `mvn clean package`  |
| ✅ Test   | Run unit tests via `mvn test` (4+ tests)  |
| 🧹 Lint   | Static analysis using Checkstyle          |
| 🐳 Docker | Build Docker image from generated `.jar`  |
| ☁️ Deploy | Push image to AWS ECR based on branch/tag |

---

## 🌐 API Endpoints

| Endpoint        | Description              |
| --------------- | ------------------------ |
| `/hello`        | Returns a Hello message  |
| `/status`       | Returns "App is running" |
| `/version`      | Returns API version      |
| `/echo?input=x` | Returns "Echo: x"        |

---

## 🧪 Sample Unit Tests

Tests are defined in `HelloControllerTest.java`, including:

- `/hello` returns status 200 and message
- `/status` health check
- `/echo` handles query param
- `/version` returns version string

---

## 🐳 Docker Usage

### 🔄 Pull Image from ECR

```bash
aws ecr get-login-password --region ca-central-1 | docker login --username AWS --password-stdin 857736875915.dkr.ecr.ca-central-1.amazonaws.com
docker pull 857736875915.dkr.ecr.ca-central-1.amazonaws.com/springboot-ci-app:latest
```

### ▶️ Run Locally

```bash
docker run -p 8080:8080 857736875915.dkr.ecr.ca-central-1.amazonaws.com/springboot-ci-app:latest
```

Visit: [http://localhost:8080/hello](http://localhost:8080/hello)

---

## 🚢 ECS Deployment with Load Balancer

The application is deployed to Amazon ECS (Fargate) and exposed via an Application Load Balancer (ALB).

Service Status Public URL : [Spring Boot API ✅](http://sp-alb-368462775.ca-central-1.elb.amazonaws.com/status)

### 📌 ALB Setup Highlights :
- ALB Listener: HTTP (Port 80)
- Target Group: Routes to ECS task running on Port 8080
- ECS Task Definition: Uses Docker image from ECR (springboot-ci-app:latest)
- Security Group: Allows inbound traffic on port 80
- Subnet: Deployed in public subnets for accessibility

🛡️ Health Check Endpoint

The ALB health checks use the /status endpoint to verify the container’s availability:

GET /status
Response: "App is running"

---

## ✅ How to Trigger Deployments

| Action                      | Result                         |
| --------------------------- | ------------------------------ |
| Push to `develop` branch    | Tags Docker image as `:dev`    |
| Push/Merge to `main` branch | Tags Docker image as `:latest` |
| Manual via GitHub UI        | `workflow_dispatch` available  |

---

## 📸 Screenshots

- ✅ CI build & deploy workflow (GitHub Actions)

![image](https://github.com/user-attachments/assets/b6a031a5-13e9-4903-a70a-b39a220fc256)

![image](https://github.com/user-attachments/assets/395a7e2b-5951-440c-a0f3-e4a578d04be6)

- ✅ Artifact download & Docker push logs

![image](https://github.com/user-attachments/assets/380c89e9-6c4e-4f9e-b49d-4066e8e1b7f9)

- ✅ Success status for multi-job pipeline

![image](https://github.com/user-attachments/assets/c842bb56-3846-4645-979d-2307cfdf5b17)

---

## 📌 Repo Hygiene

- `.gitignore` and `.gitattributes` are in place
- Branches: `main`, `develop`, `feature/tests-and-endpoints`
- Clean project organization

---

## 📬 Author

- **Rishikumar Patel**
- GitHub: [@rishhi-patel](https://github.com/rishhi-patel)
- Student ID: `8972657`
- Course: `PROG8860 – CI/CD – Mid-Term Practical`
