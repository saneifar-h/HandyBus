package com.HandyBus.Core;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class EventHandler {
    private Map<String, IEventHandler> handlerMap = new HashMap<>();

    protected void AddRegistration(String commandName, IEventHandler executor) {
        if (handlerMap.containsKey(commandName))
            throw new InvalidParameterException("Duplicate Command Registration");
        handlerMap.put(commandName, executor);
    }
    public  IEventHandler GetExecutor(String command) {
        return handlerMap.get(command);
    }

    public Set<String> GetCommands(){
        return handlerMap.keySet();
    }
}
