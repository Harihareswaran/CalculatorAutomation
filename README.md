# QA Internship Assignment: Android Automation Testing with Appium

## 1. Objective
Demonstrate the ability to configure an Android automation testing environment using Appium, design test cases, execute automated scripts, and validate results for a calculator application.

## 2. Environment Setup

### Tools and Dependencies Used
- **Java JDK:** v17  
- **Eclipse IDE:** v4.38.0  
- **Maven:** v3.9.12  
- **TestNG:** v7.11.0  
- **Appium Java Client:** v8.3.0  
- **Device:** Real Android device (UDID: 5200c707dc88a697)  

### Setup Steps
1. Install Java JDK and configure `JAVA_HOME`.  
2. Install Android Studio and create an emulator or connect a real device with USB debugging enabled.  
3. Install Appium via npm:
   npm install -g appium

4. Verify Appium installation:
   appium --version
5. Install Appium Desktop (optional for inspector and UI element identification).
6. Set up a Maven project in Eclipse/IntelliJ and add dependencies for Appium and TestNG.
7. Start Appium server and connect the device/emulator.

### Challenges Faced

* Installing correct device drivers for real device.
* Identifying the correct `appPackage` and `appActivity` for the calculator app.
* Handling empty results in the calculator when pressing the clear button.

## 3. Application Selection

**Selected Application:** Samsung Calculator (pre-installed on device)

**Reason for Selection:**

* Widely used and stable.
* Contains basic arithmetic operations.
* Supports Appium automation on Android devices.

## 4. Test Case Development

### Test Case 1: Addition Test

**Steps:**

1. Launch calculator app.
2. Enter **5**.
3. Press **+**.
4. Enter **3**.
5. Press **=**.
6. Verify the result is **8**.

**Automation Code Snippet (Java):**

CalculatorPage calc = new CalculatorPage(driver);
calc.enterNumber("5");
calc.clickAdd();
calc.enterNumber("3");
calc.clickEqual();
Assert.assertEquals(calc.getResult(), "8");


### Test Case 2: Clear Function Test

**Steps:**

1. Perform calculation (e.g., 7 + 2).
2. Press **C (Clear)**.
3. Verify display resets to **0**.

**Automation Code Snippet (Java):**

CalculatorPage calc = new CalculatorPage(driver);
calc.enterNumber("7");
calc.clickAdd();
calc.enterNumber("2");
calc.clickEqual();
calc.clickClear();
Assert.assertEquals(calc.getResult(), "0");

**Additional Test Cases**

* **Subtraction:** 9 - 4 = 5
* **Multiplication:** 6 × 2 = 12
* **Division:** 8 ÷ 2 = 4
* **Decimal Calculation (Optional):** 7 ÷ 2 = 3.5

## 5. Test Execution Report

|     Test Case       | Status |       Remarks                               |
| ------------------- | ------ | ------------------------------------------- |
| Addition Test       | Passed | Result matched expected value (8)           |
| Clear Function Test | Passed | Display reset to empty state successfully   |
| Subtraction Test    | Passed | Result matched expected value               |
| Multiplication Test | Passed | Result matched expected value               |
| Division Test       | Passed | Result matched expected value               |

 Screenshots of failures are automatically captured in `screenshots/` folder.

## 6. Code Repository

* **GitHub Link:** [CalculatorAutomation](https://github.com/Harihareswaran/CalculatorAutomation)
* Contains all test scripts, page objects, and `testng.xml` for execution.

## 7. Video Demonstration and Screenshot of Report

* **Demo Video:** [View on Google Drive](https://drive.google.com/file/d/1LF9wcTrBSAxEGYJkD_fzpwXZL2rEQbBJ/view?usp=sharing)
* Demonstrates execution of automated test cases on real device.

## 8. Conclusion

* Successfully automated two core test cases: Addition and Clear functionality.
* Configured Appium environment and executed tests on real Android device.
* Test scripts are extendable for subtraction, multiplication, division, and other operations.

## 9. Git Commands

### **Clone the Repository (First Time)**

To get a local copy of the repository:

git clone https://github.com/Harihareswaran/CalculatorAutomation.git
cd CalculatorAutomation

### **Pull Latest Changes**

If you already have the repo locally and want to update it:

git pull origin main

Note: Replace `main` with `master` if your repository uses that branch.

### **Add, Commit, and Push Changes**

If you make changes locally and want to push to GitHub:

* git add .
* git commit -m "Your commit message"
* git push origin main


