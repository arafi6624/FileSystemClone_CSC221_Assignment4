import java.util.Date;

/**
 * A class to create data entry objects in the file system which is a more specific type of FS_File.
 *
 * @author Abdul Rafi
 * @version 1.0
 */
public class FS_Data extends FS_File {
    /**
     * Constructor for the FS_Data class.
     * @param size long size of the file
     * @param id int ID of the file
     * @param parent FS_Directory of the file's parent directory
     * @param name String name of the file
     * @param createDate Date creation date of the file
     * @param hidden boolean the file's visibility in the file system
     */
    public FS_Data(long size, int id, FS_Directory parent, String name, Date createDate, boolean hidden){
        super(size, id, parent, name, createDate, hidden); // Constructs an internal instance of type FS_File with the specified parameters.
    }
}
