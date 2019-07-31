package ch8.io.B_introducing_streams;

import org.junit.Test;

public class B_stream_nomenclature {
    /*
    The java.io API provides numerous classes for creating, accessing, and manipulating streams—so many that it tends to overwhelm most new Java developers.
    Stay calm! We will review the major differences between each stream class and show you how to distinguish between them.
    Even if you do come across a particular stream on the exam that you do not recognize, often the name of the stream gives you enough information to understand exactly what it does.

    The goal of this section is to familiarize you with common terminology and naming conventions used with streams.
    Don’t worry if you don’t recognize the particular stream class names used in this section or their function; we’ll be covering each in detail in the next part of the chapter.
    */

    @Test
    public void A_Byte_Streams_vs_Character_Streams(){
        /*
        The java.io API defines two sets of classes for reading and writing streams: those with Stream in their name and those with Reader/Writer in their name.
        For example, the java.io API defines both a FileInputStream class as well as a FileReader class, both of which define a stream that reads a file.
        The difference between the two classes is based on how the stream is read or written.

        Differences between Streams and Readers/Writers
            1. The stream classes are used for inputting and outputting all types of binary or byte data.
            2. The reader and writer classes are used for inputting and outputting only character and String data.

        It is important to remember that even though readers/writers do not contain the word Stream in their class name, they are still in fact streams!
        The use of Reader/Writer in the name is just to distinguish them from byte streams.
        Throughout the chapter, we will often refer to Reader/Writer classes as streams, since conceptually they are streams.
         */
        /**Why Use Character Streams?
         * ===========================
         Since the byte stream classes can be used to input and output all types of binary data, including strings, it naturally follows that you can write all of your code to use the byte stream classes, never really needing the character stream classes.
         There are advantages, though, to using the reader/writer classes, as they are specifically focused on managing character and string data.
         For example, you can use a Writer class to output a String value to a file without necessarily having to worry about the underlying byte encoding of the file.
         For this reason, the character stream classes are sometimes referred to as convenience classes for working with text data.
         */
        /*
        The java.io API is structured such that all of the stream classes have the word InputStream or OutputStream in their name, while all Reader/Writer classes have either Reader or Writer in their name.
        Pay close attention to the name of the java.io class on the exam, as decoding it often gives you context clues as to what the class does.
        For example, without needing to look it up, it should be clear that FileReader is a class that reads data from a file as characters or strings.
        Furthermore, ObjectOutputStream sounds like a class that writes object data to a byte stream.
         */
    }


    @Test
    public void B_Input_and_Output(){
        /*
        Most Input stream classes have a corresponding Output class and vice versa. For example, the FileOutputStream class writes data that can be read by a FileInputStream.
        If you understand the features of a particular Input or Output stream class, you should naturally know what its complementary class does.
        It follows, then, that most Reader classes have a corresponding Writer class. For example, the FileWriter class writes data that can be read by a FileReader.
        There are exceptions to this rule. For the exam, you should know that PrintWriter has no accompanying PrintReader class.
        Likewise, the PrintStream class has no corresponding InputStream class. We will discuss these classes later this chapter.
         */
    }

    @Test
    public void C_LowLevel_vs_HighLevel_Streams(){
        /*
        Another way that you can familiarize yourself with the java.io API is by segmenting streams into low-level and high-level streams.
        A low-level stream connects directly with the source of the data, such as a file, an array, or a String.
        Low-level streams process the raw data or resource and are accessed in a direct and unfiltered manner.
        For example, a FileInputStream is a class that reads file data one byte at a time.
        Alternatively, a high-level stream is built on top of another stream using wrapping.
        Wrapping is the process by which an instance is passed to the constructor of another class and operations on the resulting instance are filtered and applied to the original instance.
        For example, take a look at the FileWriter and BufferedWriter objects in the following sample code:

            try (
            BufferedReader bufferedReader = new BufferedReader(
            new FileReader("zoo-data.txt"))) {
            System.out.println(bufferedReader.readLine());
            }

        In this example, FileReader is the low-level stream reader, whereas BufferedReader is the high-level stream that takes a FileReader as input.
        Many operations on the high-level stream pass through as operations to the underlying low-level stream, such as read() or close().
        Other operations override or add new functionality to the low-level stream methods.
        The highlevel stream adds new methods, such as readLine(), as well as performance enhancements for reading and filtering the low-level data.
        High-level streams can take other high-level streams as input.
        For example, although the following code might seem a little odd at first, the style of wrapping a stream is quite common in practice:

            try (ObjectInputStream objectStream = new ObjectInputStream(
            new BufferedInputStream(
            new FileInputStream("zoo-data.txt")))) {
            System.out.println(objectStream.readObject());
            }

        In this example, FileInputStream is the low-level stream that interacts directly with the file, which is wrapped by a high-level BufferedInputStream to improve performance.
        Finally, the entire object is wrapped by a high-level ObjectInputStream, which allows us to filter the data as Java objects.
        For the exam, the only low-level stream classes you need to be familiar with are the ones that operate on files. The rest of the non-abstract stream classes are all high-level streams.
         */
        /**Use Buffered Streams When Working with Files
         * ============================================
         As briefly mentioned, Buffered classes read or write data in groups, rather than a single byte or character at a time.
         The performance gain from using a Buffered class to access a low-level file stream cannot be overstated.
         Unless you are doing something very specialized in your application, you should always wrap a file stream with a Buffered class in practice.
         The reason that Buffered streams tend to perform so well in practice is that file systems are geared for sequential disk access.
         The more sequential bytes you read at a time, the fewer round-trips between the Java process and the file system, improving the access of your application.
         For example, accessing 16 sequential bytes is a lot faster than accessing 16 bytes spread across the hard drive.
         */
    }

    public void D_Stream_Base_Classes(){
        /*
        The java.io library defines four abstract classes that are the parents of all stream classes
defined within the API: InputStream, OutputStream, Reader, and Writer. For convenience,
the authors of the Java API include the name of the abstract parent class as the suffix of
the child class. For example, ObjectInputStream ends with InputStream, meaning it has
InputStream as an inherited parent class. Although most stream classes in java.io follow
this pattern, PrintStream, which is an OutputStream, does not.
The constructors of high-level streams often take a reference to the abstract class. For
example, BufferedWriter takes a Writer object as input, which allows it to take any subclass
of Writer.
The advantage of using a reference to the abstract parent class in the class constructor
should be apparent in the previous high-level stream example. With high level-streams, a
class may be wrapped multiple times. Furthermore, developers may define their own stream
subclass that performs custom filtering. By using the abstract parent class as input, the highlevel
stream classes can be used much more often without concern for the particular underlying
stream subclass.
One common area where the exam likes to play tricks on you is mixing and matching
stream classes that are not compatible with each other. For example, take a look at each of
the following examples and see if you can determine why they do not compile.
new BufferedInputStream(new FileReader("zoo-data.txt")); // DOES NOT COMPILE
new BufferedWriter(new FileOutputStream("zoo-data.txt")); // DOES NOT COMPILE
new ObjectInputStream(new FileOutputStream("zoo-data.txt")); // DOES NOT COMPILE
new BufferedInputStream(new InputStream()); // DOES NOT COMPILE
The first two examples do not compile because they mix Reader/Writer classes with
InputStream/OutputStream classes, respectively. The third example does not compile
because we are mixing an OutputStream with an InputStream. Although it is possible to
read data from an InputStream and write it to an OutputStream, wrapping the stream is
not the way to do so. As you shall see later in this chapter, the data must be copied over,
often iteratively. Finally, the last example does not compile because InputStream is an
abstract class, and therefore you cannot instantiate an instance of it.
         */
    }

    @Test
    public void E_Decoding_Java_IO_Class_Names(){
    /*
    Given that there are so many different java.io stream classes, it is reasonable to think that
you might encounter one on the exam whose name you may have forgotten. Luckily, the
function of most stream classes can be understood by decoding the name of the class. We
summarize these properties in the following list.

Review of java.io Class Properties
■■ A class with the word InputStream or OutputStream in its name is used for reading or
writing binary data, respectively.
■■ A class with the word Reader or Writer in its name is used for reading or writing
character or string data, respectively.
■■ Most, but not all, input classes have a corresponding output class.
■■ A low-level stream connects directly with the source of the data.
■■ A high-level stream is built on top of another stream using wrapping.
■■ A class with Buffered in its name reads or writes data in groups of bytes or characters
and often improves performance in sequential file systems.
When wrapping a stream you can mix and match only types that inherit from the same
abstract parent stream.
Table 8.2 describes those java.io streams you should be familiar with for the exam. Note
that most of the information about each stream, such as whether it is an input or output stream
or whether it accesses data using bytes or characters, can be decoded by the name alone.

Table 8 . 2 The java.io stream classes

Class Name Low/High Level Description
InputStream N/A The abstract class all InputStream classes
inherit from
OutputStream N/A The abstract class all OutputStream classes
inherit from
Reader N/A The abstract class all Reader classes inherit from
Writer N/A The abstract class all Writer classes inherit from
FileInputStream Low Reads file data as bytes
FileOutputStream Low Writes file data as bytes
FileReader Low Reads file data as characters
FileWriter Low Writes file data as characters
BufferedReader High Reads character data from an existing Reader in
a buffered manner, which improves efficiency
and performance
BufferedWriter High Writes character data to an existing Writer in a
buffered manner, which improves efficiency and
performance
ObjectInputStream High Deserializes primitive Java data types and graphs
of Java objects from an existing InputStream
ObjectOutputStream High Serializes primitive Java data types and graphs
of Java objects to an existing OutputStream
InputStreamReader High Reads character data from an existing InputStream
OutputStreamWriter High Writes character data to an existing
OutputStream
PrintStream High Writes formatted representations of Java
objects to a binary stream
PrintWriter High Writes formatted representations of Java
objects to a text-based output stream
____________________________________________________________
We will discuss these java.io classes in more detail including examples in upcoming
sections.
     */
    }
}
