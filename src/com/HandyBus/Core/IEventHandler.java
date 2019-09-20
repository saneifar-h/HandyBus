package com.HandyBus.Core;

public interface IEventHandler <TCommand extends IEvent>  {
    void Handle(TCommand command) throws Exception;
}
