package com.wipro.DoConnect.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.DoConnect.entities.Questions;
import com.wipro.DoConnect.status.Status;

import java.util.List;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions,Long> {

    List<Questions> findAllByStatus(Status status);

    Page<Questions> findAllByStatus(Pageable paging, Status status);

    Page<Questions> findAllByTitleContainingAndStatus(String title, Pageable paging, Status status);


}
