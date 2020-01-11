package com.crissantos.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crissantos.helpdesk.api.entity.ChangeStatus;

public interface ChangesStatusRepository extends MongoRepository<ChangeStatus, String> {
	
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangesStatusDesc(String ticketId);
	
}
