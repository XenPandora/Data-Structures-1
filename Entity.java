
public class Entity 
{

	private int life;
	private int attack;
	private int defense;
	private int speed;
	private int money;
	
	public Entity(int hp, int atk, int def, int spd, int cash)
	{
		life = hp;
		attack = atk;
		defense = def;
		speed = spd;
		money = cash;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void printStats()
	{
		System.out.println("HP: " +life +" ATK: " +attack +" DEF: " +defense +" SPD: " +speed +" $: " + money);
	}
	
	//methods that interact with the world
	public void attack(Entity victim)
	{
		victim.setLife(victim.getLife() - attack);
	}
}
