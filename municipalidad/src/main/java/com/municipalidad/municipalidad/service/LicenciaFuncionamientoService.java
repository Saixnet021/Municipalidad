package com.municipalidad.municipalidad.service;

import com.municipalidad.municipalidad.dto.CreateLicenciaRequest;
import com.municipalidad.municipalidad.dto.LicenciaFuncionamientoDTO;
import com.municipalidad.municipalidad.entity.LicenciaFuncionamiento;
import com.municipalidad.municipalidad.entity.User;
import com.municipalidad.municipalidad.repository.LicenciaFuncionamientoRepository;
import com.municipalidad.municipalidad.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LicenciaFuncionamientoService {

    private final LicenciaFuncionamientoRepository repository;
    private final UserRepository userRepository;

    public LicenciaFuncionamientoDTO create(CreateLicenciaRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        LicenciaFuncionamiento entity = new LicenciaFuncionamiento();
        entity.setNegocio(request.getNegocio());
        entity.setRuc(request.getRuc());
        entity.setDireccion(request.getDireccion());
        entity.setRepresentante(request.getRepresentante());
        entity.setEstado(LicenciaFuncionamiento.Estado.ENVIADO);
        entity.setUser(user);

        return mapToDTO(repository.save(entity));
    }

    public List<LicenciaFuncionamientoDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<LicenciaFuncionamientoDTO> getMyRequests() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        return repository.findAll().stream()
                .filter(l -> l.getUser().getId().equals(user.getId()))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private LicenciaFuncionamientoDTO mapToDTO(LicenciaFuncionamiento entity) {
        return new LicenciaFuncionamientoDTO(
                entity.getId(),
                entity.getUser().getId(),
                entity.getNegocio(),
                entity.getRuc(),
                entity.getDireccion(),
                entity.getRepresentante(),
                entity.getEstado()
        );
    }
}
