package by.learning.extapi.dao.rate;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import by.learning.extapi.domain.Rate;

public class RateDaoImplTest {
	private static final int USD_ID = 145;
	private static final int INCORRECT_ID = 999; // this id doesn't exist
	private static final int QUOTED_CURRENCIES_NUMBER = 26;

	@Test
	public void getOneByIdTest() {

		RateDao rateDao = new RateDaoImpl();

		Rate rate = rateDao.getOneById(USD_ID);

		assertEquals(145, rate.getId());
		assertEquals("USD", rate.getAbbreviation());
		assertEquals(1, rate.getScale());
		assertEquals("Доллар США", rate.getName());
	}
	
/*	@Test(expected = FileNotFoundException.class)
	public void getIncorrectIdTest() {
		
		RateDao rateDao = new RateDaoImpl();
		
		rateDao.getOneById(INCORRECT_ID);
	}*/

	@Test
	public void getAllTest() {

		RateDao rateDao = new RateDaoImpl();

		List<Rate> rateList = rateDao.getAll();
		
		assertEquals(QUOTED_CURRENCIES_NUMBER, rateList.size());
	}
}
