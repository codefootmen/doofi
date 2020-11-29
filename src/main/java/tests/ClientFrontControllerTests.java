package tests;

import controller.ClientController;
import org.junit.jupiter.api.Test;

public class ClientFrontControllerTests {

    @Test
    private void Given_DatabaseWithClient_When_ITryToGetClientById_Then_ReturnsTheClient ()
    {
        ClientController controller = new ClientController();
        String test =  controller.getClient("1");
    }
}
