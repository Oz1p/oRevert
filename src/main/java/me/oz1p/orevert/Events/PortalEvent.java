package me.oz1p.orevert.Events;

import me.oz1p.orevert.ORevert;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class PortalEvent implements Listener {
    private static final String MD = "spamfix_metadata";
    @EventHandler(priority = EventPriority.HIGH)
    public void onPortalEnter(PlayerPortalEvent event){
        if(event.getTo() != null){
            if(event.getTo().getWorld().getEnvironment() == World.Environment.NETHER){
                if(ORevert.getInstance().getCfg().getBool("block-nether")){
                    Player player = event.getPlayer();
                    if(player.hasPermission("orevert.bypass.nether") || player.isOp()){
                        return;
                    }
                    event.setCancelled(true);
                    if(player.hasMetadata(MD)){
                        return;
                    }
                    player.setMetadata(MD, new FixedMetadataValue(ORevert.getInstance(), true));
                    if(ORevert.getInstance().getCfg().getBool("play-sound")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                    }
                    player.sendMessage(ORevert.getInstance().getCfg().getPrefix() + ORevert.getInstance().getCfg().getString("lang.no-entry").replace("%type%", ORevert.getInstance().getCfg().getString("lang.nether")));
                    Bukkit.getScheduler().runTaskLater(ORevert.getInstance(), () ->{
                        player.removeMetadata(MD, ORevert.getInstance());
                    }, 20L);
                }
            }
            if(event.getTo().getWorld().getEnvironment() == World.Environment.THE_END){
                if(ORevert.getInstance().getCfg().getBool("block-end")){
                    Player player = event.getPlayer();
                    if(player.hasPermission("orevert.bypass.end") || player.isOp()){
                        return;
                    }
                    event.setCancelled(true);
                    if(player.hasMetadata(MD)){
                        return;
                    }
                    if(ORevert.getInstance().getCfg().getBool("play-sound")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                    }
                    player.setMetadata(MD, new FixedMetadataValue(ORevert.getInstance(), true));
                    player.sendMessage(ORevert.getInstance().getCfg().getPrefix() + ORevert.getInstance().getCfg().getString("lang.no-entry").replace("%type%", ORevert.getInstance().getCfg().getString("lang.end")));
                    Bukkit.getScheduler().runTaskLater(ORevert.getInstance(), () ->{
                        player.removeMetadata(MD, ORevert.getInstance());
                    }, 20L);
                }

            }
        }
    }
}
