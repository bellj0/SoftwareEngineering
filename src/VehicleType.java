public enum VehicleType 
{
	STANDARD_CRUISER, 
	FIRE_TRUCK, 
	AMBULANCE, 
	BOMB_SQUAD, 
	SUV, 
	SWAT_TEAM,
	K9,
	RIOT_TEAM;

	@Override
	public String toString() 
	{
		String name = super.toString();
		String newName = "";

		if (name.contains("_")) 
		{
			for (char c : name.toCharArray()) 
			{
				if (c == '_')
					newName += " ";
				else
					newName += c;
			}
			return newName;
		}
		return name;
	}

}
