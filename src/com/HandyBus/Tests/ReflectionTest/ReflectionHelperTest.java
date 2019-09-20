package com.HandyBus.Tests.ReflectionTest;

import com.HandyBus.Reflection.ReflectionHelper;
import com.HandyBus.Tests.TestOneWayCommand;
import com.HandyBus.Tests.TestTwoWayCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ReflectionHelperTest {
    @Test
    public void TestReflectionHelperForOneWayCommand() {
        TestOneWayCommand oneWayCommand = new TestOneWayCommand();
        assertEquals("TestOneWayCommand", ReflectionHelper.NameOf(oneWayCommand));
    }

    @Test
    public void TestReflectionHelperForTwoWayCommand() {
        TestTwoWayCommand testTwoWayCommand = new TestTwoWayCommand();
        assertEquals("TestTwoWayCommand", ReflectionHelper.NameOf(testTwoWayCommand));
    }

    @Test
    public void TestReflectionHelperForTwoWayCommandClass() {
        assertEquals("TestTwoWayCommand",  ReflectionHelper.NameOf(TestTwoWayCommand.class));
    }
}