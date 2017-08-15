import java.util.*;
import java.lang.*;

abstract class Ship
{
	private int bowRow;  //declaration of ship position on row
	private int bowColumn; // declaration of ship position on column
	private int length; // declaration how long is ship
	private boolean horizontal; // if true == position horizontal if != true it's vertical position
	private boolean [] hit;  // hit registration

	// Constructor

	abstract String getShipSType();

	Ship(int length)
	{

		this.length = length;





	}

	//METHODS

	int getBowRow()
	{
		return bowRow;
	}
	int getBowColumn()
	{
		return bowColumn;
	}
	boolean isHorizontal()
	{
		return horizontal;
	}
	int getLength()
	{
		return length;
	}



	abstract String getShipType();

	void setBowRow(int row)
	{
		this.bowRow = row;
	}
	void setBowColumn(int column)
	{
		this.bowColumn = column;
	}
	void setHorizontal(boolean horizontal)
	{
		this.horizontal = horizontal;
	}


	public boolean shootAt(int row, int column)
	{


		if (isHorizontal() == true && isRealShip() == true)
		{
			hit[column - getBowColumn()] = true;
		}
		else if (isHorizontal() == false && isRealShip() == true)
		{
			hit[row - getBowRow()] = true;
		}

		return true;

	} 

	public boolean isRealShip()
	{

		return true;
	}


	public boolean isSunk()
	{

		for (int i = 0; i < hit.length; i++)
		{
			if (hit[i] == false)
			{
				return false;
			}

		}

		return true;
	}
	
	/**
	Greating hit array and diclaring for ship length
	**/

	public void initHit(int length)
	{



		if (isRealShip() == true)
		{
			for (int i = 0; i <= length; i++)
			{
				hit = new boolean[i];
			}
		}
	}

}
