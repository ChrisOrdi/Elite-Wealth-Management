package com.ordina.ewm.elitewealthmanagement.repository;


import com.ordina.ewm.elitewealthmanagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EwmRepository  extends JpaRepository<Client, Long> {
}
