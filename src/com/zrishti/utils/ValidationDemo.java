package com.zrishti.utils;

import java.util.Scanner;

public class ValidationDemo{
	
	public static boolean isDigit(String s)
	{
		boolean invalid = false;
		//System.out.println(s);
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			//System.out.println(c);
			if(Character.isDigit(c))
			{
				invalid = true;
			}
		}
		return invalid;
		
	}
	
	public static boolean isAlphabet(String s)
	{
		boolean invalid = false;
		//System.out.println(s);
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			//System.out.println(c);
			if(Character.isLetter(c))
			{
				invalid = true;
			}
		}
		return invalid;
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String city;
		String cases;
		Boolean isInvalid;
		do {
		System.out.println("Enter the city");
		city=sc.nextLine();
		isInvalid=isDigit(city);
		
		if(isInvalid==true)
		{
			System.out.println("Invalid entry");
		}
		}while(isInvalid);
		
		
		do {
		System.out.println("Enter the number of cases");		
		cases=sc.nextLine();
		isInvalid=isAlphabet(cases);
		if(isInvalid==true)
		{
			System.out.println("Invalid entry");
		}
		}while(isInvalid);
		
		sc.close();
	}

}
