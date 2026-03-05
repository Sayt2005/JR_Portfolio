import java.util.Comparator;

public class Song {
	private String name;
	private String artist;
	private int duration;
	private int id;
	private static int songAmount;
	
	
	public Song (String name, String artist, int duration)
	{
		this.name = name;
		this.artist = artist;
		this.duration = duration;
		songAmount += 1;
		id = songAmount;
	}
	
	
	public String getName (){
		return name;
	}
	
	public String getArtist (){
		return artist;
	}
	
	public int getDuration (){
		return duration;
	}
	
	public int getID (){
		return id;
	}
	
	public int getAmount () {
		return songAmount;
	}
	
	public String toString () {
		
		if (duration % 60 > 9)
		return (this.name + " by " + this.artist + " (" + duration/60 + ":" + duration % 60 + ")");
		
		return (this.name + " by " + this.artist + " (" + duration/60 + ":0" + duration % 60 + ")");
		
	}
	
	public static final Comparator<Song> byName = new Comparator<Song> ()
	{
		public int compare (Song a, Song b)
		{
			return (a.getName().toLowerCase().compareTo(b.getName().toLowerCase()));
		}
	};
	
	public static final Comparator<Song> byNameReverse = new Comparator<Song> ()
	{
		public int compare (Song a, Song b)
		{
			return (b.getName().toLowerCase().compareTo(a.getName().toLowerCase()));
		}
	};
	
	
	public static final Comparator<Song> byID = new Comparator<Song> ()
	{
		public int compare (Song a, Song b)
		{
			if (a.getID() - b.getID() > 0)
			{
				return 1;
			}
			
			else if (a.getID() - b.getID() < 0)
			{
				return -1;
			}
			
			return 0;
		}
	};
	
	public static final Comparator<Song> byIDreverse = new Comparator<Song> ()
	{
		public int compare (Song a, Song b)
		{
			if (b.getID() - a.getID() > 0)
			{
				return 1;
			}
			
			else if (b.getID() - a.getID() < 0)
			{
				return -1;
			}
			
			return 0;
		}
	};
}


