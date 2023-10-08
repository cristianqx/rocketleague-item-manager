package com.rocketleague.itemmanager.entrypoint.impl;

import com.rocketleague.itemmanager.domain.dto.ImageDTO;
import com.rocketleague.itemmanager.domain.vo.ImagemVO;
import com.rocketleague.itemmanager.entrypoint.ImageController;
import com.rocketleague.itemmanager.exception.ForbiddenException;
import com.rocketleague.itemmanager.usecase.impl.ImageUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagem")
public class ImageControllerImpl implements ImageController {

    private static final String EXECUTION_KEY = "991599a930e960dc07956114f4429366";
    private final ImageUseCaseImpl imageUseCaseImpl;

    @Autowired
    public ImageControllerImpl(ImageUseCaseImpl imageUseCaseImpl) {
        this.imageUseCaseImpl = imageUseCaseImpl;
    }

    @Override
    public ImageDTO saveImages(final String executionKey,
                               final List<ImagemVO> imagens) {
        if (!checkExecutionKey(executionKey)) {
            throw new ForbiddenException("Chave de execução inválida");
        }
        return imageUseCaseImpl.saveImages(imagens);
    }

    public byte[] obterImagemPorId(final String id) {
        return imageUseCaseImpl.obterImagemPorId(id);
    }

    private Boolean checkExecutionKey(final String executionKey) {
        return EXECUTION_KEY.equalsIgnoreCase(executionKey);
    }
}
