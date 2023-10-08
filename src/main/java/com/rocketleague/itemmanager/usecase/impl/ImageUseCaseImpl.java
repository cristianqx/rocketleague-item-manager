package com.rocketleague.itemmanager.usecase.impl;


import com.rocketleague.itemmanager.domain.dto.ImageDTO;
import com.rocketleague.itemmanager.domain.vo.ImagemVO;
import com.rocketleague.itemmanager.exception.PathExistingException;
import com.rocketleague.itemmanager.gateway.ImageGateway;
import com.rocketleague.itemmanager.usecase.ImageUseCase;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageUseCaseImpl implements ImageUseCase {

    private static final Logger log = LoggerFactory.getLogger(ImageUseCaseImpl.class);
    private static final String PATH_IMAGE = "/var/www/rocketleague-item-manager/images/";
    private final ImageGateway imagemGateway;

    public ImageUseCaseImpl(ImageGateway imagemGateway) {
        this.imagemGateway = imagemGateway;
    }

    @Override
    public ImageDTO saveImages(final List<ImagemVO> imagens) {
        ImageDTO dto = new ImageDTO();
        List<String> erroredFileNames = new ArrayList<>();

        imagens.forEach(imagem -> {
            try {
                byte[] imagemBytes = imagemGateway.download(imagem.getSrc());
                String nomeArquivo = extractFileNameFromURL(imagem.getSrc());
                imagemGateway.saveLocally(imagemBytes, nomeArquivo, PATH_IMAGE);
            } catch (IOException | PathExistingException e) {
                erroredFileNames.add(extractFileNameFromURL(imagem.getSrc()));
                log.error("Error saving image: {}", e.getMessage());
            }
        });

        dto.setFailureCount(erroredFileNames.size());
        dto.setReceivedCount(imagens.size());
        dto.setSavedCount(imagens.size() - erroredFileNames.size());
        dto.setErroredFileNames(erroredFileNames);
        return dto;
    }

    @Override
    public byte[] obterImagemPorId(String id) {
        return null;
    }

    private String extractFileNameFromURL(String url) {
        String nameFile = url.substring(url.lastIndexOf('/') + 1).split("[?#]")[0];
        int indexLastPoint = nameFile.lastIndexOf('.');
        return (indexLastPoint > 0) ? nameFile : null;
    }
}
