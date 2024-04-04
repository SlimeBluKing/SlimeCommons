package com.slime.slimecommons.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class YamlManager {
    private final JavaPlugin instance;
    private final String fileName;
    private File yamlFile;
    private FileConfiguration yaml;

    public YamlManager(JavaPlugin plugin, String fileName){
        instance = plugin;
        this.fileName = fileName;
        loadYamlFile();
    }

    public void loadYamlFile() {
        getYamlFile();

        if(!yamlFile.exists()) {
            instance.saveResource(fileName, false);
            getYamlFile();
        }

        getYamlData();
    }

    private void getYamlFile() {
        yamlFile = new File(instance.getDataFolder(), fileName);
    }

    private void getYamlData() {
        yaml = YamlConfiguration.loadConfiguration(yamlFile);
    }

    public Object getValue(String path, Object defaultValue){
        Object value = yaml.get(path);

        if(value == null){
            value = defaultValue;

            yaml.set(path, defaultValue);

            try{
                saveYaml();
            } catch (IOException e){
                instance.getLogger().severe(e.toString());
            }
        }
        return value;
    }

    public Object getValue(String path){
        return yaml.get(path);
    }

    public boolean getBoolean(String path){
        return yaml.getBoolean(path);
    }

    public long getLong(String path){
        return yaml.getLong(path);
    }

    public double getDouble(String path) {
        return yaml.getDouble(path);
    }

    public int getInteger(String path) {
        return yaml.getInt(path);
    }

    public String getString(String path){
        return yaml.getString(path);
    }

    public List<String> getStringList(String path){
        // TODO: WTF? I'll watch the exception later...

        return yaml.getStringList(path);
    }

    public void setValue(String path, Object value){
        yaml.set(path, value);

        try{
            saveYaml();
        } catch (IOException e){
            instance.getLogger().severe(e.toString());
        }
    }

    public void saveYaml() throws IOException{
        try {
            yaml.save(yamlFile);
        } catch (IOException e){
            throw new IOException("I can't save " + yamlFile, e);
        }
    }

    public String getFileName(){
        return fileName;
    }
}