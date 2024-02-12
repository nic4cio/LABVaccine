package tech.devinhouse.labvaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.labvaccine.model.Estatisticas;
import tech.devinhouse.labvaccine.service.EstatisticasService;

@RestController
@RequestMapping("/api/estatisticas")
public class EstatisticasController {

    @Autowired
    private EstatisticasService estatisticasService;

    @GetMapping
    public ResponseEntity<Estatisticas> getEstatisticas() {
        Estatisticas estatisticas = estatisticasService.getEstatisticas();
        return new ResponseEntity<>(estatisticas, HttpStatus.OK);
    }
}
