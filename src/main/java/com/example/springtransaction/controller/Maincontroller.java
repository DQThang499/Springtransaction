package com.example.springtransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springtransaction.DAO.BankAccountDAO;
import com.example.springtransaction.exception.BankTransactionException;
import com.example.springtransaction.form.SendMoneyForm;
import com.example.springtransaction.model.BankAccountInfo;

@Controller
public class Maincontroller {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showBankAccount(Model model) {
		
		List<BankAccountInfo> list = bankAccountDAO.listBankAccountInfo();
		model.addAttribute("accountInfo", list);
		return "accountPage";
	}
	
	@RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
	public String viewSendMoney(Model model) {
		SendMoneyForm sendMoneyForm = new SendMoneyForm(1L, 2L, 100d);
		model.addAttribute("sendMoneyForm", sendMoneyForm);
		return "sendMoneyPage";
	}
	
	@RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
	public String processSendMoney(Model model, SendMoneyForm sendMoneyForm) {
		System.out.println("Send Money: " + sendMoneyForm.getAmount());
		try {
			bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(),
					sendMoneyForm.getToAccountId(),
					sendMoneyForm.getAmount());
			
		} catch (BankTransactionException e){
			model.addAttribute("errorMessage","Error"+ e.getMessage());
			
			return "/sendMoneyPage";
		}
	
		return "redirect:/";
	}
}

