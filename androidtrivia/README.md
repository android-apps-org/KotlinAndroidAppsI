# Android Navigation Patterns

## Think About

- How many distinct features do the applications you use have?
- How are they arranged?
- What might the navigation graph look like for these applications?
- How do you, the user, navigate to and from each feature?
- What navigation methods are present?
- Do they work well with the hardware navigation?
- Have you ever felt abandoned or unable to get where you want to go?
- Are other applications a part of the experience? Browser, Camera, etc.

## Activity

- Operates as a frame that contains UI fragments and can provide UI Elements that surround the Fragment
- UI Fragments operate like a view within Activity layout
- OS can only open Activities
- Activity inflates layout from setContentView

## Fragments

- onCreateView: independent of Activity onCreate
  - manually inflate and return inflated layout
- does not inherit from Context
  - need ContextCompat to access App data associated with context  (i.e. string/image resources)

## [ActionBar](https://developer.android.com/reference/android/app/ActionBar)

- Dedicated space for App branding and identity and also indicates user location in app
- Access to navigation features in predictable way
  - Navigation drawer
  - Up button (does not navigate out of app)
  - Overflow menu

## Back Stack

- Stack of previous activities from within app as well as from previous apps
- Fragment back stack is similar except entire stack is contained within Activity
  - controlled by FragmentManager
  - when Fragment is instantiated by FragmentManager
    - fragment transaction can optionally be added to stack

## [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started)

- There is always a Starting Location (fixed)
- You can always go back (last-in first-out)
- Up goes back (mostly) - should not be shown if at start location of app

## Setting Up [Navigation Graph](https://developer.android.com/guide/navigation/navigation-design-graph)

- Add navigation component dependencies in build.gradle
- Add navigation graph resource
- Add NavHostFragment
  - acts as host for each of the fragments in Activity Navigation Graph
  - as user moves between destinations within Navigation Graph for Activity
    - the NavHostFragment swaps the Fragments in and out
    - and automatically creates and manages appropriate Fragment BackStack
- Add Fragments to Graph
- Connect Fragments in Graph with Actions
- Create listeners
- Find Navigation Controller
- Navigate with Action

## Navigation Principles

- Apps have a fixed Starting Location
  - screen users see when they launch app from launcher
  - apps with login can have one-off exceptions to rule
- Navigation state of app should be represented with last-in first-out structure
  - BackStack, can always go back
- Up button goes back mostly
  - functions as system back button
  - except does not leave app (disabled up button when at start)

## [Intent](https://developer.android.com/reference/android/content/Intent)

- Indicates intention of app
  - description of something app wants Activity to perform
- Explicit
  - launch Activity with name of target Activity class
  - typically used to launch other activities within app
  - Navigation Component does this when navigating to other activities in Navigation Graph
- Implicit
  - provide abstract description of operation to be performed
  - typically used to launch activities exposed by other applications
  - Note: system may not have any apps installed to handle implicit intent
  - when multiple apps can handle implicit intent
    - Android will popup a chooser containing compatible apps
  - Action: type of thing that the app wants to have done on its behalf
  - Category: used to further dis-ambiguate action
  - Data Type: can choose apps based on data types it can accept
  - require intent-filter in AndroidManifest

