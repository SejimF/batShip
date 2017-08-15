public class Destroyer extends Ship
{
	private static String shipType = "Destroyer";
	private static int length = 2;
	private String sortName = " D";
	
	String getShipSType()
	{
		// TODO: Implement this method
		return sortName;
	}

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
