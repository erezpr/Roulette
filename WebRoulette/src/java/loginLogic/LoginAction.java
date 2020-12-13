package loginLogic;

public enum LoginAction {
    SHOW_LOGIN,CAST_USER_NAME,SHOW_MAIN,ERROR;
    
    public static LoginAction calculateAction(String playerNameChoice, String previousePlayerName) {
        if (playerNameChoice.equals("undefined") && previousePlayerName == null) {
            return SHOW_LOGIN;
        } else if (!playerNameChoice.equals("undefined")  && previousePlayerName == null) {
            return CAST_USER_NAME;
        } else if (playerNameChoice.equals("undefined")  && previousePlayerName != null) {
            return SHOW_MAIN;
        } else if (!playerNameChoice.equals("undefined") && previousePlayerName != null) {
            return ERROR;
        }
        return null;
    }
}
