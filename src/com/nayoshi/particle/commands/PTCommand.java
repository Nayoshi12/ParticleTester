package com.nayoshi.particle.commands;

import com.nayoshi.particle.ParticleTesters;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class PTCommand implements CommandExecutor {
    ParticleTesters pl;
    ArrayList<ICommand> commands;
    public PTCommand(){
        this.pl = ParticleTesters.getInstance();
        commands = new ArrayList<>();
        commands.add(new CommandCircleBuff());
    }

    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {

        if(args.length > 0){
            for(ICommand command:commands){
                if(args[0].equals(command.getName())){
                    command.execute(cs,args);
                }
            }
        }
        return true;
    }
}
