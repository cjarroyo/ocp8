package ch1.advanced_class_design.A_reviewing_oca_concepts;

public class D_Static_and_final {

    /*

    Next on the review list are the static and final modifiers. To which lines in the following
code could you independently add static and/or final without introducing a compiler
error?
1: abstract class Cat {
2: String name = "The Cat";
3: void clean() { }
4: }
5: class Lion extends Cat {
6: void clean() { }
7: }
Both static and final can be added to line 2. This allows the variable to be accessed
as Cat.name and prevents it from being changed. static cannot be added to line 3 or 6
independently because the subclass overrides it. It could be added to both, but then you
wouldn’t be inheriting the method. The final keyword cannot be added to line 3 because
the subclass method would no longer be able to override it. final can be added to line 6
since there are no subclasses of Lion.
To review, final prevents a variable from changing or a method from being overridden.
static makes a variable shared at the class level and uses the class name to refer to a
method.
static and final are allowed to be added on the class level too. You will see static
classes in the section on nested classes at the end of this chapter, so don’t worry if you didn’t
pick up on those. Using final on a class means that it cannot be subclassed. As with methods,
a class cannot be both abstract and final. In the Java core classes, String is final.

     */
}
