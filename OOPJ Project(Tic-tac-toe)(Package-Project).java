package project;
import java.util.*;
import project1.*;

/*class Gameboard
{
	String[] board; //instance variable
	String turn;
	Gameboard()    //default constructor 
	{
		board = null;
	}
	Gameboard(String[] board)  //parameterized constructor
	{
		this.board=board;   //usage of this keyword
    }
	void displayboard( String[] board)    //member function
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}
	
	  String checkWinner(String[] board,String turn)
		 {
		 	for (int a = 0; a < 8; a++) 
		 	{
		 		String line = null;
		 		
		 		switch (a) 
		 		{
		 		case 0:
		 			line = board[0] + board[1] + board[2];
		 			break;
		 		case 1:
		 			line = board[3] + board[4] + board[5];
		 			break;
		 		case 2:
		 			line = board[6] + board[7] + board[8];
		 			break;
		 		case 3:
		 			line = board[0] + board[3] + board[6];
		 			break;
		 		case 4:
		 			line = board[1] + board[4] + board[7];
		 			break;
		 		case 5:
		 			line = board[2] + board[5] + board[8];
		 			break;
		 		case 6:
		 			line = board[0] + board[4] + board[8];
		 			break;
		 		case 7:
		 			line = board[2] + board[4] + board[6];
		 			break;
		 		}
		 		//For X winner
		 		if (line.equals("XXX")) 
		 		{
		 			return "X";
		 		}
		 		
		 		// For O winner
		 		else if (line.equals("OOO"))
		 		{
		 			return "O";
		 		}
		 	}
		 	
		 	for (int a = 0; a < 9; a++) 
		 	{
		 		if (Arrays.asList(board).contains(String.valueOf(a + 1))) 
		 		{
		 			break;
		 		}
		 		else if (a == 8) 
		 		{
		 			return "draw";
		 		}
		 	}
		 	
		 	
		 	// To enter the X Or O at the exact place on board.
		 	System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		 	return null;
		 }
		  void show() //method overide
	  {
		  System.out.println("Do you wanna play the exciting game of Tic-Tac-Toe");
	  }
}*/


class Player1 extends Gameboard //subclass Player1 of superclass gameboard
{
	String winner1 = null;
	Player1()
  {
		super();  //calling superclass constructor
  }  
	Player1(String[] board)
	{
		super(board);
		this.board=board;
	}
	Player1(Player1 a)
	{
		this.board=a.board;
	}
  void displayplayer1( String name1)
  {
   displayboard(board);
   winner1=checkWinner(board,turn);
  }
  public void show()
  {
	  System.out.println("Player1 won the match");
  }
}


class Player2 extends Gameboard //subclass Player2 of superclass gameboard
{
	String winner2=null;
	 void displayplayer2()
	   {
	    displayboard(board);
	   winner2=checkWinner(board,turn);
	   }
void display() // method overloading
{
	System.out.println("\nPlayer2 won the match");
}
void display(String O)     //method overloading by passing parameters
{
	System.out.println("Symbol "+O+" is used to replace the slot numbers when its player2 turn" );
	System.out.println();
}
}

interface show    //defining interface called show
{             //method declaration without body
	void display();     //interface defines what to do not how to to do
}
class welcome implements show      //welcome class implements interface show & any no of class can implement an interface
{
	public void display() //method which implements interface must be declared as public
	{
		
		System.out.println("\t\t\t\t\t\tWELCOME TO TIC-TAC-TOE\n");
		System.out.println("\t\t\tPlay the classic tic-tac-toe game(also called Noughts and Crosses).\n");
	}
	
}
class mynewthread implements Runnable           //implementing  runnable class called mynewthread 
{
	Thread t;      //instance variable t
	String threadname;
	mynewthread(String m)    //mynewthread constructor
	{
		threadname=m;
		t=new Thread(this,threadname);   //creating thread object-
		t.start();   //start the thread t
	}
	public void run()   //entry point for child thread -execution of run method
	{
		
		
		try
		{
			
			{
			System.out.println("RULES OF TIC-TAC-TOE.\n");
			System.out.println("* The game is played on a grid that's 3 squares by 3 squares.");
			System.out.println("* You are X, your friend (or the computer in this case) is O. Players take turns putting their marks in empty squares.");
			System.out.println("* The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.");
			System.out.println("* When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.\n");
			t.sleep(1000);
			}
			
		}
		catch(InterruptedException e)
		{
			System.out.println("Thread interrupted.");
		}
	}
}

 
public class Tictactoe 
{
	static String[] board;
   static String turn;
   
   

	public static void main(String[] args)
	{
		show obj = new welcome(); 
		obj.display();
		new mynewthread("more");
		Scanner c = new Scanner(System.in);
		Gameboard ob1 = new Gameboard(); //creating objects
		//Player1 ob2 = new Player1();
		Player2 ob3 = new Player2();
		
		
	        board = new String[9];
	        turn="X";
	        String winner=null;
	        
	        for (int a = 0; a < 9; a++) 
	        {
	            board[a] = String.valueOf(a + 1);
	        }
	     
	        ob1.displayboard(board);
	        System.out.println("X will play first. Enter a slot number to place X in:");
		  
		        while (winner == null) 
		        {
	            int numInput;
	            
	              try 
	              {
	                numInput = c.nextInt();
		                if (!(numInput > 0 && numInput <= 9)) //string handling
		                {
		                	System.out.println("Invalid input; re-enter slot number:");
		                	continue;
		                }
		            }
		            catch (InputMismatchException e)//catching an exception
	               {
	                System.out.println("Invalid input; re-enter slot number:");
	                continue;
		            }
		              
		            // This game has two player x and O.
		            // Here is the logic to decide the turn.
	            if (board[numInput - 1].equals(String.valueOf(numInput))) 
	            {
	            	 board[numInput - 1] = turn;
		                
		  
		                if (turn.equals("X")) 
		                {
		                    turn = "O";
		                }
		                else 
		                {
		                    turn = "X";
		                }
		  
		                ob1.displayboard(board);
		                winner = ob1.checkWinner(board,turn);
		        }
	            else 
	            {
	            	System.out.println("Slot already taken; re-enter slot number:");
	            }
		    }
	            if(winner.equals("X"))
	            {
	            	Player1 d=new Player1(board);
	            	Player1 e=new Player1(d);
	            	e.show();//Method overiding
	            	//System.out.println("Player1 won the match");
	            	e.displayboard(board); 
	            }
	            else if(winner.equals("O"))
	            {
	            	//System.out.println("Player2 won the match");
	            	ob3.display();
	            	ob3.display("O");
	            	ob3.displayboard(board);
	            }
	            // If no one win or lose from both player x and O.
		        // then here is the logic to print "draw".
	        if (winner.equalsIgnoreCase("draw")) 
	        {
	            System.out.println("It's a draw! Thanks for playing.");
	        }	        
		        // For winner to display Congratulations! message.
		        else 
		        {
		            System.out.println("Congratulations! " + winner+ "'s have won! Thanks for playing.\n\n");
		        }
	        System.out.println("Submitted by:");
	        System.out.println("Nishank.A");
	        System.out.println("4NI19IS057");     
		 }
}



