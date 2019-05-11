package com.nayoshi.particle.commands;

import com.nayoshi.particle.ParticleTesters;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandCircleBuff implements ICommand {

    private ParticleTesters pl;

    public CommandCircleBuff() {
        pl = ParticleTesters.getInstance();
    }

    public void execute(CommandSender cs, String[] args) {
        Player player = (Player) cs;
        cs.sendMessage("test");
        new BukkitRunnable() {
            double theta = 0;
            double increment = Math.PI / 16 ;
            double x,y,z;

            public void run() {
                Location loc = player.getLocation();
                theta = theta + increment;
                x = Math.sin(theta);
                y = 0;
                z = Math.cos(theta);

                loc.add(x,y,z);
                player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY,loc,1);
                loc.subtract(x,y,z);

                x = Math.sin(theta + Math.PI/2);
                y = 1.5;
                z = Math.cos(theta + Math.PI/2);

                loc.add(x,y,z);
                player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY,loc,1);
                loc.subtract(x,y,z);

                x = Math.sin(theta + Math.PI);
                y = 0.5;
                z = Math.cos(theta + Math.PI);

                loc.add(x,y,z);
                player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY,loc,1);
                loc.subtract(x,y,z);

                x = Math.sin(theta + Math.PI*1.5);
                y = 2;
                z = Math.cos(theta + Math.PI*1.5);

                loc.add(x,y,z);
                player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY,loc,1);
                loc.subtract(x,y,z);
                if (theta > 10 * Math.PI) {
                    this.cancel();
                }

            }
        }.runTaskTimer(pl,0,1);
    }

    public String getName() {
        return "circle";
    }

    public String getPermission() {
        return "particle.circle";
    }
}
