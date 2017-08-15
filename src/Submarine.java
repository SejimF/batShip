public class Submarine extends Ship
{
	private String ShipType= "Submarine";
	private String sortName = " S";
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
	String getShipSType()
	{
		// TODO: Implement this method
		return sortName;
	}
	
}
