import java.util.Date;

/**
 * A class to create executable entry objects in the file system which is a more specific type of FS_File.
 *
 * @author Abdul Rafi
 * @version 1.0
 */
public class FS_Executable extends FS_File {

    /**
     * Constructor for the FS_Executable class.
     * @param size long size of the executable
     * @param id int ID of the executable
     * @param parent FS_Directory of the executable's parent directory
     * @param name String name of the executable
     * @param createDate Date creation date of the executable
     * @param hidden boolean the executable's visibility in the file system
     */
    public FS_Executable( long size, int id, FS_Directory parent, String name, Date createDate, boolean hidden){
        super(size, id, parent, name, createDate, hidden);
    }
}
