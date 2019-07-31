package ch8.io.A_understanding_files_and_directories.B_introducing_the_file_class;

import java.io.File;

public class C_Working_with_a_File_Object {
    /*
    The File class contains numerous useful methods for interacting with files and directories within the file system.
    We present the most commonly used ones in Table 8.1. Although this table may seem like a lot of methods to learn, many of them are self-explanatory.
    For example, exists() returns true if the file or directory path exists and false otherwise.

            java.io.File methods

    Method Name          Description
    ___________________________________________________________________________
    exists()             Returns true if the file or directory exists.
    getName()            Returns the name of the file or directory denoted by this path.
    getAbsolutePath()    Returns the absolute pathname string of this path.
    isDirectory()        Returns true if the file denoted by this path is a directory.
    isFile()             Returns true if the file denoted by this path is a file.
    length()             Returns the number of bytes in the file. For performance reasons, the file system may allocate more bytes on disk than the file actually uses.
    lastModified()       Returns the number of milliseconds since the epoch when the file was last modified.
    delete()             Deletes the file or directory. If this pathname denotes a directory, then the directory must be empty in order to be deleted.
    renameTo(File)       Renames the file denoted by this path.
    mkdir()              Creates the directory named by this path.
    mkdirs()             Creates the directory named by this path including any nonexistent parent directories.
    getParent()          Returns the abstract pathname of this abstract pathname’s parent or null if this pathname does not name a parent directory.
    listFiles()          Returns a File[] array denoting the files in the directory.
   */
}

/*
The following is a sample program that given a file path outputs information about the file or directory,
such as whether it exists, what files are contained within it, and so forth:
 */
class ReadFileInformation {
    public static void main(String[] args) {
        File file = new File("C:\\data\\zoo.txt");
        System.out.println("File Exists: " + file.exists());
        if (file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent Path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("File size: " + file.length());
                System.out.println("File LastModified: " + file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println("\t" + subfile.getName());
                }
            }
        }
    }
}

/*
In these examples, you see that the output of an I/O-based program is completely dependent on the directories and files available at runtime in the underlying file system.
Note that we used a Windows-based path in the previous sample, which requires a double backslash in the String literal for the path separator.
You may remember from Chapter 5, “Dates, Strings and Localization,” that the backslash \ is a reserved character within a String literal and must be escaped
with another backslash to be used within a String.
 */