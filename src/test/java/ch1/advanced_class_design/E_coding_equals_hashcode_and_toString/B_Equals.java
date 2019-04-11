package ch1.advanced_class_design.E_coding_equals_hashcode_and_toString;

public class B_Equals {

    /*

    Remember that Java uses == to compare primitives and for checking if two variables refer
to the same object. Checking if two objects are equivalent uses the equals() method, or at
least it does if the developer implementing the method overrides equals(). In this example,
you can see that only one of the two classes provides a custom implementation of equals():
String s1 = new String("lion");
String s2 = new String("lion");
System.out.println(s1.equals(s2)); // true
StringBuilder sb1 = new StringBuilder("lion");
StringBuilder sb2 = new StringBuilder("lion");
System.out.println(sb1.equals(sb2)); // false
String does have an equals() method. It checks that the values are the same.
StringBuilder uses the implementation of equals() provided by Object, which simply
checks if the two objects being referred to are the same.
There is more to writing your own equals() method than there was to writing
toString(). Suppose the zoo gives every lion a unique identification number. The following
Lion class implements equals() to say that any two Lion objects with the same ID are the
same Lion:
1: public class Lion {
2: private int idNumber;
3: private int age;
4: private String name;
5: public Lion(int idNumber, int age, String name) {
6: this.idNumber = idNumber;
7: this.age = age;
8: this.name = name;
9: }
10: @Override public boolean equals(Object obj) {
11: if ( !(obj instanceof Lion)) return false;
12: Lion otherLion = (Lion) obj;
13: return this.idNumber == otherLion.idNumber;
14: }
15: }
First, pay attention to the method signature on line 10. It takes an Object as the method
parameter rather than a Lion. Line 11 checks whether a cast would be allowed. You get to use
the new instanceof operator that you just learned! There is no way that a Lion is going to be
equal to a String. The method needs to return false when this occurs. If you get to line 12, a
cast is OK. Then line 13 checks whether the two objects have the same identification number.
The this. syntax is not required. Line 12 could have been return idNumber == other-
Lion.idNumber. Many programmers explicitly code this. to be explicit about the object
being referenced.

The Contract for equals() Methods
==========================


Since equals() is such a key method, Java provides a number of rules in the contract for
the method. The exam expects you to recognize correct and incorrect equals() methods,
but it will not ask you to name which property is broken. That said, it is helpful to have
seen it at least once.
The equals() method implements an equivalence relation on non‐null object references:
■■ It is reflexive: For any non‐null reference value x, x.equals(x) should return true.
■■ It is symmetric: For any non‐null reference values x and y, x.equals(y) should return
true if and only if y.equals(x) returns true.
■■ It is transitive: For any non‐null reference values x, y, and z, if x.equals(y) returns
true and y.equals(z) returns true, then x.equals(z) should return true.
■■ It is consistent: For any non‐null reference values x and y, multiple invocations of
x.equals(y) consistently return true or consistently return false, provided no
information used in equals comparisons on the objects is modified.
■■ For any non‐null reference value x, x.equals(null) should return false.
Much of this is common sense. The definition of equality doesn’t change at random,
and the same objects can’t be equal “sometimes.” The most interesting rule is the last
one. It should be obvious that an object and null aren’t equal. The key is that equals()
needs to return false when this occurs rather than throw a NullPointerException.
===================

For practice, can you see what is wrong with this equals() method?
public boolean equals(Lion obj) {
if (obj == null) return false;
return this.idNumber == obj.idNumber;
}
There is actually nothing wrong with this method. It is a perfectly good method.
However, it does not override equals() from Object. It overloads that method, which is
probably not what was intended.

The Easy Way to Write equals() Methods
===========================
Like toString(), you can use Apache Commons Lang to do a lot of the work for you. If
you want all of the instance variables to be checked, your equals() method can be one
line:
public boolean equals(Object obj) {
return EqualsBuilder.reflectionEquals(this, obj);
}
This is nice. However, for equals(), it is common to look at just one or two instance variables
rather than all of them.
public boolean equals(Object obj) {
if ( !(obj instanceof LionEqualsBuilder)) return false;
Lion other = (Lion) obj;
return new EqualsBuilder().appendSuper(super.equals(obj))
.append(idNumber, other.idNumber)
.append(name, other.name)
.isEquals();
}
Not quite as elegant, right? You have to remember to handle the null and instanceof
guard conditions first. It is still better than having to code the whole thing by hand,
though. Comparing the idNumber is easy because you can call ==. Comparing the name
means checking that either both names are null or the names are the same. If either
name is null, you need to return false. This logic is a bit messy if you write it out by
hand.
     */
}
