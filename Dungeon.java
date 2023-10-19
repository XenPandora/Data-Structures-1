import java.util.Random;
import java.util.Scanner;

public class Dungeon 
{
	private Floor currentLevel;
	private Room currentRoom;
	private Hero hero;
	
	public Dungeon() 
	{
		hero = new Hero(10, 4, 5, 5, 0);
	}
	
	public void generateFloor()
	{
		Random rand = new Random();
		int rooms = rand.nextInt(2, 6);
		Floor level = new Floor();
		for(int x = 0; x < rooms; x++)
		{
			int thing = rand.nextInt(5);
			if(thing == 0 || thing == 1)
			{
				level.addRoom(generateMonster());
			}
			else if(thing == 2)
			{
				level.addRoom(generateBuffedMonster());
			}
			else if(thing == 3)
			{
				level.addRoom(generateItem());
			}
			else if(thing == 4)
			{
				level.addRoom(generateTrap());
			}
		}
		currentLevel = level;
		currentRoom = currentLevel.getHead();
	}
	
	public String getRoomContents()
	{
		return currentRoom.getContents();
	}
	
	private Monster generateMonster()
	{
		Random rand = new Random();
		Monster monster = new Monster(rand.nextInt(1, 10), rand.nextInt(1, 10), rand.nextInt(1, 10), rand.nextInt(1, 10), rand.nextInt(1, 10));
		return monster;
	}
	
	private Monster generateBuffedMonster()
	{
		Random rand = new Random();
		Monster monster = new Monster(rand.nextInt(10, 50), rand.nextInt(10, 50), rand.nextInt(10, 50), rand.nextInt(10, 20), rand.nextInt(10, 50));
		return monster;
	}
	
	private Item generateItem()
	{
		Random rand = new Random();
		int stat = rand.nextInt(1, 10);
		Item item = new Item(stat);
		return item;
	}
	
	private Trap generateTrap()
	{
		Random rand = new Random();
		int stat = rand.nextInt(-10, 0);
		Trap trap = new Trap(stat);
		return trap;
	}
	
	//this is the actual game
	public void runGame()
	{
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("I am sorry, but yout fate has been sealed in this dungeon.");
		System.out.println("You must fight until you die");
		while(hero.getLife() > 0)
		{
			generateFloor();
			while(currentRoom.getNext() != null)
			{
				System.out.println(currentRoom.getContents());
				if(currentRoom.hasMonster())
				{
					Monster enemy = currentRoom.getMonster();
					if(enemy.getLife() > 10 || enemy.getAttack() > 10 || enemy.getDefense() > 10 || enemy.getSpeed() > 10|| enemy.getMoney() >10)
					{
						System.out.println("You sense a strong presence");
					}
					System.out.println("Would you like to fight this monster?");
					String response = scan.next();
					if(response.equalsIgnoreCase("Yes"))
					{
						while(enemy.getLife() > 0 && hero.getLife() > 0)
							{
								if(hero.getSpeed() >= enemy.getSpeed())
								{
									System.out.println("You attack the monster!");
									hero.attack(enemy);
									enemy.printStats();
									if(enemy.getLife() <= 0)
									{
										break;
									}
									System.out.println("The monster attacks you!");
									enemy.attack(hero);
									hero.printStats();
								}
								else
								{
									System.out.println("The monster attacks you!");
									enemy.attack(hero);
									hero.printStats();
									if(hero.getLife() <= 0)
									{
										break;
									}
									System.out.println("You attack the monster!");
									hero.attack(enemy);
									enemy.printStats();
								}
							}
						if(enemy.getLife() <= 0 && hero.getLife() > 0)
						{
							System.out.println("You have defeated the monster and move on to the next room");
							hero.loot(enemy);
							hero.printStats();
						}
						if(hero.getLife() <= 0)
						{
							System.out.println("You are dead");
							break;
						}
					}
					else
					{
						if(enemy.getLife() > 10 || enemy.getAttack() > 10 || enemy.getDefense() > 10 || enemy.getSpeed() > 10|| enemy.getMoney() >10)
						{
							System.out.println("The enemy respects your smart choice and leaves you alone");
						}
						else
						{
							System.out.println("You run away, but the monster gets a free attack on you");
							enemy.attack(hero);
							hero.printStats();
							if(hero.getLife() <= 0)
							{
								System.out.println("You are dead");
								break;
							}
						}
					}
					currentRoom = currentRoom.getNext();
				}
				else if(currentRoom.hasItem())
				{
					Event event = currentRoom.getInteractable();
					System.out.println("Would you like to interact with this object?");
					String response = scan.next();
					if(response.equalsIgnoreCase("Yes"))
					{
						int num = rand.nextInt(5);
						if(num == 0)
						{
							event.interactAttack(hero);
							hero.printStats();
						}
						else if(num == 1)
						{
							event.interactDefense(hero);
							hero.printStats();
						}
						else if(num == 2)
						{
							event.interactSpeed(hero);
							hero.printStats();
						}
						else if(num == 3)
						{
							event.interactMoney(hero);
							hero.printStats();
						}
						else
						{
							event.interactHealth(hero);
							hero.printStats();
							if(hero.getLife() <= 0)
							{
								System.out.println("You are dead");
								break;
							}
						}
					}
					else
					{
						System.out.println("You move on to the next room");
					}
					currentRoom = currentRoom.getNext();
				}
				else
				{
					System.out.println("Ethan, you did something incorrectly, this is not supposed to happen");
				}
			}
			if(currentRoom.getNext() == null)
			{
				System.out.println("You have completed a floor");
				System.out.println("You move onto the next floor");
			}
		}
	}
	
}

