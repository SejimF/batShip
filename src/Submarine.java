public class Submarine extends Ship
{
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
