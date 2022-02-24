package com.talker.websocketlibrary.reflections.tests;

import com.talker.websocketlibrary.reflections.DefaultActionMethodParametersGenerator;
import com.talker.websocketlibrary.reflections.InvokeParameter;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultActionMethodParametersGenerator_generate_Tests {
    Object[] exec(Method actionMethod, List<InvokeParameter> invokeParameters) {
        DefaultActionMethodParametersGenerator generator = new DefaultActionMethodParametersGenerator();
        return generator.generate(actionMethod, invokeParameters);
    }

    public void testMethod1(int x, String n) throws Exception {
    }

    public void testMethod2() throws Exception {
    }

    @Test()
    public void dontThrows() throws Exception {
        Method method = getClass().getDeclaredMethod("testMethod2");
        ArrayList<InvokeParameter> params = new ArrayList<>();
        assertDoesNotThrow(() -> exec(method, params));
    }

    @Test
    public void notNull() throws Exception {
        Method method = getClass().getDeclaredMethod("testMethod1", int.class, String.class);
        ArrayList<InvokeParameter> params = new ArrayList<>();
        params.add(new InvokeParameter(int.class, 5, 0));
        params.add(new InvokeParameter(String.class, "Hello World", 0));
        Object[] res = exec(method, params);
        assertNotNull(res);
    }

    @Test
    public void notEmpty() throws Exception {
        Method method = getClass().getDeclaredMethod("testMethod1", int.class, String.class);
        ArrayList<InvokeParameter> params = new ArrayList<>();
        params.add(new InvokeParameter(int.class, 5, 0));
        params.add(new InvokeParameter(String.class, "Hello World", 0));
        Object[] res = exec(method, params);
        assertNotEquals(0, res.length);
    }

    @Test
    public void expectedLength() throws Exception {
        Method method = getClass().getDeclaredMethod("testMethod1", int.class, String.class);
        ArrayList<InvokeParameter> params = new ArrayList<>();
        params.add(new InvokeParameter(int.class, 5, 0));
        params.add(new InvokeParameter(String.class, "Hello World", 0));
        Object[] res = exec(method, params);
        assertEquals(2, res.length);
    }

    @Test
    public void expectedFirstItem() throws Exception {
        final int expected = 5;
        Method method = getClass().getDeclaredMethod("testMethod1", int.class, String.class);
        ArrayList<InvokeParameter> params = new ArrayList<>();
        params.add(new InvokeParameter(int.class, expected, 0));
        params.add(new InvokeParameter(String.class, "Hello World", 0));
        Object[] res = exec(method, params);
        assertEquals(expected, res[0]);
    }

    @Test
    public void expectedSecondItem() throws Exception {
        final String expected = "Hello World";
        Method method = getClass().getDeclaredMethod("testMethod1", int.class, String.class);
        ArrayList<InvokeParameter> params = new ArrayList<>();
        params.add(new InvokeParameter(int.class, 5, 0));
        params.add(new InvokeParameter(String.class, expected, 0));
        Object[] res = exec(method, params);
        assertEquals(expected, res[1]);
    }
}
