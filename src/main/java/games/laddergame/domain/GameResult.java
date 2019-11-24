package games.laddergame.domain;

import games.laddergame.domain.ladder.Row;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    private List<GameComponent> players;
    private List<GameComponent> prizes;
    private List<Row> ladder;

    public GameResult(List<GameComponent> players, List<GameComponent> prizes, List<Row> ladder) {
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public List<GameComponent> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Row> getLadder() {
        return ladder;
    }

    public List<GameComponent> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }

    public Map<String, String> organizeResults() {
        Map<String, String> results = new LinkedHashMap<>();
        List<GameComponent> sortedPlayers = players.stream()
                .sorted(Comparator.comparingInt(GameComponent::getPosition))
                .collect(Collectors.toList());

        int max = sortedPlayers.size();
        IntStream.rangeClosed(0, max - 1)
                .forEach(index ->
                        results.put(sortedPlayers.get(index).getName(), sortedPlayers.get(index).getName() + ":" + prizes.get(index).getName()));

        String allResult = String.join("  ", results.values());
        results.put("all", allResult);
        return results;
    }
}