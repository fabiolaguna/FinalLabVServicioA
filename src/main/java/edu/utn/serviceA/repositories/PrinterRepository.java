package edu.utn.serviceA.repositories;

import edu.utn.serviceA.models.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrinterRepository extends JpaRepository<Printer, Integer> {
}
