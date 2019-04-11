package ch1.advanced_class_design.F_working_with_Enums;

public class A_Working_with_enums {
    /*
    In programming, it is common to have a type that can only have a finite set of values. An
enumeration is like a fixed set of constants. In Java, an enum is a class that represents an
enumeration. It is much better than a bunch of constants because it provides type‐safe
checking. With numeric constants, you can pass an invalid value and not find out until
runtime. With enums, it is impossible to create an invalid enum type without introducing a
compiler error.
Enumerations show up whenever you have a set of items whose types are known at compile
time. Common examples are the days of the week, months of the year, the planets in
the solar system, or the cards in a deck. Well, maybe not the planets in a solar system, given
that Pluto had its planetary status revoked.
To create an enum, use the enum keyword instead of the class keyword. Then list all of
the valid types for that enum.
public enum Season {
WINTER, SPRING, SUMMER, FALL
}
Since an enum is like a set of constants, use the uppercase letter convention that you used
for constants.
Behind the scenes, an enum is a type of class that mainly contains static members. It
also includes some helper methods like name() that you will see shortly. Using an enum is
easy:
Season s = Season.SUMMER;
System.out.println(Season.SUMMER); // SUMMER
System.out.println(s == Season.SUMMER); // true
As you can see, enums print the name of the enum when toString() is called. They are
also comparable using == because they are like static final constants.
An enum provides a method to get an array of all of the values. You can use this like any
normal array, including in a loop:
for(Season season: Season.values()) {
System.out.println(season.name() + " " + season.ordinal());
}
The output shows that each enum value has a corresponding int value in the order in
which they are declared. The int value will remain the same during your program, but the
program is easier to read if you stick to the human‐readable enum value.
WINTER 0
SPRING 1
SUMMER 2
FALL 3
You can’t compare an int and enum value directly anyway. Remember that an enum is a
type and not an int.
if ( Season.SUMMER == 2) {} // DOES NOT COMPILE
You can also create an enum from a String. This is helpful when working with older
code. The String passed in must match exactly, though.
Season s1 = Season.valueOf("SUMMER"); // SUMMER
Season s2 = Season.valueOf("summer"); // exception
The first statement works and assigns the proper enum value to s1. The second statement
encounters a problem. There is no enum value with the lowercase name “summer.” Java
throws up its hands in defeat and throws an IllegalArgumentException.
Exception in thread "main" java.lang.IllegalArgumentException: No enum constant
enums.Season.summer
Another thing that you can’t do is extend an enum.
public enum ExtendedSeason extends Season { } // DOES NOT COMPILE
The values in an enum are all that are allowed. You cannot add more at runtime by
extending the enum.
Now that we’ve covered the basics, we look at using enums in switch statements and
how to add extra functionality to enums.
     */
}
