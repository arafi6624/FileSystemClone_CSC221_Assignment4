import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class FS_Entry implements Comparable<FS_Entry> {

    protected int id;
    protected FS_Directory parent;
    protected String name;
    protected Date createDate;
    protected boolean hidden;

    public FS_Entry(int id, FS_Directory parent, String name, Date createDate, boolean hidden) {
        this.id = id;
        this.parent = parent;
        this.name = name;
        this.createDate = createDate;
        this.hidden = hidden;
    }
    public abstract long getSize();

    @Override
    public int compareTo(FS_Entry other) {
        int result = 0;

        if(this != other){
            result = Integer.compare(this.id, other.id);
            if(result == 0){
                result = this.createDate.compareTo(other.createDate);
                if(result == 0)
                    result = this.name.compareTo(other.name);
            }
        }
        return result;
    }

    public String fullPath(){
        if(parent == null){
            return "/" + this.name;
        }
        return parent.fullPath() + "/" + this.name;
    }

    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        String strDate = dateFormat.format(getCreateDate());

        String strHidden = "N";
        if(hidden == true){
            strHidden = "Y";
        }
        return this.id + " " + this.name + " " + strDate + " " + strHidden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FS_Directory getParent() {
        return parent;
    }

    public void setParent(FS_Directory parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
