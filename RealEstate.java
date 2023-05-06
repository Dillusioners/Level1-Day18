package Sperms;

// importing required packages
import java.io.*;

// RealEstate -> the class on which the program runs
public class RealEstate {
  // the Buyer is the user of the program
  private static Buyer user;
  // BufferedReader for user input
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  // prints the main menu of the program
  public static void printMenu(){
    System.out.println("\n\nWelcome to Dillusioners Real Estate\n");
    System.out.println("The following are your choices: ");
    System.out.println("1. View All Buyable Land");
    System.out.println("2. Rent Land");
    System.out.println("3. Sell Land");
    System.out.println("4. View Bought Land");
    System.out.println("5. Exit");
    System.out.print(">> ");
  }
  
  // prints all of the buyable land in the real estate market
  public static void printLand(){
    System.out.println("The following lands are avaliable: ");
    System.out.println("1. 3 acres of land in Ohio for $1.6 each sq. feet.");
    System.out.println("2. 100 acres of land in California for $0.54 each sq. feet");
    System.out.println("New lands will arriving soon...");
  }
  
  // method for renting a piece of land
  public static void rentLand(){
    // variable declaration
    int lc, area, cost;
    
    // asking for land code
    System.out.print("Enter the land code: ");
    // try-catch block to ensure user hasn't given string for numbers
    try{
      lc = Integer.parseInt(br.readLine());
    }
    catch(Exception e){
      System.out.println("Couldnot proceed with land code!");
      return;
    }
    
    // checking if the land code is valid
    if(lc < 1 || lc > 2){
      System.out.println("Invalid land code.\nIf you donot know what are land codes then chooce View All Buyable Land in the menu.");
      return;
    }
    
    // asking user for land area to buy
    System.out.print("How much sq. feet land you want to buy?: ");
    // try-catch block to ensure user hasn't given string for numbers
    try{
      area = Integer.parseInt(br.readLine());
    }
    catch(Exception e){
      System.out.println("Couldnot process land area!");
      return;
    }
    
    // based on the landcode, the price of the estate is set
    if(lc == 1) cost = (int)((double)area * 1.6);
    else cost = (int)((double)area * 0.54);
    
    System.out.println("Successfully bought land!");
    // updating the user land area and cost
    user.landArea += area;
    user.landCost += cost;
  }
  
  public static void sellLand(){
    int area;
    
    // asking user for the land area to sell
    System.out.println("How much land you want to sell?: ");
    // try-catch block to ensure user hasn't given string for numbers
    try{
      area = Integer.parseInt(br.readLine());
    }
    catch(Exception e){
      System.out.println("Couldnot process land area");
      return;
    }
    
    // checking if the user has even land to sell, i.e. landArea is more than the sell area
    if(user.landArea < area){
      System.out.println("You cannot sell more land than you own.");
      return;
    }
    
    // succeeding in the transaction
    System.out.println("Successfully sold " + area + " square feet of land at $0.2");
    // updating the user data
    user.landArea -= area;
    user.landCost = (int)(area * 0.2);
  }
  
  // program execution starts from here
  public static void main(String args[]){
    // variable declaration and initialization
    user = new Buyer();
    int choice;
    boolean running = true;
    
    // looping until the user chooses exit
    while(running){
      printMenu();
      
      // try-catch block to ensure user hasn't given string for numbers
      try{
          choice = Integer.parseInt(br.readLine());
      }
      catch (Exception e){
        System.out.println("Unable to detect your input.");
        continue;
      }
      
      // running a switch-case ladder for user input
      switch (choice){
        // runs if user wants to exit
        case 5:
          System.out.println("Thanks for checking out the real estate program.");
          running = false;
          break;
          
        // runs when user wants to see all buyable land
        case 1:
          printLand();
          break;
          
        // runs when user wants to rent land
        case 2:
          rentLand();
          break;
          
        // runs when user wants to sell land
        case 3:
          sellLand();
          break;
          
        // prints the user's bought land and the land value
        case 4:
          System.out.println("Land owned: " + user.landArea + " square feet");
          System.out.println("Total Land Revenue: $" + user.landCost);
          break;
          
        // runs when invalid integer is provided
        default:
          System.out.println("Invalid Integer provided in menu.");
      }
    } 
  }
}

// Buyer class to store user data
class Buyer{
  // landArea -> total land owned
  // landCost -> total value of the lands owned
  public int landArea, landCost;
  
  // initializing the variables
  Buyer(){
    landArea = 0;
    landCost = 0;
  }
}
