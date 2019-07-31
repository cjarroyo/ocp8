package ch8.io.B_introducing_streams;

import org.junit.Test;

public class C_common_stream_operations {
    /*
    Before we delve into specific stream classes, let’s review some common processes when working with streams.
     */

    @Test
    public void A_Closing_the_Stream() {
    /*
    Since streams are considered resources, it is imperative that they be closed after they are used lest they lead to resource leaks.
    As you saw in Chapter 6, “Exceptions and Assertions,” you can accomplish this by calling the close() method in a finally block or using the try-with-resource syntax.
    In a file system, failing to close a file properly could leave it locked by the operating system such that no other processes could read/write to it until the program is terminated.
    Throughout this chapter, we will close stream resources using the try-with-resource syntax, since this is the preferred way of closing resources in Java.
     */
    }

    @Test
    public void B_Flushing_the_Stream() {
    /*
    When data is written to an OutputStream, the underlying operating system does not necessarily guarantee that the data will make it to the file immediately.
    In many operating systems, the data may be cached in memory, with a write occurring only after a temporary cache is filled or after some amount of time has passed.
    If the data is cached in memory and the application terminates unexpectedly, the data would be lost, because it was never written to the file system.
    To address this, Java provides a flush() method, which requests that all accumulated data be written immediately to disk.

    The flush() method helps reduce the amount of data lost if the application terminates unexpectedly. It is not without cost, though.
    Each time it is used, it may cause a noticeable delay in the application, especially for large files.
    Unless the data that you are writing is extremely critical, the flush() method should only be used intermittently.
    For example, it should not necessarily be called after every write but after every dozen writes or so, depending on your requirements.
    For reasonably small files, you may need to call flush() only once.

    You do not need to call the flush() method explicitly when you have finished writing to a file, since the close() method will automatically do this.
    In some cases, calling the flush() method intermittently while writing a large file, rather than performing a single large flush when the file is closed, may appear to improve performance by stretching the disk access over the course of the write process.
     */
    }

    @Test
    public void C_Marking_the_Stream() {
    /*
    The InputStream and Reader classes include mark(int) and reset() methods to move the stream back to an earlier position.
    Before calling either of these methods, you should call the markSupported() method, which returns true only if mark() is supported.
    Not all java.io input stream classes support this operation, and trying to call mark(int) or reset() on a class that does not support these operations will throw an exception at runtime.

    Once you’ve verified that the stream can support these operations, you can call mark(int) with a read-ahead limit value. You can then read as many bytes as you want up to the limit value.
    If at any point you want to go back to the earlier position where you last called mark(), then you just call reset() and the stream will “revert” to an earlier state.
    In practice, it’s not actually putting the data back into the stream but storing the data that was already read into memory for you to read again.
    Therefore, you should not call the mark() operation with too large a value as this could take up a lot of memory.

    Assume that we have an InputStream instance whose next values are ABCD. Consider the following code snippet:

        InputStream is = . . .
        System.out.print ((char)is.read());

        if(is.markSupported()) {
            is.mark(100);
            System.out.print((char)is.read());
            System.out.print((char)is.read());
            is.reset();
        }

        System.out.print((char)is.read());
        System.out.print((char)is.read());
        System.out.print((char)is.read());

    The code snippet will output the following if the mark() operation is supported: ABCBCD

    It first outputs A before the if/then statement. Since we are given that the stream supports the mark() operation, it will enter the if/then statement and read two characters, BC.
    It then calls the reset() operation, moving our stream back to the state that it was in after the A was read, therefore BC are read again, followed by D.
    If the mark() operation is not supported, it will output this instead, skipping the if/then statement entirely:     ABCD

    Notice that regardless of whether the mark() operation was supported, we took care to have the stream end at the same position.
    Finally, if you call reset() after you have passed your mark() read limit, an exception may be thrown at runtime since the marked position may become invalidated.
    We say “an exception may be thrown” as some implementations may use a buffer to allow extra data to be read before the mark is invalidated.
     */
    }

    @Test
    public void D_Skipping_over_Data() {
    /*
    The InputStream and Reader classes also include a skip(long) method, which as you might expect skips over a certain number of bytes. It returns a long value, which indicates
    the number of bytes that were actually skipped. If the return value is zero or negative, such as if the end of the stream was reached, no bytes were skipped.
    Assume that we have an InputStream instance whose next values are TIGERS. Consider the following code snippet:

        InputStream is = . . .
        System.out.print ((char)is.read());
        is.skip(2)
        is.read();
        System.out.print((char)is.read());
        System.out.print((char)is.read());

    The code will read one character, T, skip two characters, IG, and then read three more characters, ERS, only the last two of which are printed to the user, which results in the following output.
        TRS

    You may notice in this example that calling the skip() operation is equivalent to calling read() and discarding the output.
    For skipping a handful of bytes, there is virtually no difference.
    On the other hand, for skipping a large number of bytes, skip() will often be faster, because it will use arrays to read the data.
     */
    }

}

