
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows 10
 */
public class Album {

    private String name, artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    
    public boolean addSong(String title, double duration){
        if(findSong(title)==null){
            this.songs.add(new Song(title, duration));
            return false;
        }else{
            System.out.println("This song is already in this album");
            return true;  
        }
    }
    
    public Song findSong(String title){
        for(int i=0;i<this.songs.size();i++){
            if(this.songs.get(i).getTitle().equals(title)){
                return songs.get(i);
            }
        }
        return null;
    }
    
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        if(trackNumber<=0||trackNumber>this.songs.size()){
            System.out.println("Song of track number "+trackNumber+" does not exist");
            return false;
        }
        playlist.add(this.songs.get(trackNumber-1));
        return true;
    }
    
    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song song = findSong(title);
        if(song==null){
            System.out.println(title+" does not exist in this album");
            return false;
        }else{
            playlist.add(song);
            return true;
        }
    }
}
