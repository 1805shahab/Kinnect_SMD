# Kinnect — Social Networking Android App

A feature-rich social networking mobile application built natively for **Android** using **Kotlin** and **XML**. The app replicates a complete social network user experience including home feed, story creation and viewer, interactive comments, messaging threads, marketplace, friend management, profile customization, and search workflows.

---

## 📱 Project Details
- **App Name**: Kinnect (`i230507`)
- **Package**: `com.shahabtariq.i230507`
- **Language**: Kotlin
- **UI Framework**: XML Layouts & Material Components
- **Min SDK**: API 26 (Android 8.0)
- **Target SDK**: API 34 (Android 14)

---

## ✨ Features & Capabilities

- **Authentication & Splash**: Smooth splash launcher screen, recent login quick-access, and full registration flow.
- **Home Feed**: Interactive feed with reaction picker popup (Like, Love, Haha, Wow, Sad, Angry), comment section, post creation, and horizontal story scroll view with custom story peek spacing.
- **Story Workflow**: Camera preview, story editor with stickers/text overlay, story viewer with progress indicator, and "Your Story" viewer.
- **Chats & Voice Call**: Active chat listing, real-time-styled chat thread with working back navigation, and voice call screen.
- **Profile & Customization**: User profile with cover photo, edit profile, and public view of other user profiles.
- **Marketplace & Search**: Grid-based marketplace picks with item details, category search, and friend requests/suggestions tab.
- **Theme & Design**: Transparent status bar matching screen backgrounds, brand teal theme, custom app launcher icons, and real media graphics.

---

## 📂 Screen Catalog (23 Screens)

| # | Screen Name | Layout File | Component Type |
|---|-------------|-------------|----------------|
| 01 | Splash Screen | `activity_splash.xml` | Activity |
| 02 | Login Screen | `activity_login.xml` | Activity |
| 03 | Sign Up Screen | `activity_sign_up.xml` | Activity |
| 04 | Home Feed | `fragment_home_feed.xml` | Fragment |
| 05 | Reaction Picker | `popup_reaction_picker.xml` | Popup Window |
| 06 | Comments | `activity_comments.xml` | Activity |
| 07 | Create Post | `activity_create_post.xml` | Activity |
| 08 | Photo Picker | `activity_photo_picker.xml` | Activity |
| 09 | Camera Preview | `activity_camera.xml` | Activity |
| 10 | Story Editor | `activity_story_editor.xml` | Activity |
| 11 | Story Viewer | `activity_story_viewer.xml` | Activity |
| 12 | Your Story | `activity_your_story.xml` | Activity |
| 13 | Search | `activity_search.xml` | Activity |
| 14 | Friends | `fragment_friends.xml` | Fragment |
| 15 | User Profile | `activity_profile.xml` | Activity |
| 16 | Edit Profile | `activity_edit_profile.xml` | Activity |
| 17 | Other Profile | `activity_other_profile.xml` | Activity |
| 18 | Notifications | `fragment_notifications.xml` | Fragment |
| 19 | Menu | `fragment_menu.xml` | Fragment |
| 20 | Chats Overview | `activity_chats.xml` | Activity |
| 21 | Chat Thread | `activity_chat_thread.xml` | Activity |
| 22 | Voice Call | `activity_voice_call.xml` | Activity |
| 23 | Marketplace | `fragment_marketplace.xml` | Fragment |

---

## 🔄 Navigation Flow

- **Splash → Login**: Automatic timer navigation after 1.5 seconds.
- **Login → Main**: Successful login opens Main Activity (clears back stack).
- **Home Feed**:
  - Tap **What's on your mind?** → Create Post → Photo Picker → Camera → Story Editor → Your Story.
  - Tap **Story Card** → Story Viewer.
  - Tap **Comment count / button** → Comments Activity.
  - Tap **Top Chat Icon** → Chats Activity → Chat Thread → Voice Call.
  - Tap **Top Search Icon** → Search Activity → Other User Profile.
- **Bottom Navigation Tabs**: Home Feed ↔ Friends ↔ Marketplace ↔ Notifications ↔ Menu.
- **Menu → Profile**: View Profile → Edit Profile.
- **Menu → Logout**: Clears activity back stack (`FLAG_ACTIVITY_CLEAR_TASK`) and returns to Login.

---

## 🛠️ Tech Stack & Architecture

- **Language**: Kotlin
- **Build System**: Gradle 8.7+ with AGP 8.7.3
- **Android Jetpack**: `AppCompat`, `ConstraintLayout`, `RecyclerView`, `CardView`, `Fragment-KTX`, `Activity-KTX`
- **Testing Framework**: AndroidJUnitRunner, Espresso Core 3.5.1
- **UI Design System**: Jetpack Material Components (NoActionBar), Custom Vector Drawables & Drawables Palette

---

## 🧪 Automated Espresso UI Tests

Located under `app/src/androidTest/java/com/shahabtariq/i230507/`:

1. **`LoginHomeMenuLogoutTest.kt`**: Tests the complete end-to-end flow from Splash → Login → Home → Navigation Menu → Logout → Login with back stack verification.
2. **`HomeCommentsBackTest.kt`**: Verifies post interaction, opening comments from Home Feed, and back stack return behavior.

---

## 🚀 How to Build & Run

1. Clone the repository:
   ```bash
   git clone https://github.com/1805shahab/Kinnect_SMD.git
