package Week3.Day1.Example3;

import Week3.Day1.Example3.service.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CalculatorApp implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Demo2Application.class);
    private Calculator calc1;
    private Calculator calc2;

    public CalculatorApp(@Qualifier("scientificCalculator") Calculator calc1, @Qualifier("simpleCalculator") Calculator calc2) {
        this.calc1 = calc1;
        this.calc2 = calc2;
    }

    @Override
    public void run(String... args) throws Exception {

        LOGGER.info("Calculeted value {}", calc1.calculate(10,2));
        LOGGER.info("Calculeted value {}", calc2.calculate(10,2));

        System.out.println(calc1.calculate(10,2));
        System.out.println(calc2.calculate(10,2));

    }
}
