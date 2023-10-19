
public class Hero extends Entity
{
	private int level;
	private int experience;
	
	public Hero(int hp, int atk, int def, int spd, int cash) {
		super(hp, atk, def, spd, cash);
		level = 1;
		experience = 0;
		// TODO Auto-generated constructor stub
	}
	
	public void loot(Entity victim)
	{
		experience = experience + 1;
		this.setMoney(this.getMoney() + victim.getMoney());
		doILevelUp();
	}
	
	public int getExperience()
	{
		return experience;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void printStats()
	{
		System.out.println("Hero Stats: \n" +"HP: " +getLife() +" ATK: " +getAttack() +" DEF: " +getDefense() +" SPD: " +getSpeed() +" $: " + getMoney());
	}
	//Helper method to check if hero levels up
	private void doILevelUp()
	{
		if(experience == 5) 
		{
			System.out.println("Level Up!");
			level++;
			this.setLife(this.getLife() +2);
			this.setAttack(this.getAttack() +2);
			this.setDefense(this.getDefense() +1);
			this.setSpeed(this.getSpeed()+1);
		}
	}
}
