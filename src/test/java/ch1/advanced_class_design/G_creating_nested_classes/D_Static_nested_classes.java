package ch1.advanced_class_design.G_creating_nested_classes;

public class D_Static_nested_classes {
    /*
    The final type of nested class is not an inner class. A static nested class is a static
class defined at the member level. It can be instantiated without an object of the
enclosing class, so it can’t access the instance variables without an explicit object of
the enclosing class. For example, new OuterClass().var allows access to the instance
variable var.
In other words, it is like a regular class except for the following:
■■ The nesting creates a namespace because the enclosing class name must be used to refer
to it.
■■ It can be made private or use one of the other access modifiers to encapsulate it.
■■ The enclosing class can refer to the fields and methods of the static nested class.
1: public class Enclosing {
2: static class Nested {
3: private int price = 6;
4: }
5: public static void main(String[] args) {
6: Nested nested = new Nested();
7: System.out.println(nested.price);
8: } }
Line 6 instantiates the nested class. Since the class is static, you do not need an
instance of Enclosing in order to use it. You are allowed to access private instance
variables, which is shown on line 7.

Importing a static Nested Class
======================
Importing a static nested class is interesting. You can import it using a regular import:
package bird;
public class Toucan {
public static class Beak {}
}
package watcher;
import bird.Toucan.Beak; // regular import ok
public class BirdWatcher {
Beak beak;
}
And since it is static, alternatively you can use a static import:
import static bird.Toucan.Beak;
Either one will compile. Surprising, isn’t it? Java treats the static nested class as if it
were a namespace.

To review the four types of nested classes, make sure that you know the information in
Table 1.2.
Table 1. 2 Types of nested classes
Member
inner class
Local inner
class Anonymous inner class static nested class
Access
modifiers
allowed
public,
protected,
private,
or default
access
None.
Already
local to
method.
None. Already local to
statement.
public, protected,
private, or default
access
Can extend
any class and
any number
of interfaces
Yes Yes No—must have exactly
one superclass or one
interface
Yes
Can be
abstract
Yes Yes N/A—because no class
definition
Yes
Can be final Yes Yes N/A—because no class
definition
Yes
Can access
instance
members of
enclosing
class
Yes Yes Yes No (not directly;
requires an
instance of the
enclosing class)
Can access
local variables
of enclosing
class
No Yes—if
final or
effectively
final
Yes—if final or effectively
final
No
Can declare
static
methods
No No No Yes
     */
}
