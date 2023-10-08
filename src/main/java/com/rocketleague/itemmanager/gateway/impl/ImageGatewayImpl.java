package com.rocketleague.itemmanager.gateway.impl;

import com.rocketleague.itemmanager.exception.PathExistingException;
import com.rocketleague.itemmanager.gateway.ImageGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.String.format;

@Component
public class ImageGatewayImpl implements ImageGateway {

    private final RestTemplate restTemplate;

    public ImageGatewayImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void saveLocally(byte[] bytes, String name, String pathToSave) throws IOException, PathExistingException {
        try {
            Path caminho = Paths.get(pathToSave, name);

            if (Files.exists(caminho)) {
                throw new PathExistingException(format("The path and file %s already exist: ", pathToSave + name));
            }

            Files.createDirectories(caminho.getParent());

            try (FileOutputStream foto = new FileOutputStream(pathToSave)) {
                foto.write(bytes);
            }

        } catch (IOException e) {
            throw new IOException("Error saving the image locally: " + e.getMessage(), e);
        }
    }

    @Override
    public byte[] download(String url) throws IOException {
        try {
            ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class);
            validarResponseStatus(responseEntity);
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new IOException("Image download failed. Status: " + e.getStatusCode(), e);
        } catch (Exception e) {
            throw new IOException("Image download failed: " + e.getMessage(), e);
        }
    }

    private void validarResponseStatus(ResponseEntity<?> responseEntity) throws IOException {
        if (!HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            throw new IOException("Image download failed. Status: " + responseEntity.getStatusCode());
        }
    }
}
