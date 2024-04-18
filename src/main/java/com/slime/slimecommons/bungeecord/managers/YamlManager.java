package com.slime.slimecommons.bungeecord.managers;

import com.slime.slimecommons.bungeecord.Logger;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;


// MMMMHHHHH.....
public class YamlManager {
    private final Plugin instance;
    private final String fileName;
    private File yamlFile;
    private Configuration yaml;

    public YamlManager(Plugin plugin, String fileName) {
        instance = plugin;
        this.fileName = fileName;
        loadYamlFile();
    }

    public void loadYamlFile() {
        if(!instance.getDataFolder().exists()) {
            instance.getDataFolder().mkdir();
        }

        getYamlFile();

        if(!yamlFile.exists()) {
            try (InputStream inputStream = instance.getResourceAsStream(fileName)) {
                if (inputStream != null) {
                    Files.copy(inputStream, yamlFile.toPath());

                    getYamlFile();
                } else {
                    throw new IOException("Resource not found: " + fileName);
                }
            } catch (IOException e) {
                Logger.severe("I can't save " + fileName, e);
            }
        }

        getYamlData();
    }

    private void getYamlFile() {
        yamlFile = new File(instance.getDataFolder(), fileName);
    }

    private void getYamlData() {
        try {
            yaml = YamlConfiguration.getProvider(YamlConfiguration.class).load(yamlFile);
        } catch (IOException e) {
            Logger.severe("I can't read " + fileName, e);
        }
    }

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
    public float getFloat(@NotNull String path) {
        return yaml.getFloat(path);
    }
    public short getShort(@NotNull String path) {
        return yaml.getShort(path);
    }
    public byte getByte(@NotNull String path) {
        return yaml.getByte(path);
    }
    public char getChar(@NotNull String path) {
        return yaml.getChar(path);
    }
    public boolean getBoolean(@NotNull String path) {
        return yaml.getBoolean(path);
    }
    public Configuration getSection(@NotNull String path) {
        return yaml.getSection(path);
    }
    public List<?> getList(@NotNull String path) {
        return yaml.getList(path);
    }
    public List<String> getStringList(@NotNull String path) {
        return yaml.getStringList(path);
    }
    public List<Integer> getIntegerList(@NotNull String path) {
        return yaml.getIntList(path);
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
    public List<Character> getCharList(@NotNull String path) {
        return yaml.getCharList(path);
    }
    public List<Short> getShortList(@NotNull String path) {
        return yaml.getShortList(path);
    }
    public Object getValue(@NotNull String path) {
        return yaml.get(path);
    }
    public Object getValue(@NotNull String path, @Nullable Object defaultValue) {
        Object value = yaml.get(path);

        if(value == null) {
            value = defaultValue;

            setValue(path, defaultValue);
        }

        return value;
    }

    public void setValue(@NotNull String path, @Nullable Object value) {
        yaml.set(path, value);

        try {
            saveYaml();
        } catch (IOException e) {
            Logger.severe(instance, "Error when saving " + fileName, e);
        }
    }

    public void saveYaml() throws IOException {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(yaml, yamlFile);
        } catch (IOException e) {
            throw new IOException("I can't save " + yamlFile, e);
        }
    }

    public String getFileName() {
        return fileName;
    }
}
