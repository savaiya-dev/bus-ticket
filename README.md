# Bus Ticket Android App

This is a Kotlin Android app using Jetpack Compose. It replicates the ticket UI and dynamic functionality of https://amar-louis.github.io/ticket-master/.

## Features
- Two sides: Admin (change zone and color scheme), User (change zone number only)
- Ticket UI with QR code, ticket type, zone, expiration timer, and bottom image
- MVVM architecture

## Contributor setup

Open the repository root (the folder containing `settings.gradle`), not `app/`.

### Toolchain

- JDK 17. Set `JAVA_HOME` to your JDK installation and use the same JDK in Android Studio's Gradle settings.
- A local Gradle 8.0 installation on `PATH`. This repository does **not** currently include `gradlew`, `gradlew.bat`, or `gradle/wrapper/`; commands below use `gradle` directly.
- Android SDK Platform 34, SDK Build-Tools 33.0.1 (the AGP 8.1 default), and Platform-Tools, installed through Android Studio's SDK Manager. Accept the SDK licenses.
- An emulator or device running Android 7.0 / API 24 or newer to run the app.
- Network access to Google Maven and Maven Central for the initial dependency download.

The build declares Android Gradle Plugin (AGP) 8.1.0, Kotlin 1.9.0, Compose compiler 1.5.1, and compile/target SDK 34. See the [AGP 8.1 compatibility notes](https://developer.android.com/build/releases/agp-8-1-0-release-notes) for its Gradle and JDK requirements. These are setup instructions, not a claim that this checkout builds successfully.

### Configure your Android SDK locally

Android Studio can create `local.properties` when you open the root project and select your installed SDK. Alternatively, create that file beside `settings.gradle` with **one** `sdk.dir` entry pointing to your SDK. Example formats (replace the username and path):

```properties
# Linux example
sdk.dir=/home/YOUR_USER/Android/Sdk
```

```properties
# macOS example
sdk.dir=/Users/YOUR_USER/Library/Android/sdk
```

```properties
# Windows example: forward slashes avoid Java properties backslash escapes
sdk.dir=C:/Users/YOUR_USER/AppData/Local/Android/Sdk
```

Use an absolute path, without quotes. Do not use `~`, `$HOME`, or `%LOCALAPPDATA%` in this file; they are not shell-expanded. Only the root file is needed; do not create `app/local.properties`.

For command-line builds you can instead set `ANDROID_HOME` to the installed SDK directory and omit `local.properties`. Remove or correct any stale `sdk.dir` first. Keep SDK and JDK paths local: `local.properties`, Gradle caches, and Android Studio state are ignored and must not be committed.

### Build and run

From the repository root, check the selected tools and build the debug APK:

```sh
java -version
gradle --version
gradle :app:assembleDebug
```

These commands also work in PowerShell when Java and Gradle are on `PATH`. A successful build writes `app/build/outputs/apk/debug/app-debug.apk`.

In Android Studio, select JDK 17 and your local Gradle 8.0 distribution in Gradle settings, sync the root project, select the `app` run configuration and a device, then Run. If prompted for a missing wrapper, use the local distribution. The VS Code **Build Android App** task also requires `gradle` on `PATH`.

To install from the command line with an emulator running or a USB-debugging-enabled device connected:

```sh
adb devices
gradle :app:installDebug
```

### Validation and troubleshooting

```sh
gradle :app:lintDebug
gradle :app:testDebugUnitTest
```

There are currently no test sources under `app/src/test` or `app/src/androidTest`. A successful test task that reports `NO-SOURCE` does not mean application behavior was tested. Record the commands actually run and their outcomes in your pull request; report missing tooling or build failures explicitly.

- **SDK location not found:** check the root `local.properties` or `ANDROID_HOME` and confirm the SDK directory exists.
- **Gradle not found / missing `gradlew`:** install Gradle 8.0 and add its `bin` directory to `PATH`; the wrapper is not included in this checkout.
- **Java/Gradle mismatch:** compare `java -version`, `gradle --version`, and Android Studio's Gradle JDK. Use JDK 17 consistently.
- **Missing SDK packages/licenses:** install the packages above and accept licenses through SDK Manager or `sdkmanager --licenses` if command-line tools are installed.
- **Dependency, compilation, or lint errors after setup:** capture the first failure with `--stacktrace`. Local SDK configuration does not resolve unrelated build or source issues.

Before committing, review `git status --short` and `git diff --cached`. Keep generated files, local paths, and signing keys out of the commit. Shared build scripts and any future complete Gradle wrapper belong in version control; the ignore rules do not exclude them.

## Customization
- Place your QR code and bottom images in `app/src/main/res/drawable/`
- Edit UI and logic in `app/src/main/java/com/example/busticket/ui/`

---

This project was scaffolded by GitHub Copilot.
