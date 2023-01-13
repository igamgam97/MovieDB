
MovieDb
==================

**MovieDb** is a Android app built entirely with Kotlin and Jetpack Compose and follows development best practices.

# Architecture

The **MovieDb** app follows the
[official architecture guidance](https://developer.android.com/topic/architecture)

# Modularization

The **MovieDb** app follows the
[official architecture guidance](https://https://developer.android.com/topic/modularization/patterns)

The **Now in Android** app has been fully modularized

Three types of modules:

* `feature:` modules -  isolated part of an app's functionality that usually corresponds to a screen or series of closely related screens
* `shared:` modules - contains some common logic for several modules, can contain other shared modules
* `core:` modules - the foundation of the application, theme, basic components like buttons etc

# Build

The app contains the usual `debug` and `release` build variants.

# UI
The Screens and UI are built entirely by [Jetpack Compose](https://developer.android.com/jetpack/compose).