package games.laddergame.view;

import games.laddergame.domain.GameComponent;
import games.laddergame.domain.GameResult;
import games.laddergame.domain.ladder.MeetingPoint;
import games.laddergame.domain.ladder.Row;

import java.util.List;

public class OutputView {
    public void printGameResult(GameResult gameResult) {
        System.out.println("사다리 결과입니다!");
        printEachName(gameResult.getPlayers());
        printLadder(gameResult.getLadder());
        printEachName(gameResult.getPrizes());
    }

    private void printLadder(List<Row> ladder) {
        ladder.forEach(row -> {
            printEachMatchingPoint(row);
            System.out.println();
        });
    }

    private void printEachMatchingPoint(Row row) {
        List<MeetingPoint> meetingPoints = row.getMathcingPoints();
        System.out.print("  |");
        meetingPoints.forEach(meetingPoint -> { ;
            if (meetingPoint.isSwap()) {
                System.out.print("-----");
            }
            else {
                System.out.print("     ");
            }
            System.out.print("|");
        });
    }

    private void printEachName(List<GameComponent> players) {
        players.forEach(player -> System.out.print("  " + player.getName()));
        System.out.println();
    }
}
