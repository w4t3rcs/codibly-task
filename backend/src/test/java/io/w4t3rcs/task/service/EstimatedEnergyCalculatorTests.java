package io.w4t3rcs.task.service;

import io.w4t3rcs.task.service.impl.EstimatedEnergyCalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EstimatedEnergyCalculatorTests {
    private static EstimatedEnergyCalculator estimatedEnergyCalculator;

    @BeforeAll
    static void init(){
        estimatedEnergyCalculator = new EstimatedEnergyCalculatorImpl();
    }

    @ParameterizedTest
    @CsvSource(value = {"3600, 0.5", "7200, 1", "11241, 1.56125"}, delimiterString = ", ")
    void testCalculateEstimatedEnergy(Double sunshineDuration, Double expectedEnergy) {
        Assertions.assertEquals(expectedEnergy, estimatedEnergyCalculator.calculateEstimatedEnergy(sunshineDuration));
    }
}
