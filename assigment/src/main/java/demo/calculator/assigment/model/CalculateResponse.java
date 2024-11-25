package demo.calculator.assigment.model;

public class CalculateResponse {
    private Number result;

    public CalculateResponse(Number result) {
        this.result = result;
    }

    // Getter
    public Number getResult() {
        return result;
    }

    public void setResult(Number result) {
        this.result = result;
    }
}

