# Multi-Module Jetpack Compose Project Template

This repository serves as a template for setting up a multi-module Jetpack Compose project. It includes pre-configured version catalogs, various modules, and convention plugins to streamline your Android development process.

## Features

- Modular project structure for scalability and maintainability.
- Version catalogs for managing library dependencies and plugins.
- Convention plugins for configuring project settings.
- Pre-configured common libraries for Android development.

## Project Structure

The project structure follows a multi-module approach, which includes the following modules:

1. `core:common`: A common module for sharing code across the project.
2. `core:designsystem`: A module for design system components and utilities.
3. `build-logic`: A module for build logic and custom convention plugins.
4. `feature:myfeaturename`: Create Feature Module according to your use case, which can include, data, domain, usecase, models, network
of its own, try to keep feature modules less dependent on other modules, so that build time improves, and configuration cache is reused

### Convention Plugins

Inside the `build-logic` module, you'll find several convention plugins that automate project setup and configuration:

- AndroidApplicationConventionPlugin
- AndroidApplicationComposeConventionPlugin
- AndroidFeaturePlugin
- AndroidHiltConventionPlugin
- AndroidLibraryComposeConventionPlugin
- AndroidLibraryConventionPlugin
- AndroidLintConventionPlugin
- JvmLibraryConventionPlugin

## Version Catalogs

The project includes version catalogs for managing library versions and plugin versions. You can find the latest versions of libraries and plugins in these catalogs:

- `libraries.versions`: Manages library versions.
- `plugins.versions`: Manages plugin versions.

## Applying Convention Plugins

To apply a convention plugin to a module, use the following syntax in your module's `build.gradle.kts` file:

```kotlin
plugins {
    // Apply the desired convention plugin
    id("template.android.library.compose")
    // Add other plugins as needed
}
