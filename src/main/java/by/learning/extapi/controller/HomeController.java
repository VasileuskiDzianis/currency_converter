package by.learning.extapi.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.learning.extapi.domain.Rate;
import by.learning.extapi.service.RateService;

@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private RateService rateService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// LOGGER.info("Welcome home! The client locale is {}.", locale);

		List<Rate> rateList = rateService.getAllRates();

		model.addAttribute("rateList", rateList);

		return "home";
	}
}
