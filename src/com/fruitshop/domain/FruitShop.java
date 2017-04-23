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

	public BigDecimal checkout(List<String> basket, boolean offerOnApples, boolean offerOnOranges) {

		BigDecimal applesTotal = BigDecimal.ZERO;
		BigDecimal orangesTotal = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;
		int numOfOranges = 0;

		for (String item : basket) {
			if (item.equalsIgnoreCase("apple"))
				applesTotal = applesTotal.add(costOfApple);

			if (item.equalsIgnoreCase("orange")) {
				orangesTotal = orangesTotal.add(costOfOrange);
				numOfOranges++;
			}
		}
		if (offerOnApples) // buy one get one free offer on apples
			applesTotal = applesTotal.divide(BigDecimal.valueOf(2));

		// Get Three For the Price of Two Oranges
		if (offerOnOranges && numOfOranges > 2) {
			int orangesToDiscount = numOfOranges / 3;
			orangesTotal = orangesTotal.subtract(costOfOrange.multiply(BigDecimal.valueOf(orangesToDiscount)));
		}

		total = applesTotal.add(orangesTotal);
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result + ((costOfApple == null) ? 0 : costOfApple.hashCode());
		result = prime * result + ((costOfOrange == null) ? 0 : costOfOrange.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FruitShop other = (FruitShop) obj;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		if (costOfApple == null) {
			if (other.costOfApple != null)
				return false;
		} else if (!costOfApple.equals(other.costOfApple))
			return false;
		if (costOfOrange == null) {
			if (other.costOfOrange != null)
				return false;
		} else if (!costOfOrange.equals(other.costOfOrange))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FruitShop [costOfApple=" + costOfApple + ", costOfOrange=" + costOfOrange + ", basket=" + basket + "]";
	}
}
