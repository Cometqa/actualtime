package ru.cometz.actualtime;

public class ConfigWorker {
    public static int getValueFromConfig(String s) {
        return ActualTime.getInstance().getConfig().getInt(s);
    }
}
