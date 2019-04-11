package ch1.advanced_class_design.F_working_with_Enums;

public class C_Add_constructors_fields_and_methods {
    /*
    Enums can have more in them than just values. It is common to give state to each
one. Our zoo wants to keep track of traffic patterns for which seasons get the most
visitors.
1: public enum Season {
2: WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
3: private String expectedVisitors;
4: private Season(String expectedVisitors) {
5: this.expectedVisitors = expectedVisitors;
6: }
7: public void printExpectedVisitors() {
8: System.out.println(expectedVisitors);
9: } ]
There are a few things to notice here. On line 2, we have a semicolon. This is required if
there is anything in the enum besides the values.
Lines 3–9 are regular Java code. We have an instance variable, a constructor, and a
method. The constructor is private because it can only be called from within the enum .
The code will not compile with a public constructor.
Calling this new method is easy:
Season.SUMMER.printExpectedVisitors();
Notice how we don’t appear to call the constructor. We just say that we want the enum
value. The fi rst time that we ask for any of the enum values, Java constructs all of the enum
values. After that, Java just returns the already‐constructed enum values. Given that explanation,
you can see why this code calls the constructor only once:
public enum OnlyOne {
ONCE (true);
private OnlyOne(boolean b) {
System. out .println("constructing");
}
public static void main(String[] args) {
OnlyOne firstCall = OnlyOne. ONCE ; // prints constructing
OnlyOne secondCall = OnlyOne. ONCE ; // doesn't print anything
} }
This technique of a constructor and state allows you to combine logic with the benefi t of
a list of values. Sometimes, you want to do more. For example, our zoo has different seasonal
hours. It is cold and gets dark early in the winter. We could keep track of the hours
through instance variables, or we can let each enum value manage hours itself:
public enum Season {
WINTER {
public void printHours() { System. out .println("9am-3pm"); }
}, SPRING {
public void printHours() { System. out .println("9am-5pm"); }
}, SUMMER {
public void printHours() { System. out .println("9am-7pm"); }
}, FALL {
public void printHours() { System. out .println("9am-5pm"); }
};
public abstract void printHours();
}
What’s going on here? It looks like we created an abstract class and a bunch of tiny subclasses.
In a way we did. The enum itself has an abstract method. This means that each and
every enum value is required to implement this method. If we forget one, we get a compiler error.
If we don’t want each and every enum value to have a method, we can create a default
implementation and override it only for the special cases:
public enum Season3 {
WINTER {
public void printHours() { System.out.println("short hours"); }
}, SUMMER {
public void printHours() { System.out.println("long hours"); }
}, SPRING, FALL;
public void printHours() { System.out.println("default hours"); }
}
This one looks better. We only code the special cases and let the others use the
enum‐provided implementation. Notice how we still have the semicolon after FALL. This is
needed when we have anything other than just the values. In this case, we have a default
method implementation.
Just because an enum can have lots of methods, doesn’t mean that it should. Try to keep
your enums simple. If your enum is more than a page or two, it is way too long. Most enums
are just a handful of lines. The main reason they get long is that when you start with a oneor
two‐line method and then declare it for each of your dozen enum types, it grows long.
When they get too long or too complex, it makes the enum hard to read.
     */
}
