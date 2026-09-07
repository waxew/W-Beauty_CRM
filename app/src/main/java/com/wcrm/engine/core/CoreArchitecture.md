# CRM Engine Core Architecture

## Rules

- Core modules must not know business industries.
- Business specific behavior belongs to Business Profile.
- Dynamic attributes belong to Custom Field Engine.

Flow:

Business Profile -> Runtime -> Modules -> Core

Industry examples such as mobile, jewelry, beauty or grocery must be configurations, not core packages.
