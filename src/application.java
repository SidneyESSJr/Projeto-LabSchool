import controller.MenuController;

public class application {
    public static void main(String[] args) throws Exception {
        MenuController menu = new MenuController();
        Integer opcao = 0;
        do {
            opcao = menu.MenuPrincipal();
        } while (opcao != 0);
    }
}
