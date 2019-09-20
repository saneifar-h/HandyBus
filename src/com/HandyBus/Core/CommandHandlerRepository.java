package com.HandyBus.Core;

import com.HandyBus.Reflection.ReflectionHelper;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandHandlerRepository {
    private Map<String, ICommandHandler> handlerMap = new HashMap<>();

    public void AddRegistration(String commandName, ICommandHandler handler) {
        if (handlerMap.containsKey(commandName))
            throw new InvalidParameterException("Duplicate Command Registration");
        handlerMap.put(commandName, handler);
    }

    public void AddRegistration(ICommand command, ICommandHandler handler) {
        String commandName = ReflectionHelper.NameOf(command);
        AddRegistration(commandName, handler);
    }

    public void AddRegistration(Class command, ICommandHandler handler) {
        String commandName = ReflectionHelper.NameOf(command);
        AddRegistration(commandName, handler);
    }

    public ICommandHandler GetHandler(Class cls) {
        return handlerMap.get(cls.getSimpleName());
    }

    public Set<String> GetAllCommands() {
        return handlerMap.keySet();
    }
}


