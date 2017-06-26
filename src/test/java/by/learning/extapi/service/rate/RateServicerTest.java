package by.learning.extapi.service.rate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import by.learning.extapi.dao.rate.RateDao;
import by.learning.extapi.dao.rate.RateDaoImpl;
import by.learning.extapi.domain.Rate;
import by.learning.extapi.service.rate.RateService;
import by.learning.extapi.service.rate.RateServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RateServicerTest {
	private static final int USD_ID = 145;
	private static final int EUR_ID = 292;
	private static final int RUB_ID = 298;
	private static final int BYN_ID = -1;

	private static final int USD_SCALE = 1;
	private static final int EUR_SCALE = 1;
	private static final int RUB_SCALE = 100;
	private static final int BYN_SCALE = 1;

	private static final BigDecimal USD_RATE = new BigDecimal("1.9284");
	private static final BigDecimal EUR_RATE = new BigDecimal("2.1544");
	private static final BigDecimal RUB_RATE = new BigDecimal("3.2309");
	private static final BigDecimal BYN_RATE = new BigDecimal("1.0000");
	
	private static final BigDecimal AMOUNT = new BigDecimal("5.45");
	
	private static final BigDecimal BYN_TO_USD = new BigDecimal("2.8262");
	private static final BigDecimal USD_TO_BYN = new BigDecimal("10.5098");
	private static final BigDecimal EUR_TO_USD = new BigDecimal("6.0887");
	private static final BigDecimal USD_TO_RUB = new BigDecimal("325.2900");
	private static final BigDecimal RUB_TO_USD = new BigDecimal("0.0913");
	private static final BigDecimal RUB_TO_BYN = new BigDecimal("0.1761");
	
	@Mock
	private RateDao rateDao = new RateDaoImpl();
	
	@InjectMocks
	private RateService rateService = new RateServiceImpl();

	@Before
	public void daoRateInitialize() {

		Rate usdRate = new Rate();
		usdRate.setId(USD_ID);
		usdRate.setScale(USD_SCALE);
		usdRate.setOfficialRate(USD_RATE);

		Rate eurRate = new Rate();
		eurRate.setId(EUR_ID);
		eurRate.setScale(EUR_SCALE);
		eurRate.setOfficialRate(EUR_RATE);

		Rate rubRate = new Rate();
		rubRate.setId(RUB_ID);
		rubRate.setScale(RUB_SCALE);
		rubRate.setOfficialRate(RUB_RATE);
		
		Rate bynRate = new Rate();
		bynRate.setId(BYN_ID);
		bynRate.setScale(BYN_SCALE);
		bynRate.setOfficialRate(BYN_RATE);

		when(rateDao.getOneById(USD_ID)).thenReturn(usdRate);
		when(rateDao.getOneById(EUR_ID)).thenReturn(eurRate);
		when(rateDao.getOneById(RUB_ID)).thenReturn(rubRate);
		when(rateDao.getOneById(BYN_ID)).thenReturn(bynRate);
	}

	@Test
	public void testConvert() {
		
		assertEquals(BYN_TO_USD, rateService.convert(AMOUNT, BYN_ID, USD_ID));
		assertEquals(USD_TO_BYN, rateService.convert(AMOUNT, USD_ID, BYN_ID));
		assertEquals(EUR_TO_USD, rateService.convert(AMOUNT, EUR_ID, USD_ID));
		assertEquals(USD_TO_RUB, rateService.convert(AMOUNT, USD_ID, RUB_ID));
		assertEquals(RUB_TO_USD, rateService.convert(AMOUNT, RUB_ID, USD_ID));
		assertEquals(RUB_TO_BYN, rateService.convert(AMOUNT, RUB_ID, BYN_ID));
		
	}
}
