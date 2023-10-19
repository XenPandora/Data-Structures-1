
public class Trap extends Event 
{

	public Trap(int number) 
	{
		super(number);
	}

	public void interactHealth(Entity victim)
	{
		victim.setLife(victim.getLife() + getValue());
		System.out.println("You stepped on a trap!");
		System.out.println("Your health gets modified by " +getValue());
	}
	
	public void interactAttack(Entity victim)
	{
		victim.setAttack(victim.getAttack() + getValue());
		System.out.println("You stepped on a trap!");
		System.out.println("Your attack gets modified by " +getValue());
	}
	
	public void interactDefense(Entity victim)
	{
		victim.setDefense(victim.getDefense() + getValue());
		System.out.println("You stepped on a trap!");
		System.out.println("Your defense gets modified by " +getValue());
	}
	
	public void interactSpeed(Entity victim)
	{
		victim.setSpeed(victim.getSpeed() + getValue());
		System.out.println("You stepped on a trap!");
		System.out.println("Your speed gets modified by " +getValue());
	}
	
	public void interactMoney(Entity victim)
	{
		victim.setMoney(victim.getMoney() + getValue());
		System.out.println("You stepped on a trap!");
		System.out.println("Your money gets modified by " +getValue());
	}
}
