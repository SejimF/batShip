

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

	Ship [] ShipOne = new Ship[]{
		new Battleship(),
	};





	//CONSTRUCTOR
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

		if (ships[row][col].isSunk() == true && ships[row][col].isRealShip())
		{
			map[row][col] = " X";
			shotsFired++;
			return true;

		}
		else if (ships[row][col].isRealShip() == true)
		{

			shotsFired++;
			hitCount++;
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


	//GRETING RAND NUMBERS



	private boolean checkPlace(Ship ship1, int row, int col, boolean orientation)
	{

		boolean free = false;

			if (orientation == true)
			{
				for (int i = 0; i < ship1.getLength(); i++)
				{ //OPEN FOR 1

					if (ships[row]    [col + i].equals("Empty sea") && 
						ships[row + 1][col + i].equals("Empty sea") &&
						ships[row - 1][col + i].equals("Empty sea"))
					{ // Open if
						free = true;
					}// CLOSE IF

				} //CLOSE FOR 1

			}
			else if (orientation == false)
			{ //CLOSE IF AND OPEN IF (IF ELSE)

				for (int a = 0; a < ship1.getLength(); a++)
				{ //OPEN FOR 1

					if (ships[row + a][col].equals("Empty sea") && 
						ships[row + a][col + 1].equals("Empty sea") &&
						ships[row + a][col - 1].equals("Empty sea"))
					{ // Open if
						free = true;
					}// CLOSE IF

				} //CLOSE FOR 1

			}  //CLOSE IF 

		return free;
	}

	private void placeShip(Ship ship)
	{

		Random rn = new Random();


		boolean placed = false;
		do
		{ // OPEN WHILE
			ship.setBowRow(rn.nextInt(9));
			ship.setBowColumn(rn.nextInt(9));
			ship.setHorizontal(rn.nextBoolean());
			if (checkPlace(ship, ship.getBowRow(), ship.getBowColumn(), ship.isHorizontal()) == true)
			{ //OPEN IF

				if (ship.isHorizontal())
				{ //OPEN IF
					for (int i = ship.getBowColumn(); i < ship.getLength(); i++)
					{ //OPEN FOR
						ships[ship.getBowRow()][i] = ship;
						placed = true;
					} // CLOSE FOR
				} // CLOSE IF
				else if (ship.isHorizontal() == false)
				{ // OPEN IF ELSE
					for (int i = ship.getBowRow(); i < ship.getLength(); i++)
					{ // OPEN FOR
						ships[i][ship.getBowColumn()] = ship;
						placed = true;
					} // OPEN FOR

				}//CLOSE IF ELSE
			} // CLOSE IF

		} while(placed == false);// CLOSE WHILE

	} // CLOSE METHOD





	public void print()
	{

		int c = 0;

		System.out.println(" 0 1 2 3 4 5 6 7 8 9");
		for (int b = 0; b <= 9; b++)
		{
			for (int i = 0; i <= 9; i++)
			{
				System.out.print(ships[b][i]);
			}
			System.out.println(c++);
		}
	}






	public void placeAllShipsRandomly()
	{




		boolean place = false;

		//while (!place){
		for (int b = 0; b < shipsi.length; b++)
		{
			placeShip(shipsi[b]);

		}place = true;
		//}
	}

}
	
	//      COL1, COL2 COL3 COL4   .....
	//ROW-1  ==   ==   ==    ===   =======
	//ROW 0  ==   SS   SS    ===   =====
	//ROW 1  ==   ==   ==    ===   ======
