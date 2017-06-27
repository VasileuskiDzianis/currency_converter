package by.learning.extapi.service.nbrb;

import java.util.List;

import by.learning.extapi.domain.Rate;

public interface NbrbApi {

	Rate getRateById(int id);

	List<Rate> getAllRates();
}
