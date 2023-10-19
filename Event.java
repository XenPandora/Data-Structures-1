
public class Event implements Interactable
{
	private int value; 
	
	public Event(int number)
	{
		value = number;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void interactHealth(Entity victim)
	{
		victim.setLife(victim.getLife() + value);
		System.out.println("Your health gets modified by " +value);
	}
	
	public void interactAttack(Entity victim)
	{
		victim.setAttack(victim.getAttack() + value);
		System.out.println("Your attack gets modified by " +value);
	}
	
	public void interactDefense(Entity victim)
	{
		victim.setDefense(victim.getDefense() + value);
		System.out.println("Your defense gets modified by " +value);
	}
	
	public void interactSpeed(Entity victim)
	{
		victim.setSpeed(victim.getSpeed() + value);
		System.out.println("Your speed gets modified by " +value);
	}
	
	public void interactMoney(Entity victim)
	{
		victim.setMoney(victim.getMoney() + value);
		System.out.println("Your money gets modified by " +value);
	}
}
