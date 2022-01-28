import entity.Refeicao;
import service.ProgramService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Refeicao> refeicaoPrincipal = new ArrayList<>();
        List<Refeicao> sobremessa = new ArrayList<>();

        for (int i = 0; i <= 0; i--) {
            ProgramService.program(refeicaoPrincipal, sobremessa);
        }
    }
}
