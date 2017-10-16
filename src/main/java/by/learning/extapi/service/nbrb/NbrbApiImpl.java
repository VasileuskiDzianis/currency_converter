package by.learning.extapi.service.nbrb;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import by.learning.extapi.domain.Rate;

@Service
public class NbrbApiImpl implements NbrbApi {
	private static final String PERIODICITY_0 = "?Periodicity=0";
	private static final String PATH_SPLITTER = "/";
	
	private static final BigDecimal BYN_TO_BYN_RATE = new BigDecimal("1.0000");
	private static final String BYN_NAME = "Белорусский рубль";
	private static final int BYN_SCALE = 1;
	private static final String BYN_ABBREVIATION = "BYN";
	private static final int BYN_ID = -1;
	
	private static final String URL_GET_RATE = "http://www.nbrb.by/API/ExRates/Rates";

	/*
	 * We have to add BYN rate because NBRB API doesn't return this object
	 */
	private final Rate bynRate;
	
	public NbrbApiImpl() {
		bynRate = new Rate();
		bynRate.setId(BYN_ID);
		bynRate.setDate(new Date());
		bynRate.setAbbreviation(BYN_ABBREVIATION);
		bynRate.setScale(BYN_SCALE);
		bynRate.setName(BYN_NAME);
		bynRate.setOfficialRate(BYN_TO_BYN_RATE);
	}

	@Override
	public Rate getRateById(int id) {
		if (id == BYN_ID) {
			return bynRate;
		}

		ObjectMapper mapper = new ObjectMapper();
		Rate rate = null;

		try {
			URL url = new URL(URL_GET_RATE + PATH_SPLITTER + id);
			rate = mapper.readValue(url, Rate.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rate;
	}

	@Override
	public List<Rate> getAllRates() {
		ObjectMapper mapper = new ObjectMapper();
		List<Rate> rateList = new ArrayList<>();
		rateList.add(bynRate);

		try {
			URL url = new URL(URL_GET_RATE + PERIODICITY_0);
			rateList.addAll(Arrays.asList(mapper.readValue(url, Rate[].class)));
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return rateList;
	}
}
