import java.util.Date;

public class FS_Executable extends FS_File {
    public FS_Executable( long size, int id, FS_Directory parent, String name, Date createDate, boolean hidden){
        super(size, id, parent, name, createDate, hidden);
    }
}
