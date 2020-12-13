package loginLogic;

import java.util.LinkedList;
import java.util.List;

public class UserNameLogic {

    private final List<String> playerNames = new LinkedList<>();

    public boolean addPlayerName(String playerName) {
        if (playerNames.contains(playerName)) {
            return false;
        } else {
            playerNames.add(playerName);
            return true;
        }
    }
}
