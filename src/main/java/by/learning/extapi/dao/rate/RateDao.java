package by.learning.extapi.dao.rate;

import java.util.List;

import by.learning.extapi.domain.Rate;

public interface RateDao {

	Rate getOneById(int id);

	List<Rate> getAll();
}
