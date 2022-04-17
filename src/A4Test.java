import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.util.Scanner;

public class A4Test {

    // Modify the path if needed
    public final static String FILE_NAME = "TestFileSystem.csv";

    // String to Date (or back to String) formatter
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

    // An output String of 50 #'s
    private final static String TEST_OUTPUT_SEPARATOR = String.format("%50s", " ").replaceAll(" ", "#");

    public static void main(String[] args) throws FileNotFoundException {

        // ensure file is accessible before moving on
        if (!new File(FILE_NAME).exists())
            throw new FileNotFoundException(String.format("Input file not found within the program's classpath. Copy the file into the class's path or adjust the file's path.%nLooking for file: %s", new File(FILE_NAME).getAbsolutePath()));

        FileSystem fileSystem = new FileSystem();

        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {

            // skips header
            scanner.nextLine();

            // process all file's lines
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                // Tokenize the line
                String[] lineParts = line.split(",");

                try {

                    // Adjust data type if required
                    int id = Integer.parseInt(lineParts[0]);
                    String type = lineParts[1].toLowerCase();
                    String name = lineParts[2];
                    int childCount = lineParts[3].isEmpty() ? 0 : Integer.parseInt(lineParts[3]);
                    long size = Long.parseLong(lineParts[4]);
                    Date createdDate = SIMPLE_DATE_FORMAT.parse(lineParts[5]);
                    boolean hidden = lineParts[6].equals("Y");

                    // find the entry of the parent directory
                    FS_Entry parent = null;

                    if (lineParts.length == 8) parent = fileSystem.findById(Integer.parseInt(lineParts[7]));

                    FS_Entry entry = switch (type) {

                        case "dir" -> new FS_Directory(childCount, id, (FS_Directory) parent, name, createdDate, hidden);
                        case "dat" -> new FS_Data(size, id, (FS_Directory) parent, name, createdDate, hidden);
                        case "exe" -> new FS_Executable(size, id, (FS_Directory) parent, name, createdDate, hidden);
                        default -> throw new InvalidKeyException(String.format("Invalid type detected \"%s\"", type));
                    };

                    if (!fileSystem.add(entry))
                        throw new Exception(String.format("Skipping duplicate entry: %s", line));

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        System.out.println();
        System.out.println(TEST_OUTPUT_SEPARATOR);
        System.out.println("Summary:");
        System.out.println(TEST_OUTPUT_SEPARATOR);

        System.out.printf("The file systems contains %d valid entries%n", fileSystem.getSize());

        FileSystem directories = fileSystem.getDirectories();
        System.out.printf("There are %d Directories%n", directories.size());

        FileSystem files = fileSystem.getFiles();
        System.out.printf("There are %d Files%n", files.size());

        FileSystem executables = fileSystem.getExecutables();
        System.out.printf("There are %d Executables%n", executables.size());

        System.out.println();
        System.out.println(TEST_OUTPUT_SEPARATOR);
        System.out.println("Output of printFormatted()");
        System.out.println(TEST_OUTPUT_SEPARATOR);

        fileSystem.printFormatted();
    }
}
