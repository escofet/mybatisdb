package com.itformacion;

import java.math.BigDecimal;

public class Discount {
	public String discount_code;
	public BigDecimal rate;
	
	public Discount(String discount_code, BigDecimal rate) {
		this.discount_code = discount_code;
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Discount [discount_code=" + discount_code + ", rate=" + rate + "]";
	}
}
