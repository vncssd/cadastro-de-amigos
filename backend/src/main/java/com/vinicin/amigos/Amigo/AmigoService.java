package com.vinicin.amigos.Amigo;

import org.springframework.stereotype.Service;

@Service
public class AmigoService {

    private AmigoRepository amigoRepository;

    public AmigoService(AmigoRepository amigoRepository) {
        this.amigoRepository = amigoRepository;
    }

    public AmigoModel criarAmigo(AmigoModel amigoModel){
        return amigoRepository.save(amigoModel);
    }
}
