package com.fruitshop.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.fruitshop.domain.FruitShop;

public class TestFruitShop {

	FruitShop shop = new FruitShop();

	// check the cost of the apples
	@Test
	public void TestCostOfApples() {
		assertEquals(BigDecimal.valueOf(0.60), shop.getCostOfApple());
	}

	// check the cost of the oranges
	@Test
	public void TestCostOfOranges() {
		assertEquals(BigDecimal.valueOf(0.25), shop.getCostOfOrange());
	}

	// Checking for null or empty basket
	@Test(expected = NullPointerException.class)
	public void WhenItemNullOrEmptyThrowsException() {
		shop.addItemToBasket(null);
		shop.addItemToBasket("");
	}

	// Checking for item other than oranges or apples
	@Test(expected = RuntimeException.class)
	public void WhenAnythingElseButAppleOrOrangeThrowsException() {
		shop.addItemToBasket("banana");
	}
}
