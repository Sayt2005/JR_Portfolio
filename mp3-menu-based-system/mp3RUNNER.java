import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class mp3RUNNER {

	public static void main(String[] args) {
		
		//SETUP
		
		//ArrayList <Song> songList = new ArrayList<>();
		ArrayList <playList> listOfplayList = new ArrayList <playList>();
		ArrayList <Song> playListsong = new ArrayList<Song>();
		playList listOne = null;
		playList songList = new playList ("Main SongList");
		Song songOne = null;
		
		int choice1 = -1;
		int choice2 = -1;
		int choice3 = -1;
		int index = -1;
		int index2 = -1;
		int sort = -1;
		String Name, Artist;
		Scanner scan = new Scanner(System.in);
		
		//WELCOME MESSAGE
		System.out.println("Welcome to MP3 Player");
		
		
		//MENU LOOP
		while (choice1 != 4)
		{
			
			//MENU PRINT OPTIONS
			System.out.println("\n\n--+---\t\tMenu\t\t---+---");
			System.out.println("\n1.\tSongs\n2.\tPlayList\n3.\tSort\n4.\tExit");
			choice1 = scan.nextInt();
			
			//MENU OPTION CODE (SONG 1 PLAYLIST 2 SORT 3 EXIT 4)
			switch (choice1) 
			{
			case 1: //MANAGE SONGS, ADD 1 REMOVE 2 VIEW 3 EXIT 0
					System.out.println("\n\n\n");
					System.out.println("Songs\t---");
					
					//LOOP UNTIL EXIT SONG SECTION
					while (choice2 != 0)
					{
						
						//SONG MANAGE OPTIONS
						System.out.println("\n1.\tAdd\n2.\tRemove\n3.\tView\n0.\tExit");
						choice2 = scan.nextInt();
						
						//SONG MENU SWITCH CASE; ADD 1 REMOVE 2 VIEW 3 EXIT 0
						switch (choice2)
						{
						
						case 0: //EXIT
							
							break;
						
						case 1: //ADD
							
							
							//TAKE IN SONG INFO
							System.out.println("\n\nEnter Song Name:");
							scan.nextLine();
							Name = scan.nextLine();
							System.out.println("Enter Artist Name:");
							Artist = scan.nextLine();
							System.out.println("Enter Duration in Seconds: ");
							
							
							//ADD TO MASTER LIST
							songOne = new Song (Name, Artist, scan.nextInt());
							songList.getSongList().add(songOne);
							
							//PRINT TO USER
							if (!songList.getSongList().isEmpty())
							{
								System.out.println("\n\nSong List\t---");
								for (int i = 0; i < songList.getSongList().size(); i ++)
								{
									System.out.println((i+1) +".\t " + songList.getSongList().get(i).toString());
								}	
							}
							
							break;
							
							
						case 2: //REMOVE
							
							//IF THERE IS A LIST TO REMOVE
							if (!songList.getSongList().isEmpty()) 
							{
								//PRINT MASTER LIST
								System.out.println("Which Song To Remove?\n");
								System.out.println("\nSong List\t---");
								
		
								for (int i = 0; i < songList.getSongList().size(); i ++)
								{
									System.out.println((i+1) +". " + songList.getSongList().get(i).toString());
								}
								
								
								
								index = scan.nextInt();
								
								//REMOVES USER INPUT - 1 TO GET PROPER INDEX`
								System.out.println("\n" + songList.getSongList().get(index-1).toString() + " was removed!");
								songList.getSongList().remove(index-1);
								
							}
							
							//LIST IS EMPTY
							else
							{
								System.out.println("No Songs To Remove\t\n\n");
							}
							break;
						
							
						case 3://VIEW 
							
							//THE LIST IS NOT EMPTY, PRINT OUT MASTER LIST
							if (!songList.getSongList().isEmpty())
							{
								System.out.println("\n\nSong List\t---");
								for (int i = 0; i < songList.getSongList().size(); i ++)
								{
									System.out.println((i+1) +".\t " + songList.getSongList().get(i).toString());
								}	
							}
							
							
							//LIST IS EMPTY
							else
							{
								System.out.println("The List is Empty");
							}
							break;
						
							
						default: //CHOSE AN INVALID OPTIONS
							System.out.println("That is not an option.");
							break;
							
						}
					}
					
					
					choice2 = -1;
					
					break;
					
					
			case 2: //PLAYLIST ADD 1 REMOVE	2 MANAGE PLAYLIST 3 VIEW 4 EXIT 0
				
				
				System.out.println("\n\n\n");
				System.out.println("Playlist\t---");
				
				
				while (choice2 != 0)
				{
					
					//PlayList Menu Options
					System.out.println("\n1.\tAdd\n2.\tRemove\n3.\tManage Playlist \n4.\tView\n0.\tEXIT");
					choice2 = scan.nextInt();
					
					
					//MENU
					switch(choice2)
					{
					
					
					case 1: //ADD PLAYLIST
						
						//GET PLAYLIST INFORMATION
						System.out.println("\n\nEnter PlayList Name:");
						scan.nextLine();
						Name = scan.nextLine();
						
						//ADD IT TO LIST
						listOne = new playList(Name);
						listOfplayList.add(listOne);
						
						break;
					
					case 2: //REMOVE PLAYLIST
						
						//IF PLAYLIST LIST IS NOT EMPTY
						if (!listOfplayList.isEmpty()) 
						{
							//PRINT OUT PLAYLISTS
							System.out.println("Which playlist To Remove?\n");
							System.out.println("\nPlayLists\t---");
							
				
							for (int i = 0; i < listOfplayList.size(); i ++)
							{
								System.out.println((i+1) + ". " + listOfplayList.get(i).toString());
							}
							
							//ASK USER INPUT
							index = scan.nextInt();
							System.out.println("\n" + listOfplayList.get(index-1).toString()+ " was removed!");
							listOfplayList.remove(index-1);
							
						}
						
						//PLAYLIST IS EMPTY
						else
						{
							System.out.println("No Playlist To Remove\t\n\n");
						}
						
						break;
					
					case 3: //MANGAE PLAYLIST, ADD 1 REMOVE 2 EXIT 3
						
						//IF PLAYLIST LIST IS NOT EMPTY
						if (!listOfplayList.isEmpty())
						{
							
							//USER INPUT, WHICH PLAYLIST TO MANAGE
							System.out.println("Which playlist do you want to manage?\n\n");
							for (int i = 0; i < listOfplayList.size(); i ++)
							{
								System.out.println((i+1) + ". " + listOfplayList.get(i).toString());
							}
							
							index = scan.nextInt();
							playListsong = listOfplayList.get(index-1).getSongList();
							
							
							//LOOP INSIDE PLAYLIST, MANAGE PLAYLIST SECTION
							while (choice3 != 0)
							{
								
							
								System.out.println("\n\n1.\tADD?\n2.\tREMOVE\n0.\tEXIT");
								choice3 = scan.nextInt();
								
								//MANAGE PLAYLIST MENU 
								switch (choice3)
								{
								
								
								case 1://ADD SONG TO PLAYLIST
									if(!songList.getSongList().isEmpty())
									{
										System.out.println("\n\nWhich song do you want to add?");
					
									
									//PRINT OUT SONG LIST
									if (!songList.getSongList().isEmpty())
									{
										System.out.println("\n\nSong List\t---");
										for (int i = 0; i < songList.getSongList().size(); i ++)
										{
											System.out.println((i+1) + ". " + songList.getSongList().get(i).toString());
										}
									}
									
									//ADDS SONG
									index2 = scan.nextInt();
									playListsong.add(songList.getSongList().get(index2-1));
									
									break;
									}
									
									//MASTER LIST IS EMPTY
									else
									{
										System.out.println("There are no songs to add.");
										break;
									}
									
									
									
								case 2: //REMOVE SONG FROM PLAYLIST
									
									//IF SONG LIST IS NOT EMPTY
									if (!playListsong.isEmpty()) 
									{
										//USER INPUT
										System.out.println("Which Song To Remove?\n");
										System.out.println("\n"+ listOfplayList.get(index-1).getName() + "\t---");
										
										
										for (int i = 0; i < playListsong.size(); i ++)
										{
											System.out.println((i+1) +". " + playListsong.get(i).toString());
										}
										
										//REMOVES SONG FROM PLAYLIST
										index2 = scan.nextInt();
										System.out.println("\n" + playListsong.get(index2-1).toString() + " was removed!");
										playListsong.remove(index2-1);
										
									}
									
									//PLAYLIST IS EMPTY
									else
									{
										System.out.println("No Songs To Remove\t\n\n");
									}
									
									break;
								
								case 0:
									break;
								}
								
								
		
							}
							
							choice3 = -1;
							
							//UPDATES PLAYLIST DURATION 
							listOfplayList.get(index-1).updateDuration();
							
							
						}
						
						//NO PLAYLIST TO MANAGE
						else 
						{
							System.out.println("No playlist to manage");
						}
						break;
				
						
					case 4: //VIEW PLAYLIST
						if (!listOfplayList.isEmpty())
						{
							
							//PRINTS OUT ALL PLAYLIST
							System.out.println("Which playlist do you want to see?\n\n");
							
							for (int i = 0; i < listOfplayList.size(); i++ )
							{
								System.out.println((i+1) +". " + listOfplayList.get(i).toString());
							}
							
							
							index = scan.nextInt();
							
							playListsong = listOfplayList.get(index-1).getSongList();
							
							
							//PRINTS OUT ALL SONGS IN PLAYLIST
							System.out.println("\n"+ listOfplayList.get(index-1).getName() + "\t---");
							
							for (int i = 0; i < playListsong.size(); i++ )
							{
								System.out.println((i+1) +". " + playListsong.get(i).toString());
							}
						}
						
						//NO PLAYLIST
						else
						{
							System.out.println("There are no playlist to view.");
						}
						
				
					}
				}
				choice2 = -1;
				break;
	
			case 3: //SORT, NAME ASCENDING 1 NAME DESCENDING 2 ID ASCENDING 3 ID DESCENDING 4
				
					System.out.println("What do you want to sort?\n1.\tSong List\n2.\tPlayLists");
					choice2 = scan.nextInt();
					
					//MENU
					switch (choice2)
					{
					
					//PLAYLIST SORT
					case 1:
						if(!listOfplayList.isEmpty())
						{
							System.out.println("Which playlist do you want to manage?\n\n");
							for (int i = 0; i < listOfplayList.size(); i ++)
							{
								System.out.println((i+1) + ". " + listOfplayList.get(i).toString());
							}
							
							index = scan.nextInt();
							playListsong = listOfplayList.get(index-1).getSongList();
							
							System.out.println("How do you want to sort?");
							System.out.println("1.\tName (Ascending)");
							System.out.println("2.\tName (Descending)");
							System.out.println("3.\tID (Ascending)");
							System.out.println("4.\tID (Descending)");
							
							choice3 = scan.nextInt();
							
							switch(choice3)
							{
							case 1: //NAME ASCENDING
								Collections.sort(listOfplayList.get(index-1).getSongList(), Song.byName);
								break;
								
							case 2: //NAME DESCENDING
								Collections.sort(listOfplayList.get(index-1).getSongList(), Song.byNameReverse);
								break;
								
							case 3: //ID ASCENDING
								Collections.sort(listOfplayList.get(index-1).getSongList(), Song.byID);
								break;
								
							case 4: //ID DESCENDING
								Collections.sort(listOfplayList.get(index-1).getSongList(), Song.byIDreverse);
								break;
			
							}
							
								
							
		
						}
						
						//NO PLAYLIST
						else
						{
							System.out.println("No Playlist!\n\n\n");
						}
						
						//MASTER LIST SORT
					case 2:
						System.out.println("How do you want to sort?");
						System.out.println("1.\tName (Ascending)");
						System.out.println("2.\tName (Descending)");
						System.out.println("3.\tID (Ascending)");
						System.out.println("4.\tID (Descending)");
						
						choice3 = scan.nextInt();
						
						switch(choice3)
						{
						case 1://NAME ASCENDING
							Collections.sort(songList.getSongList(), Song.byName);
							break;
							
						case 2://NAME DESCENDING
							Collections.sort(songList.getSongList(), Song.byNameReverse);
							break;
							
						case 3://ID ASCENDING
							Collections.sort(songList.getSongList(), Song.byID);
							break;
							
						case 4://ID DESCENDING
							Collections.sort(songList.getSongList(), Song.byIDreverse);
							break;
		
						}
					}
					
						
					break;
			case 4: 
					break;
			default:
				System.out.println("That option does not exist.");
			}
			
		}
		
		//EXIT MESSAGE
		System.out.println("\n\n--+---\t\tMP3 OFF\t\t---+---");
		scan.close();
			
			
			
			

	}

}

