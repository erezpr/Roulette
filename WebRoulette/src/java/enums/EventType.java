package enums;

public enum EventType {

    GAME_START("GameStart"),
    GAME_OVER("GameOver"),
    WINNING_NUMBER("WinningNumber"),
    RESULTS_SCORES("ResultsScores"),
    PLAYER_RESIGNED("PlayerResigned"),
    PLAYER_BET("PlayerBet"),
    PLAYER_FINISHED_BETTING("PlayerFinishedBetting");
    private final String value;

    EventType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventType fromValue(String v) {
        for (EventType c: EventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
