package com.rocketleague.itemmanager.entrypoint;

import com.rocketleague.itemmanager.domain.dto.ImageDTO;
import com.rocketleague.itemmanager.domain.vo.ImagemVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ImageController {

    @PostMapping
    ImageDTO saveImages(
            @RequestHeader(name = "Execution-Key") String executionKey,
            @RequestBody List<ImagemVO> imagens);

    @GetMapping("/{id}")

    byte[] obterImagemPorId(@PathVariable String id);
}

