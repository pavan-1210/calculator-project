# Project Instructions: Java & Web Calculator

## 🛠 Build and Run Commands
- **Java Console**:
    - Compile: `javac CalculatorService.java CalculatorApp.java`
    - Run: `java CalculatorApp`
- **Java GUI**:
    - Compile: `javac CalculatorService.java CalculatorGUI.java`
    - Run: `java CalculatorGUI`
- **Web Version**:
    - Open `index.html` in any modern web browser.

## 🏗 Architecture
- **Java Versions**:
    - **Service Layer (`CalculatorService.java`)**: Core math logic and validation.
    - **UI Layers (`CalculatorApp.java`, `CalculatorGUI.java`)**: Delegate calculations to the service.
- **Web Version**:
    - **Logic (`script.js`)**: Uses a `CalcService` object to separate expression evaluation from UI updates.
    - **Structure/Style (`index.html`, `style.css`)**: Provides a modern responsive interface.

## 📏 Key Conventions
- **Error Handling**: 
    - Java: Use `ArithmeticException` for math errors.
    - Web: Handle errors via `try...catch` in `CalcService` and display "Error" in the UI.
- **Output Formatting**: All numeric results should be formatted to 2 decimal places (using `%.2f` in Java or `.toFixed(2)` in JS).
- **Naming**: Service methods/objects should be named after the operation or a general service pattern (e.g., `CalcService`).
