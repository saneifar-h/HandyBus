package com.HandyBus.Core;

@FunctionalInterface
public interface IOneWayCommandHandler<TCommand extends IOneWayCommand> extends ICommandHandler {
    void Handle(TCommand command) throws Exception;
}
