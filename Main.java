
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows 10
 */
public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
    
        Album album = new Album("Fake album name", "Johnny Cash");
        album.addSong("Hey Jude", 3.52);
        album.addSong("Bye Jude", 3.52);
        album.addSong("Farewell", 1.52);
        album.addSong("Good morning", 2.52);
        album.addSong("Good evening", 5.52);
        albums.add(album);
        album = new Album("Second coming of Fake Album Name", "Diego Pedro");
        album.addSong("That fake song", 3.5);
        album.addSong("That fake song again", 3.45);
        album.addSong("Again, fake song", .5);
        album.addSong("Sorry, it's fake again", 3.5);
        album.addSong("Fakey fakey", 3.55);
        albums.add(album);
        
        LinkedList <Song> playlist = new LinkedList<Song>();
        play(playlist);
        albums.get(0).addToPlaylist("non-existent", playlist);  //test that the song won't add since it doesn't exist
        albums.get(0).addToPlaylist("Hey Jude", playlist);
        albums.get(0).addToPlaylist(4, playlist);
        albums.get(0).addToPlaylist("Farewell", playlist);
        albums.get(0).addToPlaylist(6, playlist);   //test the song won't add since track 6 doesn't exist
        albums.get(1).addToPlaylist(1, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(5, playlist);
        albums.get(1).addToPlaylist(50, playlist);  //there is no track 50
        play(playlist);
        
    }
    private static void play(LinkedList<Song> playlist){
        
        
        ListIterator<Song> li = playlist.listIterator();
        if(playlist.isEmpty()){
            System.out.println("Playlist has no songs");
            return;
        }else{
            System.out.println(li.next().toString()+" is currently playing");
        }
        printOption();
        int choice=scanner.nextInt();
        scanner.nextLine();
        boolean goingForward=true;
        while(choice!=7){
            switch(choice){
                case 1: choice=1;
                    if(li.hasNext()){
                        if(goingForward==false){
                        li.next();
                        goingForward=true;
                        }
                        System.out.println(li.next().toString()+" is currently playing");
                    }else{
                        System.out.println("You've reached the end of the playlist");
                    }
                    break;
                case 2: choice=2;
                    if(li.hasPrevious()){
                        if(goingForward==true){
                        li.previous();
                        goingForward=false;
                        }
                        System.out.println(li.previous().toString()+" is currently playing");
                    }else{
                        System.out.println("There is no song before the current song in the playlist");
                    }
                    break;
                case 3: choice=3;
                    if(goingForward==true){
                        System.out.println(li.previous().toString()+" is currently playing");
                        goingForward=false;
                    }else{
                        System.out.println(li.next().toString()+" is currently playing");
                        goingForward=true;
                    }
                    break;
                case 4: choice=4;
                    for(int i=0;i<playlist.size();i++){
                        System.out.println((i+1)+": "+playlist.get(i).toString());
                    }
                    break;
                case 5: choice=5;
                    printOption();
                    break;
                case 6: choice=6;
                    if(playlist.size()>0){
                        li.remove();
                        if(li.hasNext()){
                            System.out.println("Now playing"+li.next().toString());
                        }else{
                            System.out.println("Now playing"+li.previous().toString());
                        }
                    }else{
                        System.out.println("The playlist is empty!");
                        choice=7;
                    }
                    
                    
            }
            choice=scanner.nextInt();
            scanner.nextLine();
            
            
        }
        System.out.println("Closing the playlist, goodbye");
    }
    private static void printOption(){
        System.out.println("Select from below options");
        System.out.println("Option 1: next song");
        System.out.println("Option 2: previous song");
        System.out.println("Option 3: replay");
        System.out.println("Option 4: List songs in the playlist");
        System.out.println("Option 5: print available actions");
        System.out.println("Option 6: delete current song from playlist");
        System.out.println("Option 7: quit");   
    }
    
}
