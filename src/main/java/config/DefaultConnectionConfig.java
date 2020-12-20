package config;

public class DefaultConnectionConfig {
    public static final int RECONNECT_PAUSE = 10000;

    public static String USERNAME = System.getenv("botName");
    public static String TOKEN = System.getenv("botToken");
}
