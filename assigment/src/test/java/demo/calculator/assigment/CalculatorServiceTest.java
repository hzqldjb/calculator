package demo.calculator.assigment;

import demo.calculator.assigment.enmus.Operation;
import demo.calculator.assigment.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void testAddition() {
        Number result = calculatorService.calculate(Operation.ADD, 5, 10);
        assertEquals(15.0, result);
    }

    @Test
    void testSubtraction() {
        Number result = calculatorService.calculate(Operation.SUBTRACT, 5, 10);
        assertEquals(-5.0, result);
    }
    @Test
    void testMultiplication() {
        Number result = calculatorService.calculate(Operation.MULTIPLY, 5, 10);
        assertEquals(50.0, result);
    }
    @Test
    void testDivide() {
        Number result = calculatorService.calculate(Operation.DIVIDE, 5, 10);
        assertEquals(0.5, result);
    }

    @Test
    void testUnsupportedOperation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(null, 5, 10);
        });
        assertEquals("Unsupported operation: null", exception.getMessage());
    }

    @Test
    void testChaining() {
        List<Operation> operations = List.of(Operation.ADD, Operation.MULTIPLY);
        List<Number> operands = List.of(5, 3);
        Number result = calculatorService.chain(10, operations, operands);
        assertEquals(45.0, result);
    }

}
