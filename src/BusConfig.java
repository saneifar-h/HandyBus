import com.HandyBus.Core.CommandHandlerRepository;
import com.HandyBus.Core.EventHandlerRepository;

public class BusConfig implements IBusConfig {
    private CommandHandlerRepository commandHandlerRepository;
    private EventHandlerRepository eventHandlerRepository;

    @Override
    public IBusConfig SetCommandHandlerRepository(CommandHandlerRepository commandHandlerRepository) {
        this.commandHandlerRepository=commandHandlerRepository;
        return this;
    }

    @Override
    public IBusConfig SetEventHandlerRepository(EventHandlerRepository eventHandlerRepository) {
        this.eventHandlerRepository=eventHandlerRepository;
        return this;
    }

    @Override
    public CommandHandlerRepository GetCommandHandlers() {
        return this.commandHandlerRepository;
    }

    @Override
    public EventHandlerRepository GetEventHandlers() {
        return this.eventHandlerRepository;
    }
}
