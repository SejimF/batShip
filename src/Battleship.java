public class Battleship extends Ship
{
	
	private static String shipType = "Battleship";
	private static int length = 4;
	private String sortName = " B";
	
	String getShipSType()
	{
		// TODO: Implement this method
		return sortName;
	}
	
	Battleship(){
		super(length);
	}

	
	
	
	
	
	

	@Override
	String getShipType()
	{
		// TODO: Implement this method
		return shipType;
	}
	
}
