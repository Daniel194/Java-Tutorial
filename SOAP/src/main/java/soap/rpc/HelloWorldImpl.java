package soap.rpc;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.rpc.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }
}
