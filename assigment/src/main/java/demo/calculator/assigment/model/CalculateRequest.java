package demo.calculator.assigment.model;

import demo.calculator.assigment.enmus.Operation;
import jakarta.validation.constraints.NotNull;

public class CalculateRequest {

    public CalculateRequest(Operation operation, Number num1, Number num2) {
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;
    }

    @NotNull(message = "Operation is required")
    private Operation operation;

    @NotNull(message = "First number is required")
    private Number num1;

    @NotNull(message = "Second number is required")
    private Number num2;

    // Getters and Setters
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Number getNum1() {
        return num1;
    }

    public void setNum1(Number num1) {
        this.num1 = num1;
    }

    public Number getNum2() {
        return num2;
    }

    public void setNum2(Number num2) {
        this.num2 = num2;
    }
}

