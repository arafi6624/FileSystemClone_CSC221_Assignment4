import com.sun.source.tree.Tree;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.TreeSet;

public class FileSystem extends TreeSet<FS_Entry> {
    public int getSize(){
        return this.size();
    }

    public FS_Entry findById(int id){
        FS_Entry result = null;
        for(FS_Entry entry : this){
            if(entry.getId() == id){
                result = entry;
            }
        }
        return result;
    }

    public FileSystem getFiles(){
        FileSystem fs = new FileSystem();
        for(FS_Entry entry : this){
            if(entry instanceof FS_Entry){
                fs.add(entry);
            }
        }
        return fs;
    }

    public FileSystem getExecutables(){
        FileSystem fs = new FileSystem();
        for(FS_Entry entry : this){
            if(entry instanceof FS_Executable){
                fs.add(entry);
            }
        }
        return fs;
    }

    public FileSystem getDirectories(){
        FileSystem fs = new FileSystem();
        for(FS_Entry entry : this){
            if(entry instanceof FS_Directory){
                fs.add(entry);
            }
        }
        return fs;
    }

    public void printFormatted(){
        System.out.println("+--------+----------------+---------------+-------------------+--------+-------------------------------------------+---------------------------------------------------------+");
        System.out.printf("| %-6s | %-14s | %-13s | %-17s | %-6s | %-41s | %-55s |%n", "ID", "Name", "Size", "Date Created", "Hidden", "Full Path", "toString");
        for(FS_Entry entry : this){
            System.out.println("+--------+----------------+---------------+-------------------+--------+-------------------------------------------+---------------------------------------------------------+");
            String hidden = "No";
            if(entry.isHidden() == true){
                hidden = "Yes";
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
            String strDate = dateFormat.format(entry.getCreateDate());
            System.out.printf("| %-,6d | %-14s | %-,13d | %-17s | %-6s | %-41s | %-55s |%n", entry.getId(), entry.getName(), entry.getSize(), strDate, hidden, entry.fullPath(), entry.toString());
        }
        System.out.println("+--------+----------------+---------------+-------------------+--------+-------------------------------------------+---------------------------------------------------------+");
    }
}
