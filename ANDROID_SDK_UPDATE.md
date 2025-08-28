# Android SDK Compatibility Update

## Issue
The dependency `androidx.activity:activity:1.8.0` requires projects to compile against Android API level 34 or later. The project was previously configured with:
- Android Gradle Plugin: 7.3.1 (max supported compile SDK: 33)
- compileSdk: 33
- targetSdk: 33

## Changes Made

### 1. Updated Android Gradle Plugin
**File:** `gradle/libs.versions.toml`
- Changed `agp = "7.3.1"` to `agp = "8.1.4"`
- AGP 8.1.4 supports compile SDK 34 and is compatible with Gradle 8.13

### 2. Updated Compile SDK Version
**File:** `app/build.gradle.kts`
- Changed `compileSdk = 33` to `compileSdk = 34`
- This allows the project to use Android API level 34 features

### 3. Updated Target SDK Version
**File:** `app/build.gradle.kts`
- Changed `targetSdk = 33` to `targetSdk = 34`
- This opts the app into Android 14 runtime behavior (optional but recommended)

## Compatibility Matrix
- Gradle: 8.13 ✓
- Android Gradle Plugin: 8.1.4 ✓
- Compile SDK: 34 ✓
- Target SDK: 34 ✓
- androidx.activity: 1.8.0 ✓

## Why These Changes?
1. **androidx.activity:1.8.0** requires compile SDK 34+ for new APIs and compatibility
2. **AGP 7.3.1** doesn't support compile SDK 34, so upgrade to AGP 8.1.4 was necessary
3. **AGP 8.1.4** is compatible with the existing Gradle 8.13 version
4. **Target SDK 34** ensures the app benefits from latest Android optimizations and behaviors

## Notes
- The minSdk remains at 24, so device compatibility is unchanged
- These changes are backward compatible with existing app functionality
- No code changes are required, only build configuration updates