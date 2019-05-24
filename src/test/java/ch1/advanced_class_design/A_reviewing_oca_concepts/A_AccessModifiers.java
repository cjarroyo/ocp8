package ch1.advanced_class_design.A_reviewing_oca_concepts;

import ch1.advanced_class_design.A_reviewing_oca_concepts.cat.BigCat;
import ch1.advanced_class_design.A_reviewing_oca_concepts.cat.species.Lynx;

public class A_AccessModifiers {
/*
First up on the review are the access modifiers public, protected, and private and default access.
Imagine the following method exists. For now, just remember the instance variables it tries to access:
*/

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name); //compiles in all four classes because any code can access public members.
        //System.out.println(cat.hasFur); //also compiles only in BigCat and CatAdmirer.
        //System.out.println(cat.hasPaws); //compiles only in BigCat and CatAdmirer because only code in the same package can access code with default access.
        //System.out.println(cat.id); compiles only in BigCat because only code in the same class can access private members.
    }
}

/*
Now, suppose each of these classes has this main method that instantiates a BigCat and tries to print out all four variables.
Which variables will be allowed in each case?

Think about it for a minute—no really. Pause and try to answer. Ready now? While this code compiles for BigCat, it doesn’t in all of the classes.

Finally, the line with cat.hasFur also compiles only in BigCat and CatAdmirer. protected
allows subclasses and code in the same package to access members. Lynx is a tricky one.
Since the code is being accessed via the variable rather than by inheritance, it does not benefit from protected.
However, if the code in main was
    Lynx cat = new Lynx(); , Lynx would be able to access cat.hasFur using protected access because it would be seen as a subclass.

Table 1.1 Access modifiers

Can access          If that member is private?         If that member has default (package private) access?     If that member is protected?        If that member is public?
=============================================================================================================================================================================

Member in the               yes                                                 yes                                         yes                             yes
same class

Member in                   no                                                  yes                                         yes                             yes
another class in
the same package

Member in a                 no                                                  no                                          yes                             yes
superclass in a
different package

Method/field in a           no                                                  no                                          no                              yes
class (that is not
a superclass) in a
different package

*/