package me.oz1p.orevert.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> completions = new ArrayList<>();
        if(strings.length == 1 && "reload".startsWith(strings[0])){
            completions.add("reload");
        }
        if(strings.length == 1 && "toggle".startsWith(strings[0])){
            completions.add("toggle");
        }
        if(strings.length == 2 && "end".startsWith(strings[1])){
            completions.add("end");
        }
        if(strings.length == 2 && "nether".startsWith(strings[1])){
            completions.add("nether");
        }
        return completions;
    }
}
