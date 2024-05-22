package console;

import java.util.Arrays;
import java.util.Comparator;

enum Brand {
    SONY,
    MICROSOFT,
    OTHER
}

public class PlayRoom {
    public static void main(String[] args) {
        Game.GameDisk gameDisk1 = Game.getDisk("Game1", Game.Genre.ACTION, "Description1");
        Game.GameDisk gameDisk2 = Game.getDisk("Game2", Game.Genre.SPORT, "Description2");

        Game.GameDisk[] physicalGames = {gameDisk1, gameDisk2};

        Game.VirtualGame virtualGame1 = Game.getVirtualGame("VirtualGame1", Game.Genre.ACTION, 4);
        Game.VirtualGame virtualGame2 = Game.getVirtualGame("VirtualGame2", Game.Genre.SPORT, 3);

        Game.VirtualGame[] virtualGames = {virtualGame1, virtualGame2};

        GameConsole console = new GameConsole(Brand.SONY, "123456");

        for (Game.GameDisk game : physicalGames) {
            console.loadGame(game.getData());
            console.playGame();
        }

        for (Game.VirtualGame game : virtualGames) {
            console.loadGame(game.getData());
            console.playGame();
        }




        /*
        Game.GameDisk gameDisk1 = new Game.GameDisk("Game1", Game.Genre.ACTION, "Description1") {};
        Game.GameDisk gameDisk2 = new Game.GameDisk("Game2", Game.Genre.SPORT, "Description2") {};
        Game.GameDisk gameDisk3 = new Game.GameDisk("Game3", Game.Genre.RACE, "Description3") {};
        Game.GameDisk gameDisk4 = new Game.GameDisk("Game4", Game.Genre.ACTION, "Description4") {};

        Game.GameDisk[] physicalGames = {gameDisk1, gameDisk2, gameDisk3, gameDisk4};

        Arrays.sort(physicalGames, Comparator.comparing(game -> game.getDescription()));

        System.out.println("Physical games sorted by genre:");
        for (Game.GameDisk game : physicalGames) {
            System.out.println(game.getData().getName());
        }

        Game.VirtualGame virtualGame1 = new Game.VirtualGame("VirtualGame1", Game.Genre.ACTION, 4) {};
        Game.VirtualGame virtualGame2 = new Game.VirtualGame("VirtualGame2", Game.Genre.SPORT, 3) {};
        Game.VirtualGame virtualGame3 = new Game.VirtualGame("VirtualGame3", Game.Genre.RACE, 5) {};
        Game.VirtualGame virtualGame4 = new Game.VirtualGame("VirtualGame4", Game.Genre.ACTION, 2) {};

        Game.VirtualGame[] virtualGames = {virtualGame1, virtualGame2, virtualGame3, virtualGame4};

        Arrays.sort(virtualGames, (o1, o2) -> Integer.compare(o1.getRating(), o2.getRating()));

        System.out.println("\nVirtual games sorted by rating:");
        for (Game.VirtualGame game : virtualGames) {
            System.out.println(game.getData().getName() + " - Rating: " + game.getRating());
        }

         */
    }
}

