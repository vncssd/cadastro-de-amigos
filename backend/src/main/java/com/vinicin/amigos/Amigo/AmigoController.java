package com.vinicin.amigos.Amigo;

import org.springframework.web.bind.annotation.*;

@RestController



public class AmigoController {

    private AmigoModel amigoModel;

    public AmigoController(AmigoModel amigoModel) {
        this.amigoModel = amigoModel;
    }

    @PostMapping("/add")

}
