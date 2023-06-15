package org.eijsink.controller;

import org.eijsink.exception.EijsinkException;
import org.eijsink.model.Payment;
import org.eijsink.service.crud.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class PaymentControllerTest {

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private PaymentService paymentService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup () {

        this.mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    public void findAllPaymentsTest() throws Exception{
        List<Payment> payments = new ArrayList<>();

        payments.add(new Payment(23, Payment.PAYMENT_TYPE.CARD));
        payments.add(new Payment(4, Payment.PAYMENT_TYPE.CARD));
        payments.add(new Payment(32, Payment.PAYMENT_TYPE.CASH));
        payments.add(new Payment(2, Payment.PAYMENT_TYPE.CARD));
        payments.add(new Payment(8, Payment.PAYMENT_TYPE.CASH));
        payments.add(new Payment(18, Payment.PAYMENT_TYPE.CASH));

        when(paymentService.findAll()).thenReturn( payments);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/payment")
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                ).andDo(MockMvcResultHandlers.print())
                 .andExpect(jsonPath("$", hasSize(6)))
                 .andExpect(jsonPath("$[5].amount").value(payments.get(5).getAmount()))
                 .andExpect(status().isOk());

    }

    @Test
    public void savePaymentsTest() throws Exception{

        Payment payment = new Payment( 23, Payment.PAYMENT_TYPE.CARD);
    //    when(paymentService.save(payment, "ICS9983746")).thenThrow( new EijsinkException("Endpoint not available"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/payment")
                    .param("cardNumber", "IPS838847462")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .characterEncoding("UTF-8")
                    .content(getJson(payment))
                ).andDo(MockMvcResultHandlers.print())
                 .andExpect(jsonPath("$.id").exists())
                 .andExpect(jsonPath("$.amount").value(payment.getAmount()))
                 .andExpect(status().isOk());

    }

    @Test
    public void savePaymentsTestException() throws Exception{

        Payment payment = new Payment( 23, Payment.PAYMENT_TYPE.CARD);
        //https://www.digitalocean.com/community/tutorials/mockito-argument-matchers-any-eq
        when(paymentService.save(any(Payment.class), anyString())).thenThrow( new EijsinkException("Endpoint not available"));
//        when(paymentService.save(payment, "ICS9983746")).thenThrow( new EijsinkException("Endpoint not available"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/payment")
                        .param("cardNumber", "ICS9983746")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(getJson(payment))
                ).andExpect(status().isUnprocessableEntity())
                 .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResponseStatusException))
                 .andExpect(result -> assertEquals("422 UNPROCESSABLE_ENTITY \"Endpoint not available\"", result.getResolvedException().getMessage()));

    }

    private byte[] getJson(Payment payment) {

        String json = "  {\n" +
                "    \"id\": 1,\n" +
                "    \"amount\": 23,\n" +
                "    \"type\": \"CARD\"\n" +
                "  }";
        return json.getBytes();
    }




}

