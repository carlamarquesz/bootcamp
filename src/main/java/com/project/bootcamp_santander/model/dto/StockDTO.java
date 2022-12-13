package com.project.bootcamp_santander.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
/*DTO sao os dados que eu vou receber através da minha requisição*/
public class StockDTO { /*CLASSE Q EU USO PARA INTERAGIR COM O CONTROLADOR(DADOS QUE VEM DE FORA, OU SEJA
QUE ESTAO REQUISITANDO, E OS QUE EU VOU RETORNAR.*/
    /*Atributos e metodos de acessores(GET E SETTERS) criados */
    /*No caso do ID quem vai mandar eh o banco de dados e pode vim nulo*/
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 6, fraction = 2)
    private Double price;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
    @NotNull
    @Digits(integer = 3, fraction = 2)
    private Double variation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }
}
