# Bus Ticket Android App

This is a Kotlin Android app using Jetpack Compose. It replicates the ticket UI and dynamic functionality of https://amar-louis.github.io/ticket-master/.

## Features
- Two sides: Admin (change zone and color scheme), User (change zone number only)
- Ticket UI with QR code, ticket type, zone, expiration timer, and bottom image
- MVVM architecture

## How to Build
1. Open this folder in Android Studio or VS Code with Android extensions
2. Run Gradle sync and build the project
3. Launch the app on an emulator or device

## Customization
- Place your QR code and bottom images in `app/src/main/res/drawable/`
- Edit UI and logic in `app/src/main/java/com/example/busticket/ui/`

---

This project was scaffolded by GitHub Copilot.
