package ch8.io.C_working_with_streams.A_the_fileInputStream_and_fileOutputStream_classes;

import java.io.*;

/*
Now that we’ve reviewed the types of streams and their properties, it’s time to jump in and work with some stream code! Some of the techniques for accessing streams may seem a bit new to you, but as you will see they are very similar among different stream classes
 */
public class A_the_FileInputStream_and_FileOutputStream_Classes {
    /*
    The first stream classes that we are going to discuss in detail are the most basic file stream classes, FileInputStream and FileOutputStream.
    They are used to read bytes from a file or write bytes to a file, respectively. These classes include constructors that take a File object or String, representing a path to the file.

    The data in a FileInputStream object is commonly accessed by successive calls to the read() method until a value of -1 is returned, indicating that the end of the stream—in this case the end of the file—has been reached.
    Although less common, you can also choose to stop reading the stream early just by exiting the loop, such as if some search String is found
     */
    /**
     When reading a single value of a FileInputStream instance, the read() method returns a primitive int value rather than a byte value.
     It does this so that it has an additional value available to be returned, specifically -1 , when the end of the file is reached.
     If the class did return a byte instead of an int, there would be no way to know whether the end of the file had been reached based on the value returned from the read() method, since the file could
     contain all possible byte values as data. For compatibility, the FileOutputStream also uses int instead of byte for writing a single byte to a file.
     */
    /*
    The FileInputStream class also contains overloaded versions of the read() method, which take a pointer to a byte array where the data is written.
    The method returns an integer value indicating how many bytes can be read into the byte array.
    It is also used by Buffered classes to improve performance, as you shall see in the next section.
    A FileOutputStream object is accessed by writing successive bytes using the write(int) method.
    Like the FileInputStream class, the FileOutputStream also contains overloaded versions of the write() method that allow a byte array to be passed and can be used by Buffered classes.
    The following code uses FileInputStream and FileOutputStream to copy a file:
     */

}

class CopyFileSample {
    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("Zoo.class");
        File destination = new File("ZooCopy.class");
        copy(source, destination);
    }
}
    /*
    The main() method creates two File objects, one for the source fi le to copy from and one for the destination fi le to copy to.
    If the destination fi le already exists, it will be overridden by this code. Both File objects are created using relative paths, so the application would search for the Zoo.class
    in the current directory to read from, throwing a FileNotFoundException if the file is not found, which is a subclass of an IOException
     */
    /*
    The copy() method creates instances of FileInputStream and FileOutputStream, and it proceeds to read the FileInputStream one byte at a time, copying the value to the FileOutputStream as it’s read.
    As soon as the in.read() returns a -1 value, the loop ends. Finally, both streams are closed using the try-with-resource syntax presented in Chapter 6.
    Note that the performance for this code, especially for large files, would not be particularly good because the sample does not use any byte arrays. As you shall see in the next section, we can improve the implementation using byte arrays and buffered streams.
     */

    /*
     * The BufferedInputStream and BufferedOutputStream Classes
        ===============================================

     We can enhance our implementation with only a few minor code changes by wrapping the FileInputStream and FileOutputStream classes that you saw in the previous example with
     the BufferedInputStream and BufferedOutputStream classes, respectively.
     Instead of reading the data one byte at a time, we use the underlying read(byte[]) method of BufferedInputStream, which returns the number of bytes read into the provided byte array.
     The number of bytes read is important for two reasons. First, if the value returned is 0, then we know that we have reached the end of the file and can stop reading from the BufferedInputStream.
     Second, the last read of the file will likely only partially fill the byte array, since it is unlikely for the file size to be an exact multiple of our buffer array size.
     For example, if the buffer size is 1,024 bytes and the file size is 1,054 bytes, then the last read will be only 30 bytes. The length value tells us how many of the bytes in the array were actually read from the file.
     The remaining bytes of the array will be filled with leftover data from the previous read that should be discarded.
     The data is written into the BufferedOutputStream using the write(byte[],int,int) method, which takes as input a byte array, an offset, and a length value, respectively.
     The offset value is the number of values to skip before writing characters, and it is often set to 0. The length value is the number of characters from the byte array to write.

     */

/***
 Why Use the Buffered Classes?
 ==============================
 Although we could have rewritten our earlier examples to use byte arrays without introducing the Buffered classes, we chose to present them together.
 In practice, it’s quite common to use Buffered classes anytime you are reading or writing data with byte arrays. The Buffered classes contain numerous performance enhancements for managing stream data in memory.

 For example, the BufferedInputStream class is capable of retrieving and storing in memory more data than you might request with a single read() call.
 For successive calls to the read() method with small byte arrays, this would be faster in a wide variety of situations, since the data can be returned directly from memory without going to the file system.

 */

    /*
    Here’s a modified form of our copy() method, which uses byte arrays and the Buffered stream classes:
     */

class CopyBufferFileSample {

    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(source));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        File source = new File("Zoo.class");
        File destination = new File("ZooCopy.class");
        copy(source, destination);
    }
}

    /*
    You can see that this sample code that uses byte arrays is very similar to the nonbuffered sample code, although the performance improvement for using both the Buffered classes and byte arrays is an order of magnitude faster in practice.
    We also added a flush() command in the loop, as previously discussed, to ensure that the written data actually makes it to disk before the next buffer of data is read.
     */
/****
 Buffer Size Tuning
 ==================
 We chose a buffer size of 1024 in this example, as this is appropriate for a wide variety of circumstances, although in practice you may see better performance with a larger or smaller buffer size.
 This would depend on a number of factors including file system block size and CPU hardware.

 It is also common to choose a power of 2 for the buffer size, since most underlying hardware is structured with file block and cache sizes that are a power of 2.
 The Buffered classes allow you to specify the buffer size in the constructor. If none is provided, they use a default value, which is a power of 2 in most JVMs.

 Regardless of which buffer size you choose, the biggest performance increase you will see is moving from nonbuffered to buffered file access.
 Adjusting the buffer size may improve performance slightly, but unless you are using an extremely small or extremely large buffer size, it is unlikely to have a significant impact.
 */