package ch1.advanced_class_design.G_creating_nested_classes;

public class B_Members_inner_classes {
    /*
    A member inner class is defined at the member level of a class (the same level as the methods,
instance variables, and constructors). Member inner classes have the following properties:
■■ Can be declared public, private, or protected or use default access
■■ Can extend any class and implement interfaces
■■ Can be abstract or final
■■ Cannot declare static fields or methods
■■ Can access members of the outer class including private members
The last property is actually pretty cool. It means that the inner class can access the
outer class without doing anything special. Ready for a complicated way to print “Hi”
three times?
1: public class Outer {
2: private String greeting = "Hi";
3:
4: protected class Inner {
5: public int repeat = 3;
6: public void go() {
7: for (int i = 0; i < repeat; i++)
8: System.out.println(greeting);
9: }
10: }
11:
12: public void callInner() {
13: Inner inner = new Inner();
14: inner.go();
15: }
16: public static void main(String[] args) {
17: Outer outer = new Outer();
18: outer.callInner();
19: } }
A member inner class declaration looks just like a stand‐alone class declaration except
that it happens to be located inside another class—oh, and that it can use the instance variables
declared in the outer class. Line 8 shows that the inner class just refers to greeting
as if it were available. This works because it is in fact available. Even though the variable is
private, it is within that same class.
Since a member inner class is not static, it has to be used with an instance of the outer
class. Line 13 shows that an instance of the outer class can instantiate Inner normally. This
works because callInner() is an instance method on Outer. Both Inner and callInner()
are members of Outer. Since they are peers, they just write the name.
There is another way to instantiate Inner that looks odd at first. OK, well maybe not
just at first. This syntax isn’t used often enough to get used to it:
20: public static void main(String[] args) {
21: Outer outer = new Outer();
22: Inner inner = outer.new Inner(); // create the inner class
23: inner.go();
24: }
Let’s take a closer look at line 22. We need an instance of Outer in order to create Inner.
We can’t just call new Inner() because Java won’t know with which instance of Outer it is
associated. Java solves this by calling new as if it were a method on the outer variable.

.class Files for Inner Classes
=====================
Compiling the Outer.java class with which we have been working creates two class
files. Outer.class you should be expecting. For the inner class, the compiler creates
Outer$Inner.class. You don’t need to know this syntax for the exam. We mention it so
that you aren’t surprised to see files with $ appearing in your directories. You do need to
understand that multiple class files are created.
===================

Inner classes can have the same variable names as outer classes. There is a special way of
calling this to say which class you want to access. You also aren’t limited to just one inner
class. Please never do this in code you write. Here is how to nest multiple classes and access
a variable with the same name in each:
1: public class A {
2: private int x = 10;
3: class B {
4: private int x = 20;
5: class C {
6: private int x = 30;
7: public void allTheX() {
8: System.out.println(x); // 30
9: System.out.println(this.x); // 30
10: System.out.println(B.this.x); // 20
11: System.out.println(A.this.x); // 10

12: } } }
13: public static void main(String[] args) {
14: A a = new A();
15: A.B b = a.new B();
16: A.B.C c = b.new C();
17: c.allTheX();
18: }}
Yes, this code makes us cringe too. It has two nested classes. Line 14 instantiates the outermost
one. Line 15 uses the awkward syntax to instantiate a B. Notice the type is A.B. We
could have written B as the type because that is available at the member level of B. Java knows
where to look for it. On line 16, we instantiate a C. This time, the A.B.C type is necessary to
specify. C is too deep for Java to know where to look. Then line 17 calls a method on c.
Lines 8 and 9 are the type of code that we are used to seeing. They refer to the instance variable
on the current class—the one declared on line 6 to be precise. Line 10 uses this in a special
way. We still want an instance variable. But this time we want the one on the B class, which is
the variable on line 4. Line 11 does the same thing for class A, getting the variable from line 2.


Private Interfaces
============
This following code looks weird but is legal:
public class CaseOfThePrivateInterface {
private interface Secret {
public void shh();
}
class DontTell implements Secret {
public void shh() { }
} }
The rule that all methods in an interface are public still applies. A class that implements
the interface must define that method as public.
The interface itself does not have to be public, though. Just like any inner class, an inner
interface can be private. This means that the interface can only be referred to within the
current outer class.
=============

     */
}
