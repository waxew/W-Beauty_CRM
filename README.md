# W-Beauty CRM

A native Android CRM application for beauty salons, built with Kotlin and Jetpack Compose.

## Project Overview

W-Beauty CRM is designed as a standalone salon management application. The current development phase focuses on establishing a clean, scalable Android architecture that can later support customer management, reservations, services, invoices, payments, and reporting modules.

## Technology Stack

- Kotlin
- Jetpack Compose
- Material 3
- Android Architecture Components
- MVVM Architecture
- Clean Architecture principles
- Hilt Dependency Injection
- Room Database
- Kotlin Coroutines / Flow
- Navigation Compose
- KSP

## Current Architecture

```
UI (Jetpack Compose)
        |
        v
ViewModel
        |
        v
UseCase
        |
        v
Repository
        |
        v
Room Database
        |
        v
DAO / Entity
```

## Completed Modules

### Customer Management

Implemented:

- Customer Entity
- Customer DAO
- Room Database setup
- Repository layer
- UseCase layer
- ViewModel integration
- Compose customer list screen
- Add customer screen
- Navigation flow
- Basic validation
- Error state handling

## Dependency Injection

Implemented with Hilt:

- Application level Hilt setup
- Database provider
- DAO injection
- Dependency injection foundation for repositories and use cases

## Database

Current database technology:

- Room Persistence Library
- Local SQLite database

Current entities:

- Customer

Planned entities:

- Reservation
- Service
- Invoice
- Payment
- Employee
- Reports

## Build Configuration

The project uses:

- Gradle Kotlin DSL
- Android Gradle Plugin
- Kotlin Gradle Plugin
- KSP for code generation

## Development Roadmap

### Phase 1 - Foundation

- [x] Android Gradle structure
- [x] Compose setup
- [x] Room foundation
- [x] Hilt foundation
- [x] Customer module
- [ ] Final build validation
- [ ] Debug APK generation

### Phase 2 - CRM Features

Planned:

- Customer profile
- Visit history
- Appointment management
- Service records
- Payments
- Notifications
- Dashboard

### Phase 3 - Advanced Features

Planned:

- Database backup
- JSON export/import
- Automatic backup
- Database encryption
- Secure storage
- Reports and analytics

## Project Status

Current status: Active Development

The project is currently in the foundation and build stabilization stage.

## Contribution Guidelines

All changes should preserve the Clean Architecture structure and avoid direct coupling between UI and database layers.
