public class EmptySea extends Ship
{

	String sortName = " ~";
	
	String getShipSType()
	{
		// TODO: Implement this method
		return sortName;
	}
	
	@Override
	public boolean shootAt(int row, int column)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean isRealShip()
	{
		return false;
	}

	@Override
	public boolean isSunk()
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
