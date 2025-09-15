package org.devolpex.backend.reservation;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.devolpex.backend.chambre.Chambre;
import org.devolpex.backend.chambre.ChambreRepository;
import org.devolpex.backend.client.Client;
import org.devolpex.backend.client.ClientRepository;
import org.devolpex.backend.handler.OwnException;
import org.devolpex.backend.reservation.dto.ReservationDTO;
import org.devolpex.backend.utils.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationServiceImpl implements IService<ReservationDTO, ReservationREQ> {

    private final ReservationRepository reservationRepository;
    private final ReservationMapperImpl reservationMapper;
    private final ChambreRepository chambreRepository;
    private final ClientRepository clientRepository;

    @Override
    public ReservationDTO create(ReservationREQ req) {
        // Vérifier si le client existe, sinon le créer
        Client client = clientRepository.findByEmail(req.client().getEmail())
                .orElseGet(() -> clientRepository.save(Client.builder()
                        .email(req.client().getEmail())
                        .nom(req.client().getNom())
                        .prenom(req.client().getPrenom())
                        .telephone(req.client().getTelephone())
                        .build()));

        // Vérifier si la chambre est disponible dans la plage de dates donnée
        List<Reservation> existingReservations = reservationRepository.findReservationsByChambreAndDateRange(
                req.chambreId(), req.dateDebut(), req.dateFin());

        if (!existingReservations.isEmpty()) {
            // log.error("La chambre est déjà réservée dans cette plage de dates.");
            throw new OwnException("La chambre est déjà réservée dans cette plage de dates.", HttpStatus.CONFLICT);
        }

        Chambre chambre = chambreRepository.findById(req.chambreId())
                .orElseThrow(() -> {
                    // log.error("Chambre non trouvée.");
                    return new OwnException("Chambre non trouvée.", HttpStatus.NOT_FOUND);
                });

        // Construire l'objet réservation et le sauvegarder
        Reservation reservation = Reservation.builder()
                .client(client)
                .chambre(chambre)
                .dateDebut(req.dateDebut())
                .dateFin(req.dateFin())
                .preferences(req.preferences())
                .build();

        reservation = reservationRepository.save(reservation);

        // Retourner le DTO de la réservation
        return reservationMapper.toDTO(reservation);

    }

    @Override
    public ReservationDTO update(Long id, ReservationREQ req) {
        // Find the reservation
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> {
                    // log.error("Réservation non trouvée.");
                    return new OwnException("Réservation non trouvée.", HttpStatus.NOT_FOUND);
                });
        // Check if the client exists, otherwise create it
        Client client = clientRepository.findByEmail(req.client().getEmail())
                .orElseGet(() -> clientRepository.save(Client.builder()
                        .email(req.client().getEmail())
                        .nom(req.client().getNom())
                        .prenom(req.client().getPrenom())
                        .telephone(req.client().getTelephone())
                        .build()));
        // Check if the room is available in the given date range
        List<Reservation> existingReservations = reservationRepository.findReservationsByChambreAndDateRange(
                req.chambreId(), req.dateDebut(), req.dateFin());
        if (!existingReservations.isEmpty()) {
            // log.error("La chambre est déjà réservée dans cette plage de dates.");
            throw new OwnException("La chambre est déjà réservée dans cette plage de dates.", HttpStatus.CONFLICT);
        }

        // Update the reservation object and save it
        Chambre chambre = chambreRepository.findById(req.chambreId())
                .orElseThrow(() -> {
                    // log.error("Chambre non trouvée.");
                    return new OwnException("Chambre non trouvée.", HttpStatus.NOT_FOUND);
                });

        // Construire l'objet réservation et le sauvegarder
        reservation.setClient(client);
        reservation.setChambre(chambre);
        reservation.setDateDebut(req.dateDebut());
        reservation.setDateFin(req.dateFin());
        reservation.setPreferences(req.preferences());
        reservation = reservationRepository.save(reservation);
        // Return the reservation DTO
        return reservationMapper.toDTO(reservation);
    }

    @Override
    public void delete(Long id) {
        reservationRepository.findById(id)
                .ifPresentOrElse(reservationRepository::delete, () -> {
                    // log.error("Réservation non trouvée.");
                    throw new OwnException("Réservation non trouvée.", HttpStatus.NOT_FOUND);
                });
    }

    @Override
    public ReservationDTO findById(Long id) {
        return reservationRepository.findById(id)
                .map(reservationMapper::toDTO)
                .orElseThrow(() -> {
                    // log.error("Réservation non trouvée.");
                    return new OwnException("Réservation non trouvée.", HttpStatus.NOT_FOUND);
                });
    }

    @Override
    public List<ReservationDTO> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toDTO)
                .toList();
    }

    @Override
    public Page<ReservationDTO> findAll(Pageable pageable) {
        return reservationRepository.findAll(pageable)
                .map(reservationMapper::toDTO);
    }

}
