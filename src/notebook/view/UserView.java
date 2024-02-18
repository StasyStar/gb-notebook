package notebook.view;

import java.util.Scanner;
import notebook.controller.UserController;
import notebook.model.User;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        int command;

        while (true) {
            System.out.println("Доступные команды:\n" 
            + "1. Создать контакт\n"
            + "2. Вывести контакт\n"
            + "3. Редактирование контакта\n"
            + "4. Вывести все контакты\n"
            + "5. Удалить контакт\n"
            + "0. Закрыть справочник\n");
            command = Integer.parseInt(prompt("Введите номер команды: "));

            if (command == 0) return;
            switch (command) {
                case 1:
                    User u = createUser();
                    userController.saveUser(u);
                    break;
                case 2:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    String userId = prompt("Enter user id: ");
                    userController.updateUser(userId, createUser());
                case 4:
                    System.out.println(userController.readAll());
                    break;
                case 5:
                    String userID = prompt("Enter user id: ");
                    userController.delete(userID);
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private User createUser() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        return new User(firstName, lastName, phone);
    }
}
