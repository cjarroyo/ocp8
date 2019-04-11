package ch1.advanced_class_design.G_creating_nested_classes;

public class C_Local_inner_classes {
    /*
    A local inner class is a nested class defined within a method. Like local variables, a local
inner class declaration does not exist until the method is invoked, and it goes out of scope
when the method returns. This means that you can create instances only from within the
method. Those instances can still be returned from the method. This is just how local variables
work. Local inner classes have the following properties:
■ They do not have an access specifier.
■ They cannot be declared static and cannot declare s tatic fields or methods.
■ They have access to all fields and methods of the enclosing class.
■ They do not have access to local variables of a method unless those variables are final
or effectively final. More on this shortly.
Ready for an example? Here’s a complicated way to multiply two numbers:
1: public class Outer {
2: private int length = 5;
3: public void calculate() {
4: final int width = 20;
5: class Inner {
6: public void multiply() {
7: System. out .println(length * width);
8: }
9: }
10: Inner inner = new Inner();
11: inner.multiply();
12: }
13: public static void main(String[] args) {
14: Outer outer = new Outer();
15: outer.calculate();
16: }
17: }
Lines 5 through 9 are the local inner class. That class’s scope ends on line 12 where the
method ends. Line 7 refers to an instance variable and a fi nal local variable, so both variable
references are allowed from within the local inner class.
Earlier, we made the statement that local variable references are allowed if they are final
or effectively fi nal. Let’s talk about that now. The compiler is generating a class fi le from your
inner class. A separate class has no way to refer to local variables. If the local variable is final ,
Java can handle it by passing it to the constructor of the inner class or by storing it in the class
fi le. If it weren’t effectively fi nal, these tricks wouldn’t work because the value could change
after the copy was made. Up until Java 7, the programmer actually had to type the final
keyword. In Java 8, the “effectively fi nal” concept was introduced. If the code could still compile
with the keyword final inserted before the local variable, the variable is effectively fi nal.
Which of the variables do you think are effectively final in this code?
34: public void isItFinal() {
35: int one = 20;
36: int two = one;
37: two++;
38: int three;
39: if ( one == 4) three = 3;
40: else three = 4;
41: int four = 4;
42: class Inner { }
43: four = 5;
44: }
one is effectively final. It is only set in the line in which it is declared. two is not effectively
final. The value is changed on line 37 after it is declared. three is effectively final
because it is assigned only once. This assignment may happen in either branch of the if
statement, but it can happen in only one of them. four is not effectively final. Even though
the assignment happens after the inner class, it is not allowed.
     */
}
