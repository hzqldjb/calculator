package demo.calculator.assigment;

import demo.calculator.assigment.controller.HomeController;
import demo.calculator.assigment.enmus.Operation;
import demo.calculator.assigment.model.CalculateRequest;
import demo.calculator.assigment.model.CalculateResponse;
import demo.calculator.assigment.model.ChainRequest;
import demo.calculator.assigment.model.ChainResponse;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HomeControllerTest {

    @Autowired
    private HomeController homeController;

    @Test
    void testCalculate_ValidRequest() {
        // Create a valid request
        CalculateRequest request = new CalculateRequest(Operation.ADD, 10, 20);

        // Call the controller method directly
        CalculateResponse response = homeController.calculate(request).getBody();

        // Verify the result
        Assertions.assertEquals(30.0, response.getResult());
    }

    @Test
    void testCalculate_InvalidOperation() {
        // Create a request with an invalid operation
        CalculateRequest request = new CalculateRequest(null, 10, 20);

        // Expect a validation error
        Assertions.assertThrows(ConstraintViolationException.class, () -> homeController.calculate(request));
    }

    @Test
    void testChain_ValidRequest() {
        // Create a valid request for chaining operations
        ChainRequest request = new ChainRequest(5, List.of(Operation.ADD, Operation.MULTIPLY), List.of(3, 2));

        // Call the controller method directly
        ChainResponse response = homeController.chain(request);

        // Verify the result
        Assertions.assertEquals(16.0, response.getResult());
    }

    @Test
    void testChain_MissingOperands() {
        // Create a request with missing operands
        ChainRequest request = new ChainRequest(5, List.of(Operation.ADD), null);

        // Expect a validation error
        Assertions.assertThrows(ConstraintViolationException.class, () -> homeController.chain(request));
    }
}

