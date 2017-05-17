package com.itformacion;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
	public static void main(String[] args) {
		DataSource dataSource = SampleDataSourceFactory.getSampleDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(DiscountMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<Discount> discounts = session.selectList("com.itformacion.DiscountMapper.showDiscounts");
			System.out.println(discounts);
			Discount d = session.selectOne(
				"com.itformacion.DiscountMapper.getDiscount", 
				new Discount("L", new BigDecimal(7.0))
			);
			System.out.println(d);
		} finally {
			session.close();
		}
	}
}

