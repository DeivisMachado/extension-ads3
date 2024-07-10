package com.backend.mapeamento.cidade;

import com.backend.mapeamento.agente.Agente;
import com.backend.mapeamento.exception.ClientRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public Cidade buscaPeloId(Integer idCidade) {
        return cidadeRepository.findById(idCidade)
                .orElseThrow(() -> new ClientRequestException("Cidade não encontrada."));
    }

    public List<Cidade> buscaTodos(){return cidadeRepository.findAll();}


    public Cidade cadastrar(CidadeRepresentation.Criar representacao) {
        Cidade cidade = representacao.transformaEmCidade();
        return cidadeRepository.save(cidade);
    }
}
