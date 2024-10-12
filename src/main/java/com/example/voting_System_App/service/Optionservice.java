package com.example.voting_System_App.service;

import com.example.voting_System_App.entity.Option;
import com.example.voting_System_App.repo.OptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Optionservice {
//    @Autowired
//    private voteRepo voteRepo;
    @Autowired
    private OptionRepo optionRepo;

    public List<Option> getAllOption(){
        return optionRepo.findAll();
    }

    public void createdVote(int optionId){
      Option option=  optionRepo.findById(optionId).orElseThrow();
       option.setVotes(option.getVotes() + 1);

       optionRepo.save(option);
    }
}
