public class Bus implements IBus {
    private IBusConfig busConfig;

    @Override
    public void Start(IBusConfig busConfig) {
        this.busConfig = busConfig;
    }


    @Override
    public void Stop() {

    }
}
