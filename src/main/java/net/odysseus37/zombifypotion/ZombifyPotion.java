package net.odysseus37.zombifypotion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ZombifyPotion implements ModInitializer {

    public static final String MOD_ID = "zombifypotion";

    public static final StatusEffect ZOMBIFY_EFFECT = new ZombifyingEffect();

    public static final Potion ZOMBIFY_POTION_ITEM = new Potion(
            new StatusEffectInstance(RegistryEntry.of(ZOMBIFY_EFFECT), 60, 0)
    );

    @Override
    public void onInitialize() {
        Registry.register(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "zombify_effect"), ZOMBIFY_EFFECT);
        Registry.register(Registries.POTION, Identifier.of(MOD_ID, "zombify_potion"), ZOMBIFY_POTION_ITEM);

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.WEAKNESS,
                    Items.ROTTEN_FLESH,
                    RegistryEntry.of(ZOMBIFY_POTION_ITEM)
            );
        });
    }
}
