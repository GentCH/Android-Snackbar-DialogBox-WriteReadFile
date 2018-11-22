# SnackDialogWriteReadFile
An application demo on using snackbar, dialog, write and read text file to internal storage.
User input text at the space provided, multi line text is supported. 
At MainActivity.java:
Clicking "SAVE TEXT", the input will be stored/saved to internal storage. A snackbar will display "Saved successfully!" message at bottom.
Clicking "VIEW TEXT", the app will display the stored input at the next interface.
At SecondActivity.java:
Clicking "DELETE", a dialog will ask user's permission to delete the content. 
      If "YES", delete the content and dismiss.
      iF "NO", dismiss.
Clicking "HOME" will return to main page.


///Steps to add design library:
Step 1: Click "File" -> "Project Structure"
Step 2: At left, click "App" -> at right, click "Dependencies"
Step 3: Click "+" -> "1 Library dependency"
Step 4: Type "design" and search. Add the design library relevant to the API (usually it appears on the top if the search list). Click "OK".
Step 5: Click "File" -> "Sync Project with Gradle Files".
