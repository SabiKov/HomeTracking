package com.sabi11.hometracking.dao;

import com.sabi11.hometracking.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
