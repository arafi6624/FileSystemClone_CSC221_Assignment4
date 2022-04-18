import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A class to create an entry in the file system.
 */
public abstract class FS_Entry implements Comparable<FS_Entry> {

    /**
     * Stores an int id for the entry.
     */
    protected int id;

    /**
     * Stores an FS_Directory directory of the entries parent.
     */
    protected FS_Directory parent;

    /**
     * Stores a String name for the entry.
     */
    protected String name;

    /**
     * Stores the Date createDate for the creation date of the entry.
     */
    protected Date createDate;

    /**
     * Stores the boolean hidden for the entry's visibility.
     */
    protected boolean hidden;

    /**
     * Constructor for the FS_Entry class.
     * @param id int id associated with the entry
     * @param parent FS_Directory parent of the entry
     * @param name String name of the entry
     * @param createDate Date creation date of the entry
     * @param hidden boolean the entry's visibility
     */
    public FS_Entry(int id, FS_Directory parent, String name, Date createDate, boolean hidden) {
        this.id = id;
        this.parent = parent;
        this.name = name;
        this.createDate = createDate;
        this.hidden = hidden;
    }

    /**
     * Abstract method declaration to be implemented in the child class.
     * @return long size of the child class.
     */
    public abstract long getSize();

    /**
     * Compares the object with other FS_Entry objects.
     * @param other FS_Entry object being compare to.
     * @return int value as a result of the comparison.
     */
    @Override
    public int compareTo(FS_Entry other) {
        int result = 0; // Initializes result to equal 0.

        // Checks to see if the passed in object is the same as the calling object, and if not, proceeds to compare them.
        if(this != other){
            result = Integer.compare(this.id, other.id); // Sets result equal to the output of calling the compare() method of Integer and comparing their IDs.

            // Checks to see if result is still equal to 0, which would mean the IDs of the two entries are equal.
            if(result == 0){
                result = this.createDate.compareTo(other.createDate); // Uses the compareTo() method to compare the creation dates of the two entries and sets result equal to it.

                // Checks to see if result is still equal to 0, which would mean the creation dates of the two entries are equal.
                if(result == 0)
                    result = this.name.compareTo(other.name); // Uses the compareTo() method to compare the names of the two entries and sets result equal to it.
            }
        }
        return result; // Returns result.
    }

    /**
     * Returns the path of the entry in the file system.
     * @return String full path of the entry in the file system.
     */
    public String fullPath(){
        // Checks to see if parent is null, and if so, returns the concatenation of "/" and the name of the entry.
        if(parent == null){
            return "/" + this.name;
        }

        return parent.fullPath() + "/" + this.name; // Returns the concatenation of the parent's full path and the entries name.
    }

    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        String strDate = dateFormat.format(getCreateDate()); // Formats the creation date of the entry using specified format.

        String strHidden = "N";
        // Checks to see if hidden is equal to true, and if so, sets strHidden to "Y". Default behavior is set to "N".
        if(hidden == true){
            strHidden = "Y";
        }
        return this.id + " " + this.name + " " + strDate + " " + strHidden; // Returns the concatenation of the entry's id, name, creation date, and visibility.
    }

    /**
     * Gets the ID of the entry.
     * @return int id of the entry.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the entry.
     * @param id int id of the entry.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the parent directory of the entry.
     * @return FS_Directory parent of the entry.
     */
    public FS_Directory getParent() {
        return parent;
    }

    /**
     * Sets the parent directory of the entry.
     * @param parent FS_Directory parent of the entry.
     */
    public void setParent(FS_Directory parent) {
        this.parent = parent;
    }

    /**
     * Gets the name of the entry.
     * @return String name of the entry.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the entry.
     * @param name String name of the entry.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the creation date of the entry.
     * @return Date creation date of the entry.
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Sets the creation date of the entry.
     * @param createDate Date creation date of the entry.
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets the visibility of the entry.
     * @return boolean visibility of the entry.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Sets the visibility of the entry.
     * @param hidden boolean visibility of the entry.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
