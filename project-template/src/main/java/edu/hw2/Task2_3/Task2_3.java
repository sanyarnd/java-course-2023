package edu.hw2.Task2_3;

public class Task2_3 {
    private Task2_3() {
    }

    public static void main(String[] args) {
        ConnectionManager conMan = new DefaultConnectionManager();
        PopularCommandExecutor cmdExe = new PopularCommandExecutor(conMan, 10000);
        cmdExe.updatePackages();
    }
}
