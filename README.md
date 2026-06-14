# CARE - Cyber Attack Reconstruction Engine

## Overview

CARE (Cyber Attack Reconstruction Engine) is a Digital Forensics and Incident Response (DFIR) platform designed to assist investigators in managing cyber incident investigations, preserving evidence integrity, reconstructing attack timelines, and generating intelligent incident summaries.

The platform combines forensic evidence management, chain of custody tracking, timeline reconstruction, log analysis, and AI-assisted incident summarization into a unified investigation system.

---

## Key Features

### Authentication & Security

* User Registration
* User Login
* JWT Authentication
* Protected API Endpoints
* Stateless Security Architecture

### Case Management

* Create Investigation Cases
* Manage Case Information
* Track Investigation Status

### Evidence Management

* Upload Digital Evidence
* Store Evidence Metadata
* Associate Evidence with Cases
* Secure Evidence Repository

### Evidence Integrity Verification

* SHA-256 Hash Generation
* Evidence Integrity Validation
* Tamper Detection

### Chain of Custody

* Track Evidence Activities
* Record Evidence Upload Events
* Record Evidence Verification Events
* Maintain Forensic Audit Trail

### Timeline Reconstruction

* Create Investigation Events
* Retrieve Case Timelines
* Chronological Event Management

### Log Parser Engine

* Parse Uploaded Log Files
* Detect Login Events
* Detect Failed Login Attempts
* Detect Malware Alerts
* Automatically Generate Timeline Events

### AI Incident Summary Engine

* Analyze Investigation Timeline
* Determine Risk Level
* Generate Incident Summary
* Provide Investigation Recommendations

---

## Technology Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Maven

### Database

* PostgreSQL

### Security

* JWT Authentication
* SHA-256 Hashing

### Development Tools

* IntelliJ IDEA
* Postman
* Git
* GitHub

---

## Project Structure

```text
CARE---Cyber-Attack-Reconstruction-Engine

├── care-backend
│   ├── auth
│   ├── case_management
│   ├── custody
│   ├── evidence
│   ├── parser
│   ├── security
│   ├── summary
│   ├── timeline
│   └── user
│
├── uploads
│
├── project-assets
│
└── README.md
```

---

## Database

Database: PostgreSQL

Example Configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/care_db
spring.datasource.username=postgres
spring.datasource.password=your_password
```

---

## API Endpoints

### Authentication

#### Register User

```http
POST /api/auth/register
```

#### Login

```http
POST /api/auth/login
```

Returns JWT Token.

---

### Evidence Management

#### Upload Evidence

```http
POST /api/evidence/upload
```

#### Get Evidence By Case

```http
GET /api/evidence/case/{caseId}
```

#### Verify Evidence Integrity

```http
GET /api/evidence/verify/{evidenceId}
```

---

### Chain of Custody

#### Get Custody Records

```http
GET /api/custody/{evidenceId}
```

---

### Timeline

#### Create Timeline Event

```http
POST /api/timeline/{caseId}
```

#### Get Timeline

```http
GET /api/timeline/{caseId}
```

---

### AI Summary

#### Generate Incident Summary

```http
GET /api/summary/case/{caseId}
```

Example Response:

```json
{
  "caseId": 1,
  "riskLevel": "HIGH",
  "summary": "Detected failed login attempts and malware-related activity.",
  "recommendations": [
    "Review timeline events",
    "Reset affected credentials",
    "Perform malware investigation",
    "Isolate affected system"
  ]
}
```

---

## Example Investigation Workflow

1. Create Investigation Case
2. Upload Evidence
3. Generate SHA-256 Hash
4. Verify Evidence Integrity
5. Record Chain of Custody
6. Parse Log Files
7. Generate Timeline Events
8. Produce AI Incident Summary

---

## Current Project Status

### Completed

* JWT Authentication
* Case Management
* Evidence Upload
* SHA-256 Evidence Verification
* Chain of Custody Tracking
* Timeline Reconstruction
* Log Parser Engine
* AI Incident Summary Engine

### Planned Enhancements

* Dashboard Statistics API
* React Frontend Dashboard
* AI Investigator Assistant
* Attack Chain Visualization
* Threat Intelligence Integration
* Automated Incident Reports

---

## Screenshots

Add screenshots inside:

```text
project-assets/
```

Examples:

* Evidence Upload
* Evidence Verification
* Chain of Custody
* Timeline Events
* JWT Login
* AI Incident Summary

---

## Author

**Shehani Lakshika**

Cyber Security Undergraduate | Digital Forensics Enthusiast | AI & Cybersecurity Researcher

---

## License

This project is developed for educational, research, and portfolio purposes.

