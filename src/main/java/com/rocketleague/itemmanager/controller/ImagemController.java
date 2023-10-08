package com.rocketleague.itemmanager.controller;

import com.rocketleague.itemmanager.domain.dto.ImagemDTO;
import com.rocketleague.itemmanager.domain.vo.ImagemVO;
import com.rocketleague.itemmanager.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/imagem")
public class ImagemController {

    private final ImagemService imagemService;

    @Autowired
    public ImagemController(ImagemService imagemService) {
        this.imagemService = imagemService;
    }

    @PostMapping("/salvar")
    public ImagemDTO salvarImagens(@RequestParam("imagens") List<ImagemVO> imagens) {
        return imagemService.salvarImagens(imagens);
    }

    @GetMapping("/{id}")
    public byte[] obterImagemPorId(@PathVariable String id) throws IOException {
        return imagemService.obterImagemPorId(id);
    }
}
