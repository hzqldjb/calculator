package demo.calculator.assigment.service;


import demo.calculator.assigment.enmus.Operation;
import demo.calculator.assigment.operations.OperationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CalculatorService {

    private final Map<Operation, OperationHandler> handlerMap = new HashMap<>();

    @Autowired
    public CalculatorService(List<OperationHandler> handlers) {
        for (OperationHandler handler : handlers) {
            handlerMap.put(handler.getOperationType(), handler);
        }
    }

    public Number calculate(Operation operation, Number num1, Number num2) {
        OperationHandler handler = handlerMap.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
//        if (handler.getOperationType() == Operation.DIVIDE &&  num2.doubleValue() == 0) {
//            throw new DivisionByZeroException();
//        }
        return handler.apply(num1, num2);
    }

    public Number chain(Number initialValue, List<Operation> operations, List<Number> operands) {
        if (operations.size() != operands.size()) {
            throw new IllegalArgumentException("Operations and operands size must match.");
        }

        Number result = initialValue;
        for (int i = 0; i < operations.size(); i++) {
            Operation operation = operations.get(i);
            Number operand = operands.get(i);
            result = calculate(operation, result, operand);
        }
        return result;
    }
}



