public class Cruiser extends Ship
{

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
		return false;
	}

	@Override
	boolean isSunk()
	{
		// TODO: Implement this method
		return false;
	}
	
	
	private static String shipType = "Cruiser";
	private static int length = 3;
	
	Cruiser(){
		super(length);
	}

	@Override
	String getShipType()
	{
		// TODO: Implement this method
		return shipType;
	}
	
}
