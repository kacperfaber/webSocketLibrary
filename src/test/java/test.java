import com.talker.websocketlibrary.ControllerBase;
import com.talker.websocketlibrary.reflections.ModelLoader;
import org.junit.Test;
import org.reflections.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

public class test {
    @Test
    public void test() {
        Reflections reflections = new Reflections("com.talker", new SubTypesScanner());
        Set<Class<? extends ControllerBase>> controllerClasses = reflections.getSubTypesOf(ControllerBase.class);
   }
}
