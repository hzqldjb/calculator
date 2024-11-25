package demo.calculator.assigment.operations;

import org.springframework.stereotype.Component;
import demo.calculator.assigment.enmus.Operation;


@Component
public class DivideOperationHandler implements OperationHandler {

    @Override
    public Operation getOperationType() {
        return Operation.DIVIDE;
    }

    @Override
    public Number apply(Number num1, Number num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return num1.doubleValue() / num2.doubleValue();
    }
}