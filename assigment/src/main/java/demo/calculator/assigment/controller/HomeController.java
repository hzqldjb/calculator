package demo.calculator.assigment.controller;

import demo.calculator.assigment.model.CalculateRequest;
import demo.calculator.assigment.model.CalculateResponse;
import demo.calculator.assigment.model.ChainRequest;
import demo.calculator.assigment.model.ChainResponse;
import demo.calculator.assigment.service.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Validated
public class HomeController {

    private final CalculatorService calculatorService;

    public HomeController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @PostMapping("/calculate")
    public ResponseEntity<CalculateResponse> calculate(@Valid @RequestBody CalculateRequest request) {
        Number result = calculatorService.calculate(request.getOperation(), request.getNum1(), request.getNum2());
        return ResponseEntity.ok(new CalculateResponse(result));
    }

    @PostMapping("/chain")
    public ChainResponse chain(@Valid @RequestBody ChainRequest chainRequest) {
        if (chainRequest.getOperations().size() != chainRequest.getOperands().size()) {
            throw new IllegalArgumentException("The number of operations must match the number of operands.");
        }

        Number result = calculatorService.chain(
                chainRequest.getInitialValue(),
                chainRequest.getOperations(),
                chainRequest.getOperands()
        );
        return new ChainResponse(result);
    }
}