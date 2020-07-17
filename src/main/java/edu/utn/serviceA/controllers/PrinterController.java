package edu.utn.serviceA.controllers;

import edu.utn.serviceA.models.Printer;
import edu.utn.serviceA.models.dtos.PrinterResponse;
import edu.utn.serviceA.services.PrinterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "PrinterController")
@RequestMapping("/printers")
@RequiredArgsConstructor
public class PrinterController {

    private final PrinterService printerService;

    @GetMapping
    @ApiOperation(value = "getPrinters", notes = "Metodo encargado de retornar todas las impresoras")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_NO_CONTENT, message = "Retorna una lista vacia de impresoras"),
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Retorna una lista de impresoras")
    })
    public ResponseEntity<List<PrinterResponse>> getPrinters(){

        List<Printer> printers = printerService.getPrinters();

        return printers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(printers.stream()
                                                                                     .map(PrinterResponse::fromPrinter)
                                                                                     .collect(Collectors.toList()));
    }
}
