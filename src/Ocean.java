

import java.util.Arrays;
import java.util.*;

public class Ocean
{

	private final static int MAP_HEIGTH = 10;
	private final static int MAP_WEIDTH = 10;

	private Ship [][] ships = new Ship [MAP_WEIDTH][MAP_HEIGTH]; //Declaration of ships array
	private String [][] map = new String [MAP_WEIDTH][MAP_HEIGTH];


	private int shotsFired = 0;
	private int hitCount = 0;
	private int shipsSunk = 0;

	/** 
	Array of ships to be added on array of ships;
	**/
	Ship shipsi[] = new Ship[]{
		new Battleship(),
		new Cruiser(),
		new Cruiser(),
		new Destroyer(),
		new Destroyer(),
		new Destroyer(),
		new Submarine(),
		new Submarine(),
		new Submarine(),
		new Submarine()
	};

	





	//CONSTRUCTOR ocean of empty seas
	Ocean()
	{
		for (int n = 0; n < 10; n++)
		{
			for (int b = 0; b < 10; b++)
			{
				ships[n][b] = new EmptySea();
				map[n][b] = " .";
			}
		}
	}







	public String getShipTypeAt(int row, int col)
	{
		
		return ships[row][col].getShipType();
	}

	public boolean hasSunkShipAt(int row, int col)
	{
		// TODO: Implement this method
		return ships[row][col].isSunk();
	}

	public boolean shootAt(int row, int col)
	{

		if (ships[row][col].isSunk() == true && ships[row][col].isRealShip())
		{
			ships[row][col].shootAt(row,col); //Method shootAt in Ship class
			map[row][col] = " X"; //Mark as X location if ship is sunk
			shotsFired++;
			
			return false;

		}
		else if (ships[row][col].isRealShip() == true && ships[row][col].isSunk() == false)
		{
			ships[row][col].shootAt(row,col);
			map[row][col] = " S";
			shotsFired++;
			hitCount++;
			if(ships[row][col].isSunk() == true){
				shipsSunk++;
			}
			
			return true;
		}
		
		map[row][col] = " _";
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
		if (shipsSunk < 10)
		{
			return false;
		}
		else return true;

	}


	/*GRETING RAND NUMBERS
	And cheking free place for a ship
	
	
	*/
	private boolean checkPlace(Ship ship)
	{
		boolean free = false;
		Random rn = new Random();
		
		do{
			
			
			ship.setBowRow(rn.nextInt(9));
			ship.setBowColumn(rn.nextInt(9));
			ship.setHorizontal(rn.nextBoolean());
			int shipLength = ship.getLength();
			int row = ship.getBowRow();
			int col = ship.getBowColumn();
			ship.initHit(shipLength);
			if (ship.isHorizontal() == true)
			{
				for (int i = 0; i < shipLength + 1; i++)
				{ //OPEN FOR 1
				  try{//OPEN TR
					  if (col + shipLength <= 10 &&
					  ships[row]    [col + i - 1].getShipType().equals("Empty sea") && 
					  ships[row + 1][col + i - 1].getShipType().equals("Empty sea") &&	
					  ships[row - 1][col + i - 1].getShipType().equals("Empty sea"))
					{ // Open if
					free = true;
					} else{ free = false; break;}// CLOSE IF
					 }catch(IndexOutOfBoundsException e){  
						 
					 } // CLOSE ERROR
				} //CLOSE FOR 1

			}
			else if (ship.isHorizontal() == false)
			{ //CLOSE IF AND OPEN IF (IF ELSE)

				for (int a = 0; a < shipLength + 1; a++)
				{ //OPEN FOR 1
					try{
						if (row + shipLength <=10 &&
						    ships[row + a - 1][col].getShipType().equals("Empty sea") && 
							ships[row + a - 1][col + 1].getShipType().equals("Empty sea") &&
							ships[row + a - 1][col - 1].getShipType().equals("Empty sea"))
					{ // Open if
							free = true;
					} else{ free = false; break;}// CLOSE IF
						}catch(IndexOutOfBoundsException e){
							
						}
				}//CLOSE FOR 1

			} //CLOSE IF Else
			}while(!free);

		return free;
	}

	private void placeShip(Ship ship)
	{

		


		boolean placed = false;
		
	do	{ // OPEN WHILE
	
			
			boolean chek = checkPlace(ship);
			
		if (chek)
			{ //OPEN IF
			
			int shipLength = ship.getLength();
			int row = ship.getBowRow();
			int col = ship.getBowColumn();
			

				if (ship.isHorizontal() == true && col + shipLength <= 10)
				{ //OPEN IF
					for (int i = col; i < col + shipLength; i++)
					{ //OPEN FOR
						ships[row][i] = ship;
						
				} placed = true;// CLOSE FOR
				} // CLOSE IF
				else if (ship.isHorizontal() == false && row + shipLength <= 10)
				{ // OPEN IF ELSE
					for (int i = row; i < row + shipLength; i++)
					{ // OPEN FOR
						ships[i][col] = ship;
						
				} placed = true;// OPEN FOR

				}//CLOSE IF ELSE
			} // CLOSE IF

	} while(!placed);// CLOSE WHILE

	} // CLOSE METHOD





	public void print()
	{

		int c = 0;

		System.out.println(" 0 1 2 3 4 5 6 7 8 9");
		for (int b = 0; b <= 9; b++)
		{
			for (int i = 0; i <= 9; i++)
			{
				//System.out.print(ships[b][i].getShipSType());
				 if(ships[b][i].isSunk() == true && ships[b][i].isRealShip() == true){
					System.out.print(" X");
			    }else System.out.print(map[b][i]);
				}
			System.out.println(c++);
		}
	}






	public void placeAllShipsRandomly()
	{




		boolean place = false;

		while (!place){
		for (int b = 0; b < shipsi.length; b++)
		{
			placeShip(shipsi[b]);

		}place = true;
		}
	}

}
	
	//      COL1, COL2 COL3 COL4   .....
	//ROW-1  ==   ==   ==    ===   =======
	//ROW 0  ==   SS   SS    ===   =====
	//ROW 1  ==   ==   ==    ===   ======
