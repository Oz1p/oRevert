package me.oz1p.orevert.Utils;

public interface IConfig {
    void reload();
    void save();
    int getInt(String str);
    double getDouble(String str);
    String getString(String str);
    void setBool(String str, boolean value);
    boolean getBool(String str);
    String getPrefix();
}
