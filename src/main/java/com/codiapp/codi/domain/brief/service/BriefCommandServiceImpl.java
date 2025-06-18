package com.codiapp.codi.domain.brief.service;

import com.codiapp.codi.domain.brief.converter.BriefConverter;
import com.codiapp.codi.domain.brief.dto.request.BriefCreateRequestDTO;
import com.codiapp.codi.domain.brief.dto.request.BriefUpdateRequestDTO;
import com.codiapp.codi.domain.brief.entity.Brief;
import com.codiapp.codi.domain.brief.repository.BriefRepository;
import com.codiapp.codi.domain.user.entity.User;
import com.codiapp.codi.domain.user.repository.UserRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.BriefHandler;
import com.codiapp.codi.global.apiPayload.exception.handler.UserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BriefCommandServiceImpl implements BriefCommandService {

    private final BriefRepository briefRepository;
    private final UserRepository userRepository;

    @Override
    public Long createBrief(BriefCreateRequestDTO request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        Brief brief = BriefConverter.toTaskGuide(request, user);
        return briefRepository.save(brief).getId();
    }

    @Transactional
    @Override
    public void updateBrief(Long briefId,BriefUpdateRequestDTO request) {
        Brief brief = briefRepository.findById(briefId)
                .orElseThrow(()-> new BriefHandler(ErrorStatus.BRIEF_NOT_FOUND));

        brief.updateBrief(request);
    }

}
