package com.runicholdings.thedatabase;

import com.runicholdings.thedatabase.listener.LoginListener;
import com.runicholdings.thedatabase.runnable.DBRunnable;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

@Getter
public final class TheDatabase extends JavaPlugin {

    @Getter private static TheDatabase instance;

    private Thread thread;

    @Setter private HashMap<String, String> dataCache = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;

        thread = new Thread(new DBRunnable());
        thread.start();

        Bukkit.getServer().getPluginManager().registerEvents(new LoginListener(), this);
    }

    @Override
    public void onDisable() {
        thread.stop();
    }
}
