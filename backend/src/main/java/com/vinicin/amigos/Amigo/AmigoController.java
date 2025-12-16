package com.vinicin.amigos.Amigo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class AmigoController {

    private AmigoService amigoService;

    public AmigoController(AmigoService amigoService) {
        this.amigoService = amigoService;
    }

    @PostMapping ("/add")
    public AmigoModel criarAmigo(@RequestBody AmigoModel amigoModel){
        return amigoService.criarAmigo(amigoModel);
    }


}
