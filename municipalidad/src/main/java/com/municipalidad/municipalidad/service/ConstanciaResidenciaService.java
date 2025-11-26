package com.municipalidad.municipalidad.service;

import com.municipalidad.municipalidad.dto.ConstanciaResidenciaDTO;
import com.municipalidad.municipalidad.dto.CreateConstanciaRequest;
import com.municipalidad.municipalidad.entity.ConstanciaResidencia;
import com.municipalidad.municipalidad.entity.User;
import com.municipalidad.municipalidad.repository.ConstanciaResidenciaRepository;
import com.municipalidad.municipalidad.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConstanciaResidenciaService {

    private final ConstanciaResidenciaRepository repository;
    private final UserRepository userRepository;

    public ConstanciaResidenciaDTO create(CreateConstanciaRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        ConstanciaResidencia entity = new ConstanciaResidencia();
        entity.setDireccion(request.getDireccion());
        entity.setMotivo(request.getMotivo());
        entity.setEstado(ConstanciaResidencia.Estado.ENVIADO);
        entity.setUser(user);

        return mapToDTO(repository.save(entity));
    }

    public List<ConstanciaResidenciaDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<ConstanciaResidenciaDTO> getMyRequests() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        return repository.findAll().stream()
                .filter(c -> c.getUser().getId().equals(user.getId()))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ConstanciaResidenciaDTO mapToDTO(ConstanciaResidencia entity) {
        return new ConstanciaResidenciaDTO(
                entity.getId(),
                entity.getUser().getId(),
                entity.getUser().getFirstname() + " " + entity.getUser().getLastname(),
                entity.getDireccion(),
                entity.getMotivo(),
                entity.getEstado()
        );
    }
}
