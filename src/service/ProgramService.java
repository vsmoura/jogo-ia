package service;

import entity.Prato;
import util.StaticFilter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramService {

    private static Object[] optionsContinue = {"Continue", "Sair"};

    public static void program(Frame frame, Object[] options, java.util.List<Prato> pratosSalgados, java.util.List<Prato> pratosDoces) {
        JOptionPane.showConfirmDialog(frame, StaticFilter.PRATO_QUE_GOSTA, StaticFilter.JOGO_INTELIGENCIA_ARTIFICIAL, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);

        int massa = JOptionPane.showOptionDialog(frame, StaticFilter.PRATO_MASSA, StaticFilter.CONFIRM, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (massa == JOptionPane.YES_NO_OPTION) {
            fluxoPerguntas(frame, options, pratosSalgados, StaticFilter.PRATO_MASSA, StaticFilter.PRATO_LASANHA, JOptionPane.YES_NO_OPTION);
        } else {
            fluxoPerguntas(frame, options, pratosDoces, StaticFilter.PRATO_BOLO_DE_CHOCOLATE, StaticFilter.PRATO_BOLO_DE_CHOCOLATE, JOptionPane.DEFAULT_OPTION);
        }
    }

    private static void fluxoPerguntas(Frame frame, Object[] options, java.util.List<Prato> pratos, String tipoPrato, String pratoInicial, int yesNoOption) {
        if (pratos.size() > 0) {
            boolean voltarInicio = logicaIA(frame, options, pratos, tipoPrato);
            if (voltarInicio) {
                return;
            }
        }

        int resposta = JOptionPane.showOptionDialog(frame, pratoInicial, StaticFilter.CONFIRM, yesNoOption, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (resposta == JOptionPane.YES_NO_OPTION) {
            acerteiDeNovo(frame, optionsContinue);
        } else {
            adicionarNovoPrato(frame, pratos, tipoPrato);
        }
    }

    private static boolean logicaIA(Frame frame, Object[] options, java.util.List<Prato> pratos, String filter) {
        java.util.List<Prato> pratoList = new ArrayList<>();
        boolean voltarInicio = false;
        for (Prato listaPratos : pratos) {
            int resposta = JOptionPane.showOptionDialog(frame, StaticFilter.PRATO_QUE_PENSOU + listaPratos.getAdjetivo(), StaticFilter.CONFIRM, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (resposta == JOptionPane.YES_NO_OPTION) {
                int eEsse = JOptionPane.showOptionDialog(frame, StaticFilter.PRATO_QUE_PENSOU + listaPratos.getNome(), StaticFilter.CONFIRM, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (eEsse == JOptionPane.YES_NO_OPTION) {
                    acerteiDeNovo(frame, optionsContinue);
                } else {
                    adicionarNovoPrato(frame, pratoList, filter);
                }
                voltarInicio = true;
            }
        }
        pratos.addAll(pratoList);
        return voltarInicio;
    }

    private static void acerteiDeNovo(Frame frame, Object[] optionsContinue) {
        int resposta = JOptionPane.showOptionDialog(frame, StaticFilter.ACERTEI, StaticFilter.JOGO_GOURMET, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsContinue, optionsContinue[0]);
        if (resposta == JOptionPane.NO_OPTION){
            System.exit(0);
        }
    }

    private static void adicionarNovoPrato(Frame frame, List<Prato> pratos, String filter) {
        String nome = JOptionPane.showInputDialog(frame, StaticFilter.QUAL_PRATO_QUE_PENSOU, StaticFilter.DESISTO, JOptionPane.QUESTION_MESSAGE);
        if (nome != null && !nome.isEmpty()) {
            String adjetivo;

            if (filter.equals(StaticFilter.PRATO_MASSA)) {
                adjetivo = JOptionPane.showInputDialog(frame, nome + StaticFilter.COMPLETE_ADJETIVO_LASANHA, StaticFilter.COMPLETE, JOptionPane.QUESTION_MESSAGE);
            } else {
                adjetivo = JOptionPane.showInputDialog(frame, nome + StaticFilter.COMPLETE_ADJETIVO_BOLO, StaticFilter.COMPLETE, JOptionPane.QUESTION_MESSAGE);
            }

            pratos.add(new Prato(nome, adjetivo));
        } else {
            JOptionPane.showConfirmDialog(frame, StaticFilter.CAMPO_VAZIO, StaticFilter.JOGO_GOURMET, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null);
        }
    }
}
