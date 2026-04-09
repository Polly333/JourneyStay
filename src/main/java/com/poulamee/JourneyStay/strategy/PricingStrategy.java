package com.poulamee.JourneyStay.strategy;

import com.poulamee.JourneyStay.entity.Inventory;

import java.math.BigDecimal;
public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
