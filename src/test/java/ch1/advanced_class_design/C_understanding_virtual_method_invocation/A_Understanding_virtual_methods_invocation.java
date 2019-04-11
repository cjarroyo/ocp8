package ch1.advanced_class_design.C_understanding_virtual_method_invocation;

public class A_Understanding_virtual_methods_invocation {

    /*

    You just saw a poor way of feeding some animals. A better way would be to make each
Animal know how to feed itself. Granted this won’t work in the real world, but there could
be a sign in each animal habitat or the like.
abstract class Animal {
public abstract void feed(); }
}
class Cow extends Animal {
public void feed() { addHay(); }
private void addHay() { }
}
class Bird extends Animal {
public void feed() { addSeed(); }
private void addSeed() { }
}
class Lion extends Animal {
public void feed() { addMeat(); }
private void addMeat() { }
}
The Animal class is abstract, and it requires that any concrete Animal subclass have
a feed() method. The three subclasses that we defined have a one‐line feed() method
that delegates to the class‐specific method. A Bird still gets seed, a Cow still gets hay, and
so forth. Now the method to feed the animals is really easy. We just call feed() and the
proper subclass’s version is run.
This approach has a huge advantage. The feedAnimal() method doesn’t need to change
when we add a new Animal subclass. We could have methods to feed the animals all over
the code. Maybe the animals get fed at different times on different days. No matter. feed()
still gets called to do the work.
public void feedAnimal(Animal animal) {
animal.feed();
}
We’ve just relied on virtual method invocation. We actually saw virtual methods on the
OCA. They are just regular non‐static methods. Java looks for an overridden method rather
than necessarily using the one in the class that the compiler says we have. The only thing
new about virtual methods on the OCP is that Oracle now calls them virtual methods in
the objectives. You can simply think of them as methods.
In the above example, we have an Animal instance, but Java didn’t call feed on the
Animal class. Instead Java looked at the actual type of animal at runtime and called feed
on that.
Notice how this technique is called virtual method invocation. Instance variables don’t
work this way. In this example, the Animal class refers to name. It uses the one in the superclass
and not the subclass.
abstract class Animal {
String name = "???";
public void printName() {
System.out.println(name);
}
}
class Lion extends Animal {
String name = "Leo";
}
public class PlayWithAnimal {
public static void main(String... args) {
Animal animal = new Lion();
animal.printName();
}
}
This outputs ???. The name declared in Lion would only be used if name was referred to
from Lion (or a subclass of Lion.) But no matter how you call printName(), it will use the
Animal’s name, not the Lion’s name.
Aside from the formal sounding name, there isn’t anything new here. Let’s try one more
example to make sure that the exam can’t trick you. What does the following print?
abstract class Animal {
public void careFor() {
play();
}
public void play() {
System.out.println("pet animal");
} }
class Lion extends Animal {
public void play() {
System.out.println("toss in meat");
} }
public class PlayWithAnimal {
public static void main(String... args) {
Animal animal = new Lion();
animal.careFor();
} }
The correct answer is toss in meat. The main method creates a new Lion and calls
careFor. Since only the Animal superclass has a careFor method, it executes. That method
calls play. Java looks for overridden methods, and it sees that Lion implements play.
Even though the call is from the Animal class, Java still looks at subclasses, which is good
because you don’t want to pet a Lion!
     */
}
