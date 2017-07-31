import java.util.*;

abstract class Ship
{
	int bowRow;  //declaration of ship position on row
	int bowColumn; // declaration of ship position on column
	int length; // declaration how long is ship
	boolean horizontal; // if true == position horizontal if != true it's vertical position
	boolean[] hit = new boolean[length];  // hit registration
	
	// Constructor
	
	Ship(int length){
		this.length = length;
	}
	
	//METHODS
	
	int getBowRow(){
		return bowRow;
	}
	int getBowColumn(){
		return bowColumn;
	}
	boolean isHorizontal(){
		return horizontal;
	}
	int getLength(){
		return length;
	}
	
	abstract String getShipType();
	
	void setBowRow(int row){
		this.bowRow = row;
	}
	void setBowColumn(int column){
		this.bowColumn = column;
	}
	void setHorizontal(boolean horizontal){
		this.horizontal = horizontal;
	}
	public boolean shootAt(int row, int column){
		
		
		return true;
	}
	public boolean isRealShip(){
		return true;
	}
	public boolean isSunk(){
		
		return false;
	}
	
}
