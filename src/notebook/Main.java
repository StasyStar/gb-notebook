package notebook;

import notebook.controller.UserController;
import notebook.model.repository.GBRepository;
import notebook.model.repository.impl.UserRepository;
import notebook.view.UserView;

import static notebook.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {
        createDB();
        GBRepository repository = new UserRepository();
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();
    }
}

// в GBRepository, Operation дублирование методов
// в UserView надо перенести метод Create User
// в UserRepository в update можно сделать удаление remove
// из dao перенести все в UserRepository
// убрать из контроллера цикл 1.03.27


