package com.itformacion;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface DiscountMapper {
	@Select("select * from APP.DISCOUNT_CODE")
    public List<Discount> showDiscounts();
}
