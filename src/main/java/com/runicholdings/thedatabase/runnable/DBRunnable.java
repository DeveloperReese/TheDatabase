package com.runicholdings.thedatabase.runnable;

import com.runicholdings.thedatabase.TheDatabase;
import com.runicholdings.thedatabase.util.WebUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.concurrent.TimeUnit;

public class DBRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Refreshing the database...");
            TheDatabase.getInstance().setDataCache(WebUtil.getList());
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Successfully refreshed the database!");

            try {
                Thread.sleep(TimeUnit.HOURS.toMillis(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
