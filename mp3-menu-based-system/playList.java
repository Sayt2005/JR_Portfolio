import java.util.ArrayList;

public class playList {
	private String name;
	private int duration;
	private int id;
	private static int playlistAmount;
	private ArrayList<Song> SongList;
	
	
	public playList (String name)
	{
		this.name = name;
		this.duration = 0;
		this.playlistAmount += 1;
		this.id = playlistAmount;
		this.SongList = new ArrayList<Song>();
	}
	
	public void updateDuration () {
		if (!SongList.isEmpty())
		{
			duration = 0;
			for (int i = 0; i < SongList.size(); i++)
			{
				duration += SongList.get(i).getDuration();
			}
		}
	}
	
	public String getName (){
		return name;
	}
	
	public int getDuration (){
		return duration;
	}
	
	public int getID (){
		return id;
	}
	
	public int getAmount () {
		return playlistAmount;
	}
	
	public ArrayList<Song> getSongList ()
	{
		return this.SongList;
	}
	
	

	public String toString () {
		
		if (duration % 60 > 9)
		return (this.name +  " (" + duration/60 + ":" + duration % 60 + ")");
		
		return (this.name +  " (" + duration/60 + ":0" + duration % 60 + ")");
		
	}


}

