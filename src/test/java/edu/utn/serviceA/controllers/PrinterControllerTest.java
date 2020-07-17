package edu.utn.serviceA.controllers;

import edu.utn.serviceA.models.Printer;
import edu.utn.serviceA.models.dtos.PrinterResponse;
import edu.utn.serviceA.services.PrinterService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PrinterControllerTest {

    PrinterController printerController;

    @Mock
    PrinterService printerService;

    @Before
    public void setUp(){
        initMocks(this);
        printerController = new PrinterController(printerService);
    }

    @Test
    public void getPrintersNoContent(){

        List<Printer> printers = new ArrayList<>();

        when(printerService.getPrinters()).thenReturn(printers);

        Assert.assertEquals(ResponseEntity.noContent().build(), printerController.getPrinters());
    }

    @Test
    public void getPrintersOk(){

        List<Printer> printers = new ArrayList<>();
        printers.add(new Printer());

        when(printerService.getPrinters()).thenReturn(printers);

        Assert.assertEquals(ResponseEntity.ok(printers.stream().map(PrinterResponse::fromPrinter)
                .collect(Collectors.toList())), printerController.getPrinters());
    }

}
