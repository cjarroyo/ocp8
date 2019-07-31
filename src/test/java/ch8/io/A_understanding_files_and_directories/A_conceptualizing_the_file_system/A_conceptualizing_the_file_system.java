package ch8.io.A_understanding_files_and_directories.A_conceptualizing_the_file_system;

    /*
    What can Java applications do outside the scope of managing objects and attributes in memory?
    How can they save data so that information is not lost every time the program is terminated? They use files, of course!

    You can design code that writes the current state of an application to a file every time the application is closed and then reloads the data when the application is executed the next time.
    In this manner, information is preserved between program executions.

    This chapter focuses on using the java.io API to interact with files and streams.
    We start by describing how files and directories are organized within a file system and show how to access them with the java.io.File class.
    We then show how to read and write file data with the stream classes.

    Finally, we conclude this chapter by discussing ways of reading user input at runtime using the Console class.
    In the next chapter, “NIO.2,” we will revisit the discussion of files and show how Java now provides more powerful techniques for managing files.
    */

/*
We begin this chapter by describing what a file is and what a directory is within a file system.
We then present the java.io.File class and demonstrate how to use it to read and write file information.
*/
public class A_conceptualizing_the_file_system {
    /*
    Before we start working with files and directories, we present the terminology that we will be using throughout this chapter.

    A file is record within a file system that stores user and system data. Files are organized using directories.
    A directory is a record within a file system that contains files as well as other directories.
    For simplicity, we often refer to a directory reference as a "file record" throughout this chapter,
    since it is stored in the file system with a unique name and with attributes similar to a file.
    For example, a file and directory can both be renamed with the same operation. Finally, the root directory is the topmost directory in the file system, from
    which all files and directories inherit. In Windows, it is denoted with a drive name such as c:\, while on Linux it is denoted with a single forward slash /.

    In order to interact with files, we need to connect to the file system. The file system is in charge of reading and writing data within a computer.
    Different operating systems use different file systems to manage their data. For example, Windows-based systems use a different file system than Unix-based ones.
    As you shall see, Java includes numerous methods, which automatically connect to the local file system for you, allowing you to perform the same operations across multiple file systems.
    A path is a String representation of a file or directory within a file system. Each file system defines its own path separator character that is used between directory entries.
    In most file systems, the value to the left of a separator is the parent of the value to the right of the separator.
    For example, the path value /user/home/zoo.txt means that the file zoo.txt is inside the home directory, with the home directory inside the user directory. You will see that
    paths can be absolute or relative later in this chapter.
    We show how a directory and file system is organized in a hierarchical manner in Figure 8.1 .
    In this diagram, directories are represented as rectangles and files as ovals.
     */
}
