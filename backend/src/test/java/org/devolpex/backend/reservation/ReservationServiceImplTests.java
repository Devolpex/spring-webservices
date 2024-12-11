// package org.devolpex.backend.reservation;

// import org.devolpex.backend.chambre.Chambre;
// import org.devolpex.backend.chambre.ChambreRepository;
// import org.devolpex.backend.client.Client;
// import org.devolpex.backend.client.ClientDTO;
// import org.devolpex.backend.client.ClientRepository;
// import org.devolpex.backend.handler.OwnException;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// import java.time.LocalDate;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// @ExtendWith(MockitoExtension.class)
// public class ReservationServiceImplTests {

//     @Mock
//     private ReservationRepository reservationRepository;

//     @Mock
//     private ReservationMapperImpl reservationMapper;

//     @Mock
//     private ChambreRepository chambreRepository;

//     @Mock
//     private ClientRepository clientRepository;

//     @InjectMocks
//     private ReservationServiceImpl reservationService;

//     private Client client;
//     private Chambre chambre;
//     private ClientDTO clientDTO;
//     private List<Reservation> existingReservations;

//     @BeforeEach
//     void setUp() {
//         client = Client.builder()
//                 .email("test@example.com")
//                 .nom("Test")
//                 .prenom("User")
//                 .telephone("1234567890")
//                 .build();

//         clientDTO = ClientDTO.builder()
//                 .email("test@example.com")
//                 .nom("Test")
//                 .prenom("User")
//                 .telephone("1234567890")
//                 .build();

//         chambre = Chambre.builder()
//                 .id(1L)
//                 .type("Double")
//                 .prix(100.0)
//                 .disponible(true)
//                 .build();

//         existingReservations = Arrays.asList(
//                 Reservation.builder().chambre(chambre).dateDebut(LocalDate.of(2023, 9, 15)).dateFin(LocalDate.of(2023, 9, 20)).build(),
//                 Reservation.builder().chambre(chambre).dateDebut(LocalDate.of(2023, 9, 25)).dateFin(LocalDate.of(2023, 9, 30)).build());
//     }

//     @Test
//     void testCreateReservationInAvailableDateRange() {
//         ReservationREQ req = ReservationREQ.builder()
//                 .client(clientDTO)
//                 .chambreId(1L)
//                 .dateDebut(LocalDate.of(2023, 9, 21))
//                 .dateFin(LocalDate.of(2023, 9, 24))
//                 .build();

//         when(clientRepository.findByEmail(any())).thenReturn(Optional.of(client));
//         when(chambreRepository.findById(any())).thenReturn(Optional.of(chambre));
//         when(reservationRepository.findReservationsByChambreAndDateRange(any(), any(), any())).thenReturn(List.of());

//         reservationService.create(req);
//     }

// //     @Test
// //     void testCreateReservationInUnavailableDateRange() {
// //         List<ReservationREQ> requests = Arrays.asList(
// //                 ReservationREQ.builder().client(clientDTO).chambreId(1L).dateDebut(LocalDate.of(2023, 9, 14)).dateFin(LocalDate.of(2023, 9, 21)).build(),
// //                 ReservationREQ.builder().client(clientDTO).chambreId(1L).dateDebut(LocalDate.of(2023, 9, 23)).dateFin(LocalDate.of(2023, 9, 27)).build(),
// //                 ReservationREQ.builder().client(clientDTO).chambreId(1L).dateDebut(LocalDate.of(2023, 9, 14)).dateFin(LocalDate.of(2023, 9, 27)).build(),
// //                 ReservationREQ.builder().client(clientDTO).chambreId(1L).dateDebut(LocalDate.of(2023, 9, 15)).dateFin(LocalDate.of(2023, 9, 21)).build(),
// //                 ReservationREQ.builder().client(clientDTO).chambreId(1L).dateDebut(LocalDate.of(2023, 9, 20)).dateFin(LocalDate.of(2023, 9, 24)).build(),
// //                 ReservationREQ.builder().client(clientDTO).chambreId(1L).dateDebut(LocalDate.of(2023, 9, 20)).dateFin(LocalDate.of(2023, 9, 25)).build());

// //         when(clientRepository.findByEmail(any())).thenReturn(Optional.of(client));
// //         when(chambreRepository.findById(any())).thenReturn(Optional.of(chambre));
// //         when(reservationRepository.findReservationsByChambreAndDateRange(any(), any(), any()))
// //                 .thenReturn(existingReservations);

// //         for (ReservationREQ req : requests) {
// //             assertThrows(OwnException.class, () -> reservationService.create(req));
// //         }
// //     }

//     @Test
//     void testCreateReservationInFutureDateRange() {
//         ReservationREQ req = ReservationREQ.builder()
//                 .client(clientDTO)
//                 .chambreId(1L)
//                 .dateDebut(LocalDate.of(2023, 10, 1))
//                 .dateFin(LocalDate.of(2023, 10, 15))
//                 .build();

//         when(clientRepository.findByEmail(any())).thenReturn(Optional.of(client));
//         when(chambreRepository.findById(any())).thenReturn(Optional.of(chambre));
//         when(reservationRepository.findReservationsByChambreAndDateRange(any(), any(), any())).thenReturn(List.of());

//         reservationService.create(req);
//         verify(reservationRepository).save(any(Reservation.class));  // Verifying that the reservation is saved
//     }
// }
