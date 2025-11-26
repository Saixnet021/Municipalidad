package com.municipalidad.municipalidad.service;

import com.municipalidad.municipalidad.dto.CreateMesaDePartesRequest;
import com.municipalidad.municipalidad.dto.MesaDePartesDTO;
import com.municipalidad.municipalidad.entity.MesaDePartes;
import com.municipalidad.municipalidad.entity.User;
import com.municipalidad.municipalidad.repository.MesaDePartesRepository;
import com.municipalidad.municipalidad.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MesaDePartesService {

    private final MesaDePartesRepository repository;
    private final UserRepository userRepository;
    private final String UPLOAD_DIR = "uploads/";

    public MesaDePartesDTO create(CreateMesaDePartesRequest request) throws IOException {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        String fileName = null;
        if (request.getArchivo() != null && !request.getArchivo().isEmpty()) {
            fileName = saveFile(request.getArchivo());
        }

        MesaDePartes mesaDePartes = new MesaDePartes();
        mesaDePartes.setAsunto(request.getAsunto());
        mesaDePartes.setDescripcion(request.getDescripcion());
        mesaDePartes.setArchivoAdjunto(fileName);
        mesaDePartes.setEstado(MesaDePartes.Estado.ENVIADO);
        mesaDePartes.setUser(user);

        MesaDePartes saved = repository.save(mesaDePartes);
        return mapToDTO(saved);
    }

    public List<MesaDePartesDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<MesaDePartesDTO> getMyRequests() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        // Assuming repository has findByUserId, if not I need to add it or use findAll and filter (bad performance but ok for now)
        // Better to update repository.
        return repository.findAll().stream()
                .filter(m -> m.getUser().getId().equals(user.getId()))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private String saveFile(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);
        return fileName;
    }

    private MesaDePartesDTO mapToDTO(MesaDePartes entity) {
        return new MesaDePartesDTO(
                entity.getId(),
                entity.getUser().getId(),
                entity.getUser().getFirstname() + " " + entity.getUser().getLastname(),
                entity.getAsunto(),
                entity.getDescripcion(),
                entity.getArchivoAdjunto(),
                entity.getEstado()
        );
    }
}
