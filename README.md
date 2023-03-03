Your task is to do the following (look for the TODOs in the code):

* Create a navigation graph for the Main Screen, Details Screen and Dictionary Dialog. You can place it in the com.example.plants.navigation.
** You'll need to think about how you pass data between the screens. What routes to define for them.
** The Details screen, for instance, should accept either a plant ID or plant name to perform lookups.
* Create and connect the viewModels for the Main and Details screens.
* Clicking on a plant from the main screen brings up the details screen for that plant.
** Lookup can be either by plant ID or plant name.
* Clicking on a plant hyperlink in the description on the details screen takes you to the details screen for that plant.
** Lookup in this case will be by plant name, because we won't have the ID in this case.
* Clicking on a definition hyperlink opens the dictionary dialog.
** Pass the word name to the dialog. Dialog will look up the definition.
* Clicking on the "Go To Main Screen" button takes the user all the way back to the main screen of the app ("back" is the operative word).

Extra credit:

* Improve the UIs for all of the screens. Get creative! E.g.:
** Show a thumbnail on the Main Screen
** Add an App Bar for all screens.
** Show an Up button on the Details Screens.
** Make the content scrollable.
** ... and whatever improvements you can think of.
* Add a delay in the coroutines and show a loading spinner while the data is loading on the screens.
* Try allowing multiple Details screens to be on the backstack, as well as only one.