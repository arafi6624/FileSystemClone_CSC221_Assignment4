import java.util.Date;

/**
 * A class to create file entry objects in the file system.
 * It has the following members:
 * 1. size
 * 2. toString()
 * 3. compareTo()
 * 4. getSize()
 * 5. setSize()
 *
 * @author Abdul Rafi
 * @version 1.0
 */
public abstract class FS_File extends FS_Entry {

    /**
     * Stores the size of the file.
     */
    protected long size;

    /**
     * Constructor for the FS_File class.
     * @param size long size of the file
     * @param id int ID associated with the file
     * @param parent FS_Directory directory entry of its parent
     * @param name String name of the file
     * @param createDate Date creation date of the file
     * @param hidden boolean the file's visibility in the file system
     */
    public FS_File(long size, int id, FS_Directory parent, String name, Date createDate, boolean hidden){
        super(id, parent, name, createDate, hidden); // Constructs an internal instance of type FS_Entry with the specified parameters.
        this.size = size; // Initializes the size of the file to the passed in value for size.
    }

    /**
     * Returns the String concatenation of the parent toString and the size of the file.
     * @return String concatenation of the parent toString and the size of the file.
     */
    @Override
    public String toString(){
        String numString = String.format("%,d", this.size); // Formats the size of the file with commas.
        return super.toString() + " " + numString; // Returns the concatenation of the parent toString() and the size of the file.
    }

    /**
     * Compares the object with other FS_File objects.
     * @param other FS_File object being compared to.
     * @return int value as a result of the comparison.
     */
    public int compareTo(FS_File other){
        int result = 0; // Initializes result to equal 0.

        // Checks to see if the passed in object is the same as the calling object, and if not, proceeds to compare them.
        if(this != other){
            result = Integer.compare(this.id, other.id); // Sets result equal to the output of calling the compare() method of Integer and comparing their IDs.

            // Checks to see if result is still equal to 0, which would mean the IDs of the two files are equal.
            if(result == 0){
                result = this.createDate.compareTo(other.createDate); // Uses the compareTo() method to compare the creation dates of the two objects and sets result equal to it.

                // Checks to see if result is still equal to 0, which would mean the creation dates of the two objects are equal.
                if(result == 0){
                    result = this.name.compareTo(other.name); // Uses the compareTo() method to compare the names of the two objects and sets result equal to it.

                    // Checks to see if result is still equal to 0, which would mean that the names of the two objects are equal.
                    if(result == 0){
                        result = Long.compare(this.size, other.size); // Sets result equal to the output by invoking the compare() method of Long and comparing the size of the two objects.
                    }
                }
            }
        }

        return result; // Returns result.
    }

    /**
     * Gets the size of the file.
     * @return long size of the file.
     */
    public long getSize(){
        return this.size;
    }

    /**
     * Sets the size of the file.
     * @param size long size of the file.
     */
    public void setSize(long size) {
        this.size = size;
    }
}
