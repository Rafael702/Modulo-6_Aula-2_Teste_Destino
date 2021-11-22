package br.com.zup.DestinoZup.destino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoService destinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Destino cadastrarDestino(@RequestBody Destino destino){
        return destinoService.salvarDestino(destino);
    }
}
