package com.HandyBus.Core;

@FunctionalInterface
public interface ITwoWayCommandHandler<TCommand extends ITwoWayCommand, TResult> extends ICommandHandler {
    TResult Handle(TCommand command) throws Exception;
}
