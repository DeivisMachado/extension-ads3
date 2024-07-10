package com.backend.mapeamento.agente;

import com.backend.mapeamento.cidade.Cidade;
import com.backend.mapeamento.cidade.CidadeService;
import com.backend.mapeamento.exception.ClientRequestException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AgenteService {

    private AgenteRepository agenteRepository;
    private CidadeService cidadeService;

    public Agente cadastrar(AgenteRepresentation.Criar representacao) {
        Cidade cidadeEscolhida = cidadeService.buscaPeloId(representacao.getId_cidade());
        Agente agente = representacao.transformaEmAgente(cidadeEscolhida);
        return agenteRepository.save(agente);

    }

    public Agente atualizar(Integer id,
                            AgenteRepresentation.Atualizar representacao) {
        Agente agente = representacao.atualizaAgente(buscaPeloId(id));
        return agenteRepository.save(agente);
    }

    public Agente buscaPeloId(Integer id) {
        return agenteRepository.findById(id)
                .orElseThrow(() -> new ClientRequestException("Agente não encontrado."));
    }

    public ResponseEntity<Void> deletar(Integer id) {
        agenteRepository.deleteById(id);
        return null;
    }

    public List<Agente> buscarVarios() {
        return agenteRepository.findAll();
    }
}
