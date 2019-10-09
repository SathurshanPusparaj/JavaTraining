package com.dox.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addNewMember() {
		System.out.println(getClass()+": DOING STUFF: ADDING A MEMBERSHIP DAO");
		
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass()+":I'm going to sleep");
	}
}
