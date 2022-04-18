import java.text.SimpleDateFormat;
import java.util.TreeSet;

/**
 * A class to simulate the file system of an OS. It extends the TreeSet class to hold the entries in the system.
 * It has the following members:
 * 1. getSize()
 * 2. findById()
 * 3. getFiles()
 * 4. getExecutables()
 * 5. getDirectories()
 * 6. printFormatted()
 *
 * @author Abdul Rafi
 * @version 1.0
 */
public class FileSystem extends TreeSet<FS_Entry> {
    /**
     * Returns the size of the file system but the number of entries in the the TreeSet.
     * @return int size of the file system.
     */
    public int getSize(){ return this.size(); }

    /**
     * Finds the entry in the file system by its ID.
     * @param id int ID associated with an entry.
     * @return FS_Entry object of the entry associated with the given ID.
     */
    public FS_Entry findById(int id){
        FS_Entry result = null; // Initializes the FS_Entry instance result to null.

        // Iterates through the entries in the file system and sets it equal to result if their id matches the given id.
        for(FS_Entry entry : this){
            if(entry.getId() == id){
                result = entry;
            }
        }
        return result; // Returns result.
    }

    /**
     * Returns a new FileSystem object containing all the file entries in the file system.
     * @return FileSystem object with only file entries from the file system.
     */
    public FileSystem getFiles(){
        FileSystem fs = new FileSystem(); // Initializes the FileSystem instance fs to null.

        // Iterates through the entries in the file system and adds them to fs if they're an instance of FS_File.
        for(FS_Entry entry : this){
            if(entry instanceof FS_File){
                fs.add(entry);
            }
        }
        return fs; // Returns fs.
    }

    /**
     * Returns a new FileSystem object containing all the executable entries in the file system.
     * @return FileSystem object with only file entries from the file system.
     */
    public FileSystem getExecutables(){
        FileSystem fs = new FileSystem(); // Initializes the FileSystem instance fs to null.

        // Iterates through the entries in the file system and adds them to fs if they're an instance of FS_Executable.
        for(FS_Entry entry : this){
            if(entry instanceof FS_Executable){
                fs.add(entry);
            }
        }
        return fs; // Returns fs.
    }

    /**
     * Returns a new FileSystem object containing all the directory entries in the file system.
     * @return FileSystem object with only directory entries from the file system.
     */
    public FileSystem getDirectories(){
        FileSystem fs = new FileSystem(); // Initializes the FileSystem instance fs to null.

        // Iterates through the entries in the file system and adds them to fs if they're an instance of FS_Directory.
        for(FS_Entry entry : this){
            if(entry instanceof FS_Directory){
                fs.add(entry);
            }
        }
        return fs; // Returns fs.
    }

    /**
     * Prints all the entries in the file system.
     */
    public void printFormatted(){
        System.out.println("+--------+----------------+---------------+-------------------+--------+-------------------------------------------+---------------------------------------------------------+");
        System.out.printf("| %-6s | %-14s | %-13s | %-17s | %-6s | %-41s | %-55s |%n", "ID", "Name", "Size", "Date Created", "Hidden", "Full Path", "toString"); // Headers for the table columns.
        for(FS_Entry entry : this){
            System.out.println("+--------+----------------+---------------+-------------------+--------+-------------------------------------------+---------------------------------------------------------+");
            String hidden = "No";

            // If the entry is hidden, then String hidden is set to "Yes". Default behaviour is set to "No".
            if(entry.isHidden() == true){
                hidden = "Yes";
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
            String strDate = dateFormat.format(entry.getCreateDate()); // Formats the creation date for the entry in the specified format.
            System.out.printf("| %-,6d | %-14s | %-,13d | %-17s | %-6s | %-41s | %-55s |%n", entry.getId(), entry.getName(), entry.getSize(), strDate, hidden, entry.fullPath(), entry.toString()); // Prints all necessary details about the entry in their respective columns.
        }
        System.out.println("+--------+----------------+---------------+-------------------+--------+-------------------------------------------+---------------------------------------------------------+");
    }
}
