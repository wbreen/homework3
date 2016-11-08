/**
 *
 * Copyright: 2016 Jenny Faig & Tyler LaVecchia
 */

package edu.elon.business;

import java.io.Serializable;
import java.text.NumberFormat;
import org.apache.catalina.tribes.util.Arrays;

public class Calculation implements Serializable{
    private double principal;
    private double rate;
    private int years;
    private double [] yearCalcs;
    
    public Calculation() {
        principal = 0;
        rate = 0;
        years = 0;
    }
    
    public Calculation(Double principal, Double rate, Integer years) {
        this.principal = principal;
        this.rate = rate;
        this.years = years;
        this.yearCalcs = new double[years];
    }
    
    @Override
    public String toString() {
        getFutureValue();
        return "Principal is " + principal + ", rate is " + rate + ", years is " + years + ", first future value are " + yearCalcs[0];
    }
    
    public String getPrincipal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(principal);
    }
    
    public void setPrincipal(Double principal) {
        this.principal = principal;
    }
    
    public Double getRate() {
        return rate;
    }
    
    public void setRate(Double rate) {
        this.rate = rate;
    }
    
    public Integer getYears() {
        return years;
    }
    
    public void setYears(Integer years) {
        this.years = years;
    }
    
    public double[] getFutureValue() {
        Double newRate = rate/100;
	for (int i = 0;i < years; i++) {
	  yearCalcs[i] = principal*Math.pow((1+newRate),i+1); 
	}
        return yearCalcs;
    }
}
