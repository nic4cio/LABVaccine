package tech.devinhouse.labvaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.labvaccine.dto.AdministracaoVacinaDTO;
import tech.devinhouse.labvaccine.model.AdministracaoVacina;
import tech.devinhouse.labvaccine.service.AdministracaoVacinaService;

@RestController
@RequestMapping("/api/administracao-vacina")
public class AdministracaoVacinaController {

    @Autowired
    private AdministracaoVacinaService administracaoVacinaService;

    @PostMapping
    public ResponseEntity<?> cadastrarAdministracaoVacina(@RequestBody AdministracaoVacinaDTO administracaoVacinaDTO) {
        AdministracaoVacina novaAdministracaoVacina = administracaoVacinaService.cadastrarAdministracaoVacina(administracaoVacinaDTO);
        return new ResponseEntity<>(novaAdministracaoVacina, HttpStatus.CREATED);
    }
}
