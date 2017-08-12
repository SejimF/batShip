import java.util.*;
import java.lang.*;

abstract class Ship
{
	private static int bowRow;  //declaration of ship position on row
	private static int bowColumn; // declaration of ship position on column
	private  int length; // declaration how long is ship
	private static boolean horizontal; // if true == position horizontal if != true it's vertical position
	private boolean [] hit  = new boolean[getLength()];  // hit registration
	
	// Constructor
	
	Ship(int length){
		
		this.length = length;
		
		if(isRealShip()){
			for(int i = 0; i < hit.length; i++){
				hit[i] = false;
			}
		}
		
		
		
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
		
		/* 
		if(isRealShip() == false){

		}else if(isHorizontal() == true && isRealShip() == true){
			hit[column - getBowRow()] = true;
		}else if(isHorizontal() == false && isRealShip() == true){
			hit[row - getBowColumn()] = true;
		}
		*/
		return true;
		
	} 
	
	public boolean isRealShip(){

		return true;
	}
	
	
	public boolean isSunk(){
		for(boolean check : hit) if(!check) return true;
		return false;
	}
	
}
