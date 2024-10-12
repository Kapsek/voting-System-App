package com.example.voting_System_App.repo;

import com.example.voting_System_App.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepo extends JpaRepository<Poll,Integer> {


}
