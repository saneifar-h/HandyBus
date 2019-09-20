package com.HandyBus.Core;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.HandyBus.Reflection.ReflectionHelper;

public class EventHandlerRepository {
    private Map<String, IEventHandler> handlerMap = new HashMap<>();

    protected void AddRegistration(String eventName, IEventHandler handler) {
        if (handlerMap.containsKey(eventName))
            throw new InvalidParameterException("Duplicate Event Registration");
        handlerMap.put(eventName, handler);
    }

    protected void AddRegistration(IEvent event, IEventHandler handler) {
        String eventName=ReflectionHelper.NameOf(event);
        AddRegistration(eventName,handler);
    }

    protected void AddRegistration(Class eventClass, IEventHandler handler) {
        String eventName=ReflectionHelper.NameOf(eventClass);
        AddRegistration(eventName,handler);
    }



    public IEventHandler GetHandler(String command) {
        return handlerMap.get(command);
    }

    public Set<String> GetAllEvents() {
        return handlerMap.keySet();
    }
}
