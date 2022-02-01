package service;

import entity.Refeicao;

import java.awt.*;

import static javax.swing.JOptionPane.*;
import static util.StaticFilter.*;

public class DialogService {

    private static Object[] opcaoSimOuNao = {"Sim", "Não"};
    private static Object[] opcaoSairOuContinue = {"Sair", "Continue"};

    private static Frame frame = new Frame();

    public static void dialogPenseNoPratoQueGosta() {
        showConfirmDialog(frame,
                PENSE_NO_PRATO_QUE_GOSTA,
                JOGO_INTELIGENCIA_ARTIFICIAL,
                DEFAULT_OPTION,
                PLAIN_MESSAGE
        );
    }

    public static int dialogIsRefeicaoPrincipalMassa() {
        return showOptionDialog(frame,
                REFEICAO_E_MASSA,
                CONFIRMA,
                YES_NO_OPTION,
                QUESTION_MESSAGE,
                null,
                opcaoSimOuNao,
                opcaoSimOuNao[0]
        );
    }

    public static int dialogAcertouDePrimeira(String refeicaoInicial, int yesNoOption) {
        return showOptionDialog(frame,
                refeicaoInicial,
                CONFIRMA,
                yesNoOption,
                QUESTION_MESSAGE,
                null,
                opcaoSimOuNao,
                opcaoSimOuNao[0]
        );
    }

    public static String dialogQualOPratoQueVocePensou() {
        return showInputDialog(frame,
                QUAL_PRATO_QUE_VOCE_PENSOU,
                DESISTO,
                QUESTION_MESSAGE
        );
    }

    public static int dialogAcerteiARefeicaoComONome(Refeicao refeicao) {
        return showOptionDialog(frame,
                PRATO_QUE_PENSOU + refeicao.getNome(),
                CONFIRMA, YES_NO_OPTION,
                QUESTION_MESSAGE,
                null,
                opcaoSimOuNao,
                opcaoSimOuNao[0]
        );
    }

    public static int dialogAcerteiARefeicaoComOAdjetivo(Refeicao refeicao) {
        return showOptionDialog(frame,
                PRATO_QUE_PENSOU + refeicao.getAdjetivo(),
                CONFIRMA, YES_NO_OPTION, QUESTION_MESSAGE,
                null, opcaoSimOuNao,
                opcaoSimOuNao[0]
        );
    }

    public static String dialogAdicionarAdjetivoARefeicao(String nome, String tipoRefeicao) {
        return showInputDialog(frame,
                nome + tipoRefeicao,
                COMPLETE,
                QUESTION_MESSAGE
        );
    }

    public static void dialogCampoVazio() {
        showConfirmDialog(frame,
                CAMPO_VAZIO,
                JOGO_GOURMET,
                DEFAULT_OPTION,
                WARNING_MESSAGE,
                null
        );
    }

    public static int dialogAcerteiDeNovo() {
        return showOptionDialog(frame,
                ACERTEI,
                JOGO_GOURMET,
                DEFAULT_OPTION,
                INFORMATION_MESSAGE,
                null,
                opcaoSairOuContinue,
                opcaoSairOuContinue[1]
        );
    }
}
