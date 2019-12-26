package com.adalitek.mph.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int id;
    @Column(name = "EMAIL")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "PASSWORD")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @Column(name = "NAME")
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @Column(name = "LAST_NAME")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    @Column(name = "ACTIVE")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<admin> admins;
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}
	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
		
		
	}
	public void setActive(int Active) {
		// TODO Auto-generated method stub
		this.active=active;
		
	}
	public void setRoles(HashSet<admin> hashSet) {
		// TODO Auto-generated method stub
		
	}
	
}
