package demo.calculator.assigment.operations;

import demo.calculator.assigment.enmus.Operation;
import org.springframework.stereotype.Component;

@Component
public class SubtractOperationHandler implements OperationHandler {

    @Override
    public Operation getOperationType() {
        return Operation.SUBTRACT;
    }

    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
