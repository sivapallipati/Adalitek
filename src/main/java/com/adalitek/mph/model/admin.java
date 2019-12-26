package com.adalitek.mph.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin")
public class admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Admin_ID")
    private int id;
    @Column(name = "Admin")
    private String admin;

}

