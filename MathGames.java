/*
   CSCI 1100 - Group Project - MathGames
   
   --Group Members--
   Matt Peachey  - B00767172 - Section 2
   James Macphee - B00768516 - Section 1
   Sean O'Neill   - B00767505 - Section 1
   -----------------
   
   This program is our submission for the group project for CSCI1100 Class
   Our program is an interactive math game.
   
   Work began on November 17th 2017 - Work concluded on November 27t 2017
*/

import java.util.Scanner;
import java.util.Random;

public class MathGames2{
   static String[] names = {"Steve","Natalie","Julia","William","Ashley","Connor"};
   static String[] fruits = {"Pear(s)","Apple(s)","Orange(s)","Banana(s)","Tomato(s)"};
   static String name;
   static Random ran = new Random();
   static Scanner kb = new Scanner(System.in);
   static int levscore,score,total,math=1,levelnum,isTrue;
   static boolean lev =true;

   //The MAIN method
   public static void main(String[]args){
      homeMenu();
      ready();
      if(isTrue == 1){
         isTrue =0;
         levscore =0;
         wordOrMulti();
      }
      if(math!=2){
      multi();
      multiWord();
      }
      else if(math == 2){
         multiWord();
      }
     gameFinal();
      System.out.println("END");
      }

   //The home menu method
   public static void homeMenu(){
      System.out.print("Hello and welcome to MathGames!!!\nWhat is your name: ");
      name = kb.nextLine();
      System.out.println("Today I will teach you some basic math skills.");
      System.out.print("please enter what grade you are in (between 1-4): ");
      int grade = kb.nextInt();
      while(grade>4 || grade<1){
            System.out.println("\nYou have entered an invalid grade, please try again");
            System.out.print("please enter what grade you are in (between 1-4): ");
            grade = kb.nextInt();
         }
      if(grade == 1){
         System.out.println("Cool, You're in grade 1!  Your problems will be a bit more difficult!");
      }
      else if(grade == 2){
         System.out.println("Cool, You're in grade 2!  Your problems will be a bit more difficult!");
         levelnum = 1;
      }
      else if(grade == 3){
         levelnum = 2;
         System.out.println("Cool, You're in grade 3!  Your problems will be a bit more difficult!");
      }  
      else if(grade == 4){
         levelnum = 3;
         System.out.println("Cool, You're in grade 4!  Your problems will be a bit more difficult!");
      }
      else{
         while(grade>4 || grade<1){
            System.out.println("\nYou have entered an invalid grade, please try again");
            System.out.print("please enter what grade you are in (between 1-4): ");
            grade = kb.nextInt();
         }
      }
      
   }
   
   //The ready method
   public static void ready(){ 
      System.out.print("\n A math question is going to appear, please enter the answer. Are you ready? (yes or no): ");
      String ready = kb.next(); 
      if(ready.equals("yes")||ready.equals("Yes")||ready.equals("YES")){
         System.out.println();
         basic();
         
      }
      else{
         System.out.print("Please enter 'yes' once you are ready: ");
         ready = kb.next();
         if(ready.equals("yes")){
            System.out.println();
            basic();
         }
         else{
            System.out.print("Please restart the program when you are ready. MathGames out.");
            System.exit(0);
         }
      }
   }
   
   
   //This is the correct answer method
   public static void correct(){
      System.out.println("Awesome! Your answer is correct:)\n");
      levscore++;
      score++;
      total++;
      if(levscore>=5){
         levelup();
         lev=false;
      }
   }
   
   
   
   //This is the incorrect answer method
   public static void incorrect(){
      System.out.println("Uh oh! Your answer is incorrect:(\n");
      total++;
   }
   
   
   
   //This is the level up method
   public static void levelup(){
      System.out.println("Congrats! You leveled up!\n\n");
      
      lev = true;
      isTrue = 1;
      
   }
   
   //This method is called to start each question
   public static void nextq(){
      System.out.println("\nOkay " + name + ", Here is your next question: ");
   }
   
   //This is the method for basic math problems
   public static void basic(){
      lev = true;
      while(lev==true){
         int n1 = (ran.nextInt(9)+1 + levscore);
         int n2 = (ran.nextInt(9)+1);
         if(math==1){
            nextq();
            int sum = n1 + n2;
            System.out.print("What does " + n1 + " + " + n2 + " equal? ");
            int guess = kb.nextInt();
            //This 'if' decides which method to call.
            if(sum == guess){
               correct();
            }
            else{
               incorrect();
            } 
         }
         
         if(math==2){
            nextq();
            int multi = n1*n2;
            System.out.print("What does " + n1 + " * " + n2 + " equal? ");
            int guess = kb.nextInt();
            //'if' statement to judge user answer
            if(multi == guess){
               correct();
            }
            else{
               incorrect();
            }
         }
      }
   }

   
   
   //Choice between word or multiplication to be ran after the first addition set of problems
   public static void wordOrMulti(){
      System.out.print("Would you like to try some word problems or move on to multipication questions? (1 = word, 2 = multiplication): ");
      int decision = kb.nextInt();
      
      if(decision == 1){
         System.out.println("Welcome to word problems");
         math =1;
         word();
      }
      else if(decision == 2){
         System.out.println("welcome to multi");
         math =2;
         lev = true;
         basic();
      }
      else{
         System.out.println("ya fucked up bud");
         System.exit(0);
      }
   
   }
   
   public static void word(){
      
      while(levscore<5){
         int x = ran.nextInt(5);
         int x2 = ran.nextInt(5);
         int num1 = ran.nextInt(9)+1 + levelnum;
         int num2 = ran.nextInt(9)+1 + levelnum;
         int sum = num1+num2;
         if(math == 1){
            nextq();
            if(ran.nextInt(101)%2 == 0){
              
               System.out.print(names[x2] + " has " + num1 + " " + fruits[x] + " and " + num2 + " " + fruits[2] + ".  How many fruits does " + names[x2] + " have in total? ");
               if(kb.nextInt() == sum){
                  correct();
               }
               else{
                  incorrect();
               } 
            }
            
            else{
            
               if(num2>num1){
                  num1 = num2 +2;
               }
              
               System.out.print(names[x2] + " has " + num1 +" "+ fruits[x] + " and gives " + num2 + " of them to " + names[3]+ ".  How many does " + names[x2] + " have left? ");
               if(kb.nextInt()==(num1-num2)){
                  correct();
               }
               else{
                  incorrect();
               }
            }
         }
         
         else{
         multiWord();
         }
      }
   } 
   

   //This method allows the multiplication basic problems to run
   public static void multi(){
      System.out.println("Welcome to Multiplication problems!");
      math = 2;
      levscore =0;
      lev = true;
      ready();
   }
   //This is the method for the word problems regarding multiplication
   public static void multiWord(){
      levscore = 0;
      System.out.println("Great work, time for some word problems! ");
      while(levscore<5){
      int x = ran.nextInt(5);
      int x2 = ran.nextInt(5);
      int num1 = ran.nextInt(9)+1;
      int num2 = ran.nextInt(9)+1;
      int multi = num1*num2;

            if(ran.nextInt(101)%2 == 0){
               System.out.print(names[x2] + " has " + num1 + " " + fruits[x] + " seeds,  if 1 seed produces " + num2 +" "+ fruits[x] + " plants.  How many plants will " + names[x2] + " have? ");
               if(kb.nextInt() == multi){
                  correct();
               }
               else{
                  incorrect();
               }
          }
      }  
   }
   //This method gets called at the end of the game
   public static void gameFinal(){
      System.out.println("Congratulations, You have leveled up beyond my ability.  Thank you for playing today!");
      System.out.println("You got " + score  + " questions correct out of " + total+"!");
      if(score/total ==1){
         System.out.println("WOW! A perfect score! Great JOB! ");
         System.out.println("You must be much smarter than the average elementary student.  Would you like to try a BONUS question? Please say \"yes\" :D");
         String response = kb.next();
         if(response.equals("Yes") || response.equals("YES") || response.equals("yes")){
            bonus();
         }
         else{
            System.out.println("Thats okay,  have a good day!");
            System.exit(0);
         }
      }
   
      System.out.println("Have a great day!");   
   
   }
   
   //Bonus Question
   public static void bonus(){
      System.out.println("HERE COMES THE BONUS QUESTION!!!!!");
      System.out.print("What is the slope of the curve ~ X^2+4X+43 ~  AT X = 0 ?? ");
      if(kb.nextInt() == 4){
         System.out.println("HOLY COW! You are brilliant!  Well Done! ");
         System.out.println("Thanks again for playing, Have a wonderful day");
         System.exit(0);
      }
      else{
         System.out.println("OH NO! Sorry, that isn't right..  Thats okay,  you are only an elementary student after all");
         System.out.println("Thanks again for playing, Have a wonderful day");
         System.exit(0);
      }      
   }
}
  