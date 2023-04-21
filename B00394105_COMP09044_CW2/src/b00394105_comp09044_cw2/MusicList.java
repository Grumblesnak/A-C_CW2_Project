package b00394105_comp09044_cw2;

import java.util.LinkedList;
import java.util.ListIterator;

public class MusicList {
    LinkedList<Song> songs = new LinkedList<>();
    Integer songCount;
    
    public MusicList(){
        
    }
    
    public void addSong(String title, String artist, String genre, Integer releaseYear, Integer songID, Integer listID){
        Song newSong = new Song(title, artist, genre, releaseYear, songID, listID);
        songs.add(newSong);
    }
    
    public boolean checkSongTitle(String title, Integer listID){
        boolean songExists = false;
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).title.equals(title) && songs.get(i).listID.equals(listID)){
                songExists = true;
            }
        }
        return songExists;
    }
    
    public boolean checkArtist(String artist, Integer listID){
        boolean correctArtist = false;
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                correctArtist = true;
            }
        }
        return correctArtist;
    }
    
    public void deleteSong(String title, String artist, Integer listID){
        for(int i = 0; i< songs.size(); i++){
            if(songs.get(i).title.equals(title) && songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                songs.remove(i);
            }
        }
    }
    
    public void updateSong(String title, String artist, String genre, Integer releaseYear, Integer listID){
        for(int i = 0; i< songs.size(); i++){
            if(songs.get(i).listID.equals(listID)){
                songs.get(i).title = title;
                songs.get(i).artist = artist;
                songs.get(i).genre = genre;
                songs.get(i).releaseYear = releaseYear;
            }
        }
    }
    
    public Integer getCount(){
        songCount = songs.size();
        return songCount;
    }
    
    public void displaySongs(Integer listID){
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                if(songs.get(i).listID.equals(listID)){
                    System.out.println(songs.get(i));
                }
            }
        } else {
            System.out.println("No Songs in Playlist...");
        }
    }
}
