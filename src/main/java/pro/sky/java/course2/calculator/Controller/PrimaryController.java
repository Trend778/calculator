package pro.sky.java.course2.calculator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.Service.CalculatorService;

@RequestMapping("/calculator")
@RestController
public class PrimaryController {

    private final CalculatorService calculatorService;

    public PrimaryController(CalculatorService calculatorService) {   //инжект
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcomeCalculator() {
        return "Добро пожаловать в калькулятор.";
    }
    @GetMapping("/plus")
    public String showAddition(@RequestParam  (value = "num1" , required = false) Integer num1,
                               @RequestParam (value ="num2", required = false) Integer num2) {                               // /calculator/plus?num1=5&num2=5
        if (num1 == null || num2 == null) {
            return "<h1>В строке выше следует указать параметры! =) </h1>";
        }
        return buildResultString(num1, num2,"+",+ calculatorService.plus(num1, num2));
    }
    @GetMapping("/minus")
    public String showSubtraction(@RequestParam  (value = "num1" , required = false) Integer num1,
                                  @RequestParam (value ="num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>В строке выше следует указать параметры! =) </h1>";
        }
        return buildResultString(num1, num2,"-", + calculatorService.minus(num1, num2));                   // /calculator/minus?num1=5&num2=5
    }
    @GetMapping("/multiply")
    public String showMultiplication(@RequestParam  (value = "num1" , required = false) Integer num1,
                                     @RequestParam (value ="num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>В строке выше следует указать параметры! =) </h1>";
        }
        return buildResultString(num1, num2,"*", calculatorService.multiply(num1, num2));           // /calculator/multiply?num1=5&num2=5
    }
    @GetMapping("/divide")
    public String showdivision(@RequestParam  (value = "num1" , required = false) Integer num1,
                               @RequestParam (value ="num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>В строке выше следует указать параметры! =) </h1>";
        }
        else if (num2 == 0) {
            return "<h1> Делить на ноль нельзя!!! </h1>";
        }
        return buildResultString(num1, num2,"/", calculatorService.divide(num1, num2));  // /calculator/divide?num1=5&num2=5
    }

    private String buildResultString(int num1, int num2, String operation, Number result) {  // А вот за эту фичу Дмитрию Бизину отдельное спасибо, что показал!! =)
        return String.format("%d %s %d = %s" , num1, operation,num2,result);
    }
}
