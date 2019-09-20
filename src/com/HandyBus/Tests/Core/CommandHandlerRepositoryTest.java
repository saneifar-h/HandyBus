package com.HandyBus.Tests.Core;

import com.HandyBus.Core.*;
import com.HandyBus.Reflection.ReflectionHelper;
import com.HandyBus.Tests.TestOneWayCommand;
import com.HandyBus.Tests.TestTwoWayCommand;
import org.junit.jupiter.api.Test;
import spark.utils.Assert;

import java.security.InvalidParameterException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CommandHandlerRepositoryTest {
    CommandHandlerRepository commandHandlerRepository;
    String oneWayHandleResult = "";


    private void Setup() {
        commandHandlerRepository = new CommandHandlerRepository();
        commandHandlerRepository.AddRegistration(TestTwoWayCommand.class, (ITwoWayCommandHandler<TestTwoWayCommand, String>) command -> "TestTwoWayCommand Handled Name:= " + command.CommandName);
        commandHandlerRepository.AddRegistration(TestOneWayCommand.class, (IOneWayCommandHandler<TestOneWayCommand>) command -> oneWayHandleResult = "TestOneWayCommand Handled Name:= " + command.CommandName);
    }

    @Test
    public void Test_Register_And_ReturnCommands_Count_Equals_Number_Of_Registration() {
        Setup();
        Set<String> commands = commandHandlerRepository.GetAllCommands();
        assertEquals(2, commands.size());
    }

    @Test
    public void Test_Register_Duplicate_Throw_InvalidParameter_Exception() {
        Setup();
        try {
            commandHandlerRepository.AddRegistration(TestTwoWayCommand.class, (ITwoWayCommandHandler<TestTwoWayCommand, String>) command -> "TestTwoWayCommand Handled Duplicate");
            fail("Must Throw Exception But No Exception Threw");
        } catch (Exception ex) {
            assertTrue(ex.getClass() == InvalidParameterException.class);
            assertEquals("Duplicate Command Registration", ex.getMessage());
        }
    }

    @Test
    public void Test_Get_Handlers_And_Execute_Must_Do_TheRelativeAction() throws Exception {
        Setup();
        TestTwoWayCommand twoWayCommand = new TestTwoWayCommand();
        twoWayCommand.CommandName = "TwoWayCommand 1";
        ICommandHandler handler = commandHandlerRepository.GetHandler(TestTwoWayCommand.class);
        if(!(handler instanceof  ITwoWayCommandHandler))
            fail("Invalid Handler Type Returned");
        ITwoWayCommandHandler commandHandler = (ITwoWayCommandHandler) handler;
        Object result = commandHandler.Handle(twoWayCommand);
        assertEquals("TestTwoWayCommand Handled Name:= " + twoWayCommand.CommandName, result);
    }

    @Test
    public void Test_Get_Handlers_And_Check_Cast() throws Exception {
        Setup();
        TestOneWayCommand oneWayCommand = new TestOneWayCommand();
        oneWayCommand.CommandName = "OneWayCommand 1";
        ICommandHandler handler = commandHandlerRepository.GetHandler(TestOneWayCommand.class);
        if (!(handler instanceof IOneWayCommandHandler))
            fail("Invalid Type Returned");
        IOneWayCommandHandler oneWayCommandHandler = (IOneWayCommandHandler) handler;
        ((IOneWayCommandHandler) handler).Handle(oneWayCommand);
        assertEquals("TestOneWayCommand Handled Name:= " + oneWayCommand.CommandName, oneWayHandleResult);
    }
}