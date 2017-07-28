public class EmptySea extends Ship
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
		return false;
	}

	@Override
	boolean isSunk()
	{
		// TODO: Implement this method
		return false;
	}
	
	private String shipType = "Empty sea";
	private static int length = 1;
	
	EmptySea(){
		super(length);
	}

	@Override
	String getShipType()
	{
		return shipType;
	}
	
	
}
