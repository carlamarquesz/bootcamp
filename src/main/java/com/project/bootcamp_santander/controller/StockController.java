package com.project.bootcamp_santander.controller;

import com.project.bootcamp_santander.model.dto.StockDTO;
import com.project.bootcamp_santander.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController /*Servidor que segue padroes Rest*/
@RequestMapping(value = "/stock") /*Quem quiser acessar o controlador será por essa url e acionar a classe java
StockController*/
public class StockController { /*Criar os Endpoints aqui (GET,PUT,PUSH, DELETE)*/

    /*Vai entender se tem ou nao que vai chamar o repository*/
    @Autowired
    private StockService service;
    /*Endpoint com metodo post pois está inserindo "algo" com o save ,
    quero consumir(ele vai enviar) esses dados em Json e produzir(Devolver) um JSON tb. */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) /*Vou responder o StockDTO que enviou
    no body da requisição os dados(atributos) */{
        return ResponseEntity.ok(service.save(dto)); /*Enviou o dto que ele enviou*/
    }

    /*Metodo PUT*/
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
//        return ResponseEntity.ok(dto);
//    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }
    /*Metodo GET*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findALL(){
//        List<StockDTO> list = new ArrayList<>();
//        StockDTO dto = new StockDTO();
//        dto.setId(1L);
//        dto.setName("Magazine Luiza");
//        dto.setPrice(200D);
//        dto.setVariation(-10D);
//        dto.setDate(LocalDate.now());
//        list.add(dto);
//        return ResponseEntity.ok(list);
        return ResponseEntity.ok(service.findALL());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
//        List<StockDTO> list = new ArrayList<>();
//        StockDTO stock1 = new StockDTO();
//        stock1.setId(1L);
//        stock1.setName("Magazine Luiza");
//        stock1.setPrice(1000.0);
//        stock1.setVariation(100.0);
//        stock1.setDate(LocalDate.now());
//        StockDTO stock2 = new StockDTO();
//        stock2.setId(2L);
//        stock2.setName("Ponto Frio");
//        stock2.setPrice(2000.0);
//        stock2.setVariation(50.0);
//        stock2.setDate(LocalDate.now());
//        list.add(stock1);
//        list.add(stock2);
//        StockDTO dtoSelect = list.stream().filter(x -> x.getId().compareTo(id)==0).findFirst().get();
        /*Percorre a lista retornando uma string e fazendo um filtro pegando quem ta pecorrendo com o ID que
        to enviando, se for igual a 0 é pq eh igual. (0=igual, -1= menor, 1=igual)*/
        return ResponseEntity.ok(service.findById(id));

    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday() {
        return ResponseEntity.ok(service.findByToday());
    }
}
