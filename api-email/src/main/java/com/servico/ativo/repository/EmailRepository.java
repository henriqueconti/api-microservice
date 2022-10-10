package com.servico.ativo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.servico.ativo.model.EmailModel;


public interface EmailRepository extends MongoRepository<EmailModel, String>{
	
	List<EmailModel> findBySendDateEmail(LocalDate sendDateEmail);
}