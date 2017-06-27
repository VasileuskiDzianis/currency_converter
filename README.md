# currency_converter
REST-service "Currency converter" uses nbrb.by REST API (http://www.nbrb.by/APIHelp/ExRates) for getting actual currency rates.
Web-UI uses AJAX for getting result. Used technologies: Spring core, Spring MVC, Jackson, JQuery Ajax, JUnit, Mockito.

The main goals of this project is:
- explore what JSON is;
- how to parse JSON;
- explore what REST Web Service is;
- what AJAX is;
- how to send requests with AJAX;
- how to handle responses with AJAX.

There aren't in this project:
- input data validation (browser/server side);
- exception handling in cases such as: nbrb.by unavailable, incorrect currency code etc.
