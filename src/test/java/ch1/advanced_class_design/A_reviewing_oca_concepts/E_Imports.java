package ch1.advanced_class_design.A_reviewing_oca_concepts;

public class E_Imports {
    /*
    Oracle no longer lists packages and imports in the objectives for the OCP 8 exam. They do
include visibility modifiers, which means that you still need to understand packages and
imports. So let’s review. How many different ways can you think of to write imports that
will make this code compile?
public class ListHelper {
public List <String> copyAndSortList(List <String> original) {
List <String> list = new ArrayList <String>(original);
sort(list);
return list;
}
}
The key is to note that this question really has two parts. One thing to figure out is how
to get sort(list) to compile. Since sort() is a static method on Collections, you definitely
need a static import. Either of these will do it:
import static java.util.Collections.sort;
import static java.util.Collections.*;
The other part of the question is to note that List and ArrayList are both
referenced. These are regular classes and need regular imports. One option is to use a
wildcard:
import java.util.*;
The other option is to list them out:
import java.util.List;
import java.util.ArrayList;
There are other imports you can add, but they have redundancy or are unnecessary.
For example, you could import java.lang.*. However, this package is always imported
whether you specify it or not.
     */
}
