package com.fruitshop.domain;

import java.math.BigDecimal;

public class FruitShop {

	private final BigDecimal costOfApple = BigDecimal.valueOf(0.6);
	private final BigDecimal costOfOrange = BigDecimal.valueOf(0.25);

	public BigDecimal getCostOfApple() {
		return costOfApple;
	}

	public BigDecimal getCostOfOrange() {
		return costOfOrange;
	}
}
