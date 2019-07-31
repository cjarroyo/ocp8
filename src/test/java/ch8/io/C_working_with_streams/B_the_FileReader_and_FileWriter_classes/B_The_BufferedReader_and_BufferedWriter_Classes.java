package ch8.io.C_working_with_streams.B_the_FileReader_and_FileWriter_classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B_The_BufferedReader_and_BufferedWriter_Classes {
    /*
    Let’s take a look at a sample program that makes use of both the BufferedReader and BufferedWriter classes using the associated readLine() and write(String) methods.
    It reads a text file, outputs each line to screen, and writes a copy of the file to disk. Since these classes are buffered, you can expect better performance than if you read/wrote each character one at a time.
     */

    static class CopyTextFileSample {
        public static List<String> readFile(File source) throws IOException {
            List<String> data = new ArrayList<String>();
            try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
                String s;
                while ((s = reader.readLine()) != null) {
                    data.add(s);
                }
            }
            return data;
        }

        public static void writeFile(List<String> data, File destination) throws
                IOException {
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(destination))) {
                for (String s : data) {
                    writer.write(s);
                    writer.newLine();
                }
            }
        }

        public static void main(String[] args) throws IOException {
            File source = new File("Zoo.csv");
            File destination = new File("ZooCopy.csv");
            List<String> data = readFile(source);
            for (String record : data) {
                System.out.println(record);
            }
            writeFile(data, destination);
        }
    }

    /*
    This example is similar to the file copy example that you saw previously, with some important differences. First, in the readFile() method, we use a temporary String
    reference s to hold the value of the data in loop as we read it. Unlike FileInputStream and FileReader, where we used -1 to check for file termination of an int value, with
    BufferedReader, we stop reading the file when readLine() returns null.

    Next, instead of immediately copying the data we read from the file into the output file, we store it in a List of String objects in the readFile() method. This allows us to both
    display and modify the data, prior to writing it to disk later.

    For example, let’s say that we wanted to replace one person’s name in a text file with another. We would just use the String.replaceAll() method on the data as we wrote it to disk, and the
    new file would have the replacement. By working entirely with String values instead of byte values, we have access to the all of the methods in the String API to manipulate data.
    The last major difference between this code and the previous copy file example is in how data is written in the writeFile() method. Unlike the previous examples where we
    had to write the code one byte at a time or by using a byte array, we can write the entire String in a single call. The write(String) method is quite convenient in practice. We
    then use the writer.newLine() method to insert a line break into the copied file, as our reader.readLine() method split on line breaks.

    Note that we used the .csv file extension in this example to represent comma-separated values files, as these are commonly text based. This example also assumes that the CSV file
    is small enough to fit entirely in memory.

    Let’s say that the file is so large that it cannot fit in memory. If you wanted to write it directly to disk, rather than storing it in a List object, you could take our earlier copy file
    stream example and replace it with Reader/Writer methods.
     */

    /*
    Comparing the Two Copy Applications
    ==================================
    Although both this example and the previous InputStream/OutputStream solution can successfully copy the file, only the Reader/Writer solution gives us structured access to the text data.
    In order to accomplish the same feat with the InputStream/OutputStream classes, the application would have to detect the end of each line, which could be a lot of extra work.
    For example, if we are using a BufferedInputStream , multiple end-of-line characters could appear in the buffer array, meaning that we would have to go searching for them and
    then reconstruct the strings contained within the buffer array manually.

    We would also have to write code to detect and process the character encoding. The character encoding determines how characters are encoded and stored in bytes and later read back or decoded as characters.
    Although this may sound simple, Java supports a wide variety of character encodings, ranging from ones that may use one byte for Latin characters, UTF-8 and ASCII for example, to using two or more bytes per character, such as UTF-16 .
    For the exam, you don’t need to memorize the character encodings, but you should be familiar with the names if you come across them on the exam.
     */
    /**Character encoding in Java
     * =============================
     In Java, the character encoding can be specifi ed using the Charset class by passing a
     name value to the static Charset.forName() method, such as in the following examples:
     Charset usAsciiCharset = Charset.forName("US-ASCII");
     Charset utf8Charset = Charset.forName("UTF-8");
     Charset utf16Charset = Charset.forName("UTF-16");
     Java supports numerous
     */

    /*
    The key point here is that although you can use InputStream / OutputStream instead of Reader / Writer to read and write text fi les, it is inappropriate to do so.
    Recall that the character stream classes were created for convenience, and you should certainly take advantage of them when working with text data.
     */
}
