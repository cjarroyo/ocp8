package ch1.advanced_class_design.A_reviewing_oca_concepts;

public class B_Overloading_and_overriding {
/*
Next we review the differences between overloading and overriding. Which method(s) in BobcatKitten overload or override the one in Bobcat?

1: public class Bobcat {
2:      public void findDen() { }
3: }
1: public class BobcatKitten extends Bobcat {
2:      public void findDen() { }
3:      public void findDen(boolean b) { }
4:      public int findden() throws Exception { return 0; }
5: }


The one on line 2 is an override because it has the same method signature.
The one on line 3 is an overloaded method because it has the same method name but a different parameter list.
The one on line 4 is not an override or overload because it has a different method name.
Remember that Java is case sensitive.
To review, overloading and overriding happen only when the method name is the same.

Further, overriding occurs only when the method signature is the same. The method signature is the method name and the parameter list.

For overloading, the method parameters must vary by type and/or number.
When multiple overloaded methods are present, Java looks for the closest match first. It tries to find the following:
- Exact match by type
- Matching a superclass type
- Converting to a larger primitive type
- Converting to an autoboxed type
- Varargs

For overriding, the overridden method has a few rules:
- The access modifier must be the same or more accessible.
- The return type must be the same or a more restrictive type, also known as covariant return types.
- If any checked exceptions are thrown, only the same exceptions or subclasses of those exceptions are allowed to be thrown.

The methods must not be static. (If they are, the method is hidden and not overridden.)

*/
}
