# [Activity/Fragment Lifecycle](http://landenlabs.com/android/info/activity-life-cycle/activity-life-cycle.html)

## Share Dialog Example

- Opening share popup puts Activity in onPause state
- Clicking outside share dialog puts Activity in onResume state
- Not same as navigating away from Activity
  - Activity is still on screen (partially) and considered in foreground
  - this is what differentiates onStop/onStart from onResume/onPause
  - onResume/onPause have to do with focus
    - onResume called when Activity has focus
    - onPause called when Activity loses focus
- onStart called when Activity becomes visible
- onStop called when Activity goes off screen

## Definitions

- Visible Lifecycle: part of Lifecycle between onStart and onStop when Activity is visible
- Focus: Activity is said to have focus when its the activity user can interact with
- Foreground: when Activity is on screen
- Background: when Activity is fully off screen, it is considered in background

## Lifecycle States

- Initialized: starting state whenever you make new activity
  - this is a transient state -- it immediately goes to Created
- Created: Activity has just been created
  - but its not visible and it does not have focus
  - i.e. not able to interact with it
- Started: Activity is visible but does not have focus
- Resumed: state of activity when it is running (i.e. is visible and has focus)
- Destroyed: Activity is destroyed
  - it can be ejected from memory at any point
  - should not be referenced or interacted with

## Lifecycle Callbacks

- onCreate: called first time activity starts and is
  - therefore only called once during lifecycle of activity
  - represents when activity is created and initialized
  - activity is not yet visible and you can not interact with it
  - You must implement onCreate:
    - inflate activity UI (i.e. findViewById or data-binding)
    - initialize variables
    - any other initialization that only happens once during activity lifetime
- onRestart: called only if app was already created
  - anything that runs only if not being created
- onStart (visible/foreground): triggered when activity is about to become visible
  - can be called multiple times as user navigates away from activity and then back
  - i.e. when user goes to home screen or to a new activity in app
    - at this point, activity is not interactive
  - In onStart:
    - start any sensors, animations or other procedures that need to start when activity is visible
- onResume (focus/interactive): triggered when activity has focus and user can interact with it
  - Here you should:
    - start any sensors, animations or other procedures that need to start when activity has focus
    - i.e. activity user is currently interacting with
- onPause (focus/interactive): mirror method to onResume
  - called as soon as activity loses focus and user cannot interact with it
  - activity can lose focus without fully disappearing from screen
  - i.e. when a dialog appears that partially obscures activity)
  - Here you should:
    - stop any sensors, animations or other procedures that should not run
      - when activity does not have focus and is partially obscured
    - keep execution fast, next activity is not shown until this completes
      - i.e. blocks UI from drawing; keep this light-weight
- onStop (visible/foreground): mirror method to onStart
  - called when you can no longer see the activity
  - Here you should:
    - stop any sensor, animations or other procedures that should not run when the activity is not on screen
    - can use this to persist (permanently save) data
    - stop logic that updates UI
      - this should not be running when activity is off-screen (waste of resources)
    - there are also restrictions as soon as app goes into background
      - which is when all activities in your app are in background
- onDestroy: mirror method to onCreate
  - called once when activity is fully destroyed
  - happens when you navigate back out of activity (i.e. back button) or manually call finish()
  - last chance to clean up resources associated with activity
  - Here you should:
    - tear down or release any resources that are related to activity and are not automatically released for you
    - forgetting to do this could cause a memory leak!
    - logic that refers to activity or attempts to update UI after activity has been destroyed could crash app!

## [Lifecycle Aware Components](https://developer.android.com/topic/libraries/architecture/lifecycle)

- Problem: developers were responsible for behavior of components
  - i.e. starting/stopping components
  - now components can adjust behavior based on current lifecycle state of activity/fragment
  - i.e. as a LifecycleObserver to LifecycleOwner
  - makes code less error prone
- Library introduced 3 key objects:
  - LifecycleOwner: class that has a lifecycle (Activity/Fragment)
  - LifecycleObserver: object that observes LifecycleOwner
  - Android Lifecycle: object can be queried and checked for state
      ```
        this.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED) 
      ```

## Resources

- [Lifecycle Cheatsheet](https://medium.com/androiddevelopers/the-android-lifecycle-cheat-sheet-part-iii-fragments-afc87d4f37fd)
- [Architecture Components](https://www.youtube.com/watch?v=FrteWKKVyzI)
- [Lifecycle Library](https://www.youtube.com/watch?v=bEKNi1JOrNs)

