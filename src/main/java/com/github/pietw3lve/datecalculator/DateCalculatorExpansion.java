package com.github.pietw3lve.datecalculator;

import org.bukkit.OfflinePlayer;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class DateCalculatorExpansion extends PlaceholderExpansion {
    
    private final DateCalculatorPlugin plugin;
    
    public DateCalculatorExpansion(DateCalculatorPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getAuthor() {
        return "PieTw3lve";
    }
    
    @Override
    public String getIdentifier() {
        return "datecalculator";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier) {
        // %datecalculator_daysbetweentoday_<yyyy-MM-dd>%
        if (identifier.startsWith("daysbetweentoday_")) {
            String targetDate = identifier.substring(17);
            plugin.getLogger().info(targetDate);
            return plugin.getDaysBetweenToday(targetDate);
        }
        return null;
    }
}
