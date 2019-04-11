package ch1.advanced_class_design.E_coding_equals_hashcode_and_toString;

public class A_ToString {
    /*
    When studying for the OCA, we learned that Java automatically calls the toString()
method if you try to print out an object. We also learned that some classes supply a humanreadable
implementation of toString() and others do not. When running the following
example, we see one of each:
public static void main(String[] args) {
System.out.println(new ArrayList()); // []
System.out.println(new String[0]); // [Ljava.lang.String;@65cc892e
}
ArrayList provided an implementation of toString() that listed the contents of the
ArrayList, in this case, an empty ArrayList. (If you want to be technical about it, a superclass
of ArrayList implemented toString() and ArrayList inherited that one instead of
the one in Object, whereas the array used the default implementation from Object.) You
don’t need to know that for the exam, though.
Clearly, providing nice human‐readable output is going to make things easier for developers
working with your code. They can simply print out your object and understand what it
represents. Luckily, it is easy to override toString() and provide your own implementation.
Let’s start with a nice, simple example:
public class Hippo {
private String name;
private double weight;
public Hippo(String name, double weight) {
this.name = name;
this.weight = weight;
}
@Override
public String toString() {
return name;
}
public static void main(String[] args) {
Hippo h1 = new Hippo("Harry", 3100);
System.out.println(h1); // Harry
} }
Now when we run this code, it prints Harry. Granted that we have only one Hippo, so it
isn’t hard to keep track of this! But when the zoo later gets a whole family of hippos, it will
be easier to remember who is who.
When you implement the toString() method, you can provide as much or as little information
as you would like. In this example, we use all of the instance variables in the object:
public String toString() {
return "Name: " + name + ", Weight: " + weight;
}

The Easy Way to Write toString() Methods
=======================
Once you’ve written a toString() method, it starts to get boring to write more—especially
if you want to include a lot of instance variables. Luckily, there is an open source library that
takes care of it for you. Apache Commons Lang (http://commons.apache.org/proper/
commons-lang/) provides some methods that you might wish were in core Java.
This is all you have to write to have Apache Commons return all of the instance variables
in a String:
public String toString() {
return ToStringBuilder.reflectionToString(this);
}
Calling our Hippo test class with this toString() method outputs something like
toString.Hippo@12da89a7[name=Harry,weight=3100.0]. You might be wondering what
this reflection thing is that is mentioned in the method name. Reflection is a technique
used in Java to look at information about the class at runtime. This lets the ToString-
Builder class determine what are all of the instance variables and to construct a
String with each.
When testing your code, there is a benefit to not having information in toString()
that isn’t useful to your caller (12da89a7). Apache Commons accounts for this as well.
You can write
@Override public String toString() {
return ToStringBuilder.reflectionToString(this,
ToStringStyle.SHORT_PREFIX_STYLE);
}
This time our Hippo test class outputs Hippo[name=Harry,weight=3100.0]. There
are a few other styles that support letting you choose to omit the class names or the
instance variable names.
     */
}
