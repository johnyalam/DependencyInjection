# 💉 Koin Dependency Injection — Android

![Platform](https://img.shields.io/badge/Platform-Android-green?logo=android)
![Language](https://img.shields.io/badge/Language-Kotlin-purple?logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-blue?logo=jetpackcompose)
![Koin](https://img.shields.io/badge/DI-Koin%204.2.0-orange)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A clean, production-ready Android sample demonstrating **Koin Dependency Injection** with **MVVM**, **Clean Architecture**, and **Jetpack Compose**. Built as a hands-on reference for developers who want to understand how Koin wires together a real Android project.


## ✨ Features

- ✅ Koin 4.x DSL — `single`, `factory`, `viewModel`
- ✅ MVVM pattern with `StateFlow` + sealed `UiState`
- ✅ Repository pattern — interface-driven, easily testable
- ✅ Jetpack Compose UI with `koinViewModel()`
- ✅ Clean Architecture layer separation
- ✅ `collectAsStateWithLifecycle()` for lifecycle-aware state collection
- ✅ Offline-ready data source structure (local + remote)

---

## 🏗️ Architecture

This project follows **Clean Architecture** with three distinct layers. Dependency arrows point inward — outer layers know nothing about inner ones.

```
┌─────────────────────────────────────┐
│         Presentation Layer          │
│   UserScreen · UserViewModel        │
│   UserUiState (sealed class)        │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│           Domain Layer              │
│   UserRepository (interface)        │
│   GetUserUseCase                    │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│            Data Layer               │
│   UserRepositoryImpl                │
│   UserDataSource (local / remote)   │
└─────────────────────────────────────┘
               │
┌──────────────▼──────────────────────┐
│             DI Layer                │
│   dataModule · presentationModule   │
│   Koin wires it all at startup      │
└─────────────────────────────────────┘
```

### 📁 Project Structure

```
fi.developer.dependencyinjection
 ├── di/
 │    └── AppModule.kt
 ├── model/
 │    └── User.kt
 ├── repository/
 │    ├── UserRepository.kt
 │    └── UserRepositoryImpl.kt
 ├── ui/
 │    └── screen/
 │         └── UserScreen.kt
 ├── viewmodel/
 │    ├── UserViewModel.kt
 │    └── UserUiState.kt
 └── DependencyApplication.kt
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin |
| UI | Jetpack Compose |
| DI | Koin 4.2.0 |
| Architecture | MVVM + Clean Architecture |
| State management | StateFlow + collectAsStateWithLifecycle |
| Minimum SDK | 24 |
| Target SDK | 35 |

---

## 🚀 Getting Started

### Prerequisites

- Android Studio **Hedgehog** or later
- JDK **17**
- Android SDK **35**

### Installation

1. **Clone the repository**

```bash
git clone https://github.com/your-username/koin-dependency-injection.git
cd koin-dependency-injection
```

2. **Open in Android Studio**

```
File → Open → Select the project folder
```

3. **Sync Gradle**

Android Studio will prompt you to sync. Click **Sync Now**, or run:

```bash
./gradlew build
```

4. **Run the app**

Select a device or emulator and click **Run**, or:

```bash
./gradlew installDebug
```

### Dependencies

```toml
# libs.versions.toml
[versions]
koin         = "4.2.0"
koin-compose = "4.2.0"

[libraries]
koin-android          = { module = "io.insert-koin:koin-android",          version.ref = "koin" }
koin-androidx-compose = { module = "io.insert-koin:koin-androidx-compose", version.ref = "koin-compose" }
```

```kotlin
// app/build.gradle.kts
dependencies {
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
}
```

---

## 🧩 How Koin Is Set Up

### 1. Define modules

```kotlin
val dataModule = module {
    single<UserRepository> { UserRepositoryImpl() }
}

val presentationModule = module {
    viewModel { UserViewModel(get()) }
}
```

### 2. Start Koin in Application

```kotlin
class DependencyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DependencyApplication)
            modules(dataModule, presentationModule)
        }
    }
}
```

### 3. Inject ViewModel in Compose

```kotlin
@Composable
fun UserScreen(viewModel: UserViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    // ...
}
```

---

## 🤝 Contributing

Contributions are welcome! Here's how to get involved:

1. **Fork** the repository
2. **Create** your feature branch
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. **Commit** your changes
   ```bash
   git commit -m "feat: add your feature description"
   ```
4. **Push** to your branch
   ```bash
   git push origin feature/your-feature-name
   ```
5. **Open a Pull Request** and describe what you've changed

### Contribution Guidelines

- Follow the existing code style and architecture patterns
- Keep commits small and focused — one concern per commit
- Use [Conventional Commits](https://www.conventionalcommits.org/) for commit messages (`feat:`, `fix:`, `docs:`, `refactor:`)
- Add or update comments where the logic isn't immediately obvious
- Test your changes on at least one physical or emulated device before opening a PR

---

## 📄 License

```
MIT License

Copyright (c) 2026 Md Johny Alam

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```

---

## 🙋 Author

**Md Johny Alam**
Senior Software Engineer · Android & React Native

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?logo=linkedin)](https://linkedin.com/in/your-profile)
[![Medium](https://img.shields.io/badge/Medium-Read%20Article-black?logo=medium)](https://medium.com/your-article-link)

---

> ⭐ If this project helped you, consider giving it a star — it helps others find it too.
