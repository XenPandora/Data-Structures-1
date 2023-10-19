
public class Floor 
{
	private Room head;
	
	public Floor()
	{
		head = null;
	}
	
	public Floor(Monster input)
	{
		head = new Room(input);
	}
	
	public Floor(Event input)
	{
		head = new Room(input);
	}
	
	public void addRoom(Monster info)
	{
		if(head == null)
		{
			head = new Room(info);
		}
		else
		{
			Room temp = head;
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			temp.setNext(info);
		}
	}
	
	public void addRoom(Event info)
	{
		if(head == null)
		{
			head = new Room(info);
		}
		else
		{
			Room temp = head;
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			temp.setNext(info);
		}
	}
	
	public Room getHead()
	{
		return head;
	}
	
}
