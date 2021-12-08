package br.com.zup.DestinoZup;

import br.com.zup.DestinoZup.categoria.CategoriaRepository;
import br.com.zup.DestinoZup.destino.Destino;
import br.com.zup.DestinoZup.destino.DestinoRepository;
import br.com.zup.DestinoZup.destino.DestinoService;
import br.com.zup.DestinoZup.destino.exceptions.RegiaoNaoEncontradaException;
import br.com.zup.DestinoZup.regiao.Regiao;
import br.com.zup.DestinoZup.regiao.RegiaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DestinoZupApplicationTests {

    @MockBean
    private DestinoRepository destinoRepository;
    @MockBean
    private RegiaoRepository regiaoRepository;
    @MockBean
    private CategoriaRepository categoriaRepository;

    @Autowired
    private DestinoService destinoService;

    @Test
    public void testarSalvarDestinoCaminhoRuim() {
        Mockito.when(regiaoRepository.existsById(Mockito.anyString())).thenReturn(false);
        Destino destino = new Destino();
        Regiao regiao = new Regiao();
        regiao.setNome("Xablau");
        destino.setRegiao(regiao);

        Assertions.assertThrows(RegiaoNaoEncontradaException.class, () -> {
            destinoService.salvarDestino(destino);
        });
    }

    public void testarSalvarDestinoCaminhoBom() {
        Mockito.when(regiaoRepository.existsById(Mockito.anyString())).thenReturn(true);

        Destino destino = new Destino();
        Regiao regiao = new Regiao();
        regiao.setNome("Xablau");
        destino.setRegiao(regiao);

        Mockito.when(regiaoRepository.existsById(Mockito.anyString())).thenReturn(true);
        Mockito.when(destinoRepository.save(Mockito.any(Destino.class))).thenReturn(destino);

        destinoService.salvarDestino(destino);
        //Mockito Verify verifica quantas vezes
        Mockito.verify(destinoService.salvarDestino(destino));

    }


}
