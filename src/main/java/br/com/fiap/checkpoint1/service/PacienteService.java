package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.PacienteCriacaoDTO;
import br.com.fiap.checkpoint1.dto.PacienteDTO;
import br.com.fiap.checkpoint1.model.Paciente;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PacienteService {

    private final Map<Long, Paciente> pacienteMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // Criação de um novo paciente.
    public PacienteDTO create(PacienteCriacaoDTO dto) {
        Long id = idCounter.getAndIncrement();
        Paciente paciente = new Paciente(
                dto.getNome(),
                dto.getEndereco(),
                dto.getBairro(),
                dto.getEmail(),
                dto.getTelefoneCompleto()
        );
        paciente.setId(id);
        pacienteMap.put(id, paciente);
        return toDTO(paciente);
    }

    public PacienteDTO update(Long id, PacienteCriacaoDTO dto) {
        Paciente paciente = pacienteMap.get(id);
        if (paciente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
        paciente.setNome(dto.getNome());
        paciente.setEndereco(dto.getEndereco());
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefoneCompleto(dto.getTelefoneCompleto());
        return toDTO(paciente);
    }

    public void delete(Long id) {
        if (pacienteMap.remove(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
    }


    public PacienteDTO findById(Long id) {
        Paciente paciente = pacienteMap.get(id);
        if (paciente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
        return toDTO(paciente);
    }

    public List<PacienteDTO> findAll() {
        List<PacienteDTO> lista = new ArrayList<>();
        for (Paciente paciente : pacienteMap.values()) {
            lista.add(toDTO(paciente));
        }
        return lista;
    }
    
    private PacienteDTO toDTO(Paciente paciente) {
        return new PacienteDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEndereco(),
                paciente.getBairro(),
                paciente.getEmail(),
                paciente.getTelefoneCompleto()
        );
    }
}
