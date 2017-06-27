package by.learning.extapi.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.learning.extapi.service.rate.RateService;

@RestController
public class ConverterController {

	@Autowired
	private RateService rateService;

	@RequestMapping(value = "api/convert/{amount}/{sourceId}/{targetId}", method = RequestMethod.GET)
	public String convert(Model model, 
			@PathVariable int sourceId, 
			@PathVariable int targetId,
			@PathVariable BigDecimal amount) {
		
		return rateService.convert(amount, sourceId, targetId).toString();
	}
}
