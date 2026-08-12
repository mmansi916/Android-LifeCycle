# Lifecycle and Persistence Proof of Testing

This document provides a sequential walkthrough of 6 test cases verifying the Android Activity Lifecycle and data persistence in the application.

## Test Sequence

````carousel
### Case 1: First Launch
**States**: `onCreate` -> `onStart` -> `onResume`
The app starts with a clean slate, initializing views and loading default state.
![Case 1 Screenshot](/C:/ActivityLifecycleGitCollaboration/.artifacts/dfd3fdff-3918-4db4-a36d-1607a026c653/case1.png)
<!-- slide -->
### Case 2: Home Button
**States**: `onPause` -> `onStop`
Pressing the Home button moves the app to the background, pausing UI updates and saving state.
![Case 2 Screenshot](/C:/ActivityLifecycleGitCollaboration/.artifacts/dfd3fdff-3918-4db4-a36d-1607a026c653/case2.png)
<!-- slide -->
### Case 3: Reopen from Recents
**States**: `onRestart` -> `onStart` -> `onResume`
Returning to the app restores it to the foreground, resuming all interactive elements.
![Case 3 Screenshot](/C:/ActivityLifecycleGitCollaboration/.artifacts/dfd3fdff-3918-4db4-a36d-1607a026c653/case3.png)
<!-- slide -->
### Case 4: Back Button
**States**: `onPause` -> `onStop` -> `onDestroy`
The Back button finishes the activity, triggering a full teardown.
![Case 4 Screenshot](/C:/ActivityLifecycleGitCollaboration/.artifacts/dfd3fdff-3918-4db4-a36d-1607a026c653/case4.png)
<!-- slide -->
### Case 5: Exit Button
**States**: Graceful termination via `finish()`
The in-app Exit button programmatically ends the activity, similar to the Back button.
![Case 5 Screenshot](/C:/ActivityLifecycleGitCollaboration/.artifacts/dfd3fdff-3918-4db4-a36d-1607a026c653/case5.png)
<!-- slide -->
### Case 6: Persistence Check
**Action**: Changed color to **Green**, closed, and RELAUNCHED.
**Result**: The background remains Green and "LifecycleProof" text is restored from `SharedPreferences`.
![Case 6 Screenshot](/C:/ActivityLifecycleGitCollaboration/.artifacts/dfd3fdff-3918-4db4-a36d-1607a026c653/case6.png)
````

## Lifecycle Traces (Logcat)
The following traces confirm the transition sequence for Case 1:
```text
D/MainActivity: onCreate called
D/MainActivity: onStart called
D/MainActivity: onResume called
```

## Summary
The app successfully manages lifecycle transitions and preserves user data (`currentColor` and `etUserInput`) across process deaths using `SharedPreferences`.
