public class Battleship extends Ship
{
	
	private static String shipType = "Battleship";
	private static int length = 4;
	
	Battleship(){
		super(length);
	}

	@Override
	boolean shootAt(int row, int column)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	boolean isRealShip()
	{
		// TODO: Implement this method
		return true;
	}

	@Override	boolean isSunk()
	{
		// TODO: Implement this method
		return false;
	}
	
	
	
	
	

	@Override
	String getShipType()
	{
		// TODO: Implement this method
		return shipType;
	}
	
}
