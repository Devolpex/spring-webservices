package org.devolpex.backend.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.devolpex.backend.client.ClientServiceImpl;
import org.devolpex.backend.client.controllers.ClientSOAP;
import org.devolpex.backend.reservation.ReservationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class CXFConfig {
    
    // private ReservationServiceImpl reservationService;
    private ClientSOAP clientService;
    private Bus bus;

    // @Bean
    // public EndpointImpl endpoint() {
    //     EndpointImpl endpoint = new EndpointImpl(bus, reservationService);
    //     endpoint.publish("/ws/reservation");
    //     return endpoint;
    // }

    @Bean
    public EndpointImpl clientEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, clientService);
        endpoint.publish("/ws/client");
        return endpoint;
    }
}