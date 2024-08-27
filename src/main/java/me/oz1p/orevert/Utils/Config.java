package me.oz1p.orevert.Utils;

import me.oz1p.orevert.ORevert;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class Config implements IConfig{
    private FileConfiguration config;

    public Config(){
        ORevert.getInstance().saveDefaultConfig();
        config = ORevert.getInstance().getConfig();
    }
    @Override
    public void reload() {
        ORevert.getInstance().reloadConfig();
        config = ORevert.getInstance().getConfig();
    }

    @Override
    public void save() {
        try{
            config.save(new File(ORevert.getInstance().getDataFolder(), "config.yml"));
        }
        catch (Exception e){
            ORevert.getInstance().getLogger().severe(e.getMessage());
        }
    }

    @Override
    public int getInt(String str) {
        try{
            return config.getInt(str);
        }
        catch (Exception e){
            ORevert.getInstance().getLogger().severe("Ошибка в конфиге!");
            return 1;
        }
    }

    @Override
    public double getDouble(String str) {
        try{
            return config.getDouble(str);
        }
        catch (Exception e){
            ORevert.getInstance().getLogger().severe("Ошибка в конфиге!");
            return 1.0;
        }
    }

    @Override
    public String getString(String str) {
        try{
            return HelpMethods.processHexColors(config.getString(str));
        }
        catch (Exception e){
            ORevert.getInstance().getLogger().severe("Ошибка в конфиге!");
            return " §cОшибка в конфиге§r ";
        }
    }

    @Override
    public void setBool(String str, boolean value) {
        config.set(str, value);
    }

    @Override
    public boolean getBool(String str) {
        try{
            return config.getBoolean(str);
        }
        catch (Exception e){
            ORevert.getInstance().getLogger().severe("Ошибка в конфиге!");
            return false;
        }
    }

    @Override
    public String getPrefix() {
        return getString("prefix") + " §f";
    }
}
