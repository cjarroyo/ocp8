package ch8.io.C_working_with_streams.D_the_printStream_and_printWriter_classes;

import org.junit.Test;

public class A_the_PrintStream_and_PrintWriter_Classes {
    /*
    The PrintStream and PrintWriter classes are high-level stream classes that write formatted representation of Java objects to a text-based output stream.
    As you may have ascertained by the name, the PrintStream class operates on OutputStream instances and writes data as bytes, whereas the PrintWriter class operates on Writer instances and writes data as characters.
    For convenience, both of these classes include constructors that can open and write to files directly.
    Furthermore, the PrintWriter class even has a constructor that takes an OutputStream as input, allowing you to wrap a PrintWriter class around an OutputStream.

    These classes are primarily convenience classes in that you could write the low-level primitive or object directly to a stream without a PrintStream or PrintWriter class,
    although using one is helpful in a wide variety of situations.
    In fact, the primary method class we have been using to output information to screen throughout this book uses a PrintStream object! For the exam, you should be aware that
    System.out and System.err are actually PrintStream objects.
    Because PrintStream inherits OutputStream and PrintWriter inherits from Writer , both support the underlying write() method while providing a slew of print-based methods.
    For the exam, you should be familiar with the print() , println() , format() , and printf() methods.
    Unlike the underlying write() method, which throws a checked IOException that must be caught in your application, these print-based methods do not throw any checked exceptions.
    If they did, you would have been required to catch a checked exception anytime you called System.out.println() in your code! Both classes provide a method, checkError() , that can be used to detect the presence of a problem after
    attempting to write data to the stream.
    For the rest of this section, we will use PrintWriter in our examples, as writing String data as characters instead of byte values is recommended.
    Keep in mind that the same examples could be easily rewritten with a PrintStream object.
     */

    /************
     You might remember from Chapter 5 that String formatting is no longer a
     part of the OCP 8 exam. For the exam, you should be aware that the Console
     class includes two methods, format() and printf() , which take an optional
     vararg and format the output, although you’re no longer required to know
     the various rules for formatting for the exam. For this chapter, we will
     provide the first String argument to these methods only.
     */

    @Test
    public void A_print() {
        /*
        The most basic of the print-based methods is print() , which is overloaded with all
        Java primitives as well as String and Object . In general, these methods perform
        String.valueOf() on the argument and call the underlying stream’s write() method,
                although they also handle character encoding automatically. For example, the following
        sets of print / write code are equivalent:

         */
       /* PrintWriter out = new PrintWriter("zoo.log");
        out.print(5); // PrintWriter method
        out.write(String.valueOf(5)); // Writer method
        out.print(2.0); // PrintWriter method
        out.write(String.valueOf(2.0)); // Writer method
        Animal animal = new Animal();
        out.print(animal); // PrintWriter method
        out.write(animal==null ? "null": animal.toString()); // Writer method*/

       /*
       You may remember from your OCA study material that valueOf() applied to an object
calls the object’s toString() method or returns null if the object is not set.
As these examples show, you could write to the same stream without the PrintWriter
methods, but having the convenience of methods that convert everything to String values
for you is extremely useful in practice.
        */


    }
    @Test
    public void B_println() {
        /*
        The next methods available in the PrintStream and PrintWriter classes are the
println() methods, which are virtually identical to the print() methods, except that
they insert a line break after the String value is written. The classes also include a
version of println() that takes no arguments, which terminates the current line by
writing a line separator.
These methods are especially helpful, as the line break or separator character is JVM
dependent. For example, in some systems a line feed symbol, \n , signifi es a line break,
whereas other systems use a carriage return symbol followed by a line feed symbol, \r\n ,
to signify a line break. As you saw earlier in the chapter with file.separator , the line.
separator value is available as a Java system property at any time:
System.getProperty("line.separator");
         */
        /*****
         Although you can use print() instead of println() and insert all line
         break characters manually, it is not recommended in practice. As the
         line break character is OS dependent, it is recommended that you rely
         on println() for inserting line breaks since it makes your code more
         lightweight and portable.
         */

    }

    @Test
    public void C_format_and_printf(){
        /*
        Like the String.format() methods discussed in Chapter 5 , the format() method in
PrintStream and PrintWriter takes a String , an optional locale, and a set of arguments,
and it writes a formatted String to the stream based on the input. In other words, it is a
convenience method for formatting directly to the stream. Refer to Chapter 5 for more
details about how String values can be formatted in Java.
For convenience, as well as to make C developers feel more at home in Java, the
PrintStream and PrintWriter APIs also include a set of printf() methods, which are
straight pass-through methods to the format() methods. For example, although the names
of the following two methods differ, their input values, output value, and behavior are
identical in Java. They can be used interchangeably:
public PrintWriter format(String format, Object args. . .)
public PrintWriter printf(String format, Object args. . .)
         */

    }

    @Test
    public void D_Sample_PrintWriter_Application(){
        /*
        We conclude this section with sample code of the PrintWriter class in action, as well as the
accompanying output file:
import java.io.*;
public class PrintWriterSample {
public static void main(String[] args) throws IOException {
File source = new File("zoo.log");
try (PrintWriter out = new PrintWriter(
new BufferedWriter(new FileWriter(source)))) {
out.print("Today's weather is: ");
out.println("Sunny");
out.print("Today's temperature at the zoo is: ");
out.print(1/3.0);
out.println('C');
out.format("It has rained 10.12 inches this year");
out.println();
out.printf("It may rain 21.2 more inches this year");
}
}
}
Note that we used a BufferedWriter along with FileWriter to access the file. We could
have also used the PrintWriter(String filename) constructor in this example, as we did earlier
in this section. The following are the contents of the file generated by the preceding code.
Today's weather is: Sunny
Today's temperature at the zoo is: 0.3333333333333333C
It has rained 10.12 inches this year
It may rain 21.2 more inches this year
You should pay close attention to the line breaks in the sample. For example, we called
println() after our format(), since format() does not automatically insert a line break
after the text. One of the most common bugs with printing data in practice is failing to
account for line breaks properly.
         */

    }

    @Test
    public void E_Review_of_Stream_Classes(){
        /*
        We conclude this part of the chapter with Figure 8.3, which shows the various java.
io stream classes that we have discussed and how they are related to one another via
inheritance. The classes on the left side of the diagram are the abstract parent classes. The
classes on the right side with dotted borders are low-level streams, and the ones with solid
borders are high-level streams. Note that this diagram does not include all java.io stream
classes, just the ones with which you should be familiar for the exam.

Diagram of java.io classes
         */

    }
    @Test
    public void F_Other_Stream_Classes(){
        /*
        The high-level InputStreamReader and OutputStreamWriter presented in Figure 8.3 are
out of scope for the exam but useful in practice. The InputStreamReader class takes an
InputStream instance and returns a Reader object. Likewise, the OutputStreamWriter class
takes an OutputStream instance and returns a Writer object. In this manner, these classes
convert data between character and byte streams. These classes are also unique in that they
are the only java.io stream classes to have both Stream and Reader/Writer in their name.

Likewise, the DataInputStream and DataOutputStream are no longer required for the
exam. They function quite similarly to the Object stream classes but are tailored to write
only primitives and String values. In practice, they are rarely used as they require values
and their associated types to be read in the precise order in which they were written. For
example, if you wrote a String followed by an int and then a float, you would need to
repeat this order exactly to read the data properly. In this manner, the files created by the
DataOutputStream methods tend to be too rigid and too cumbersome to use in professional
software development.
Finally, the parent classes FilterInputStream and FilterOutputStream were not
discussed in this section, but they are also presented in the Figure 8.3, since we did discuss
classes that inherit from them. The Filter classes are the superclass of all classes that filter
or transform data. These classes will not be on the exam, though.
         */

    }

}
