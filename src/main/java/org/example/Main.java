package org.example;

import org.example.controller.ActorController;
import org.example.controller.FilmController;
import org.example.model.Actor;
import org.example.repository.ActorDao;
import org.example.repository.ActorDaoJdbc;
import org.example.repository.FilmDao;
import org.example.repository.FilmDaoJdbc;
import org.example.service.ActorService;
import org.example.service.FilmService;

import java.util.Scanner;

public class Main {

    final static ActorDao actorRepository = new ActorDaoJdbc();

    final static ActorService service = new ActorService(actorRepository);

    final static ActorController controller = new ActorController(service);

    final static FilmDao filmRepository = new FilmDaoJdbc();

    final static FilmService filmService = new FilmService(filmRepository);

    final static FilmController filmController = new FilmController(filmService);

    public static void main(String[] args) {
        System.out.println("Hello world!");

        mainMenu();
    }

    private static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose option!");
        System.out.println("1. List all actors!");
        System.out.println("2. Get actor by name!");
        System.out.println("3. Add pre made actor!");
        System.out.println("4. Change actors name!");
        System.out.println("5. Delete actor by id!");
        System.out.println("6. List Films");
        System.out.println("7. Exit");

        String input = scanner.nextLine();

        switch (input){
            case "1": controller.listAllActors(); mainMenu(); break;
            case "2": getActorByName(); mainMenu(); break;
            case "3": controller.addActor(new Actor(1, "NEW", "ACTOR")); mainMenu(); break;
            case "4": changeActor(); mainMenu(); break;
            case "5": deleteActor(); mainMenu(); break;
            case "6": filmController.listAllFilms(); break;
            default:;
        }
    }

    private static void deleteActor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which actor do you want to delete?");
        int id = Integer.parseInt(scanner.nextLine());
        controller.deleteActorById(id);
    }

    private static void changeActor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give id!");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Give first name!");
        String firstName = scanner.nextLine();
        System.out.println("Give last name!");
        String lastName = scanner.nextLine();

        controller.updateActor(id, new Actor(1, firstName, lastName));

    }

    private static void getActorByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which actor do you want to find?");
        String name = scanner.nextLine();
        controller.writeOutActorByName(name);
    }
}