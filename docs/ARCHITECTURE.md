# W-Beauty_CRM Architecture

## Application Architecture

Clean Architecture + MVVM

Layers:

Presentation
- UI Screens
- ViewModels
- UI State

Domain
- Use Cases
- Business Rules

Data
- Repository
- Local Database
- Data Sources

## Technology Stack

- Kotlin
- Android Studio
- Jetpack Compose
- Room Database
- WorkManager
- Hilt Dependency Injection

## Offline First

The application is designed to work offline using local database storage.
Cloud synchronization can be added in future SaaS versions.
