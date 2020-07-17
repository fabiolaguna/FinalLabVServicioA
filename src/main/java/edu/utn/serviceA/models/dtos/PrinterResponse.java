package edu.utn.serviceA.models.dtos;

import edu.utn.serviceA.models.Impression;
import edu.utn.serviceA.models.Printer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PrinterResponse {

    private String brand;

    private String model;

    private List<Impression> impressions;

    public static PrinterResponse fromPrinter(Printer printer){

        return PrinterResponse.builder()
                .brand(printer.getBrand())
                .model(printer.getModel())
                .impressions(printer.getImpressions())
                .build();
    }
}
