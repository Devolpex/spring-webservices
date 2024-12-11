package org.devolpex.backend.handler;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OwnErrorRES {
    private String message;
    private List<OwnFieldError> fieldErrors;
    private HttpStatus status;
}
