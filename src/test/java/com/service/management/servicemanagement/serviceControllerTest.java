package com.service.management.servicemanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class serviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void emptyServiceID_400() throws Exception {

        String requestJson = "{\n" +
                "\"customerId\":\t\"2050878561\",\n" +
                "\"serviceId\":\t\"\"\n" +
                "}";

        mockMvc.perform(put("/activateServiceId")
                .content(requestJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void emptyCustomerID_400() throws Exception {

        String requestJson = "{\n" +
                "\"customerId\":\t\"\",\n" +
                "\"serviceId\":\t\"0426017732\"\n" +
                "}";

        mockMvc.perform(put("/activateServiceId")
                .content(requestJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void validRequest_200() throws Exception {

        String requestJson = "{\n" +
                "\"customerId\":\t\"2050878561\",\n" +
                "\"serviceId\":\t\"0426017706\"\n" +
                "}";

        mockMvc.perform(put("/activateServiceId")
                .content(requestJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void ServiceList_200() throws Exception {


        mockMvc.perform(get("/serviceIds")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void CustomerServiceList_200() throws Exception {


        mockMvc.perform(get("/serviceIds/2050878561")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
