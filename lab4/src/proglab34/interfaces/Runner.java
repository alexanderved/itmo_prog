package proglab34.interfaces;

public interface Runner {
    void startRunning();
    void stopRunning();
    void runOn(Runnable runnable);
}