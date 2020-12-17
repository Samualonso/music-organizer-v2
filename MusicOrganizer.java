import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    public void listAllFiles(){
        int index = 0;
        int posicion = 0;
        while (index < files.size()){
            posicion += 1;
            String filename = files.get(index);
            System.out.println(posicion + ". " + filename);
            index++;
        }
    }
    
    public void listMatching(String searchString){
        boolean artistFound = false;
        for (String filename : files) {
            if (filename.contains(searchString)) {
                System.out.println(filename);
                artistFound = true;
            }
        }
        if (artistFound == false) {
            System.out.println("No hay ningún archivo que contenga esa palabra)");
        }
    }
    
    public void playSamplesArtist(String searchString){
        for (String filename : files) {
            if (filename.contains(searchString)) {
                player.playSample(filename);
            }
        }
    }
    
    public int findFirst(String searchString) {
        int index = 0;
        boolean found = false;
        int tamaño = files.size();
        while (index < tamaño) {
            String filename = files.get(index);
            if (filename.contains(searchString)) {
                found = true;
            }
            index++;
        }
        
        if (!found) {
            index = -1;
        }
        
        return index;
    }
}
