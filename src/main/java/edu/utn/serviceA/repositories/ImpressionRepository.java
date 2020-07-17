package edu.utn.serviceA.repositories;

import edu.utn.serviceA.models.Impression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpressionRepository extends JpaRepository<Impression, Integer> {
}
