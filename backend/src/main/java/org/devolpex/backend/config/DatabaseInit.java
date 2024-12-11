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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        // Insert Chambres (10 Chambres)
        List<Chambre> chambres = IntStream.range(1, 11)
                .mapToObj(i -> Chambre.builder()
                        .type(i % 2 == 0 ? "Double" : "Single") // Alternate between "Single" and "Double"
                        .prix(i % 2 == 0 ? 100.0 : 50.0) // Alternate prices
                        .disponible(true)
                        .build())
                .collect(Collectors.toList());

        chambreRepository.saveAll(chambres);

        // Insert Reservations (30 Reservations)
        List<Reservation> reservations = IntStream.range(1, 31)
                .mapToObj(i -> {
                    Client client = i % 2 == 0 ? client2 : client1; // Alternate clients
                    Chambre chambre = chambres.get(i % chambres.size()); // Alternate chambres

                    return Reservation.builder()
                            .client(client)
                            .chambre(chambre)
                            .dateDebut(LocalDate.of(2023, 9, 10).plusDays(i)) // Create reservations with different start dates
                            .dateFin(LocalDate.of(2023, 9, 15).plusDays(i)) // Create reservations with different end dates
                            
                            .build();
                })
                .collect(Collectors.toList());

        reservationRepository.saveAll(reservations);

        System.out.println("Database initialized with 10 Chambres and 30 Reservations.");
    }
}
