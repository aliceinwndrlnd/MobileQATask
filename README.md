# Mobile QA Assignment

## Description
Automated tests for a simple native Android application that shows a list of cities which you can search.
## Stack:
- Java 11
- Espresso
- JUnit4
- Gradle
- PageObject model

## Structure:

- `app/` - Main application
- `app/src/test/` - Unit tests
- `app/src/androidTest/` - Instrumentation tests
- `app/build/reports/androidTests/connected/index.html` - Report for Instrumentation tests
- `app/build/reports/tests/testDebugUnitTest/index.html` - Report for Unit tests
- `Reports/` - TestCases, BugReport and Common Report


## How to Run

### Preconditions:
- Clone this project to your local
- Open this project through AndroidStudio
- Create a virtual device (Tools -> Device Manager -> Create Device button -> Choose any device with <ins>mark Play Store</ins> and APi level > 30)
- Run app before tests are started with your virtual android device (I used Pixel 3a API 30) by Run button.

## Run UI Tests
- Run MainActivityTest class through console (terminal) on your IDE or Android Studio by command

> ```   adb shell am instrument -w -r -e debug false -e class 'app.com.mobileassignment.views.tests.MainActivityTest' app.com.mobileassignment.test/androidx.test.runner.AndroidJUnitRunner  ```

- Or you can run Test Class <ins>MainActivityTest</ins> which is located in <ins>androidTest folder</ins> by Run button 

path: ```   app/src/androidTest/tests/MainActivityTest  ```

## Run Unit Tests
- You can run Test Class <ins>CityAdapterTest</ins> which is located in <ins>test folder</ins> by Run Button 

path: ```   app/src/test/ApplicationTest  ```

## Reports
Reports are located in the Reports folder at the root of the project. There are TestCases, BugReport and Final Report 

path: ```   Reports/  ```

Also after the tests running reports will be generated an html test result report which are stored at

```   app/build/reports/androidTests/connected/index.html  ```   for Instrumental tests

and

```   app/build/reports/tests/testDebugUnitTest/index.html  ```   for Unit Tests

You can open index.html files through browser to see the reports.







