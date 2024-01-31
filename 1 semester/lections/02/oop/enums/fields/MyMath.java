package tinkoff2.oop.enums.fields;

public enum MyMath {
    ADD {
        public int getRes(int a, int b) {return a + b;}
    },
    SUB{
        public int getRes(int a, int b) {return a - b;}
    },
    MUL{
        public int getRes(int a, int b) {return a * b;}
    },
    DIV{
        public int getRes(int a, int b) {return a / b;}
    };

    public abstract int getRes(int a, int b);
}
