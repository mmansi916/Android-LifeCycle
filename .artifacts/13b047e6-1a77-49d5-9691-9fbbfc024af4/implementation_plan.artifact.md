# Project Plan: Activity Lifecycle, SharedPreferences, and Git Collaboration

This project aims to demonstrate the Android Activity lifecycle, persistent storage using `SharedPreferences`, and professional collaboration using Git/GitHub branching strategies.

## User Review Required

> [!IMPORTANT]
> Since we are switching from Jetpack Compose to XML, I will add `androidx.appcompat` and `androidx.constraintlayout` dependencies.

> [!NOTE]
> For Git collaboration, we will follow a simplified Git Flow:
> - `main`: Production-ready code.
> - `develop`: Integration branch for features.
> - `feature/*`: Specific feature branches (e.g., `feature/lifecycle-logging`, `feature/shared-prefs`).

## Proposed Changes

### 1. Project Infrastructure & Git

#### [INITIALIZE] Git Repository
- Run `git init`.
- Create a standard `.gitignore` for Android projects.
- Create initial branches: `main` and `develop`.

#### [MODIFY] [libs.versions.toml](file:///C:/ActivityLifecycleGitCollaboration/gradle/libs.versions.toml)
- Add dependencies for XML UI: `appcompat` and `constraintlayout`.

#### [MODIFY] [build.gradle.kts](file:///C:/ActivityLifecycleGitCollaboration/app/build.gradle.kts)
- Include the new dependencies.

### 2. UI Layout (XML)

#### [NEW] [activity_main.xml](file:///C:/ActivityLifecycleGitCollaboration/app/src/main/res/layout/activity_main.xml)
- A `TextView` to display current lifecycle status/logs.
- An `EditText` for user input (e.g., "User Name").
- A `Button` to manually save information (though we will also save automatically).

### 3. Activity Lifecycle & SharedPreferences Logic

#### [MODIFY] [MainActivity.kt](file:///C:/ActivityLifecycleGitCollaboration/app/src/main/java/com/example/activitylifecyclegitcollaboration/MainActivity.kt)
- Inherit from `AppCompatActivity`.
- Implement all major lifecycle hooks (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`, `onRestart`).
- Add `Log.d` calls and UI updates in each hook.
- Implement `SharedPreferences` to save the `EditText` content in `onPause` and restore it in `onCreate`/`onResume`.

## Verification Plan

### Automated Tests
- `./gradlew assembleDebug` to verify build.

### Manual Verification
- Observe `Logcat` for lifecycle logs as the app is rotated, minimized, and restored.
- Enter text in the `EditText`, close the app, and reopen it to verify `SharedPreferences` persistence.
- Verify Git branch structure using `git branch`.
