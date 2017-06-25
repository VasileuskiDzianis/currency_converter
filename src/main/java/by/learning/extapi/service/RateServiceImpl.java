package by.learning.extapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.learning.extapi.dao.rate.RateDao;
import by.learning.extapi.domain.Rate;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
	private RateDao rateDao;
	
	@Override
	public List<Rate> getAllRates() {
				
		return rateDao.getAll();
	}
}
