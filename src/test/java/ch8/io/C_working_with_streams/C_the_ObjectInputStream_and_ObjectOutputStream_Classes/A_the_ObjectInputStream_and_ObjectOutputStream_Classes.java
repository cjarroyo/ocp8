package ch8.io.C_working_with_streams.C_the_ObjectInputStream_and_ObjectOutputStream_Classes;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
    Throughout this book, we have been managing our data model using classes, so it makes sense that we would want to write these objects to disk.
    The process of converting an in-memory object to a stored data format is referred to as serialization , with the reciprocal process of converting stored data into an object, which is known as deserialization .
    In this section, we will show you how Java provides built-in mechanisms for serializing and deserializing streams of objects directly to and from disk, respectively.
     */

/*******
 Although understanding serialization is important for using ObjectInputStream and ObjectOutputStream , we should mention that Oracle has a long history of adding and removing serialization from the list of exam objectives.
 Please check the latest list of objectives prior to taking the exam to determine if it is present.
 */

public class A_the_ObjectInputStream_and_ObjectOutputStream_Classes {

    @Test
    public void A_The_Serializable_Interface() {
        /*
        In order to serialize objects using the java.io API, the class they belong to must implement
the java.io.Serializable interface. The Serializable interface is a tagging or marker
interface, which means that it does not have any methods associated with it. Any class can
implement the Serializable interface since there are no required methods to implement.
The purpose of implementing the Serializable interface is to inform any process
attempting to serialize the object that you have taken the proper steps to make the object
serializable, which involves making sure that the classes of all instance variables within
the object are also marked Serializable . Many of the built-in Java classes that you have
worked with throughout this book, including the String class, are marked Serializable .
This means that many of the simple classes that we have built throughout this book can be
marked Serializable without any additional work.
         */
        /*******
         Note that the requirement for properly marking an object as Serializable
         may involve nested objects. For example, if a Cat class is marked as
         Serializable and contains a reference to a Tail object, then the class
         definition for the Tail object must also be marked as Serializable .
         Therefore, any object references contained within the Tail class must
         belong to classes that are also marked as Serializable , and so on.
         */

/*
A process attempting to serialize an object will throw a NotSerializableException
if the class or one of its contained classes does not properly implement the Serializable
interface. Let’s say that you have a particular object within a larger object that is not
serializable, such as one that stores temporary state or metadata information about
the larger object. You can use the transient keyword on the reference to the object,
which will instruct the process serializing the object to skip it and avoid throwing a
NotSerializableException . The only limitation is that the data stored in the object will be
lost during the serialization process.
Besides transient instance variables, static class members will also be ignored during
the serialization and deserialization process. This should follow logically, as static class
variables do not belong to one particular instance. If you need to store static class information,
it will be need to be copied to an instance object and serialized separately.
 */
/********why not mark every Class as Serializable ?
 * =============================================
 You might be wondering why we don’t just mark every class with the Serializable
 interface since there is no cost to doing so. The reason that we do not is that there
 are some classes that we want to instruct the JVM not to serialize. In particular,
 process-heavy classes such as the Thread class or any of the Stream classes would be
 diffi cult, often impossible, to save to persistent storage, since much of their work involves
 managing JVM processes or resources in real time.
 By refraining from marking a class as Serializable, we are actively encouraging
 developers using it within their Serializable object either to make the reference to
 the class a local variable or, if they choose to include it in their class definition, to make
 sure that they mark it as transient, so that they realize the contents of the object will
 not be saved when the larger object is serialized.
 ========================================

 The following program is an example of our Animal class that implements a
 Serializable properly:
 */

    }

}


class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private char type;

    public Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getType() {
        return type;
    }

    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
    }
}
/*
All that was required to make our previous Animal class serializable in Java was to add
implements Serializable to the class definition. Notice that we also added a variable
called serialVersionUID. Although this is certainly not required as part of implementing
the Serializable interface, it is considered a good practice to do so and update this static
class variable anytime you modify the class.
This serialVersionUID is stored with the serialized object and assists during the deserialization
process. The serialization process uses the serialVersionUID to identify uniquely
a version of the class. That way, it knows whether the serialized data for an object will
match the instance variable in the current version of the class. If an older version of the
class is encountered during deserialization, an exception may be thrown. Alternatively,
some deserialization tools support conversions automatically.
 */

/********
 Maintaining a Serial UID
 =======================
 We recommend that you do not rely on the generated serialVersionUID provided by the
 Java compiler and that you explicitly declare one in each of your Serializable classes.
 Different Java compiler versions across different platforms may differ in their implementation
 of the generated serialVersionUID.
 For example, you may end up with different serial ID values for the same class, if you
 are working with the Oracle implementation of Java 8 on a Windows platform versus
 a colleague using the OpenJDK Java 6 product on a Linux platform. This would lead to
 class incompatibility issues when deserializing the data, even though the data format
 is actually the same. Therefore, it is recommended that you provide and manage the
 serialVersionUID in all of your Serializable classes, updating it anytime the instance
 variables in the class are changed.
 ========================*/

/*
 public void B_Serializing_and_Deserializing_ Objects(){
     The java.io API provides two stream classes for object serialization and deserialization
    called ObjectInputStream and ObjectOutputStream.
    The ObjectOutputStream class includes a method to serialize the object to the stream
    called void writeObject(Object). If the provided object is not Serializable, or
    it contains an embedded reference to a class that is not Serializable or not marked
    transient, a NotSerializableException will be thrown at runtime.
    For the reciprocal process, the ObjectInputStream class includes a deserialization
    method that returns an object called readObject(). Notice that the return type of this
    method is the generic type java.lang.Object, indicating that the object will have to be cast
    explicitly at runtime to be used.
    We now provide a sample program that reads and writes Animal data objects:
 }
*/


class ObjectStreamSample {
    public static List<Animal> getAnimals(File dataFile) throws IOException,
            ClassNotFoundException {
        List<Animal> animals = new ArrayList<Animal>();
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof Animal)
                    animals.add((Animal) object);
            }
        } catch (EOFException e) {
// File end reached
        }
        return animals;
    }

    public static void createAnimalsFile(List<Animal> animals, File dataFile)
            throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Animal animal : animals)
                out.writeObject(animal);
        }
    }

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("Tommy Tiger", 5, 'T'));
        animals.add(new Animal("Peter Penguin", 8, 'P'));
        File dataFile = new File("animal.data");
        createAnimalsFile(animals, dataFile);
        System.out.println(getAnimals(dataFile));
    }
}

/*
From a high-level, the program first creates a list of Animal objects in memory that
includes two Animal instances. It then writes the list data into memory to an animal.data
file saved in the current working directory. Finally, it reads the data from the file
and outputs the following text:
[Animal [name=Tommy Tiger, age=5, type=T], Animal [name=Peter Penguin, age=8,
type=P]]
For performance reasons, we wrap each low-level file stream with a Buffered stream
and then chain the result to an Object stream. The createAnimalsFile() method should
be somewhat straightforward since we are just iterating over the List object and serializing
each Animal object to disk using the writeObject() method.
The getAnimals() method is a little more complex, as we must take special care to
deserialize the objects from disk. First, we need to check that the object we are reading is
actually an instance of the Animal class before explicitly casting it, or else we might get a
ClassCastException at runtime. In practice, we may want to throw an exception or log
additional details if we encounter a class type that we did not expect.
Next, the readObject() throws the checked exception, ClassNotFoundException, since
the class of the deserialized object may not be available to the JRE. Therefore, we need to
catch the exception or rethrow in our method signatures; in this case, we chose the latter.
Finally, since we are reading objects, we can’t use a -1 integer value to determine when
we have finished reading a file. Instead, the proper technique is to catch an EOFException,
which marks the program encountering the end of the file. Notice that we don’t do anything
with the exception other than finish the method. This is one of the few times when it
is perfectly acceptable to swallow an exception.
 */