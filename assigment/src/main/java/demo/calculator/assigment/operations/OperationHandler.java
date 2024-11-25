package demo.calculator.assigment.operations;


import demo.calculator.assigment.enmus.Operation;

public interface OperationHandler {
    Operation getOperationType();
    Number apply(Number num1, Number num2);
}
