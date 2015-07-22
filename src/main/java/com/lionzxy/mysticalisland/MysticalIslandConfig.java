package com.lionzxy.mysticalisland;

import cpw.mods.fml.common.Loader;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by lionzxy on 22.07.15.
 */
public class MysticalIslandConfig {
    public static Configuration config;



    public static void preInit(){
        createConfig();
    }
    public static void createConfig(){
        File configFile = new File(Loader.instance().getConfigDir(), "MysticalIsland.cfg");
        config = new Configuration(configFile,"0.0.1");
        loadConfig();
    }
    public static void loadConfig(){
        config.save();
        config.load();
    }
    public static int getDamageGun(String name){
        return config.getInt(name,"guns",100,0,99999,"Дамаг, который будет получать моб");
    }
}
