package com.mabrur.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "portfolios")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Portfolio {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false, unique = false)
    private String title;

    @Column(length = 50, nullable = false, unique = false)
    private String label;

    @Column(length = 200, nullable = false, unique = false)
    private Integer number;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String urlDemo;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String urlFirstSource;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String urlSecondSource;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String urlVideo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String tech;

    @Column(name = "image", unique = false, nullable = true, length = 100000)
    private byte[] image;
}
