package com.talker.websocketlibrary.reflections.tests;

import com.talker.websocketlibrary.reflections.DefaultMethodReturnTypeProvider;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Method;

public class DefaultMethodReturnTypeProvider_provide_Tests {
    public class SampleClass {
        public void sampleVoidMethod() {}
        public int sampleIntMethod() {return 0;};
        public Object sampleObjectMethod(){return this;};
    }

    Class<?> exec(Method method) {
        return new DefaultMethodReturnTypeProvider().provide(method);
    }
    @Test
    public void doesNotThrow() {
        Assertions.assertDoesNotThrow(() -> exec(SampleClass.class.getMethod("sampleVoidMethod")));
    }
    @Test
    public void voidIfMethodIsVoid() throws NoSuchMethodException {
        Assertions.assertEquals(void.class, exec(SampleClass.class.getMethod("sampleVoidMethod")));
    }
    @Test
    public void intIfMethodIsInt() throws NoSuchMethodException{
        Assertions.assertEquals(int.class, exec(SampleClass.class.getMethod("sampleIntMethod")));
    }
    @Test
    public void ObjectIfMethodIsObject() throws NoSuchMethodException{
        Assertions.assertEquals(Object.class, exec(SampleClass.class.getMethod("sampleObjectMethod")));
    }
}
