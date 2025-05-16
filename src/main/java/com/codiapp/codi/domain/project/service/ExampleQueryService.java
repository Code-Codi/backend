package com.codiapp.codi.domain.project.service;

import com.codiapp.codi.domain.project.dto.ExampleDTO;

// get 요청은 ~QueryService, 나머지 요청은 ~CommandService
public interface ExampleQueryService {
    ExampleDTO.ExampleDetailDTO getExample();
}
