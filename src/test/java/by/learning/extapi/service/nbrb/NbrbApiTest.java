package by.learning.extapi.service.nbrb;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import by.learning.extapi.domain.Rate;

public class NbrbApiTest {
	private static final int USD_ID = 145;
	private static final int QUOTED_CURRENCIES_NUMBER = 27;

	@Test
	public void getOneByIdTest() {

		NbrbApi nbrbApi = new NbrbApiImpl();

		Rate rate = nbrbApi.getRateById(USD_ID);

		assertEquals(145, rate.getId());
		assertEquals("USD", rate.getAbbreviation());
		assertEquals(1, rate.getScale());
		assertEquals("Доллар США", rate.getName());
	}

	@Test
	public void getAllTest() {

		NbrbApi nbrbApi = new NbrbApiImpl();

		List<Rate> rateList = nbrbApi.getAllRates();

		assertEquals(QUOTED_CURRENCIES_NUMBER, rateList.size());
	}
}
