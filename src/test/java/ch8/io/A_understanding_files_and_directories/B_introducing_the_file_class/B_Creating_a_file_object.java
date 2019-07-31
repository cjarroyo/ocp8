package ch8.io.A_understanding_files_and_directories.B_introducing_the_file_class;

import java.io.File;

public class B_Creating_a_file_object {
    /*
    A File object often is initialized with String containing either an absolute or relative path to the file or directory within the file system.
    The absolute path of a file or directory is the full path from the root directory to the file or directory, including all subdirectories that contain the file or directory.
    Alternatively, the relative path of a file or directory is the path from the current working directory to file or directory.
    For example, the following is an absolute path to the zoo.txt file:
                    /home/smith/data/zoo.txt
    The following is a relative path to the same file, assuming the user’s current directory was set to
                    /home/smith.
                    data/zoo.txt
    Different operating systems vary in their format of path names. For example, Unix based systems use the forward slash / for paths,
    whereas Windows-based systems use the backslash \ character.
    That said, many programming languages and file systems support both types of slashes when writing path statements.
    For convenience, Java offers two options to retrieve the local separator character: a system property and a static variable defined in the File class.
    Both of the following examples will output the separator character:
        System.out.println(System.getProperty("file.separator"));
        System.out.println(java.io.File.separator);
    The following code creates a File object and determines if the path it references exists within the file system:

     */
}

class FileSample {
    public static void main(String[] args) {
        File file = new File("/home/smith/data/zoo.txt");
        System.out.println(file.exists());

    /*
    This example uses the absolute path to a file and outputs true or false, depending on whether the file exists.
    The most common File constructor we will use throughout this chapter takes a single String as an argument representing the relative or absolute path.
    There are other constructors, such as the one that joins an existing File path with a relative child path, as shown in the following example:*/
        File parent = new File("/home/smith");
        File child = new File(parent, "data/zoo.txt");
    /*
    In this example, we create a path that is equivalent to our previous example, using a combination of a child path and a parent path.
    If the parent object happened to be null, then it would be skipped and the method would revert to our single String constructor.
    */
    }
}