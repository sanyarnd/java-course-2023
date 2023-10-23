package tinkoff2.oop.classes.anon;

public class Main {
    public static void main(String[] args) {
//        MonitoringSystem errorModule = new ErrorMonitoringModule();
        MonitoringSystem securityModule = new SecurityModule();

//        errorModule.startMonitoring();
        securityModule.startMonitoring();
    }
}
