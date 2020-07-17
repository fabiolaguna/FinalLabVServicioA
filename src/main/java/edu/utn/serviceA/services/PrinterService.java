package edu.utn.serviceA.services;

import edu.utn.serviceA.models.Printer;
import edu.utn.serviceA.repositories.PrinterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrinterService {

    private final PrinterRepository printerRepository;

    public List<Printer> getPrinters() {

        return printerRepository.findAll();
    }
}
