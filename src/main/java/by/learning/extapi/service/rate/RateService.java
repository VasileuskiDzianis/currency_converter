package by.learning.extapi.service.rate;

import java.math.BigDecimal;

public interface RateService {

	BigDecimal convert(BigDecimal amount, int sourceCurrencyId, int tagetCurrencyId);
}
