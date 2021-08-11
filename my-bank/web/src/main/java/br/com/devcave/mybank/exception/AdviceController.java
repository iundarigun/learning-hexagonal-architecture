package br.com.devcave.mybank.exception;

import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class AdviceController {
    private final Tracer tracer;

    @ExceptionHandler(MyBankException.class)
    public ResponseEntity<ErrorResponse> myBankExceptionHandler(final MyBankException myBankException) {
        log.info("myBankExceptionHandler");
        return myBankExceptionHandler(myBankException, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> myBankExceptionHandler(final MyBankException myBankException,
                                                                 final HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus)
                .body(new ErrorResponse(
                        tracer.currentSpan().context().traceIdString(),
                        myBankException.getErrorList()
                ));
    }
}
