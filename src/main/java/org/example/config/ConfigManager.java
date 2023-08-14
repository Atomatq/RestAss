package org.example.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {

    public ConfigManager() {
    }

    public static Configuration getConfiguration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
