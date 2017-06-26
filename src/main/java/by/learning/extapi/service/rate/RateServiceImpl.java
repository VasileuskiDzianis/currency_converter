package by.learning.extapi.service.rate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.learning.extapi.domain.Rate;
import by.learning.extapi.service.nbrb.NbrbApi;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
	private NbrbApi nbrbApi;

	@Override
	public BigDecimal convert(BigDecimal amount, int sourceCurrencyId, int tagetCurrencyId) {
		BigDecimal result;

		Rate sourceRate = nbrbApi.getOneById(sourceCurrencyId);
		Rate targetRate = nbrbApi.getOneById(tagetCurrencyId);

		result = amount.divide(new BigDecimal(sourceRate.getScale()), 4, RoundingMode.HALF_UP);
		result = result.multiply(sourceRate.getOfficialRate());
		result = result.divide(targetRate.getOfficialRate(), 4, RoundingMode.HALF_UP);
		result = result.multiply(new BigDecimal(targetRate.getScale()));

		return result;
	}
}
