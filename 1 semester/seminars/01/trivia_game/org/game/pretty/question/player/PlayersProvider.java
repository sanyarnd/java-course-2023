package org.game.pretty.question.player;

import java.util.List;

public class PlayersProvider {
    private final List<Player> players;
    private int position = 0;

    public PlayersProvider(List<Player> players) {
        this.players = players;
    }

    public Player getNext() {
        position = ++position % players.size();
        return players.get(position);
    }

    public Player getCurrent() {
        return players.get(position);
    }

    public int playerCount() {
        return players.size();
    }
}
