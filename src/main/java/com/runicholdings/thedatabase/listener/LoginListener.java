package com.runicholdings.thedatabase.listener;

import com.runicholdings.thedatabase.TheDatabase;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onLogin(PlayerLoginEvent e) {
        if (TheDatabase.getInstance().getDataCache().containsKey(e.getPlayer().getUniqueId().toString())) {
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "\n§cYou are not allowed to join this server due to being in TheDatabase!\nReason: " + TheDatabase.getInstance().getDataCache().get(e.getPlayer().getUniqueId().toString()) + "\nTo appeal this, join our discord server using the invite code 5uedvjF");
        }
    }
}
