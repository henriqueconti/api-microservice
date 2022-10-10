package com.servico.ativo.controller;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servico.ativo.dto.EmailDto;
import com.servico.ativo.model.EmailModel;
import com.servico.ativo.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/send-email")
	public ResponseEntity<EmailModel> sendEmail(@RequestBody EmailDto model){
		EmailModel email = modelMapper.map(model, EmailModel.class);
		emailService.sendEmail(email);
		
		return new ResponseEntity<EmailModel>(email, HttpStatus.OK);
	}
	
	@GetMapping("/email")
	public ResponseEntity<List<EmailModel>> getEmail(){
		List<EmailModel> emailList = emailService.getEmail();
		
		return new ResponseEntity<List<EmailModel>>(emailList, HttpStatus.OK);
	}
	
	@GetMapping("/email/{data}")
	public ResponseEntity<List<EmailModel>> getEmail(@PathVariable(value = "data")String data){
		LocalDate dataLocalDate = LocalDate.parse(data);
		List<EmailModel> emailList = emailService.getEmailByData(dataLocalDate);
		
		return new ResponseEntity<List<EmailModel>>(emailList, HttpStatus.OK);
	}
}
