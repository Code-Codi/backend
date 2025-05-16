package com.codiapp.codi.domain.project.service;

import com.codiapp.codi.domain.project.dto.ExampleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleQueryServiceImpl implements ExampleQueryService {
    @Override
    public ExampleDTO.ExampleDetailDTO getExample() {
        return new ExampleDTO.ExampleDetailDTO("제목");
    }
}
