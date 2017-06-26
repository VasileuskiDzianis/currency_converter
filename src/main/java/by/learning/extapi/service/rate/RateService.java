package by.learning.extapi.service.rate;

import java.math.BigDecimal;
import java.util.List;

import by.learning.extapi.domain.Rate;

public interface RateService {

	List<Rate> getAllRates();
	
	Rate getOneById(int id);
	
	BigDecimal convert(BigDecimal amount, int sourceCurrencyId, int tagetCurrencyId);
}
