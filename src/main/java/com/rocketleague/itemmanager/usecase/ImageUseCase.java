package com.rocketleague.itemmanager.usecase;

import com.rocketleague.itemmanager.domain.dto.ImageDTO;
import com.rocketleague.itemmanager.domain.vo.ImagemVO;

import java.util.List;

public interface ImageUseCase {
    ImageDTO saveImages(List<ImagemVO> imagens);
    byte[] obterImagemPorId(String id);
}
