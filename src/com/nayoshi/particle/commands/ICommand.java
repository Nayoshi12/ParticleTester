package com.nayoshi.particle.commands;

import org.bukkit.command.CommandSender;

public interface ICommand {
    void execute(CommandSender cs,String[] args);
    String getName();
    String getPermission();
}
