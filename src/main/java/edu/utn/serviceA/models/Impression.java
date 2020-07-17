package edu.utn.serviceA.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "impressions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Impression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_impression")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_printer", nullable = false)
    private Printer printer;
}
