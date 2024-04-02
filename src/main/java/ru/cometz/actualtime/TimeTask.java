package ru.cometz.actualtime;

import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class TimeTask extends BukkitRunnable {
    @Override
    public void run() {
        int a = ActualTime.getCurrentSeconds();
        for (org.bukkit.World world : getServer().getWorlds()) {
            world.setTime((a/3600 - ConfigWorker.getValueFromConfig("offset"))* 1000L);
        }
    }
}
