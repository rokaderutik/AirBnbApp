package com.rutikrokade.projects.AirBnbApp.strategy;

import com.rutikrokade.projects.AirBnbApp.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Inventory inventory);
}
