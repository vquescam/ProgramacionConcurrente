package com.feedback1.gestionpedidos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.feedback1.gestionpedidos.model.Order;
import com.feedback1.gestionpedidos.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder() throws Exception {
        String orderJson = "{\"description\": \"Test Order\", \"amount\": 100.0}";
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateOrderWithError() throws Exception {
        Order order = new Order();
        order.setDescription("Test Order");
        order.setAmount(100.0);
        assertThrows(Exception.class, () -> {
            orderService.updateOrder(order);
        });
    }
}