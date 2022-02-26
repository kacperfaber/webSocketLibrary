# webSocketLibrary

### In this document

- [Installing](#introduction)
- [Setup](#setup)

## Setup
You need to...
- Register beans
    - **Model** (com.talker.websocketlibrary.reflections)
    - **IMessageReader** (com.talker.websocketlibrary.messaging)
    - **IMessageWriter** (com.talker.websocketlibrary.messaging)

- Register webSocketLibrary packages
  - Add **@EnableWebSocketLibrary annotation**
- Create **SocketHandler** implementation
- Run spring application

#### Main class
```
@EnableWebSocketLibrary
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(args);
    }
    
    @Bean
    public Model getModel(ModelLoader modelLoader) {
        String s = ""; // your controllers package prefix
        return modelLoader.load(prefix); 
    }
        
    @Bean
    public IMessageReader getMessageReader() {
        return new DefaultMessageReader();
    }
        
    @Bean
    public IMessageWriter getMessageWriter(IDataWriter dataWriter) {
        return new DefaultMessageWriter(dataWriter);
    }
}
```

// TODO(missing SocketHandler sample)

## Creating controller

- Add **@SocketController** annotation (com.talker.websocketlibrary.reflections.annotations)
  - SocketController annotation overrides after **@Component**
- Controller can override from **ControllerBase**
- Create first action
  - Action must be annotated with **@SocketAction** (com.talker.websocketlibrary.reflections.annotations)
  - Action can take parameters, see [IActionInvokerExtension](#IActionInvokerExtensions)
  - Action can return values, see [IResultInterpeter](#IResultInterpreter)

#### Sample Controller
```
@SocketController
public class PingController {
  @SocketAction("ping") // name given by IMessageReader
  public void ping() {
     // your code
  }
}
```

## IActionInvokerExtension
Extension can add any object as action parameter. For sample - it can be current user
#### add object as parameter
> actionInvoke.addParameter(Object o, Class<?> oClass, int weight)

#### Sample Extension
```
@Component
public class CurrentUserExtension implements IActionInvokerExtension {
    @Override
    public void beforeInvoke(ActionInvoke actionInvoke, Object controller, HandlerEvent handlerEvent, Payload payload) {
       String currentUserId = actionInvoke.getCommand().userId;
       actionInvoke.addParameter(currentUserId, String.class, 0);
    } 
}
```