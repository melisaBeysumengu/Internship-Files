package Week3.Day1.Example3.service;

import Week3.Day1.Example3.component.PrimarySchoolCalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculator implements Calculator{
    @Override
    public long calculate(long n1, long n2) {
        return n1+n2;
    }

    private PrimarySchoolCalculatorUtil primarySchoolCalculatorUtil;

    @Autowired
    SimpleCalculator(PrimarySchoolCalculatorUtil p){
        this.primarySchoolCalculatorUtil = p;
    }
}



