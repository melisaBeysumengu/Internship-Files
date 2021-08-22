package Week3.Day1.Example3.service;

import Week3.Day1.Example3.component.AcademicCalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScientificCalculator implements Calculator{

    private AcademicCalculatorUtil academicCalculatorUtil;

    @Autowired
    ScientificCalculator(AcademicCalculatorUtil a){
        this.academicCalculatorUtil = a;
    }

    @Override
    public long calculate(long n1, long n2) {
        return n1*n2;
    }
}
