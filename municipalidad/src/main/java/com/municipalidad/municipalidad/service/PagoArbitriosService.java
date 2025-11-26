package com.municipalidad.municipalidad.service;

import com.municipalidad.municipalidad.dto.CreateArbitrioRequest;
import com.municipalidad.municipalidad.dto.PagoArbitriosDTO;
import com.municipalidad.municipalidad.entity.PagoArbitrios;
import com.municipalidad.municipalidad.entity.User;
import com.municipalidad.municipalidad.repository.PagoArbitriosRepository;
import com.municipalidad.municipalidad.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagoArbitriosService {

    private final PagoArbitriosRepository repository;
    private final UserRepository userRepository;

    public PagoArbitriosDTO create(CreateArbitrioRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        PagoArbitrios entity = new PagoArbitrios();
        entity.setTipo(request.getTipo());
        entity.setMonto(request.getMonto());
        entity.setEstadoPago(PagoArbitrios.EstadoPago.PENDIENTE);
        entity.setUser(user);

        return mapToDTO(repository.save(entity));
    }

    public List<PagoArbitriosDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<PagoArbitriosDTO> getMyDebts() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        return repository.findAll().stream()
                .filter(p -> p.getUser().getId().equals(user.getId()))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void pay(Long id) {
        PagoArbitrios entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Arbitrio not found"));
        entity.setEstadoPago(PagoArbitrios.EstadoPago.PAGADO);
        repository.save(entity);
    }

    private PagoArbitriosDTO mapToDTO(PagoArbitrios entity) {
        return new PagoArbitriosDTO(
                entity.getId(),
                entity.getUser().getId(),
                entity.getUser().getFirstname() + " " + entity.getUser().getLastname(),
                entity.getTipo(),
                entity.getMonto(),
                entity.getEstadoPago()
        );
    }
}
