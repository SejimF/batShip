

import java.util.Arrays;
import java.lang.reflect.*;
import java.util.*;

public class Ocean
{
	
	private static int MAP_HEIGTH = 10;
	private static int MAP_WEIDTH = 10;
	
	private static int battleShips = 1;
	private static int cruisers = 2;
	private static int destroyers = 3;
	private static int submarines = 4;
	Ship ship;
	Ship [][] ships = new Ship [MAP_WEIDTH][MAP_HEIGTH]; //Declaration of ships array
	String [][] map = new String [MAP_WEIDTH][MAP_HEIGTH];
	
	
	int shotsFired = 0;
	int hitCount = 0;
	int shipsSunk = 0;
	Ship battleship = new Battleship();
	Ship cruiser = new Cruiser();
	Ship destroyer = new Destroyer();
	Ship submarine = new Submarine();
	
	
	
	//CONSTRUCTOR
	Ocean(){
		

		for(int n = 0; n < 10; n++){
			for(int b = 0; b < 10; b++){
				ships[n][b] = new EmptySea();
			}
		}
		
		
			}
	
			
	

	public String getShipTypeAt(int row, int col)
	{
		// TODO: Implement this method
		return ships[row][col].getShipType();
	}

	public boolean hasSunkShipAt(int row, int col)
	{
		// TODO: Implement this method
		return ships[row][col].isSunk();
	}

	public boolean shootAt(int row, int col)
	{
		// TODO: Implement this method
		shotsFired++;
		return false;
	}

	public String getShipsSunk()
	{
		// TODO: Implement this method
		return Integer.toString(shipsSunk);
	}

	public String getHitCount()
	{
		// TODO: Implement this method
		return Integer.toString(hitCount);
	}

	public String getShotsFired()
	{
		// TODO: Implement this method
		return Integer.toString(shotsFired);
	}

	public boolean isGameOver()
	{
		if(shipsSunk < 10){
			return false;
		}else return true;
		
	}
	
	
	

	public void print()
	{
		int c = 0;
		System.out.println("0 1 2 3 4 5 6 7 8 9");
		for(int b = 0; b <= 9; b++){
			for(int i = 0; i <= 9; i++){
				System.out.print(ships[b][i]);
			}
				System.out.println(c++);
		}
		
	}
	
	public void shipPosition(Ship ship){
		this.ship = ship;  
		Random randNum = new Random();
		int ok = 0;  //ok, cheks if ship have bewn placed on the grid
			
		/* 
		Placing ship in the array in random index positions and in random horiontal status
		*/
		do{
			int row = randNum.nextInt(10);     //random row
			int column = randNum.nextInt(10);  //random column
			boolean horizont = randNum.nextBoolean();  //random horizontal pos
			ship.setHorizontal(horizont);  //giving the ship horizontal position
			
			if(ships[row][column].getShipType().equals("Empty sea") && column + ship.getLength() < 10 && ship.isHorizontal() == true){
				// if row and col contains empty sea, and if it have place to placed in the length in that horizontal position
				for(int start = 0; start < ship.getLength(); start++){
					ships[row][column+start] = ship;
					}
			}else if(ships[row][column].getShipType().equals("Empty sea") && row + ship.getLength() < 10 && ship.isHorizontal() == false){
				for(int start = 0; start < ship.getLength(); start++){
					ships[row+start][column] = ship;
				ok++;
				}
			}
		}while(ok < 1);
	}

	public void placeAllShipsRandomly()
	{
		
		for(int shipC = 0; shipC < battleShips; shipC++){
			shipPosition(new Battleship());
			}
			
			for(int shipC = 0; shipC < cruisers; shipC++){
				shipPosition(new Cruiser());
			}
			
		for(int shipC = 0; shipC < destroyers; shipC++){
			shipPosition(new Destroyer());
		}
		
		for(int shipC = 0; shipC < submarines; shipC++){
			shipPosition(new Submarine());
		}
		
		}
		
	}