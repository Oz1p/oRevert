package me.oz1p.orevert.Commands;

import me.oz1p.orevert.ORevert;
import me.oz1p.orevert.Utils.Config;
import me.oz1p.orevert.Utils.HelpMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Config cfg = ORevert.getInstance().getCfg();
        if(strings.length == 1 && strings[0].equalsIgnoreCase("reload")){
            if(commandSender.isOp() || commandSender.hasPermission("orevert.reload")){
                cfg.reload();
                commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.reloaded"));
                return true;
            }
            commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.no-perms"));
            return true;
        }
        if(strings.length == 2 && strings[0].equalsIgnoreCase("toggle")){
            if(strings[1].equalsIgnoreCase("nether")){
                if(commandSender.isOp() || commandSender.hasPermission("orevert.toggle.nether"))
                {
                    if(cfg.getBool("block-nether")){
                        cfg.setBool("block-nether", false);
                        cfg.save();
                        commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.toggled").replace("%type%", cfg.getString("lang.nether")).replace("%bool%", cfg.getString("lang.allowed")));
                        return true;
                    }
                    cfg.setBool("block-nether", true);
                    cfg.save();
                    commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.toggled").replace("%type%", cfg.getString("lang.nether")).replace("%bool%", cfg.getString("lang.not-allowed")));
                    return true;
                }
                commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.no-perms"));
                return true;
            }
            if(strings[1].equalsIgnoreCase("end")){
                if(commandSender.isOp() || commandSender.hasPermission("orevert.toggle.end"))
                {
                    if(cfg.getBool("block-end")){
                        cfg.setBool("block-end", false);
                        cfg.save();
                        commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.toggled").replace("%type%", cfg.getString("lang.end")).replace("%bool%", cfg.getString("lang.allowed")));
                        return true;
                    }
                    cfg.setBool("block-end", true);
                    cfg.save();
                    commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.toggled").replace("%type%", cfg.getString("lang.end")).replace("%bool%", cfg.getString("lang.not-allowed")));
                    return true;
                }
                commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.no-perms"));
               return true;
            }

        }
        commandSender.sendMessage(cfg.getPrefix() + HelpMethods.processHexColors("&7Версия: " + ORevert.getInstance().getVersion()));
        commandSender.sendMessage(cfg.getPrefix() + HelpMethods.processHexColors("&7Разработчик: Oz1p"));
        commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.usage-1"));
        commandSender.sendMessage(cfg.getPrefix() + cfg.getString("lang.usage-2"));
        return true;
    }
}
