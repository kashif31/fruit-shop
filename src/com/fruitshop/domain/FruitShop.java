package com.fruitshop.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FruitShop {

	private final BigDecimal costOfApple = BigDecimal.valueOf(0.6);
	private final BigDecimal costOfOrange = BigDecimal.valueOf(0.25);
	private List<String> basket = new ArrayList<String>();

	public BigDecimal getCostOfApple() {
		return costOfApple;
	}

	public BigDecimal getCostOfOrange() {
		return costOfOrange;
	}

	public List<String> getBasket() {
		return basket;
	}

	public void addItemToBasket(String item) {

		if (item.isEmpty() || item == null)
			throw new NullPointerException("Invalid_Input : Item can not be null or empty");

		if ((item.equalsIgnoreCase("apple") || item.equalsIgnoreCase("orange"))) {
			this.basket.add(item);
		} else {
			throw new RuntimeException("Invalid_Input : Shop only selling apples and oranges");
		}
	}

	public BigDecimal checkout(List<String> basket) {

		BigDecimal applesTotal = BigDecimal.ZERO;
		BigDecimal orangesTotal = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;

		for (String item : basket) {
			if (item.equalsIgnoreCase("apple"))
				applesTotal = applesTotal.add(costOfApple);

			if (item.equalsIgnoreCase("orange"))
				orangesTotal = orangesTotal.add(costOfOrange);
		}

		total = applesTotal.add(orangesTotal);
		return total;
	}
}
