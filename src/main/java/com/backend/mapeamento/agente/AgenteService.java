package com.backend.mapeamento.agente;

import com.backend.mapeamento.exception.ClientRequestException;

import java.util.List;

public class AgenteService {

    private AgenteRepository agenteRepository;

    public Agente cadastrar(AgenteRepresentation.Criar representacao) {
        Agente agente = representacao.transformaEmAgente();
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

    public void deletar(Integer id) {
        agenteRepository.deleteById(id);
    }

    public List<Agente> buscarVarios() {
        return agenteRepository.findAll();
    }
}
