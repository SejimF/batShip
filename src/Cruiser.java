public class Cruiser extends Ship
{
	
	private static String shipType = "Cruiser";
	private static int length = 3;
	String sortName = " C";
	
	String getShipSType()
	{
		// TODO: Implement this method
		return sortName;
	}

	
	
	
	
	
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
