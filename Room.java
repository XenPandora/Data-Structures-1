public class Room 
{
	private Monster monster;
	private Event interactable;
	private Room next;
	private Room previous;
	
	public Room()
	{
		monster = null;
		interactable = null;
		next = null;
		previous = null;
	}
	
	public Room(Monster input)
	{
		monster = input;
		interactable = null;
		next = null;
		previous = null;
	}
	
	public Room(Event input)
	{
		monster = null;
		interactable = input;
		next = null;
		previous = null;
	}

	public Monster getMonster() 
	{
		return monster;
	}

	public void setMonster(Monster data) 
	{
		monster = data;
	}
	
	public Event getInteractable()
	{
		return interactable;
	}
	
	public void setInteractable(Event interactable)
	{
		this.interactable = interactable;
	}

	public Room getNext() 
	{
		return next;
	}

	public void setNext(Monster input) 
	{
		next = new Room(input);
	}
	
	public void setNext(Event input)
	{
		next = new Room(input);
	}

	public Room getPrevious() 
	{
		return previous;
	}

	public void setPrevious(Room previous) 
	{
		this.previous = previous;
	}
	
	public String getContents()
	{
		if(this.getMonster() != null)
		{
			return "There is a monster in this room";
		}
		else if(this.getInteractable() != null)
		{
			return "There is an item in this room";
		}
		else
		{
			return "This room is empty";
		}
	}
	
	public boolean hasMonster()
	{
		if(monster != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasItem()
	{
		if(interactable != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
