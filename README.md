Reproduction of AOSP Issue 231717
=================================

`RecyclerView` crashes unexpectedly if the view is scrolling and the item count in the adapter
changes without calling `notifyDataSetChanged`. While `notifyDataSetChanged` or a variant
_should_ always be called, it is not expected that the `RecyclerView` will continue attempting
to animate the scroll once it is no longer visible. Prior to version 25, it was permissible to leave
the adapter in an inconsistent state once the `RecyclerView` was detached.

The issue itself can be found [here](https://issuetracker.google.com/issues/37132154).

#### Steps to Reproduce

1. Flick the `RecyclerView` so that it coasts.
1. Press the home button while the view is still settling.
1. Observe the exception.

Additionally, it may be necessary to enable "Don't keep activities" in the developer settings.
