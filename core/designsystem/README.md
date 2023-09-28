# Design System Module

The Design System module provides a set of reusable components, themes, colors, typography, and other styling elements to maintain a consistent and visually appealing user interface across your Android application.

## Features

### Custom Components

The Design System module should includes a collection of custom UI components that are designed to enhance the user experience and maintain a cohesive design language. These components can include:

- **Custom Buttons:** Stylish and customizable buttons for various use cases.
- **Card Views:** Pre-designed card layouts with consistent styling.
- **Text Fields:** Custom text input fields with consistent typography and animations.
- **Custom Dialogs:** Customized dialog boxes and pop-up modals.
- **Icon Sets:** A collection of icons that match the design language.

### Themes

The module provides a set of predefined themes that can be easily applied to your application to ensure a consistent look and feel. These themes include dark mode support and customizable color palettes.

### Colors

The Design System defines a color palette that follows the Material Design guidelines. These predefined colors can be used to maintain consistency and create visually appealing UIs.
Use [Material-Theme-Builder](https://m3.material.io/theme-builder#/custom) to create your own Material theme palette, which can be easily replaced with Color.kt

### Typography

Consistent typography is essential for a cohesive design. The module includes predefined text styles and fonts size to ensure uniformity in your app's typography.
You can customize typography for your custom FontFamily or can use [Downloadable fonts](https://developer.android.com/jetpack/compose/text/fonts#downloadable-fonts) 

## Getting Started

To get started with the Design System module in your Android project, follow these steps:

1. Add the module as a dependency to your project.
2. Import and apply the predefined themes and styles to your layouts and views.
3. Utilize the custom components provided by the module in your UI.

```gradle
dependencies {
    implementation project("core:designsystem")
}
