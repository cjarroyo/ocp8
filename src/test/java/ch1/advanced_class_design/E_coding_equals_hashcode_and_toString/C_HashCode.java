package ch1.advanced_class_design.E_coding_equals_hashcode_and_toString;

public class C_HashCode {
    /*

    Whenever you override equals(), you are also expected to override hashCode(). The hash
code is used when storing the object as a key in a map. You will see this in Chapter 3,
“Generics and Collections.”
A hash code is a number that puts instances of a class into a finite number of categories.
Imagine that I gave you a deck of cards, and I told you that I was going to ask you for specific
cards and I want to get the right card back quickly. You have as long as you want to
prepare, but I’m in a big hurry when I start asking for cards. You might make 13 piles of
cards: All of the aces in one pile, all the twos in another pile, and so forth. That way, when
I ask for the five of hearts, you can just pull the right card out of the four cards in the pile
with fives. It is certainly faster than going through the whole deck of 52 cards! You could
even make 52 piles if you had enough space on the table.
The following is the code that goes with our little story. Cards are equal if they have the
same rank and suit. They go in the same pile (hash code) if they have the same rank.
public class Card {
private String rank;
private String suit;
public Card(String r, String s) {
if (r == null || s == null)
throw new IllegalArgumentException();
rank = r;
suit = s;
}
public boolean equals(Object obj) {
if ( !(obj instanceof Card)) return false;
Card c = (Card) obj;
return rank.equals(c.rank) && suit.equals(c.suit);
}
public int hashCode() {
return rank.hashCode();
}
}

In the constructor, you make sure that neither instance variable is null. This check
allows equals() to be simpler because you don’t have to worry about null there. The
hashCode() method is quite simple. It asks the rank for its hash code and uses that.
That’s all well and good. But what do you do if you have a primitive and need the hash code?
The hash code is just a number. On the exam, you can just use a primitive number as is or divide
to get a smaller int. Remember that all of the instance variables don’t need to be used in a
hashCode() method. It is common not to include boolean and char variables in the hash code.
The official JavaDoc contract for hashCode() is harder to read than it needs to be. The
three points in the contract boil down to these:
■■ Within the same program, the result of hashCode() must not change. This means that
you shouldn’t include variables that change in figuring out the hash code. In our hippo
example, including the name is fine. Including the weight is not because hippos change
weight regularly.
■■ If equals() returns true when called with two objects, calling hashCode() on each of
those objects must return the same result. This means hashCode() can use a subset of
the variables that equals() uses. You saw this in the card example. We used only one
of the variables to determine the hash code.
■■ If equals() returns false when called with two objects, calling hashCode() on each of
those objects does not have to return a different result. This means hashCode() results
do not need to be unique when called on unequal objects.
Going back to our Lion, which has three instance variables and only used idNumber in
the equals() method, which of these do you think are legal hashCode() methods?
16: public int hashCode() { return idNumber; }
17: public int hashCode() { return 6; }
18: public long hashcode() { return idNumber; }
19: public int hashCode() { return idNumber * 7 + age; }
Line 16 is what you would expect the hashCode() method to be. Line 17 is also legal. It
isn’t particularly efficient. It is like putting the deck of cards in one giant pile. But it is legal.
Line 18 is not an override of hashCode(). It uses a lowercase c, which makes it a different
method. If it were an override, it wouldn’t compile because the return type is wrong. Line
19 is not legal because it uses more variables than equals().

The Easy Way to Write hashCode() Methods
==============
You probably thought that this was going to be about the Apache Commons Lang class
for hash code. There is one, but it isn’t the easiest way to write hash code.
It is easier to code your own. Just pick the key fields that identify your object (and
don’t change during the program) and combine them:
public int hashCode() {
return keyField + 7 * otherKeyField.hashCode();
}
It is common to multiply by a prime number when combining multiple fields in the
hash code. This makes the hash code more unique, which helps when distributing
objects into buckets.


     */
}
