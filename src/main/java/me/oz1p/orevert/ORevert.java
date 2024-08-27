package me.oz1p.orevert;

import me.oz1p.orevert.Commands.CommandExecutor;
import me.oz1p.orevert.Commands.TabCompleter;
import me.oz1p.orevert.Events.PortalEvent;
import me.oz1p.orevert.Utils.Config;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class ORevert extends JavaPlugin {
    private static ORevert instance;
    private Config cfg;
    private String version = "1.0";
    @Override
    public void onEnable() {
        getLogger().info("§6         ____                     _   ");
        getLogger().info("§6    ___ |  _ \\ _____   _____ _ __| |_ ");
        getLogger().info("§6   / _ \\| |_) / _ \\ \\ / / _ \\ '__| __|");
        getLogger().info("§6  | (_) |  _ <  __/\\ V /  __/ |  | |_ ");
        getLogger().info("§6   \\___/|_| \\_\\___| \\_/ \\___|_|   \\__|");
        getLogger().info("§6                    v" + version);
        // Instance
        instance = this;
        // Config
        getLogger().info("Загрузка конфига...");
        cfg = new Config();
        // Metrics
        getLogger().info("Загрузка BStats...");
        Metrics metrics = new Metrics(this, 23197);
        // Commands
        getLogger().info("Регистрация команд...");
        getCommand("orevert").setExecutor(new CommandExecutor());
        getCommand("orevert").setTabCompleter(new TabCompleter());
        // Events
        getLogger().info("Регистрация Ивентов...");
        getServer().getPluginManager().registerEvents(new PortalEvent(), this);
        getLogger().info("Готово!");
    }
    public static ORevert getInstance(){
        return instance;
    }
    public Config getCfg(){
        return cfg;
    }
    public String getVersion(){
        return version;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
        cfg = null;
        getLogger().info("Пока-пока!");
    }
}
