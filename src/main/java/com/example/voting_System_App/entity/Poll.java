package com.example.voting_System_App.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String question;

    @OneToMany(mappedBy = "poll", cascade= CascadeType.ALL)
     private List<Option> optionList;
}
