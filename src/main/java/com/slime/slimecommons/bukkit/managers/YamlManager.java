package com.slime.slimecommons.bukkit.managers;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * A utility class for managing YAML files in Bukkit plugins.
 */
public class YamlManager {
    private final JavaPlugin instance;
    private final String fileName;
    private File yamlFile;
    private FileConfiguration yaml;

    /**
     * Constructs a new YamlManager.
     *
     * @param plugin   The JavaPlugin instance.
     * @param fileName The name of the YAML file.
     */
    public YamlManager(JavaPlugin plugin, String fileName){
        instance = plugin;
        this.fileName = fileName;
        loadYamlFile();
    }

    /**
     * Loads the YAML file from disk.
     */
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

    // Methods for checking data types
    public boolean isString(@NotNull String path) {
        return yaml.isString(path);
    }
    public boolean isInteger(@NotNull String path) {
        return yaml.isString(path);
    }
    public boolean isDouble(@NotNull String path) {
        return yaml.isDouble(path);
    }
    public boolean isLong(@NotNull String path) {
        return yaml.isLong(path);
    }
    public boolean isBoolean(@NotNull String path) {
        return yaml.isBoolean(path);
    }
    public boolean isList(@NotNull String path) {
        return yaml.isList(path);
    }
    public boolean isVector(@NotNull String path) {
        return yaml.isVector(path);
    }
    public boolean isOfflinePlayer(@NotNull String path) {
        return yaml.isOfflinePlayer(path);
    }
    public boolean isItemStack(@NotNull String path) {
        return yaml.isItemStack(path);
    }
    public boolean isColor(@NotNull String path) {
        return yaml.isColor(path);
    }
    public boolean isLocation(@NotNull String path) {
        return yaml.isLocation(path);
    }
    public boolean isConfigurationSection(@NotNull String path) {
        return yaml.isConfigurationSection(path);
    }

    // Methods for retrieving data
    public String getString(@NotNull String path) {
        return yaml.getString(path);
    }
    public int getInteger(@NotNull String path) {
        return yaml.getInt(path);
    }
    public double getDouble(@NotNull String path) {
        return yaml.getDouble(path);
    }
    public long getLong(@NotNull String path) {
        return yaml.getLong(path);
    }
    public boolean getBoolean(@NotNull String path) {
        return yaml.getBoolean(path);
    }
    public Vector getVector(@NotNull String path) {
        return yaml.getVector(path);
    }
    public OfflinePlayer getOfflinePlayer(@NotNull String path) {
        return yaml.getOfflinePlayer(path);
    }
    public ItemStack getItemStack(@NotNull String path) {
        return yaml.getItemStack(path);
    }
    public Color getColor(@NotNull String path) {
        return yaml.getColor(path);
    }
    public Location getLocation(@NotNull String path) {
        return yaml.getLocation(path);
    }
    public ConfigurationSection getConfigurationSection(@NotNull String path) {
        return yaml.getConfigurationSection(path);
    }
    public List<?> getList(@NotNull String path) {
        return yaml.getList(path);
    }
    public List<String> getStringList(@NotNull String path) {
        return yaml.getStringList(path);
    }
    public List<Integer> getIntegerList(@NotNull String path) {
        return yaml.getIntegerList(path);
    }
    public List<Double> getDoubleList(@NotNull String path) {
        return yaml.getDoubleList(path);
    }
    public List<Long> getLongList(@NotNull String path) {
        return yaml.getLongList(path);
    }
    public List<Boolean> getBooleanList(@NotNull String path) {
        return yaml.getBooleanList(path);
    }
    public List<Float> getFloatList(@NotNull String path) {
        return yaml.getFloatList(path);
    }
    public List<Byte> getByteList(@NotNull String path) {
        return yaml.getByteList(path);
    }
    public List<Character> getCharacterList(@NotNull String path) {
        return yaml.getCharacterList(path);
    }
    public List<Short> getShortList(@NotNull String path) {
        return yaml.getShortList(path);
    }
    public Object getValue(@NotNull String path) {
        return yaml.get(path);
    }
    public Object getValue(@NotNull String path, @Nullable Object defaultValue){
        Object value = yaml.get(path);

        if(value == null){
            value = defaultValue;

            setValue(path, defaultValue);
        }
        return value;
    }

    // Methods for setting data
    public void setValue(@NotNull String path, @Nullable Object value){
        yaml.set(path, value);

        try{
            saveYaml();
        } catch (IOException e){
            instance.getLogger().severe(e.toString());
        }
    }

    /**
     * Saves the YAML file to disk.
     *
     * @throws IOException If an I/O error occurs while saving the file.
     */
    public void saveYaml() throws IOException{
        try {
            yaml.save(yamlFile);
        } catch (IOException e){
            throw new IOException("I can't save " + yamlFile, e);
        }
    }

    /**
     * Gets the name of the YAML file.
     *
     * @return The name of the YAML file.
     */
    public String getFileName(){
        return fileName;
    }
}