public class Destroyer extends Ship
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
	
	
	private static String shipType = "Destroyer";
	private static int length = 2;

	Destroyer(){
		super(length);
	}
	
	@Override
	String getShipType()
	{
		// TODO: Implement this method
		return shipType;
	}
	
}
