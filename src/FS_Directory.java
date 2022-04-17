import java.util.Date;

public class FS_Directory extends FS_Entry {

    private int childCount;

    public FS_Directory(int childCount, int id, FS_Directory parent, String name, Date createDate, boolean hidden) {
        super(id, parent, name, createDate, hidden);
        this.childCount = childCount;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.childCount;
    }

    public int compareTo(FS_Directory other){
        int result = 0;

        if(this != other){
            result = Integer.compare(this.id, other.id);
            if(result == 0){
                result = this.createDate.compareTo(other.createDate);
                if (result == 0){
                    result = this.name.compareTo(other.name);
                    if (result == 0)
                        result = Integer.compare(this.childCount, other.childCount);
                }
            }
        }

        return result;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }
}
