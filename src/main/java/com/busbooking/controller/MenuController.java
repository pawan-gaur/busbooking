package com.busbooking.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.busbooking.Service.AgentRegistrationService;
import com.busbooking.Service.BusDealerService;
import com.busbooking.Service.BusHireService;
import com.busbooking.Service.SignUpService;
import com.busbooking.Service.TicketBookService;
import com.busbooking.Service.WriteUsService;
import com.busbooking.model.AgentRegistration;
import com.busbooking.model.BusHire;
import com.busbooking.model.BusSearch;
import com.busbooking.model.SignUp;
import com.busbooking.model.TicketBook;
import com.busbooking.model.WriteUs;

@Controller
public class MenuController {

	@Autowired
	private AgentRegistrationService agentRegistrationService;

	@Autowired
	private BusHireService busHireService;

	@Autowired
	private WriteUsService writeUsService;

	@Autowired
	private SignUpService signUpService;
	
	@Autowired
	private BusDealerService busDealerService;
	
	@Autowired
	TicketBookService ticketBookService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute BusSearch busSearch) {
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@ModelAttribute BusSearch busSearch) {
		return "index";
	}

	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	public String hotels() {
		return "hotels";
	}

	@RequestMapping(value = "/bushire", method = RequestMethod.GET)
	public String bushire() {
		return "bushire";
	}
	
	@RequestMapping(value = "/busSearch", method = RequestMethod.POST)
	public String busSearch(@Valid @ModelAttribute("busSearch") BusSearch busSearch, BindingResult result, ModelMap map) {
		map.addAttribute("busDealer", busDealerService.findAll());
		map.addAttribute("busSearch", busSearch);
		return "busSearch";
	}	

	@RequestMapping(value = "/saveBusHire", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> saveBusHire(@RequestBody BusHire busHire) {
		busHireService.save(busHire);
		return new ResponseEntity<Object>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/agentRegistration", method = RequestMethod.GET)
	public String agent() {
		return "agent";
	}

	@RequestMapping(value = "/saveAgentDetails", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> saveAgent(@RequestBody AgentRegistration agentRegistration) {
		agentRegistrationService.save(agentRegistration);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/printTicket", method = RequestMethod.GET)
	public String printTicket() {
		return "printTicket";
	}
	
	@RequestMapping(value = "/ticketCancellation", method = RequestMethod.GET)
	public String ticketCancellation() {
		return "ticketCancellation";
	}

	@RequestMapping(value = "/saveWriteUs", method = RequestMethod.POST)
	public ResponseEntity<Object> saveWriteUs(@RequestBody WriteUs writeUs) {
		writeUsService.save(writeUs);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/saveSignup", method = RequestMethod.POST, consumes = {
			"application/x-www-form-urlencoded" })
	public String saveSignUp(@ModelAttribute SignUp signUp) {
		signUpService.save(signUp);
		return "index";
	}
	
	@RequestMapping(value = "/ticketBook", method = RequestMethod.POST)
	public ResponseEntity<Object> ticketBook(@RequestBody TicketBook ticketBook) {
		ticketBook.setBookingdate(new Date());
		ticketBookService.save(ticketBook);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
