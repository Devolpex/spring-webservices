package org.devolpex.backend.reservation;

import java.time.LocalDate;
import java.util.List;

import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Observed
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r WHERE r.chambre.id = :chambreId AND " +
            "(r.dateDebut < :dateFin AND r.dateFin > :dateDebut)")
    List<Reservation> findReservationsByChambreAndDateRange(@Param("chambreId") Long chambreId,
            @Param("dateDebut") LocalDate dateDebut,
            @Param("dateFin") LocalDate dateFin);
}
