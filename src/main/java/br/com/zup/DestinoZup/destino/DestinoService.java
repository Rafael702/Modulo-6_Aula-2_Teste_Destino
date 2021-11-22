package br.com.zup.DestinoZup.destino;

import br.com.zup.DestinoZup.categoria.CategoriaRepository;
import br.com.zup.DestinoZup.regiao.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DestinoService {
    private DestinoRepository destinoRepository;
    private RegiaoRepository regiaoRepository;
    private CategoriaRepository categoriaRepository;

    @Autowired
    public DestinoService(DestinoRepository destinoRepository, RegiaoRepository regiaoRepository, CategoriaRepository categoriaRepository) {
        this.destinoRepository = destinoRepository;
        this.regiaoRepository = regiaoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Destino salvarDestino(Destino destino){
        if(!regiaoRepository.existsById(destino.getRegiao().getNome())){
            throw new RuntimeException("Região não existe");
        }

        return destinoRepository.save(destino);
    }
}
