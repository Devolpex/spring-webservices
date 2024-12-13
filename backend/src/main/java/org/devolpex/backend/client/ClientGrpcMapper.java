package org.devolpex.backend.client;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.devolpex.backend.client.dto.ChambreDTO;
import org.devolpex.backend.client.dto.ClientDTO;
import org.devolpex.backend.client.dto.ReservationDTO;
import org.devolpex.backend.stubs.client.ChambrePRT;
import org.devolpex.backend.stubs.client.ClientPRT;
import org.devolpex.backend.stubs.client.ClientPagePRT;
import org.devolpex.backend.stubs.client.ClientRequestPRT;
import org.devolpex.backend.stubs.client.ReservationPRT;
import org.devolpex.backend.stubs.shared.PageablePRT;
import org.devolpex.backend.stubs.shared.SortPRT;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


@Component
public class ClientGrpcMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    // Convert a ClientDTO to a Client Proto
    public ClientPRT toProto(ClientDTO dto) {
        if (dto == null) {
            return null;
        }

        ClientPRT.Builder builder = ClientPRT.newBuilder()
                .setId(dto.getId())
                .setNom(dto.getNom())
                .setPrenom(dto.getPrenom())
                .setEmail(dto.getEmail())
                .setTelephone(dto.getTelephone());

        // Handle reservations if they are not null
        if (dto.getReservations() != null) {
            builder.addAllReservations(dto.getReservations().stream()
                    .map(this::toProto) // Convert each ReservationDTO to ReservationPRT
                    .collect(Collectors.toList()));
        }

        return builder.build();
    }

    // Covert a Reservation Proto to a Reservation DTO
    private ReservationPRT toProto(ReservationDTO dto) {
        return ReservationPRT.newBuilder()
                .setId(dto.getId())
                .setChambre(this.toProto(dto.getChambre()))
                .setDateDebut(dto.getDateDebut().format(DATE_FORMATTER))
                .setDateFin(dto.getDateFin().format(DATE_FORMATTER))
                .setPreferences(dto.getPreferences() == null ? "" : dto.getPreferences())
                .build();
    }

    // Convert a Chambre DTO to a Chambre Proto
    private ChambrePRT toProto(ChambreDTO dto) {
        if (dto == null) {
            return null;
        }
        return ChambrePRT.newBuilder()
                .setId(dto.getId())
                .setType(dto.getType())
                .setPrix(dto.getPrix().floatValue())
                .build();
    }

    // Convert from ClientRequestPRT to ClientREQ
    public ClientREQ fromProto(ClientRequestPRT proto) {
        if (proto == null) {
            return null;
        }

        return ClientREQ.builder()
                .nom(proto.getNom())
                .prenom(proto.getPrenom())
                .email(proto.getEmail())
                .telephone(proto.getTelephone())
                .build();
    }

    // Map From Sort to SortPRT
    private static SortPRT mapSortToProto(Sort sort) {
        return SortPRT.newBuilder()
                .setSorted(sort.isSorted())
                .setUnsorted(sort.isUnsorted())
                .setEmpty(sort.isEmpty())
                .build();
    }


    // Method to map Page<ClientDTO> to ClientPage
    public ClientPagePRT mapToProtoPage(Page<ClientDTO> clientPage) {
        if (clientPage == null) {
            // Return an empty page if the input is null
            return ClientPagePRT.newBuilder().build();
        }
        // Build the ClientPage response
        ClientPagePRT.Builder clientPageBuilder = ClientPagePRT.newBuilder()
                .setTotalElements(clientPage.getTotalElements())
                .setTotalPages(clientPage.getTotalPages())
                .setLast(clientPage.isLast())
                .setFirst(clientPage.isFirst())
                .setSize(clientPage.getSize())
                .setNumber(clientPage.getNumber())
                .setNumberOfElements(clientPage.getNumberOfElements())
                .setEmpty(clientPage.isEmpty());

        // Map the content of the page to Proto Client list
        clientPage.getContent().forEach(clientDTO -> {
            ClientPRT protoClient = this.toProto(clientDTO);
            clientPageBuilder.addContent(protoClient);
        });

        // Add pageable information (e.g., sorting details)
        PageablePRT pageable = PageablePRT.newBuilder()
                .setPageNumber(clientPage.getPageable().getPageNumber())
                .setPageSize(clientPage.getPageable().getPageSize())
                .setOffset(clientPage.getPageable().getOffset())
                .setPaged(clientPage.getPageable().isPaged())
                .setUnpaged(clientPage.getPageable().isUnpaged())
                .setSort(mapSortToProto(clientPage.getSort()))
                .build();

        clientPageBuilder.setPageable(pageable);

        return clientPageBuilder.build();
    }

}
