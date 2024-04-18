package com.slime.slimecommons.bungeecord;

import net.md_5.bungee.api.plugin.Plugin;

public class SlimeCommonsBungee extends Plugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        start();
    }

    private void start(){
        printLogo();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void printLogo() {
        Logger.log("\n" +
                "   _____ _ _                 _____                                          \n" +
                "  / ____| (_)               / ____|                                         \n" +
                " | (___ | |_ _ __ ___   ___| |     ___  _ __ ___  _ __ ___   ___  _ __  ___ \n" +
                "  \\___ \\| | | '_ ` _ \\ / _ \\ |    / _ \\| '_ ` _ \\| '_ ` _ \\ / _ \\| '_ \\/ __|\n" +
                "  ____) | | | | | | | |  __/ |___| (_) | | | | | | | | | | | (_) | | | \\__ \\\n" +
                " |_____/|_|_|_| |_| |_|\\___|\\_____\\___/|_| |_| |_|_| |_| |_|\\___/|_| |_|___/\n" +
                "                                                                            \n");
    }
}
