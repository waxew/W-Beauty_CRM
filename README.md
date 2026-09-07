# W-Beauty_CRM

## Beauty CRM Android Platform

W-Beauty_CRM is a professional Android CRM application designed for beauty salons and service-based businesses.

The project goal is to create an offline-first, scalable management system including customer management, reservations, invoices, financial tracking, and future SaaS capabilities.

---

# Project Vision

Create a complete salon management ecosystem:

- Customer Relationship Management (CRM)
- Appointment and reservation management
- Service management
- Invoice and payment management
- Reports and analytics
- Customer loyalty system
- Advertisement integration
- Future cloud/SaaS expansion

---

# Current Development Branch

```text
crm-development
```

Development is performed feature-by-feature with independent commits.

---

# Technology Stack

## Android

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- Coroutines
- Flow

## Architecture

- Clean Architecture
- MVVM Pattern
- Repository Pattern
- Dependency Injection

## Local Database

Offline-first approach:

- Room Database
- SQLite
- Local data persistence

Future synchronization layer:

- Cloud Backend
- Multi Salon SaaS Support

---

# Main Modules

## Customer Management

Features:

- Customer profile
- Contact information
- Visit history
- Service history
- Customer notes
- Customer tags

---

## Reservation System

Features:

- Appointment creation
- Calendar management
- Conflict prevention
- Persian calendar support
- Holiday and occasion support

---

## Service Management

Features:

- Service catalog
- Pricing
- Duration
- Staff assignment

---

## Invoice Management

Features:

- Invoice creation
- Invoice items
- Payments
- Remaining balance
- Financial history

---

## Reports & Analytics

Planned features:

- Revenue reports
- Popular services
- Customer analysis
- Business insights

---

## Smart CRM

Future features:

- Customer loyalty
- Reminder system
- Campaign management
- Customer segmentation

---

## Advertisement Layer

Prepared architecture for:

- Click based advertisements
- Tapsell SDK integration
- Ads management layer

---

# Database Design

Core entities:

- Customer
- Service
- Staff
- Reservation
- Invoice
- Invoice Item
- Payment
- Expense
- Notification
- Holiday

---

# Development Roadmap

## Phase 1

Project foundation:

- Repository setup
- Android Studio structure
- Gradle configuration
- Architecture foundation

## Phase 2

Database layer:

- Room setup
- Entities
- DAO
- Repository implementation

## Phase 3

CRM Modules:

- Customer module
- Reservation module
- Invoice module

## Phase 4

Advanced features:

- Loyalty
- Analytics
- Ads
- Backup

## Phase 5

Release preparation:

- Testing
- Optimization
- Production build

---

# Project Status

Current completed sections:

✅ Repository initialization  
✅ Development branch setup  
✅ Architecture documentation  
✅ Core layer foundation  
✅ Database foundation

In progress:

- Room entities
- DAO layer
- Customer module

---

# Version Strategy

Versions will follow:

```text
v1.0.0
v1.1.0
v2.0.0
```

Stable releases will be preserved as immutable baselines.

---

# License

Private project - W-Beauty_CRM
