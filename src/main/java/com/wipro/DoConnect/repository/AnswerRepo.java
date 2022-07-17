package com.wipro.DoConnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.DoConnect.entities.Answer;
import com.wipro.DoConnect.status.Status;

import java.util.List;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Long> {

    List<Answer> findAllByStatus(Status status);
}
