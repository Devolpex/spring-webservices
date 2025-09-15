// package org.devolpex.backend.chambre.controllers;

// import java.util.List;

// import org.devolpex.backend.chambre.ChambreServiceImpl;
// import org.devolpex.backend.chambre.dto.ChambreDto;
// import org.devolpex.backend.chambre.dto.ChambreReq;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort.Direction;
// import org.springframework.stereotype.Component;

// import jakarta.jws.WebMethod;
// import jakarta.jws.WebParam;
// import jakarta.jws.WebService;
// import lombok.RequiredArgsConstructor;

// @Component
// @WebService(serviceName = "ChambreService")
// @RequiredArgsConstructor
// public class ChambreSoap {

//     private ChambreServiceImpl service;

//     @WebMethod
//     public List<ChambreDto> fetchReservationList() {
//         return service.findAll();
//     }

//     @WebMethod
//     public ChambreDto fetchReservationById(@WebParam(name="id") Long id) {
//         return service.findById(id);
//     }

//     @WebMethod
//     public ChambreDto createReservation(ChambreReq chambre) {
//         return service.create(chambre);
//     }

//     @WebMethod
//     public ChambreDto updateReservation(@WebParam(name="id") Long id, ChambreReq chambre) {
//         return service.update(id, chambre);
//     }

//     @WebMethod
//     public void deleteReservation(@WebParam(name="id") Long id) {
//         service.delete(id);
//     }

//     @WebMethod
//     public Page<ChambreDto> fetchReservationPage(@WebParam(name="page") Integer page, @WebParam(name="size") Integer size, @WebParam(name="sortBy") String sortBy, @WebParam(name="orderBy") String orderBy) {
//         Pageable pageable = PageRequest.of(page - 1, size, Direction.valueOf(orderBy.toUpperCase()), sortBy);
//         return service.findAll(pageable);
//     }
    
// }
