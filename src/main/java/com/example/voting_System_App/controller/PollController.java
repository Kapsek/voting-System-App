package com.example.voting_System_App.controller;

import com.example.voting_System_App.entity.Option;
import com.example.voting_System_App.entity.Poll;
import com.example.voting_System_App.entity.PollData;
import com.example.voting_System_App.service.Optionservice;
import com.example.voting_System_App.service.Pollservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PollController {
    @Autowired
    private Pollservice pollservice;
    @Autowired
    private Optionservice optionservice;

    @GetMapping("/")
    public String homePage (Model model){
      model.addAttribute("polls", pollservice.getAllpoll());
      return "index";
    }

    @GetMapping("/poll/{id}")
    public String viewPoll(@PathVariable int id , Model model){
        model.addAttribute("poll", pollservice.getPollById(id));

        return "poll";
    }
    @PostMapping("/poll")
    public String creatPoll(@ModelAttribute PollData pollData){
        Poll poll= new Poll();
        poll.setQuestion(pollData.getQuestion());

        List<Option> optionList = new ArrayList<>();

        for (String optionStr: pollData.getOptions()){
            Option option = new Option();
            option.setDesc(optionStr);
            option.setPoll(poll);

            optionList.add(option);

        }
        poll.setOptionList(optionList);

        pollservice.createPoll(poll);


        return "redirect:/";
    }
    @PostMapping("/vote")
    public String createdVote(int optionId){
       optionservice.createdVote(optionId);

        return "redirect:/";
    }
    @GetMapping("/poll/{id}/results")
    public String pollResults(@PathVariable int id , Model model){
        model.addAttribute("poll", pollservice.getPollById(id));
        return "results";
    }
}
