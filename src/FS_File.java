import java.util.Date;

public abstract class FS_File extends FS_Entry {

    protected long size;

    public FS_File(long size, int id, FS_Directory parent, String name, Date createDate, boolean hidden){
        super(id, parent, name, createDate, hidden);
        this.size = size;
    }

    @Override
    public String toString(){
        String numString = String.format("%,d", this.size);
        return super.toString() + " " + numString;
    }

    public int compareTo(FS_File other){
        int result = 0;

        if(this != other){
            result = Integer.compare(this.id, other.id);
            if(result == 0){
                result = this.createDate.compareTo(other.createDate);
                if(result == 0){
                    result = this.name.compareTo(other.name);
                    if(result == 0){
                        result = Long.compare(this.size, other.size);
                    }
                }
            }
        }

        return result;
    }

    public long getSize(){
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
