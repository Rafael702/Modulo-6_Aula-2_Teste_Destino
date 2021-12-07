package br.com.zup.DestinoZup;

import br.com.zup.DestinoZup.categoria.Categoria;
import br.com.zup.DestinoZup.categoria.CategoriaRepository;
import br.com.zup.DestinoZup.destino.DestinoRepository;
import br.com.zup.DestinoZup.destino.DestinoService;
import br.com.zup.DestinoZup.regiao.RegiaoRepository;
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
	public void testarSalvarDestinoCaminhoRuim(){
		Mockito.when(regiaoRepository.existsById(Mockito.anyString())).thenReturn(true);
	}



}
