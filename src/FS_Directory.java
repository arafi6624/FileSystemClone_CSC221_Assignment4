import java.util.Date;

/**
 * A class to create directory entry objects in the file system.
 * It has the following members:
 * 1. childCount
 * 2. getSize()
 * 3. toString()
 * 4. getChildCount()
 * 5. setChildCount()
 *
 * @author Abdul Rafi
 * @version 1.0
 */
public class FS_Directory extends FS_Entry {

    /**
     * Keeps track of the number of child directories and files.
     */
    private int childCount;

    /**
     * Constructor for the FS_Directory class.
     * @param childCount int number of children of the directory
     * @param id int ID associated with the directory
     * @param parent FS_Directory directory entry of its parent
     * @param name String name of the directory
     * @param createDate Date creation date of the directory
     * @param hidden boolean the directory's visibility in the file system
     */
    public FS_Directory(int childCount, int id, FS_Directory parent, String name, Date createDate, boolean hidden) {
        super(id, parent, name, createDate, hidden); // Constructs an internal instance of type FS_Entry with specified parameters.
        this.childCount = childCount; // Initializes childCount to equal to the passed in value.
    }

    /**
     * Returns the size of directory.
     * @return long size of the directory.
     */
    @Override
    public long getSize() {
        return 0;
    }

    /**
     * Returns the String concatenation of the parent toString and the childCount of the directory.
     * @return String concatenation of the parent toString and the childCount of the directory.
     */
    @Override
    public String toString(){
        return super.toString() + " " + this.childCount; // Concatenates the result from the toString() of the parent class and the childCount.
    }

    /**
     * Compares the object with other FS_Directory objects.
     * @param other FS_Directory object being compared to.
     * @return int value as a result of the comparison.
     */
    public int compareTo(FS_Directory other){
        int result = 0; // Initializes result to equal 0.

        // Checks to see if the passed in object is the same as the calling object, and if not, proceeds to compare them.
        if(this != other){
            result = Integer.compare(this.id, other.id); // Sets result equal to the output of calling the compare() method of Integer and comparing their IDs.

            // Checks to see if result is still equal to 0, which would mean the IDs of the two directories are equal.
            if(result == 0){
                result = this.createDate.compareTo(other.createDate); // Uses the compareTo() method to compare the creation dates of the two objects and sets result equal to it.

                // Checks to see if result is still equal to 0, which would mean the creation dates of the two objects are equal.
                if (result == 0){
                    result = this.name.compareTo(other.name); // Uses the compareTo() method to compare the names of the two objects and sets result equal to it.

                    // Checks to see if result is still equal to 0, which would mean that the names of the two objects are equal.
                    if (result == 0)
                        result = Integer.compare(this.childCount, other.childCount); // Sets result equal to the output by invoking the compare() method of Integer and comparing the childCount of the two objects.
                }
            }
        }

        return result; // Returns result.
    }

    /**
     * Gets the childCount of the directory.
     * @return int number of children of the directory.
     */
    public int getChildCount() {
        return childCount;
    }

    /**
     * Sets the childCount of the directory.
     * @param childCount int number of children of the directory.
     */
    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }
}
