# About Me: Android Layouts

## Think About

- Where might I use these components in applications every day? How are they used?
- What data is needed to comprise the content of these applications?
- Which pieces of that data are static? Which pieces are dynamic?
- What is the relational layout of each of the components?
  - How would you accomplish this?
  - What constraints would be required?

## Constraint Types

- Fixed Constraint: i.e. margins
- Wrap Content: view expands to fit contents
- Exact Line: match constraint(s)
  - the more constraints of matching kind
  - the more the layout can adapt to different screen sizes and orientations
  - which means fewer layouts for app

## [Chains](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout#Chains)

- Linked views in horizontal/vertical row and behave as a group
- Controlled by attributes set on head of chain
- Head is element from which chain was created
- Behavior: control by assigning weight and bias to elements
  - Spread Chain (default): spreads elements equally in available space
  - Spread Inside Chain: use all available space with head and tail glued to parent
  - Weighted Chain: use all space and re-size elements
    - based on values set in layout constraint horizontal/vertical weight attributes
  - Packed Chain: will use minimum space
    - use bias to move group of elements on axis

## [DataBinding](https://developer.android.com/topic/libraries/data-binding/start)

- findViewById is expensive: requires traversing view hierarchy at runtime
- data binding: connect layout to activity/fragment at compile-time (layout inflation)
  - compiler generates helper class (binding class) when activity is created
  - can access view with generated binding class without any overhead
- [Data Binding Library](https://developer.android.com/topic/libraries/data-binding/)
- [Generated Binding Classes](https://developer.android.com/topic/libraries/data-binding/generated-binding)
- [View Binding](https://developer.android.com/topic/libraries/view-binding)
- [Accessing Views](https://www.youtube.com/watch?v=Qxj2eBmXLHg&feature=youtu.be&t=444)
- [Binding Expressions](https://developer.android.com/topic/libraries/data-binding/expressions)

## Resources

- [Google Play](https://play.google.com/store/apps)
- [Support different pixel densities](https://developer.android.com/training/multiscreen/screendensities)
- [Responsive UI with ConstraintLayout](https://developer.android.com/training/constraint-layout/)
- [Performance of ConstraintLayout](https://android-developers.googleblog.com/2017/08/understanding-performance-benefits-of.html)
- [ConstraintLayout CodeLab](https://developer.android.com/codelabs/constraint-layout#0)
- [Layout Editor](https://developer.android.com/studio/write/layout-editor.html)

