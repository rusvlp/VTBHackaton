package com.example.demo.controllers;

import com.example.demo.entites.Image;
import com.example.demo.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@Controller
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id){
        Image image = imageService.getImageById(id);
        return ResponseEntity.ok().
                header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public Boolean delete(@PathVariable Long id/*, Model m, Principal p*/){
        return imageService.deleteById(id);
        /*if (imageService.deleteById(id)){
            m.addAttribute("message", "Успешно удалено");
        } else {
            m.addAttribute("message", "Не удалось удалить");
        }
        return "success"; */
    }
}
