package com.github.pietw3lve.datecalculator;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateCalculatorPlugin extends JavaPlugin
{

    public void onEnable()
    {
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            getLogger().info("PlaceholderAPI found! Registering placeholders...");
            new DateCalculatorExpansion(this).register();
        } else {
            getLogger().info("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    public String getDaysBetweenToday(String targetDate) {
        try {
            LocalDate today = LocalDate.now();
            LocalDate target = LocalDate.parse(targetDate);
            long days = ChronoUnit.DAYS.between(target, today);
            return String.valueOf(days);
        } catch (Exception e) {
            return "Invalid date format!";
        }
    }
}
