package services;

import enums.Cargo;
import exceptions.ValidacaoException;
import model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida) {
        Cargo cargoAtual = funcionario.getCargo();
        if (Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerentes não podem ser promovidos");
        }
        if (metaBatida) {
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionário não bateu a meta");
        }
    }
}
