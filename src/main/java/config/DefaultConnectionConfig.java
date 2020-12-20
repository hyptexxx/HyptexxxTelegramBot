package config;

public class DefaultConnectionConfig {
    public static final int RECONNECT_PAUSE = 10000;

    public static String USERNAME = System.getProperty("botName");
    public static String TOKEN = System.getProperty("botToken");
}
