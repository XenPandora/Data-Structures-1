
public class Monster extends Entity
{
	public Monster(int hp, int atk, int def, int spd, int cash) 
	{
		super(hp, atk, def, spd, cash);
		// TODO Auto-generated constructor stub
	}
	
	public void printStats()
	{
		System.out.println("Monster Stats: \n" +"HP: " +getLife() +" ATK: " +getAttack() +" DEF: " +getDefense() +" SPD: " +getSpeed() +" $: " + getMoney());
	}
}
