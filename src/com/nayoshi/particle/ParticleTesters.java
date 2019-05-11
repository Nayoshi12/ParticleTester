package com.nayoshi.particle;

import com.nayoshi.particle.commands.PTCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleTesters extends JavaPlugin {
    private static ParticleTesters instance;
    public void onEnable(){
        instance = this;
        getCommand("particle-tester").setExecutor(new PTCommand());
    }
    public static ParticleTesters getInstance(){
        return instance;
    }
}
