// Calculator Logic "Service"
const CalcService = {
    calculate: (expression) => {
        try {
            // Using Function constructor instead of eval for slightly better security
            const result = new Function(`return ${expression}`)();
            if (!isFinite(result)) throw new Error("Div by Zero");
            return Number(result).toFixed(2);
        } catch (e) {
            return "Error";
        }
    }
};

// UI Logic "App"
let currentInput = "";

function appendNumber(num) {
    currentInput += num;
    updateDisplay();
}

function appendOperator(op) {
    if (currentInput === "" || isNaN(currentInput.slice(-1))) return;
    currentInput += op;
    updateDisplay();
}

function clearDisplay() {
    currentInput = "";
    updateDisplay();
}

function deleteLast() {
    currentInput = currentInput.slice(0, -1);
    updateDisplay();
}

function calculate() {
    const result = CalcService.calculate(currentInput);
    currentInput = result;
    updateDisplay();
}

function updateDisplay() {
    document.getElementById('display').value = currentInput;
}
