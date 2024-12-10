package org.devolpex.backend.config;

import org.devolpex.backend.chambre.Chambre;
import org.devolpex.backend.chambre.ChambreRepository;
import org.devolpex.backend.client.Client;
import org.devolpex.backend.client.ClientRepository;
import org.devolpex.backend.reservation.Reservation;
import org.devolpex.backend.reservation.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ChambreRepository chambreRepository;
    private final ReservationRepository reservationRepository;

    public DatabaseInit(ClientRepository clientRepository, ChambreRepository chambreRepository, ReservationRepository reservationRepository) {
        this.clientRepository = clientRepository;
        this.chambreRepository = chambreRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert Clients
        Client client1 = Client.builder()
                .email("test@example.com")
                .nom("Test")
                .prenom("User")
                .telephone("1234567890")
                .build();

        Client client2 = Client.builder()
                .email("john.doe@example.com")
                .nom("John")
                .prenom("Doe")
                .telephone("0987654321")
                .build();

        clientRepository.saveAll(Arrays.asList(client1, client2));

        // Insert Chambres
        Chambre chambre1 = Chambre.builder()
                .type("Single")
                .prix(50.0)
                .disponible(true)
                .build();

        Chambre chambre2 = Chambre.builder()
                .type("Double")
                .prix(100.0)
                .disponible(true)
                .build();

        chambreRepository.saveAll(Arrays.asList(chambre1, chambre2));

        // Insert Reservations
        Reservation reservation1 = Reservation.builder()
                .client(client1)
                .chambre(chambre1)
                .dateDebut(LocalDate.of(2023, 9, 15))
                .dateFin(LocalDate.of(2023, 9, 20))
                .build();

        Reservation reservation2 = Reservation.builder()
                .client(client2)
                .chambre(chambre2)
                .dateDebut(LocalDate.of(2023, 9, 25))
                .dateFin(LocalDate.of(2023, 9, 30))
                .build();

        reservationRepository.saveAll(Arrays.asList(reservation1, reservation2));

        System.out.println("Database initialized with test data.");
    }
}
