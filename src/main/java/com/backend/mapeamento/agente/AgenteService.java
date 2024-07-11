package com.backend.mapeamento.agente;

import com.backend.mapeamento.cidade.Cidade;
import com.backend.mapeamento.cidade.CidadeService;
import com.backend.mapeamento.exception.ClientRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Cidade> cidadeEscolhida = Optional.empty();
        Agente agente = buscaPeloId(id);
        if (!Objects.equals(representacao.getId_cidade(), agente.getCidade().getId())) {
            cidadeEscolhida = Optional.of(cidadeService.buscaPeloId(representacao.getId_cidade()));
        }
        agente = representacao.atualizaAgente(agente, cidadeEscolhida);
        return agenteRepository.save(agente);
    }

    public Agente buscaPeloId(Integer id) {
        return agenteRepository.findById(id)
                .orElseThrow(() -> new ClientRequestException("Agente não encontrado."));
    }

    public void deletar(Integer id) {
        agenteRepository.deleteById(id);
    }

    public List<Agente> buscarVarios() {
        return agenteRepository.findAll();
    }
}
