# Adjoe Task

Please write Java code (no Kotlin). You are allowed to use libraries unless stated otherwise in the description of the task. The app should be able to run on every device from Android 5.0 on.
1. Native android:
● Create an activity which loads (and processes) data from this URL (use only
Java/Android standard libraries)
○ https://jsonplaceholder.typicode.com/albums
● Find a way to render the album titles (sorted by ID) from the JSON into a view, which is scrollable.
2. Services
● Build a BroadcastReceiver that listens to ​USER_PRESENT​ ​Intent
● Implement a background task (for example: JobScheduler or background service) that
runs periodically
● Everytime the background task runs, create a push notification that shows the user how
long the phone was active since the Intent was triggered (the time should be shown every few seconds)
