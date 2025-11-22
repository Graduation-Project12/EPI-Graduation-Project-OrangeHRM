# OrangeHRM Automation Testing Project

This project contains automated test scripts for the **PIM Module** of OrangeHRM using:
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Page Object Model (POM)**
- **Allure Reporting**

---

## 📌 Project Structure

```
final_project/
│
├── src/
│   ├── main/java/com/orangehrm
│   │   └── (not used in this project)
│   │
│   ├── test/java/com/orangehrm
│       ├── base/
│       │   └── BaseTest.java
│       │
│       ├── pages/
│       │   ├── LoginPage.java
│       │   ├── DashboardPage.java
│       │   ├── AddEmployeePage.java
│       │   └── EmployeeListPage.java
│       │
│       └── tests/
│           ├── AddEmployeeTest.java
│           ├── PIM_SearchTests.java
│           └── PIM_SearchAdvancedTests.java
│
├── pom.xml
└── testng.xml
```

---

## 🚀 How to Run All Tests

### ✔️ Option 1 — Run using testng.xml
1. Open IntelliJ.
2. Right‑click **testng.xml**
3. Click **Run 'testng.xml'**

This runs:
- Add Employee tests  
- Basic Search tests  
- Advanced Search tests  

---

## 📊 Allure Report Setup

### 1️⃣ Install Allure (Windows)
1. Download from official website  
   https://github.com/allure-framework/allure2/releases

2. Extract it to:
```
C:llure
```

3. Add to PATH:
```
C:llurein
```

4. Verify:
```
allure --version
```

---

## 📄 Generate Allure Report

After running tests:

```
allure serve allure-results
```

This will:
✔ open the Allure Report automatically  
✔ show test steps  
✔ show screenshots (if added later)

---

## ⚡ Running Maven Tests (Optional)

```
mvn clean test
```

---

## 📝 Key Features

### ✔ TestNG  
- Parallel tests using testng.xml  
- Test priorities  
- Assertions included  

### ✔ Selenium  
- Explicit waits  
- Robust locators  
- POM structure  

### ✔ Allure  
- Steps  
- Stories  
- Features  
- Severity levels  

---

## 📌 Future Improvements
- Add screenshot on failure  
- Add log4j2 logging  
- Add Jenkins pipeline  
- Upload report as artifact  

---

## 📬 Developed By
**Kerolos Barsoum**  
Automation Tester — Final Project (DEPI R3)

