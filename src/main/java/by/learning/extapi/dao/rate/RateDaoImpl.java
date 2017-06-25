package by.learning.extapi.dao.rate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import by.learning.extapi.domain.Rate;

@Repository
public class RateDaoImpl implements RateDao {
	private String urlGet = "http://www.nbrb.by/API/ExRates/Rates";
	private URL url;

	@Override
	public Rate getOneById(int id) {
		ObjectMapper mapper = new ObjectMapper();
		Rate rate = null;

		try {
			url = new URL(urlGet + "/" + id);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			rate = mapper.readValue(url, Rate.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rate;
	}

	@Override
	public List<Rate> getAll() {
		ObjectMapper mapper = new ObjectMapper();
		List<Rate> rateList = null;

		try {
			url = new URL(urlGet + "?Periodicity=0");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			rateList = Arrays.asList(mapper.readValue(url, Rate[].class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rateList;
	}

}
