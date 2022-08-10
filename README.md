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
- `app/test/` - Unit tests
- `app/androidTest/` - Instrumentation tests
- `app/build/reports/androidTests/connected/index.html` - Report for Instrumentational tests
- `app/build/reports/tests/testDebugUnitTest/index.html` - Report for Unit tests
- `Reports` - TestCases, BugReport and Common Report


## Steps to reproduce
- Clone this project to your local
- Open this project through AndroidStudio
- Run app before tests are started with your android device (I used Pixel 3a API 30) by Run button.

![Screenshot_2](https://user-images.githubusercontent.com/83962883/181755502-654bf2ab-02c8-4d2a-a031-be586b768e37.png)

## Run UI Tests
- Run MainActivityTest class through console (terminal) on your IDE or Android Studio by command

> ```   adb shell am instrument -w -r -e debug false -e class 'app.com.mobileassignment.views.tests.MainActivityTest' app.com.mobileassignment.test/androidx.test.runner.AndroidJUnitRunner  ```

- Or you can run Test Class (MainActivityTest) which is located in androidTest folder by Run button.

![Screenshot_9](https://user-images.githubusercontent.com/83962883/183925927-20398383-9858-4e34-a197-354af2328968.png)

## Run Unit Tests
- You can run CityAdapterTest class which is located in test folder by Run Button

![Screenshot_10](https://user-images.githubusercontent.com/83962883/183926201-94020549-5466-4c4d-bc7d-6fa1d7269192.png)

## Reports
Reports are located in the Reports folder at the root of the project. There are TestCases, BugReport and common conclusion.

![Screenshot_3](https://user-images.githubusercontent.com/83962883/183088973-286ed73d-1822-4ccf-b814-b93071ae1bc7.png)

Also after the tests running reports will be generated an html test result report which are stored at

> ```   app/build/reports/androidTests/connected/index.html  ```

and

> ```   app/build/reports/tests/testDebugUnitTest/index.html  ```

You can open index.html files through browser.

![Screenshot_5](https://user-images.githubusercontent.com/83962883/183926689-cda4fcf5-a3f7-4ca9-8a8a-7301168bf1d1.png)






