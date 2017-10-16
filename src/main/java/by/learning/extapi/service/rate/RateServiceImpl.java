package by.learning.extapi.service.rate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.learning.extapi.domain.Rate;
import by.learning.extapi.service.nbrb.NbrbApi;

@Service
public class RateServiceImpl implements RateService {
	private static final int DIVIDING_SCALE = 4;

	@Autowired
	private NbrbApi nbrbApi;

	@Override
	public BigDecimal convert(BigDecimal amount, int sourceCurrencyId, int tagetCurrencyId) {
		Rate sourceRate = nbrbApi.getRateById(sourceCurrencyId);
		Rate targetRate = nbrbApi.getRateById(tagetCurrencyId);

		BigDecimal result = amount.divide(new BigDecimal(sourceRate.getScale()), DIVIDING_SCALE, RoundingMode.HALF_UP);
		result = result.multiply(sourceRate.getOfficialRate());
		result = result.divide(targetRate.getOfficialRate(), DIVIDING_SCALE, RoundingMode.HALF_UP);
		result = result.multiply(new BigDecimal(targetRate.getScale()));

		return result;
	}
}
