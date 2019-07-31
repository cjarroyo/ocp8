package ch8.io.C_working_with_streams.B_the_fileReader_and_fileWriter_classes;

public class A_the_FileReader_and_FileWriter_classes {
    /*
    The FileReader and FileWriter classes, along with their associated buffer classes, are among the most convenient classes in the java.io API, in part because reading and writing text data are among the most common ways that developers interact with files.

    Like the FileInputStream and FileOutputStream classes, the FileReader and FileWriter classes contain read() and write() methods, respectively.

    These methods read/write char values instead of byte values; although similar to what you saw with streams, the API actually uses an int value to hold the data so that -1 can be returned if the end of the file is detected.

    The FileReader and FileWriter classes contain other methods that you saw in the stream classes, including close() and flush(), the usage of which is the same.

    The Writer class, which FileWriter inherits from, offers a write(String) method that allows a String object to be written directly to the stream. Using FileReader also allows you to pair it with BufferedReader in order to use the very convenient readLine() method, which you will see in the next example.
     */
}
