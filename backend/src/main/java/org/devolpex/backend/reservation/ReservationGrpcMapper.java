package org.devolpex.backend.reservation;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.devolpex.backend.reservation.dto.ChambreDTO;
import org.devolpex.backend.reservation.dto.ClientDTO;
import org.devolpex.backend.reservation.dto.ReservationDTO;
import org.devolpex.backend.stubs.chambre.Chambre;
import org.devolpex.backend.stubs.client.Client;
import org.devolpex.backend.stubs.reservation.Pageable;
import org.devolpex.backend.stubs.reservation.Reservation;
import org.devolpex.backend.stubs.reservation.ReservationPage;
import org.devolpex.backend.stubs.reservation.Sort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.google.protobuf.Timestamp;

@Component
public class ReservationGrpcMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    // Convert a ReservationDTO to a Reservation Proto
    public Reservation toProto(ReservationDTO dto) {
        return Reservation.newBuilder()
                .setId(dto.getId())
                .setClient(this.toProto(dto.getClient()))
                .setChambre(this.toProto(dto.getChambre()))
                .setDateDebut(dto.getDateDebut().format(DATE_FORMATTER))
                .setDateFin(dto.getDateFin().format(DATE_FORMATTER))
                .setPreferences(dto.getPreferences() == null ? "" : dto.getPreferences())
                .build();
    }

    // Private method to convert a ClientDTO to a Client Proto
    private Client toProto(ClientDTO clientDTO) {
        if (clientDTO == null) {
            return null;
        }
        return Client.newBuilder()
                .setId(clientDTO.getId())
                .setNom(clientDTO.getNom())
                .setPrenom(clientDTO.getPrenom())
                .setEmail(clientDTO.getEmail())
                .setTelephone(clientDTO.getTelephone())
                .build();
    }

    // Private method to convert a ChambreDTO to a Chambre Proto
    private Chambre toProto(ChambreDTO dto) {
        if (dto == null) {
            return null;
        }
        return Chambre.newBuilder()
                .setId(dto.getId())
                .setType(dto.getType())
                .setPrix(dto.getPrix().floatValue())
                .setDisponible(dto.getDisponible())
                .build();
    }

    // // Method to map Sort to Proto Sort
    private static Sort mapSortToProto(org.springframework.data.domain.Sort sort) {
        return Sort.newBuilder()
                .setSorted(sort.isSorted())
                .setUnsorted(sort.isUnsorted())
                .setEmpty(sort.isEmpty())
                .build();
    }

    // Method to map Page<ReservationDTO> to ReservationPage
    public ReservationPage mapToProtoPage(Page<ReservationDTO> reservationPage) {
        // Map the content of the page to the Proto Reservation list
        ReservationPage.Builder reservationPageBuilder = ReservationPage.newBuilder()
                .setTotalElements(reservationPage.getTotalElements())
                .setTotalPages(reservationPage.getTotalPages())
                .setLast(reservationPage.isLast())
                .setFirst(reservationPage.isFirst())
                .setSize(reservationPage.getSize())
                .setNumber(reservationPage.getNumber())
                .setNumberOfElements(reservationPage.getNumberOfElements())
                .setEmpty(reservationPage.isEmpty());

        // Map the reservations to the Proto format
        reservationPage.getContent().forEach(reservationDTO -> {
            Reservation protoReservation = this.toProto(reservationDTO);
            reservationPageBuilder.addContent(protoReservation);
        });

        // Add pageable information (e.g., sorting details)
        Pageable pageable = Pageable.newBuilder()
                .setPageNumber(reservationPage.getPageable().getPageNumber())
                .setPageSize(reservationPage.getPageable().getPageSize())
                .setOffset(reservationPage.getPageable().getOffset())
                .setPaged(reservationPage.getPageable().isPaged())
                .setUnpaged(reservationPage.getPageable().isUnpaged())
                .setSort(mapSortToProto(reservationPage.getSort()))
                .build();

        reservationPageBuilder.setPageable(pageable);

        return reservationPageBuilder.build();
    }

    /**
     * Method to map a ReservationREQ (proto) to a ReservationREQ (DTO)
     */
    public ReservationREQ mapToReservationReq(org.devolpex.backend.stubs.reservation.ReservationREQ proto) {
        // Convert Timestamp to LocalDate
        LocalDate dateDebut = timestampToLocalDate(proto.getDateDebut());
        LocalDate dateFin = timestampToLocalDate(proto.getDateFin());

        return ReservationREQ.builder()
                .client(ClientDTO.builder()
                        .id(proto.getClient().getId())
                        .nom(proto.getClient().getNom())
                        .prenom(proto.getClient().getPrenom())
                        .email(proto.getClient().getEmail())
                        .telephone(proto.getClient().getTelephone())
                        .build())
                .chambreId(proto.getChambreId())
                .dateDebut(dateDebut)
                .dateFin(dateFin)
                .preferences(proto.getPreferences())
                .build();

    }

    private LocalDate timestampToLocalDate(Timestamp timestamp) {
        // Convert the Timestamp to LocalDate
        Instant instant = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
