package com.github.samuelmodesto.solid.service;

import com.github.samuelmodesto.solid.ValidacaoException;
import com.github.samuelmodesto.solid.model.Cargo;
import com.github.samuelmodesto.solid.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida){
        Cargo cargoAtual = funcionario.getCargo();
        if(Cargo.GERENTE == cargoAtual){
            throw new ValidacaoException("Gerentes nao podem ser promovidos");
        }

        if(metaBatida){
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);

        } else{
            throw new ValidacaoException("Funcionario nao bateu a meta");
        }
    }
}
