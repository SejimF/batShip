public class Destroyer extends Ship
{
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
