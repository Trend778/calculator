package pro.sky.java.course2.calculator.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {


    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public double divide(int num1, int num2) {
            return (double) num1 / num2;
    }
}
