package org.example;

import org.example.test1.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    public void addTest(){
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class,()-> calculator.divide(4, 0));

    }
}
