package tech.devinhouse.labvaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/{identificador}")
    public ResponseEntity<AdministracaoVacina> atualizarAdministracaoVacina(
            @PathVariable Long identificador,
            @RequestBody AdministracaoVacinaDTO administracaoVacinaDTO) {

        AdministracaoVacina administracaoVacinaAtualizada = administracaoVacinaService.atualizarAdministracaoVacina(identificador, administracaoVacinaDTO);

        return new ResponseEntity<>(administracaoVacinaAtualizada, HttpStatus.OK);
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<AdministracaoVacina> getAdministracaoVacina(@PathVariable Long identificador) {
        AdministracaoVacina administracaoVacina = administracaoVacinaService.getAdministracaoVacinaById(identificador);
        if (administracaoVacina != null) {
            return ResponseEntity.ok(administracaoVacina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{identificador}")
    public ResponseEntity<?> excluirAdministracaoVacina(@PathVariable Long identificador) {
        administracaoVacinaService.excluirAdministracaoVacinaById(identificador);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
