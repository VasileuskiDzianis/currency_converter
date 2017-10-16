package by.learning.extapi.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.learning.extapi.domain.Rate;
import by.learning.extapi.service.nbrb.NbrbApi;

@Controller
public class HomeController {
	private static final String HOME_PAGE = "home";
	private static final String RATE_LIST_MODEL = "rateList";

	@Autowired
	private NbrbApi nbrbApi;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Rate> rateList = nbrbApi.getAllRates();

		model.addAttribute(RATE_LIST_MODEL, rateList);

		return HOME_PAGE;
	}
}
