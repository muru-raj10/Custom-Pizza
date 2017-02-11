import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Copyright (c) Numerical Method Inc.
 * http://www.numericalmethod.com/
 *
 * THIS SOFTWARE IS LICENSED, NOT SOLD.
 *
 * YOU MAY USE THIS SOFTWARE ONLY AS DESCRIBED IN THE LICENSE.
 * IF YOU ARE NOT AWARE OF AND/OR DO NOT AGREE TO THE TERMS OF THE LICENSE,
 * DO NOT USE THIS SOFTWARE.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITH NO WARRANTY WHATSOEVER,
 * EITHER EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION,
 * ANY WARRANTIES OF ACCURACY, ACCESSIBILITY, COMPLETENESS,
 * FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, NON-INFRINGEMENT,
 * TITLE AND USEFULNESS.
 *
 * IN NO EVENT AND UNDER NO LEGAL THEORY,
 * WHETHER IN ACTION, CONTRACT, NEGLIGENCE, TORT, OR OTHERWISE,
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 * ANY CLAIMS, DAMAGES OR OTHER LIABILITIES,
 * ARISING AS A RESULT OF USING OR OTHER DEALINGS IN THE SOFTWARE.
 */
//package com.numericalmethod.algoquant.pizza;

/**
 * Add to this class or write new classes so that a customer can order and
 * custom make his own pizza.
 *
 * @author haksunli
 */
public class Pizza {
	//elements of a Pizza
    private String dough;
    private String sauce;
    private String cheese;
    private Set<String> Meattopping;
    private Set<String> Vegtopping;
    private String size;
    private Double cost;

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
    	
        this.sauce = sauce;
    }
    
    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
    	
        this.cheese = cheese;
    }

    public Set<String> getMeatTopping() {
        return Meattopping;
    }

    public void setMeatTopping(Set<String> Meattopping) {
        this.Meattopping = Meattopping;
    }
    
    public Set<String> getVegTopping() {
        return Vegtopping;
    }

    public void setVegTopping(Set<String> Vegtopping) {
        this.Vegtopping = Vegtopping;
    }
    
    public String getSize(){
    	return size;
    }
    
    public void setSize(String s){
    	this.size= s;
    }
    
    public double getCost(){
    	return cost;
    }
    
    public void setCost(Double c){
    	this.cost=c;
    }
    //calculates cost of the custom made pizza
    public void CalulateCost(){
    	 //base cost = $3
    	
    	int n = this.getVegTopping().size();
    	int m = this.getMeatTopping().size();
    	Double cost = 3.0 + n*1.5+m*2.5;
    	
    	switch(this.size){
    	case "L":
    		cost *= 1.6;
    		break;
    	case "M":
    		cost *= 1.25;
    		break;
    	default :
    		cost *= 1.0;	
    	}
    	this.setCost(cost);
    }
    
    public static final Scanner sc1 = new Scanner(System.in);
    public static final Scanner sc2 = new Scanner(System.in);
    public static final Scanner sc3 = new Scanner(System.in);
    public static final Scanner sc4 = new Scanner(System.in);
    //allows customer to choose sauce
    public void ChooseSauce(){
    	String Sauce="Tomato";
    	int i = 0;
    	while (i==0){
        	System.out.println("Choose one Sauce. Enter Name");
        	System.out.println("Pesto, Salsa, BBQ, Tomato, Alfredo , Garlic Aioli"); //choices
        	Sauce = sc1.next();
        	System.out.println("Your choice : " + Sauce);
        	System.out.println("Press 1 to confirm, 0 to choose again");
        	i = sc2.nextInt();
        	}  	
    	this.setSauce(Sauce);  	
    }
    //allows customer to choose dough
    public void ChooseDough(){
    	String Dough="Neopolitan-style";
    	int i = 0;
    	while (i==0){
        	System.out.println("Choose one Dough. Enter Name");
        	System.out.println("Neopolitan, New York, Sicilian"); //choices
        	Dough = sc1.next();
        	System.out.println("Your choice : " + Dough + "-style");
        	System.out.println("Press 1 to confirm, 0 to choose again");
        	i = sc2.nextInt();
        	}  	
    	this.setDough(Dough);  	
    }
    //allows customer to choose cheese
    public void ChooseCheese(){
    	String Cheese="Mozerella";
    	int i = 0;
    	while (i==0){
        	System.out.println("Choose one Cheese. Enter Name");
        	System.out.println("Mozerella, Cheddar, Swiss, Parmesan");//choices
        	Cheese = sc1.next();
        	System.out.println("Your choice : " + Cheese);
        	System.out.println("Press 1 to confirm, 0 to choose again");
        	i = sc2.nextInt();
        	}  	
    	this.setCheese(Cheese);  	
    }
    //allows customer to select size
    public void SelectSize(){
    	String Size="S";
    	int i = 0;
    	while (i==0){
        	System.out.println("Select size. Default is S.");
        	System.out.println("S,M,L");
        	Size = sc1.next();
        	System.out.println("Your choice : " + Size);
        	System.out.println("Press 1 to confirm, 0 to choose again");
        	i = sc2.nextInt();
        	}
    	switch(Size){
    	case "L":
    	case "l":
    		this.setSize("L");
    		break;
    	case "M":
    	case "m":
    		this.setSize("M");
    		break;
    	default :
    		this.setSize("S");	
    	}  	
    }
    //allows customer to choose meat toppings. More than one can be chosen
    public void ChooseMeat(){
    	Set<String> meattops= new HashSet<String>();
    	int i = 0;
    	int k =8;	
    	while(i==0){
    	    	System.out.println("Choose one Meat. Enter Name");
    			System.out.println("Sausage, Pepperoni, Grilled Chicken, Beef, Salami ,"
    				+ " Anchovies");
    			String meat = sc1.next();
    			meattops.add(meat);
    			System.out.println("Your choice : " + meat);
    			System.out.println("Press 1 to confirm, 0 to delete");
    			k = sc2.nextInt();
    			if (k==0){
    				meattops.remove(meat);     		
    			}
    			
    			System.out.println("Press 1 to end, 0 to choose more");
    			i = sc3.nextInt();
    			
    			System.out.println("Your choice :" + meattops);
    	}
    	this.setMeatTopping(meattops);  	
    }
    //allows customer to choose veg toppings. More than one can be chosen
    public void ChooseVeg(){
    	Set<String> vegtops= new HashSet<String>();
    	int i = 0;
    	int k =8;	
    	while(i==0){
    	    	System.out.println("Choose one Veg. Enter Name");
    			System.out.println("onions, mushrooms, green pepper, mushroom,  tomatoes ,"
    				+ " Anchovies");
    			String veg = sc1.next();
    			vegtops.add(veg);
    			System.out.println("Your choice : " + veg);
    			System.out.println("Press 1 to confirm, 0 to delete");
    			k = sc2.nextInt();
    			if (k==0){
    				vegtops.remove(veg);     		
    			}
    			
    			System.out.println("Press 1 to end, 0 to choose more");
    			i = sc3.nextInt();
    		
    			System.out.println("Your choice :" + vegtops);
    	}
    	this.setVegTopping(vegtops);  	
    }
    
    public void CustomisePizza(){
    	int i = 0;
    	while(i==0){
        	this.ChooseDough();
        	this.ChooseCheese();
        	this.ChooseMeat();
        	this.ChooseVeg();
        	this.ChooseSauce();
        	this.SelectSize();
        	this.CalulateCost();
        	this.PrintOrder();
        	System.out.println("Press 1 to Confirm, Press 0 to reorder");
        	i = sc1.nextInt();
    	}
    	System.out.println("Thank you for ordering with us!");
    }

    public String toString() {
        return "Dough:" + dough + " style \n MeatTopping:" + Meattopping + "\n Sauce:" + sauce
        		+ "\n VegTopping:" + Vegtopping + "\n Size: " + size + "\n Cost: " + cost
        		+ "\n Cheese: " + cheese;
    }
    
    public void PrintOrder(){
    	System.out.println(toString());
    }

}
