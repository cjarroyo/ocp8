package ch1.advanced_class_design.A_reviewing_oca_concepts;

import ch1.advanced_class_design.A_reviewing_oca_concepts.cat.BigCat;

public class A_AccessModifiers {

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);

        //System.out.println(cat.hasFur);
        //System.out.println(cat.hasPaws);
        //System.out.println(cat.id);
    }
}