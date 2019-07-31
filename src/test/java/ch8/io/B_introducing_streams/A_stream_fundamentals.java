package ch8.io.B_introducing_streams;

    /*
    In this section, we present the concept of streams in Java and show how they are used for input/output (I/O) processing.
    I/O refers to the nature of how data is accessed, either by reading the data from a resource (input), or writing the data to a resource (output).
    This section will focus on the common ways that data is input and output using files accessed by streams.

    Note that the I/O streams that we discuss in this chapter are data streams and completely unrelated to the new Stream API that you saw in Chapter 4,
    “Functional Programming.” Even we agree that the naming of the new Stream API can be a little confusing when discussing I/O streams.
     */

public class A_stream_fundamentals {
    /*
    The contents of a file may be accessed or written via a stream, which is a list of data elements presented sequentially.
    Streams should be conceptually thought of as a long, nearly never-ending “stream of water” with data presented one “wave” at a time.
     */
    /**
     It may be helpful to visualize a stream as being so large that all of the data contained in it could not possibly fit into memory.
     For example, a 1 terabyte file could not be stored entirely in memory by most computer systems (at the time this book is being written).
     The file can still be read and written by a program with very little memory, since the stream allows the application to focus on only a small portion of the overall stream at any  given time.
     We demonstrate this principle in Figure 8.2 .
     The stream is so large that once we start reading it, we have no idea where the beginning or the end is.
     We just have a pointer to our current position in the stream and read data one block at a time.
     */
    /*
    Visual representation of a stream

                                Reading a byte into a Block

    ...01001010011000010111011001100001001000000011110100100000010001100111010101101110...
    Toward the Head of the Stream                            Toward the Tail of the Stream
                                                Next Block

    Each type of stream segments data into a “wave” or “block” in a particular way. For example, some stream classes read or write data as individual byte values.
    Other stream classes read or write individual characters or strings of characters.
    On top of that, some stream classes read or write groups of bytes or characters at a time, specifically those with the word Buffered in their name.
     */

    /**All Java Streams Use Bytes
     * ==========================
     Although the java.io API is full of streams that handle characters, strings, groups of bytes, and so on, nearly all are built on top of reading or writing an individual byte or
     an array of bytes at a time. The reasoning behind more high-order streams is for convenience as well as performance.
     For example, writing a file one byte at a time is time consuming and slow in practice because the round-trip between the Java application and the file system is relatively expensive.
     By utilizing a BufferedOutputStream, the Java application can write a large chunk of bytes at a time, reducing the round-trips and drastically improving performance.
     */

    /*
    Although streams are commonly used with file I/O, they are more generally used to handle reading/writing of a sequential data source.
    For example, you might construct a Java application that submits data to a website using an input stream and reads the result via an output stream.
    In fact, you have been using streams since your first “Hello World” program! Java provides three built-in streams, System.in, System.err, and System.out, the last of which we have
    been using to output data to the screen throughout this book. We will discuss these three streams in detail later in this chapter when we discuss user input.
     */
}
