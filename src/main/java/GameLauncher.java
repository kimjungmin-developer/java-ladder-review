public class GameLauncher {
    public static void main(String[] args) {
        RacingGameInputAsker inputAsker = new RacingGameInputAsker();
        RacingGame racingGame = new RacingGame(inputAsker);
        GameStarter.start(racingGame);
    }
}