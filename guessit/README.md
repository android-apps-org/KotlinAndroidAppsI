# Guess It: App Architecture

## Think About

- For the various features, what data is required to be displayed to the user?
- Do the features require multiple states?
  - Think about a social media app with the ability to edit or comment on the post.
- What logic is required to make these features functional? Which layer do you think that logic would reside?
- Are there any long running tasks that persist when the application is in the background?
- Does the data update while you’re using the app? Do you have to do anything to make that change?

## UIController: (Activity/Fragment)

- responsible for any user-interface related tasks
  - display data and capture OS and user events
  - limit to only UI related tasks
  - take any decision making power away from UI Controller
  - i.e. not responsible for calculations or processing that decides actual text to draw
  - i.e. while it knows what button has been pressed
    - it immediately passes that information to ViewModel

## [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel)

- In Android context:
  - abstract class that holds app UI data
  - is part of Lifecycle Library
- Survives configuration changes
- Should not reference fragments, activities, or views
- UIController references ViewModel
- hold data needed for UI (associated Activity/Fragment) and prepare it for display
- also may do simple calculations and transformations on data so its ready to display by UIController
- may contain instances of LiveData

## [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)

- crucial for communicating information from ViewModel to UIController
  - that it should update and re-draw the screen
- LiveData is an Observable data holder class that is lifecycle-aware
- Knows about Lifecycle state of UIController observers
  - uses this information to interact intelligently with Activity/Fragment
- When UI Controller is off-screen, it will not get updates
  - if value of LiveData changes, off-screen fragment is not updated
- When UI Controller comes back on-screen, it will get current data immediately
  - it will call observer code with most recent value
- When LiveData already exists, and new UI Controller starts to observe it
  - it will get current data immediately
- When UIController is destroyed
  - LiveData will internally clean up its own connections to Observer

## Resources

- [Android Architecture Samples](https://github.com/android/architecture-samples)
- [Guide to App Architecture](https://developer.android.com/jetpack/guide)
- [ViewModel Overview](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Saving State](https://developer.android.com/topic/libraries/architecture/saving-states)
- [Handling Lifecycles with Lifecycle-Aware Components](https://developer.android.com/topic/libraries/architecture/lifecycle)
- [companion object](https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html#static-fields)
- [MediatorLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MediatorLiveData)

