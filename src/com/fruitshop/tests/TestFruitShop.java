package com.fruitshop.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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

	// Checking total when all items are apples and no offers applied
	@Test
	public void WhenFiveApplesInBasketReturnTotalThreeGBP() {
		List<String> items = Arrays.asList("apple", "apple", "apple", "apple", "apple");
		assertEquals(BigDecimal.valueOf(3.0), shop.checkout(items, false));
	}

	// Checking total when all items are oranges and no offers applied
	@Test
	public void WhenFiveOrangesInBasketReturnTotalOneTwentyFiveGBP() {
		List<String> items = Arrays.asList("orange", "orange", "orange", "orange", "orange");
		assertEquals(BigDecimal.valueOf(1.25), shop.checkout(items, false));
	}

	// Checking total for apples and oranges in basket and no offers applied
	@Test
	public void WhenTwoOrangesThreeApplesInBasketReturnTotalTwoFiftyfiveGBP() {
		List<String> items = Arrays.asList("apple", "orange", "apple", "orange", "orange", "apple");
		assertEquals(BigDecimal.valueOf(2.55), shop.checkout(items, false));
	}

	// Checking total buy one get one free offer when apples only in basket
	@Test
	public void WhenFiveApplesWithOfferInBasketReturnTotalThreeGBP() {
		List<String> items = Arrays.asList("apple", "apple", "apple", "apple", "apple");
		assertEquals(BigDecimal.valueOf(1.5), shop.checkout(items, true));
	}
}
