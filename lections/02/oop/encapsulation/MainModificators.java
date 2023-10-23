package tinkoff2.oop.encapsulation;

import tinkoff2.oop.encapsulation.modificators.*;

public class MainModificators {
    public static void main(String[] args) {
        Public publ = new Public();
        ProtectedChild prot = new ProtectedChild();
        Private priv = new Private();
        Default def = new Default();
        System.out.println(publ.a);
//        System.out.println(prot.a);
//        System.out.println(def.a);
//        System.out.println(priv.a);
    }
}
