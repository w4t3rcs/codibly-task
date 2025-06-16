package io.w4t3rcs.task.service.impl;

import io.w4t3rcs.task.service.EstimatedEnergyCalculator;
import org.springframework.stereotype.Service;

@Service
public class EstimatedEnergyCalculatorImpl implements EstimatedEnergyCalculator {
    public static final float POWER = 2.5F;
    public static final float EFFICIENCY = 0.2F;
    public static final int SECONDS_PER_HOUR = 3600;

    @Override
    public double calculateEstimatedEnergy(double sunshineDuration) {
        return POWER * EFFICIENCY * (sunshineDuration / SECONDS_PER_HOUR);
    }
}
