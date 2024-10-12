package com.example.voting_System_App.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String desc;



    private  int  Votes;


    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;



}
