package by.learning.extapi.service.nbrb;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
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
	private String urlGet = "http://www.nbrb.by/API/ExRates/Rates";
	private URL url;

	/*
	 * We have to add BYN rate because NBRB API doesn't return this object
	 */
	private Rate bynRate = new Rate();
	{
		bynRate.setId(-1);
		bynRate.setDate(new Date());
		bynRate.setAbbreviation("BYN");
		bynRate.setScale(1);
		bynRate.setName("Белорусский рубль");
		bynRate.setOfficialRate(new BigDecimal("1.0000"));
	}

	@Override
	public Rate getRateById(int id) {

		if (id == -1) {

			return bynRate;
		}

		ObjectMapper mapper = new ObjectMapper();
		Rate rate = null;

		try {
			url = new URL(urlGet + "/" + id);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}

		try {
			rate = mapper.readValue(url, Rate.class);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return rate;
	}

	@Override
	public List<Rate> getAllRates() {
		ObjectMapper mapper = new ObjectMapper();
		List<Rate> rateList = null;

		try {
			url = new URL(urlGet + "?Periodicity=0");
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}

		try {
			rateList = new ArrayList<Rate>(Arrays.asList(mapper.readValue(url, Rate[].class)));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		rateList.add(0, bynRate);

		return rateList;
	}

}
