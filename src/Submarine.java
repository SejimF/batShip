public class Submarine extends Ship
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
	
	
	private String ShipType= "Submarine";
	private static int length = 1;
	
	Submarine(){
		super(length);
	}

	@Override
	String getShipType()
	{
		// TODO: Implement this method
		return ShipType;
	}
}
