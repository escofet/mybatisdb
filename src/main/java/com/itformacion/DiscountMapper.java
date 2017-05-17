package com.itformacion;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface DiscountMapper {
	@Select("select * from APP.DISCOUNT_CODE")
    public List<Discount> showDiscounts();
	
	@Select("select * from APP.DISCOUNT_CODE where DISCOUNT_CODE= #{discount_code} AND rate=#{rate} FETCH FIRST ROW ONLY")
	public Discount getDiscount(String discount_code, double rate);
}
