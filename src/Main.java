import entity.Refeicao;

import java.util.ArrayList;
import java.util.List;

import static service.ProgramService.program;

public class Main {

    public static void main(String[] args) {

        List<Refeicao> refeicaoPrincipal = new ArrayList<>();
        List<Refeicao> sobremessa = new ArrayList<>();

        while (true) {
            program(refeicaoPrincipal, sobremessa);
        }
    }
}
