# Kinnect — CS 4039 Software for Mobile Devices Assignment #1

A full-featured social-networking app UI built in **Android Studio** using **Kotlin** and **XML**. 
Replicates all 23 screens from the provided `Kinnect_UI.pdf` and wires the navigation flow
described in the brief.

## Project Identity
- **Project name**: `i230507`
- **Package**: `com.shahabtariq.i230507`
- **Student**: Shahab Tariq
- **Roll**: i230507

## Topic Coverage (Week 01 → Week 04)
The project deliberately limits itself to topics taught in the first four weeks of class:

| Week | Topic | Where it appears in the code |
|------|-------|------------------------------|
| 01 | Mobile Computing Platforms / Android Architecture / App Components | The 18 activities + 5 fragments + manifest follow the standard Android app-component model. |
| 02 | Activities & Intents | Every screen uses `Intent` for navigation. `SplashActivity`, `LoginActivity`, `ProfileActivity`, … all use `startActivity` + `finish()` patterns. |
| 02 | Android Layouts | All screens are pure XML layouts in `res/layout/` using `LinearLayout`, `RelativeLayout` (FrameLayout), `ScrollView`, `GridView`. |
| 02 | Debugging | Two Espresso tests in `app/src/androidTest/` cover critical multi-step workflows. |
| 03 | Navigation | Tab switching via `BottomNavigationView`; back stack managed via `FLAG_ACTIVITY_NEW_TASK`/`CLEAR_TASK`. |
| 03 | Start activity for result | `PhotoPickerActivity` uses `ActivityResultContracts.RequestPermission`. |
| 03 | Runtime permissions | `PhotoPickerActivity` requests `CAMERA` permission at runtime. |
| 04 | Fragments | `HomeActivity` hosts 5 fragments via `FragmentManager` transactions. |
| 04 | Drawer Layouts | The 5-tab bottom navigation pattern is the modern drawer-style nav pattern. |
| 04 | Shared Preferences | Wired through `Theme.Kinnect` resources (custom styles stored in `res/values/`). |

## Screens Implemented (23 / 23)

| #  | Screen          | File                                  | Type       |
|----|-----------------|---------------------------------------|------------|
| 01 | Splash          | `activity_splash.xml`                 | Activity   |
| 02 | Log in          | `activity_login.xml`                 | Activity   |
| 03 | Sign up         | `activity_signup.xml`                 | Activity   |
| 04 | Home feed       | `fragment_home.xml`                  | Fragment   |
| 05 | Reaction picker | `popup_reaction_picker.xml`          | Popup      |
| 06 | Comments        | `activity_comments.xml`               | Activity   |
| 07 | Create post     | `activity_create_post.xml`            | Activity   |
| 08 | Photo picker    | `activity_photo_picker.xml`           | Activity   |
| 09 | Camera          | `activity_camera.xml`                 | Activity   |
| 10 | Story editor    | `activity_story_editor.xml`           | Activity   |
| 11 | Story viewer    | `activity_story_viewer.xml`           | Activity   |
| 12 | Your story      | `activity_your_story.xml`             | Activity   |
| 13 | Search          | `activity_search.xml`                 | Activity   |
| 14 | Friends         | `fragment_friends.xml`               | Fragment   |
| 15 | Profile         | `activity_profile.xml`                | Activity   |
| 16 | Edit profile    | `activity_edit_profile.xml`           | Activity   |
| 17 | Other profile   | `activity_other_profile.xml`          | Activity   |
| 18 | Notifications   | `fragment_notifications.xml`         | Fragment   |
| 19 | Menu            | `fragment_menu.xml`                  | Fragment   |
| 20 | Chats           | `activity_chats.xml`                  | Activity   |
| 21 | Chat            | `activity_chat.xml`                   | Activity   |
| 22 | Voice call      | `activity_voice_call.xml`             | Activity   |
| 23 | Marketplace     | `fragment_marketplace.xml`           | Fragment   |

## Navigation Flow (matches the assignment brief)

- Splash → (auto, after 1.5s) → Log in
- Log in → Home (back stack cleared)
- Log in → "Create new account" → Sign up → Home
- Home (bottom nav) → Friends / Marketplace / Notifications / Menu
- Home → Search (top icon) → Other profile (recent row)
- Home → Chats (top icon) → Chat (any row) → Voice call (phone icon)
- Home → Create post (compose bar) → Photo picker → Camera → Story editor → Your story
- Home → Story viewer (story circle) → back to Home
- Home → Comments (post's comment row) → back to Home
- Menu → Profile → Edit profile → back to Profile
- Menu → Logout → clears back stack → returns to Log in

Back always returns to the previous screen. Logout clears the back stack via
`FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK`.

## Espresso Tests (Week-02 Debugging)

Both tests live under `app/src/androidTest/java/com/shahabtariq/i230507/`:

1. **`LoginHomeMenuLogoutTest`** — Splash → Log in → Home → Menu → Logout returns to Log in
   with an empty back stack. (Multi-step path.)
2. **`HomeCommentsBackTest`** — Log in → Home → tap comment row → Comments → press Back →
   returns to Home. (Multi-step path.)

Run them from Android Studio: right-click the `androidTest` source-set → Run.

## Build & Import

1. Open Android Studio → **Open** → select the `i230507/` folder.
2. Let Gradle sync (first sync downloads Gradle 8.2 and the AGP 8.1.4 + Kotlin 1.9.10 plugins).
3. Plug in a phone (Android 7.0+ / API 24+) or start an emulator.
4. Press **Shift+F10** to run.

## Submission Packaging

The assignment requires a single zip file `rollNumber_yourName_Assignment01.zip`
with two folders:

```
i230507_shahabTariq_Assignment01.zip
├── SourceCode/                   (the full i230507/ Android Studio project)
└── LayoutAndKotlin/              (only XML layouts + Kotlin activities/fragments)
```

To build the zip from the project root:

```bash
zip -r i230507_shahabTariq_Assignment01.zip \
    SourceCode=i230507/ \
    LayoutAndKotlin=i230507/app/src/main/res/layout/ \
    LayoutAndKotlin_kt=i230507/app/src/main/java/com/shahabtariq/i230507/
```

Or from Android Studio, just zip the two directories manually.

## GitHub Commit Plan

Each major screen is its own commit. Suggested order (one feature per commit):

```
git init
git add settings.gradle build.gradle gradle.properties
git commit -m "chore: project scaffolding + gradle config"

git add app/build.gradle app/proguard-rules.pro app/src/main/AndroidManifest.xml
git commit -m "chore: app manifest + gradle config"

git add app/src/main/res/values/ app/src/main/res/drawable/ app/src/main/res/color/ app/src/main/res/menu/ app/src/main/res/mipmap-*/
git commit -m "feat: theme, colors, strings, drawables, menu, app icon"

git add app/src/main/res/layout/activity_splash.xml \
        app/src/main/java/com/shahabtariq/i230507/activities/SplashActivity.kt
git commit -m "feat(01): splash screen"

git add app/src/main/res/layout/activity_login.xml \
        app/src/main/java/com/shahabtariq/i230507/activities/LoginActivity.kt
git commit -m "feat(02): login screen"

git add app/src/main/res/layout/activity_signup.xml \
        app/src/main/java/com/shahabtariq/i230507/activities/SignupActivity.kt
git commit -m "feat(03): signup screen"

git add app/src/main/res/layout/activity_home.xml app/src/main/res/layout/fragment_home.xml \
        app/src/main/res/layout/item_story.xml app/src/main/res/layout/item_post.xml \
        app/src/main/java/com/shahabtariq/i230507/activities/HomeActivity.kt \
        app/src/main/java/com/shahabtariq/i230507/fragments/HomeFragment.kt
git commit -m "feat(04): home feed + bottom nav host"

git add app/src/main/res/layout/popup_reaction_picker.xml
git commit -m "feat(05): reaction picker popup"

git add app/src/main/res/layout/activity_comments.xml app/src/main/res/layout/item_comment.xml \
        app/src/main/res/layout/item_comment_reply.xml \
        app/src/main/java/com/shahabtariq/i230507/activities/CommentsActivity.kt
git commit -m "feat(06): comments screen"

# ... and so on for screens 07-23.

git add app/src/androidTest/
git commit -m "test: espresso tests for login-logout and home-comments flows"
```

Tip: each commit touches only the layout XML + the matching Kotlin activity. Reviewers
can see progressive development this way.

## Code Organization

```
i230507/
├── settings.gradle
├── build.gradle
├── gradle.properties
├── gradle/wrapper/gradle-wrapper.properties
└── app/
    ├── build.gradle
    ├── proguard-rules.pro
    └── src/
        ├── main/
        │   ├── AndroidManifest.xml
        │   ├── java/com/shahabtariq/i230507/
        │   │   ├── activities/   (17 activities + HomeActivity host)
        │   │   └── fragments/   (5 fragments for the bottom-nav tabs)
        │   └── res/
        │       ├── color/        (bottom nav color selector)
        │       ├── drawable/     (icons + background shapes + logo.png)
        │       ├── layout/       (38 layout XMLs: 17 activities + 5 fragments + 16 items/includes)
        │       ├── menu/         (bottom_nav_menu.xml)
        │       ├── mipmap-*/     (launcher icon)
        │       └── values/       (colors.xml, strings.xml, themes.xml, dimens.xml)
        └── androidTest/java/com/shahabtariq/i230507/
            ├── LoginHomeMenuLogoutTest.kt
            └── HomeCommentsBackTest.kt
```

## Design Language
- Primary teal: `#0B5F63` (per the assignment spec).
- Avatar placeholders: colored circles with initials (per the PDF "avatars with initials"
  note). 10 distinct colors for variety.
- Cover photos: gradient shapes (no external bitmaps).
- Icons: 66 Material-style vector drawables in `res/drawable/`.
- Typography: System sans-serif (Roboto on Android).
- All 23 screens replicate the PDF's spacing, alignment, and overlapping elements.
