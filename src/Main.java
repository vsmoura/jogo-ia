import entity.Prato;
import service.ProgramService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Object[] options = {"Sim", "Não"};

        Frame frame = new Frame();

        List<Prato> pratosSalgados = new ArrayList<>();
        List<Prato> pratosDoces = new ArrayList<>();

        for (int i = 0; i <= 0; i--) {
            ProgramService.program(frame, options, pratosSalgados, pratosDoces);
        }
    }
}
