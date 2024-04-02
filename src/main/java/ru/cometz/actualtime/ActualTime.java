package ru.cometz.actualtime;

import org.bukkit.GameRule;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.time.LocalDateTime;

public final class ActualTime extends JavaPlugin {
    private static ActualTime instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getLogger().info("ActualTime loaded.");
        getLogger().info("Внимание! Возможна дохуища багов, ибо тестить такую штучку не оч просто. Если что пишите там, где скачали об ошибке, я скоро пофикшу и выпущу фикс.");
        for (org.bukkit.World world : getServer().getWorlds()) {
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        }
        new TimeTask().runTaskTimer(this, 0L, ConfigWorker.getValueFromConfig("repeat"));
    }

    public static int getCurrentSeconds() {
        LocalDateTime date = LocalDateTime.now();
        return (int) Duration.between(date.withSecond(0).withMinute(0).withHour(0), date).getSeconds();
    }

    public static ActualTime getInstance() {
        return instance;
    }
}
