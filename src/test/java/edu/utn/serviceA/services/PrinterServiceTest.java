package edu.utn.serviceA.services;

import edu.utn.serviceA.models.Printer;
import edu.utn.serviceA.repositories.PrinterRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PrinterServiceTest {

    PrinterService printerService;

    @Mock
    PrinterRepository printerRepository;

    @Before
    public void setUp(){
        initMocks(this);
        printerService = new PrinterService(printerRepository);
    }

    @Test
    public void getPrinters(){

        List<Printer> printers = new ArrayList<>();

        when(printerRepository.findAll()).thenReturn(printers);

        Assert.assertEquals(printers, printerService.getPrinters());
    }
}
