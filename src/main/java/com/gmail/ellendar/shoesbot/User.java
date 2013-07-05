package com.gmail.ellendar.shoesbot;

/**
 * Bot user.
 * @author jgill
 *
 */
public class User {
	private String name;
	
	//VERIFY CREDIT ON CONFIRMATION! BEWARE RACE CONDITIONS FOR CONCURRENT BOT CONNECTIONS ON SHARED CREDIT POOLS!
	private int credit;		//In thousandths of a ticket. 
	
	//Transaction history
	//password
}
