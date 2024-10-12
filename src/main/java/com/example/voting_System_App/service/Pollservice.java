package com.example.voting_System_App.service;

import com.example.voting_System_App.entity.Poll;
import com.example.voting_System_App.repo.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Pollservice {
    @Autowired
    private PollRepo pollrepo;


    public List<Poll> getAllpoll() {
        return pollrepo.findAll();
    }

    public Poll getPollById(int id) {
        return pollrepo.findById(id).orElseThrow();
    }

    public void createPoll(Poll poll) {
        pollrepo.save(poll);
    }
}
