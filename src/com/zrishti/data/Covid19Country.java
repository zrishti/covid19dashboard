package com.zrishti.data;

import java.sql.*;
import com.zrishti.utils.*;


public class Covid19Country {
	   String cdate;
	   String country;
	   int totalCases;
	   int newCases;
	   int totalDeaths;
	   int newDeaths;
	   int totalRecover;
	   
	   
	   
	   public void getDetailsByDate()
	   {
		   
	   }
	   public String getDate() 
	   {
	   return this.cdate;
	  }

	  
	  public void setDate(String value) {
	     this.cdate = value;
	  }
	   
	   
	    public String getCountry() 
	    {
	    return this.country;
	   }
	 
	   
	   public void setCountry(String value) {
	      this.country = value;
	   }
	 
	   
	   public int getTotalCases() {
	      return this.totalCases;
	   }
	 
	   
	   public void setTotalCases(int tcases) {
	      this.totalCases = tcases;
	   }
	 
	   
	   public int getNewCases() {
	      return this.newCases;
	   }
	 
	   
	   public void setNewCases(int value) {
	      this.newCases = value;
	   }
	 
	   
	   public int getTotalDeaths() {
	      return this.totalDeaths;
	   }
	 
	  
	   public void setTotalDeaths(int value) {
	      this.totalDeaths = value;
	   }
	 
	   
	   public int getNewDeaths() {
	      return this.newDeaths;
	   }
	 
	  
	   public void setNewDeaths(int value) {
	      this.newDeaths = value;
	   }
	 
	   
	   public int getTotalRecover() {
	      return this.totalRecover;
	   }
	 
	   
	   public void setTotalRecover(int value) {
	      this.totalRecover = value;
	   }
	   

	
}
