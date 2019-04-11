package ch1.advanced_class_design.B_using_instanceof;

public class A_Using_instanceof {
    /*
    Now we move on to the new topics. On the OCA, you learned about many operators
including < and ==. Now it is time to learn another: instanceof.
In a instanceof B, the expression returns true if the reference to which a points is an
instance of class B, a subclass of B (directly or indirectly), or a class that implements the B
interface (directly or indirectly).
Let’s see how this works. You have three classes with which to work:
class HeavyAnimal { }
class Hippo extends HeavyAnimal { }
class Elephant extends HeavyAnimal { }
You see that Hippo is a subclass of HeavyAnimal but not Elephant. Remember that the
exam starts with line numbers other than 1 when showing a code snippet. This is to tell
you that you can assume the correct code comes before what you see. You can assume any
missing code is correct and all imports are present.
12: HeavyAnimal hippo = new Hippo();
13: boolean b1 = hippo instanceof Hippo; // true
14: boolean b2 = hippo instanceof HeavyAnimal; // true
15: boolean b3 = hippo instanceof Elephant; // false
On line 13, you see that hippo is an instance of itself. We’d certainly hope so! Line
14 returns true because hippo is an instance of its superclass. Line 15 returns false
because hippo is not an Elephant. The variable reference is HeavyAnimal, so there could
be an Elephant in there. At runtime, Java knows that the variable is in fact pointing to
a Hippo.
All Java classes inherit from Object, which means that x instanceof Object is usually
true, except for one case where it is false. If the literal null or a variable reference pointing
to null is used to check instanceof, the result is false. null is not an Object. For example:
26: HeavyAnimal hippo = new Hippo();
27: boolean b4 = hippo instanceof Object; // true
28: Hippo nullHippo = null;
29: boolean b5 = nullHippo instanceof Object; // false
Line 27 returns true because Hippo extends from Object indirectly as do all classes.
Line 29 returns false because the nullHippo variable reference points to null and null is
not a Hippo. This next one is interesting:
30: Hippo anotherHippo = new Hippo();
31: boolean b5 = anotherHippo instanceof Elephant; // DOES NOT COMPILE
Line 31 is a tricky one. The compiler knows that there is no possible way for a Hippo
variable reference to be an Elephant, since Hippo doesn’t extend Elephant directly or
indirectly.
The compilation check only applies when instanceof is called on a class. When checking
whether an object is an instanceof an interface, Java waits until runtime to do the
check. The reason is that a subclass could implement that interface and the compiler
wouldn’t know it. There is no way for Hippo to be a subclass of Elephant.
For example, suppose that you have an interface Mother and Hippo does not implement it:
public interface Mother {}
class Hippo extends HeavyAnimal { }
This code compiles:
42: HeavyAnimal hippo = new Hippo();
43: boolean b6 = hippo instanceof Mother;
It so happens that Hippo does not implement Mother. The compiler allows the statement
because there could later be a class such as this:
class MotherHippo extends Hippo implements Mother { }
The compiler knows an interface could be added, so the instanceof statement could be
true for some subclasses, whereas there is no possible way to turn a Hippo into an Elephant.
The instanceof operator is commonly used to determine if an instance is a subclass of
a particular object before applying an explicit cast. For example, consider a method that
takes as input an Animal reference and performs an operation based on that animal’s type:
public void feedAnimal(Animal animal) {
if(animal instanceof Cow) {
((Cow)animal).addHay();
} else if(animal instanceof Bird) {
((Bird)animal).addSeed();
} else if(animal instanceof Lion) {
((Lion)animal).addMeat();
} else {
throw new RuntimeException("Unsupported animal");
} }
In this example, you needed to know if the animal was an instance of each subclass
before applying the cast and calling the appropriate method. For example, a Bird or
Lion probably will not have an addHay() method, a Cow or Lion probably will not have
an addSeed() method, and so on. The else throwing an exception is common. It allows
the code to fail when an unexpected Animal is passed in. This is a good thing. It tells the
programmer to fix the code rather than quietly letting the new animal go hungry.
This is not a good way to write code. instanceof and the practice of casting with if statements
is extremely rare outside of the exam. It is mostly used when writing a library that will be
used by many others. On the exam, you need to understand how instanceof works though.
     */
}
