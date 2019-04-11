package ch1.advanced_class_design.F_working_with_Enums;

public class B_Using_enum_in_switch_statements {
    /*
    Enums may be used in switch statements. Pay attention to the case value in this code:
Season summer = Season.SUMMER;
switch (summer) {
case WINTER:
System.out.println("Get out the sled!");
break;
case SUMMER:
System.out.println("Time for the pool!");
break;
default:
System.out.println("Is it summer yet?");
}
The code prints "Time for the pool!" since it matches SUMMER. Notice that we
just typed the value of the enum rather than writing Season.WINTER. The reason is that
Java already knows that the only possible matches can be enum values. Java treats the
enum type as implied. In fact, if you were to type case Season.WINTER, it would not
compile. Keep in mind that an enum type is not an int. The following code does not
compile:
switch (summer) {
case 0: // DOES NOT COMPILE
System.out.println("Get out the sled!");
break;
}
You can’t compare an int with an enum. Pay special attention when working with enums
that they are used only as enums.
     */
}
