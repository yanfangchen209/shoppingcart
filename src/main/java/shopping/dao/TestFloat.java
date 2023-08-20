package shopping.dao;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestFloat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("0.00");
		double price1 = 29.9;
		double price2 = 39.9;
		System.out.println(df.format(price1*1 + price2*2));
		
		BigDecimal p1 = new BigDecimal("29.9");
        BigDecimal p2 = new BigDecimal("39.9");
        BigDecimal resultBigDecimal = p1.multiply(BigDecimal.valueOf(1)).add(p2.multiply(BigDecimal.valueOf(2)));
        System.out.println(resultBigDecimal.toString());
	}

}
