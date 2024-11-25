package demo.calculator.assigment.model;

import demo.calculator.assigment.enmus.Operation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class ChainRequest {

    public ChainRequest(Number initialValue, List<Operation> operations, List<Number> operands) {
        this.initialValue = initialValue;
        this.operations = operations;
        this.operands = operands;

    }

    @NotNull(message = "Initial value cannot be null")
    private Number initialValue;

    @NotNull(message = "Operations list cannot be null")
    @Size(min = 1, message = "At least one operation must be provided")
    private List<Operation> operations;

    @NotNull(message = "Operands list cannot be null")
    @Size(min = 1, message = "At least one operand must be provided")
    private List<Number> operands;

    // Getters and Setters
    public Number getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Number initialValue) {
        this.initialValue = initialValue;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Number> getOperands() {
        return operands;
    }

    public void setOperands(List<Number> operands) {
        this.operands = operands;
    }
}

