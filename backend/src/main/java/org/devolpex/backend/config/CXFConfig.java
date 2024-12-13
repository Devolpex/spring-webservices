package org.devolpex.backend.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.devolpex.backend.chambre.controllers.ChambreSoap;
import org.devolpex.backend.reservation.controllers.ReservationSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
public class CXFConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private ReservationSoap reservationSoap;

    @Autowired
    private ChambreSoap chambreSoap;

    @Bean
    public EndpointImpl reservationEndpoint() {
        // Add debug logs
        System.out.println("Initializing reservationEndpoint...");
        if (bus == null) {
            System.out.println("Bus is null");
        }
        if (reservationSoap == null) {
            System.out.println("ReservationSoap is null");
        }

        // Ensure 'bus' and 'reservationSoap' are not null before using them
        if (bus == null || reservationSoap == null) {
            throw new NullPointerException("Bus or ReservationSoap is null");
        }

        EndpointImpl endpoint = new EndpointImpl(bus, reservationSoap);
        endpoint.publish("/ws/reservation");
        return endpoint;
    }

    @Bean
    public EndpointImpl chambreEndpoint() {
        // Add debug logs
        System.out.println("Initializing chambreEndpoint...");
        if (bus == null) {
            System.out.println("Bus is null");
        }
        if (chambreSoap == null) {
            System.out.println("ChambreSoap is null");
        }

        // Ensure 'bus' and 'chambreSoap' are not null before using them
        if (bus == null || chambreSoap == null) {
            throw new NullPointerException("Bus or ChambreSoap is null");
        }

        EndpointImpl endpoint = new EndpointImpl(bus, chambreSoap);
        endpoint.publish("/ws/chambre");
        return endpoint;
    }
}