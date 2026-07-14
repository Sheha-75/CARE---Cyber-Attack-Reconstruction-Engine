# CARE – Cyber Attack Reconstruction Engine

<p align="center">

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-green?style=for-the-badge&logo=springboot)
![React](https://img.shields.io/badge/React-TypeScript-blue?style=for-the-badge&logo=react)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue?style=for-the-badge&logo=postgresql)
![License](https://img.shields.io/badge/License-MIT-success?style=for-the-badge)

</p>

---

## Overview

CARE (Cyber Attack Reconstruction Engine) is an AI-powered **Digital Forensics and Incident Response (DFIR)** platform designed to assist cybersecurity professionals in investigating, reconstructing, and analyzing cyber incidents.

The platform provides investigators with a centralized environment to manage investigations, securely collect and preserve digital evidence, maintain chain of custody records, reconstruct attack timelines, verify evidence integrity, and generate intelligent investigation summaries.

CARE is being developed as an enterprise-grade cybersecurity platform with future support for AI-assisted investigations, MITRE ATT&CK mapping, automated reporting, and threat intelligence integration.

---

# Key Features

### Authentication & Security

- JWT Authentication
- Secure User Registration & Login
- BCrypt Password Encryption
- Spring Security Integration
- Role-Based Access Architecture

---

### Investigation Management

- Create Investigation Cases
- Unique Case Number Generation
- Severity Classification
- Investigation Status Tracking
- Investigation Metadata Management

---

### Evidence Management

- Secure Evidence Upload
- SHA-256 Integrity Verification
- Digital Evidence Storage
- Evidence Metadata Tracking
- Automated Evidence Validation

---

### Chain of Custody

- Complete Evidence Audit Trail
- Investigator Activity Logging
- Evidence Handling History
- Forensic Integrity Preservation

---

### Timeline Reconstruction

- Incident Timeline Generation
- Log File Parsing
- Event Correlation
- Chronological Attack Reconstruction

---

### Investigation Summary

- Automated Investigation Summary
- Risk Assessment
- Security Recommendations
- Incident Overview Generation

---

### Dashboard

- Investigation Statistics
- Open Case Monitoring
- Evidence Statistics
- Timeline Statistics

---

# Technology Stack

## Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Maven

## Frontend *(In Progress)*

- React
- TypeScript
- Material UI
- Axios

## Database

- PostgreSQL

## Security

- JWT Authentication
- BCrypt Password Hashing
- SHA-256 Evidence Integrity Verification

## AI *(Planned)*

- Python
- LangChain
- Local LLM
- MITRE ATT&CK Mapping

---

# Project Architecture

```
                 React Frontend
                        │
                        ▼
            Spring Boot REST API
                        │
 ┌───────────────┬───────────────┬───────────────┐
 │               │               │               │
 ▼               ▼               ▼               ▼
Authentication Investigation  Evidence      Timeline
                               Management     Engine
 │               │               │               │
 └───────────────┴───────────────┴───────────────┘
                        │
                        ▼
                 PostgreSQL Database
```

---

# Project Structure

```
care-backend
│
├── auth
├── case_management
├── config
├── custody
├── dashboard
├── evidence
├── parser
├── role
├── security
├── summary
├── timeline
└── user
```

---

# Implemented Modules

| Module | Status |
|---------|--------|
| Authentication | ✅ Completed |
| User Management | ✅ Completed |
| Role Management | ✅ Completed |
| Investigation Management | ✅ Completed |
| Evidence Management | ✅ Completed |
| Chain of Custody | ✅ Completed |
| Timeline Reconstruction | ✅ Completed |
| Dashboard | ✅ Completed |
| Investigation Summary | ✅ Completed |
| Security Configuration | ✅ Completed |
| PostgreSQL Integration | ✅ Completed |
| React Frontend | 🚧 In Progress |
| AI Investigation Engine | 📅 Planned |

---

# REST API

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/auth/register` | Register User |
| POST | `/api/auth/login` | User Login |
| POST | `/api/cases` | Create Investigation |
| GET | `/api/cases` | Retrieve Investigations |
| POST | `/api/evidence/upload` | Upload Evidence |
| GET | `/api/evidence/case/{id}` | Retrieve Evidence |
| GET | `/api/evidence/verify/{id}` | Verify Evidence |
| POST | `/api/timeline/{caseId}` | Add Timeline Event |
| GET | `/api/timeline/{caseId}` | View Timeline |
| GET | `/api/dashboard/stats` | Dashboard Statistics |
| GET | `/api/summary/case/{id}` | Investigation Summary |

---

# Installation

Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/CARE---Cyber-Attack-Reconstruction-Engine.git
```

Navigate to the backend

```bash
cd care-backend
```

Build the project

```bash
mvn clean install
```

Run the application

```bash
mvn spring-boot:run
```

---

# Database Configuration

Update the database configuration inside:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/care_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

---

# Roadmap

## Phase 1 ✅

- Authentication
- Investigation Management
- Evidence Management
- Timeline Engine
- Chain of Custody
- Dashboard

---

## Phase 2 🚧

- React Frontend
- Dashboard UI
- Investigation Workspace
- Evidence Upload Interface
- Timeline Visualization

---

## Phase 3 📅

- AI Attack Reconstruction
- MITRE ATT&CK Mapping
- IOC Correlation
- Threat Intelligence Integration
- Automated Investigation Reports
- PDF Report Generation

---

# Future Enhancements

- AI-assisted forensic investigations
- Malware behavior analysis
- IOC extraction
- Threat intelligence feeds
- Timeline visualization
- Interactive evidence explorer
- Automated forensic reporting
- Digital evidence search
- MITRE ATT&CK Navigator integration
- Case collaboration
- Audit logging
- Cloud deployment

---

# License

This project is released under the MIT License.

---

# Author

**Shehani Lakshika Chandrakumar**

BSc (Hons) in Information Technology (Cyber Security)

Sri Lanka Institute of Information Technology (SLIIT)

---

> **CARE is an enterprise Digital Forensics and Incident Response platform that combines secure evidence management, cyber attack reconstruction, and AI-assisted investigation capabilities to support modern cybersecurity operations.**
