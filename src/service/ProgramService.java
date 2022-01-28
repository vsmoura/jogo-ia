package service;

import entity.Refeicao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.swing.JOptionPane.*;
import static service.DialogService.*;
import static util.StaticFilter.*;

public class ProgramService {

    public static void program(List<Refeicao> refeicaoPrincipal, List<Refeicao> sobremessa) {

        dialogPenseNoPratoQueGosta();

        int reposta = dialogIsRefeicaoPrincipalMassa();

        if (reposta == YES_NO_OPTION) {
            fluxoDePerguntas(refeicaoPrincipal,
                    REFEICAO_E_MASSA,
                    REFEICAO_LASANHA,
                    YES_NO_OPTION
            );
        } else {
            fluxoDePerguntas(sobremessa,
                    REFEICAO_E_BOLO_DE_CHOCOLATE,
                    REFEICAO_E_BOLO_DE_CHOCOLATE,
                    DEFAULT_OPTION
            );
        }
    }

    private static void fluxoDePerguntas(List<Refeicao> refeicoes, String tipoReceicao, String refeicaoInicial, int yesNoOption) {
        if (refeicoes.size() > 0) {
            boolean voltarInicio = logicaInteligenciaArtificial(refeicoes, tipoReceicao);
            if (voltarInicio) {
                return;
            }
        }

        int resposta = dialogAcertouDePrimeira(refeicaoInicial, yesNoOption);

        AcerteiOuAdicionarNovaRefeicao(refeicoes, tipoReceicao, resposta);
    }

    private static void AcerteiOuAdicionarNovaRefeicao(List<Refeicao> refeicoes, String tipoReceicao, int resposta) {
        if (resposta == YES_NO_OPTION) {
            acerteiDeNovo();
        } else {
            adicionarNovaRefeicao(refeicoes, tipoReceicao);
        }
    }

    private static boolean logicaInteligenciaArtificial(List<Refeicao> refeicaos, String tipoRefeicao) {
        List<Refeicao> refeicaoList = new ArrayList<>();
        boolean voltarInicio = false;

        for (Refeicao listaPratos : refeicaos) {

            int resposta = dialogAcerteiARefeicaoComOAdjetivo(listaPratos);

            if (resposta == YES_NO_OPTION) {
                int eEsse = dialogAcerteiARefeicaoComONome(listaPratos);
                AcerteiOuAdicionarNovaRefeicao(refeicaoList, tipoRefeicao, eEsse);
                voltarInicio = true;
            }
        }

        refeicaos.addAll(refeicaoList);
        return voltarInicio;
    }

    private static void adicionarNovaRefeicao(List<Refeicao> refeicaos, String tipoRefeicao) {
        String nome = dialogQualOPratoQueVocePensou();

        if (nome != null && !nome.isEmpty()) {
            String adjetivo;

            if (Objects.equals(tipoRefeicao, REFEICAO_E_MASSA)) {
                adjetivo = dialogAdicionarAdjetivoARefeicao(nome, COMPLETE_ADJETIVO_REFEICAO_PRINCIPAL);
            } else {
                adjetivo = dialogAdicionarAdjetivoARefeicao(nome, COMPLETE_ADJETIVO_SOBREMESSA);
            }
            refeicaos.add(new Refeicao(nome, adjetivo));
        } else {
            dialogCampoVazio();
        }
    }

    private static void acerteiDeNovo() {
        int resposta = dialogAcerteiDeNovo();

        fecharPrograma(resposta);
    }

    private static void fecharPrograma(int resposta) {
        if (resposta == YES_OPTION) {
            System.exit(0);
        }
    }
}
