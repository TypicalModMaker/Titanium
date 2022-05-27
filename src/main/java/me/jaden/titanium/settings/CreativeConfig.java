package me.jaden.titanium.settings;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

@Getter
public class CreativeConfig {
    private final boolean enabled;
    private final boolean allowNegativeAmplifiers;
    private final int maxPotionEffectAmplifier;
    private final int maxPotionEffectDuration;
    private final int maxPotionEffects;

    public CreativeConfig(FileConfiguration configuration) {
        configuration.addDefaults(ImmutableMap.<String, Object>builder()
                .put("creative.enabled", false)
                .put("creative.potions.max-potion-effects", 5)
                .put("creative.potions.max-potion-effect-duration-ticks", 9600)
                .put("creative.potions.max-potion-effect-amplifier", 10)
                .put("creative.potions.allow-negative-effect-amplifier", false)
                .build());

        this.enabled = configuration.getBoolean("creative.enabled", false);
        this.maxPotionEffects = configuration.getInt("creative.potions.max-potion-effects");
        this.allowNegativeAmplifiers = configuration.getBoolean("creative.potions.allow-negative-effect-amplifier");
        this.maxPotionEffectDuration = configuration.getInt("creative.potions.max-potion-effect-duration-ticks");
        this.maxPotionEffectAmplifier = configuration.getInt("creative.potions.max-potion-effect-amplifier");
    }
}
