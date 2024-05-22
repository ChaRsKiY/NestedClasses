package console;

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
    }
}

