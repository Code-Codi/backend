package com.codiapp.codi.domain.board.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageRequestDTO {
    private int page = 1;        
    private int size = 10;        

    public int getOffset() {
        return (page - 1) * size;
    }
}
