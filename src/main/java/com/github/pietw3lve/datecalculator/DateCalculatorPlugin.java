package com.github.pietw3lve.datecalculator;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DateCalculatorPlugin extends JavaPlugin
{

    private LocalDate today;
    private long lastUpdated;

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
        long now = System.currentTimeMillis();
        if (today == null || now - lastUpdated >= 86400000) {
            today = LocalDate.now();
            lastUpdated = now;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate target = LocalDate.parse(targetDate, formatter);
            if (target != null) {
                long days = ChronoUnit.DAYS.between(target, today);
                return String.valueOf(days);
            }
        } catch (DateTimeParseException e) {
            return "Invalid date format!";
        }
        return "Invalid date format!";
    }
}
