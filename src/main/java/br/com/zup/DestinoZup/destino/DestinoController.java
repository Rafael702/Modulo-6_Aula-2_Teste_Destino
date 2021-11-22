package br.com.zup.DestinoZup.destino;

import br.com.zup.DestinoZup.destino.dto.DestinoEntradaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoService destinoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Destino cadastrarDestino(@RequestBody @Valid DestinoEntradaDTO destino){
        Destino destinoConvertido = modelMapper.map(destino, Destino.class);
        return destinoService.salvarDestino(destinoConvertido);
    }
}
