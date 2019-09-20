import com.HandyBus.Core.CommandHandlerRepository;
import com.HandyBus.Core.EventHandlerRepository;

public interface IBusConfig {
    IBusConfig  SetCommandHandlerRepository(CommandHandlerRepository commandHandlerRepository);
    IBusConfig  SetEventHandlerRepository(EventHandlerRepository eventHandlerRepository);
    CommandHandlerRepository GetCommandHandlers();
    EventHandlerRepository GetEventHandlers();
}
