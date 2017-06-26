package by.learning.extapi.service.rate;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

	@Override
	public Rate getOneById(int id) {

		return rateDao.getOneById(id);
	}

	@Override
	public BigDecimal convert(BigDecimal amount, int sourceCurrencyId, int tagetCurrencyId) {
		BigDecimal result;

		Rate sourceRate = rateDao.getOneById(sourceCurrencyId);
		Rate targetRate = rateDao.getOneById(tagetCurrencyId);

		result = amount.divide(new BigDecimal(sourceRate.getScale()), 4, RoundingMode.HALF_UP);
		result = result.multiply(sourceRate.getOfficialRate());
		result = result.divide(targetRate.getOfficialRate(), 4, RoundingMode.HALF_UP);
		result = result.multiply(new BigDecimal(targetRate.getScale()));

		return result;
	}
}
