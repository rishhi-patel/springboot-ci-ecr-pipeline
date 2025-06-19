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

## ✅ How to Trigger Deployments

| Action                      | Result                         |
| --------------------------- | ------------------------------ |
| Push to `develop` branch    | Tags Docker image as `:dev`    |
| Push/Merge to `main` branch | Tags Docker image as `:latest` |
| Manual via GitHub UI        | `workflow_dispatch` available  |

---

## 📸 Screenshots

- ✅ CI build & deploy workflow (GitHub Actions)
- ✅ Artifact download & Docker push logs
- ✅ Success status for multi-job pipeline

---

## 📌 Repo Hygiene

- `.gitignore` and `.gitattributes` are in place
- Branches: `main`, `develop`, `feature/tests-and-endpoints`
- Clean project organization

---

## 📬 Author

**Rishikumar Patel**
GitHub: [@rishhi-patel](https://github.com/rishhi-patel)
Student ID: `8972657`
Course: `PROG8860 – CI/CD – Mid-Term Practical`

---

## 📎 Submission

- ✅ GitHub Repo: [https://github.com/rishhi-patel/springboot-ci-ecr-pipeline](https://github.com/rishhi-patel/springboot-ci-ecr-pipeline)
- ✅ All pipeline criteria met
- ✅ Multi-environment deployment to AWS ECR
