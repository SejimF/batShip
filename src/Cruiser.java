public class Cruiser extends Ship
{
	
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
