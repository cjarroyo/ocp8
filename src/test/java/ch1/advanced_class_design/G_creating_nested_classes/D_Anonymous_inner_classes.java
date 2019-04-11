package ch1.advanced_class_design.G_creating_nested_classes;

public class D_Anonymous_inner_classes {
    /*
    An anonymous inner class is a local inner class that does not have a name. It is declared
and instantiated all in one statement using the new keyword. Anonymous inner classes are
required to extend an existing class or implement an existing interface. They are useful when
you have a short implementation that will not be used anywhere else. Here’s an example:
1: public class AnonInner {
2: abstract class SaleTodayOnly {
3: abstract int dollarsOff();
4: }
5: public int admission(int basePrice) {
6: SaleTodayOnly sale = new SaleTodayOnly() {
7: int dollarsOff() { return 3; }
8: };
9: return basePrice - sale.dollarsOff();
10: } }
Lines 2 through 4 define an abstract class. Lines 6 through 8 define the inner class.
Notice how this inner class does not have a name. The code says to instantiate a new
SaleTodayOnly object. But wait. SaleTodayOnly is abstract. This is OK because we
provide the class body right there—anonymously.
Pay special attention to the semicolon on line 8. We are declaring a local variable on
these lines. Local variable declarations are required to end with semicolons, just like other
Java statements—even if they are long and happen to contain an anonymous inner class.
Now we convert this same example to implement an interface instead of extending an
abstract class:
1: public class AnonInner {
2: interface SaleTodayOnly {
3: int dollarsOff();
4: }
5: public int admission(int basePrice) {
6: SaleTodayOnly sale = new SaleTodayOnly() {
7: public int dollarsOff() { return 3; }
8: };
9: return basePrice - sale.dollarsOff();
10: } }
The most interesting thing here is how little has changed. Lines 2 through 4 declare an
interface instead of an abstract class. Line 7 is public instead of using default access
since interfaces require public methods. And that is it. The anonymous inner class is the
same whether you implement an interface or extend a class! Java figures out which one
you want automatically.
But what if we want to implement both an interface and extend a class? You can’t with
an anonymous inner class, unless the class to extend is java.lang.Object. Object is a special
class, so it doesn’t count in the rule. Remember that an anonymous inner class is just
an unnamed local inner class. You can write a local inner class and give it a name if you
have this problem. Then you can extend a class and implement as many interfaces as you
like. If your code is this complex, a local inner class probably isn’t the most readable option
anyway.
There is one more thing that you can do with anonymous inner classes. You can
define them right where they are needed, even if that is an argument to another
method:
1: public class AnonInner {
2: interface SaleTodayOnly {
3: int dollarsOff();
4: }
5: public int pay() {
6: return admission(5, new SaleTodayOnly() {
7: public int dollarsOff() { return 3; }
8: });
9: }
10: public int admission(int basePrice, SaleTodayOnly sale) {

11: return basePrice - sale.dollarsOff();
12: }}
Lines 6 through 8 are the anonymous inner class. We don’t even store it in a local
variable. Instead, we pass it directly to the method that needs it. Reading this style of code
does take some getting used to. But it is a concise way to create a class that you will use
only once.
Before you get too attached to anonymous inner classes, know that you’ll see a shorter
way of coding them in Chapter 4, “Functional Programming.”


Inner Classes as Event Handlers
==========================
Writing graphical user interface code isn’t on the exam. Nonetheless, it is a very common
use of inner classes, so we’ll give you a taste of it here:
JButton button = new JButton("red");
button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
// handle the button click
}
});
This technique gives the event handler access to the instance variables in the class with
which it goes. It works well for simple event handling.
You should be aware that inner classes go against some fundamental concepts, such as
reuse of classes and high cohesion (discussed in the next chapter). Therefore, make sure
that inner classes make sense before you use them in your code.


     */
}
