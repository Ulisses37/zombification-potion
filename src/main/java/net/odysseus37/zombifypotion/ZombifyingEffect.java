package net.odysseus37.zombifypotion;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;


public class ZombifyingEffect extends StatusEffect {

    protected ZombifyingEffect(){
        super(StatusEffectCategory.HARMFUL, 0x5A6C81);
    }

    @Override
    public boolean isInstant(){
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier){
        if(entity instanceof VillagerEntity villager) {
            World world = villager.getWorld();
            if (world instanceof ServerWorld serverWorld) {
                ZombieVillagerEntity zombieVillager = villager.convertTo(EntityType.ZOMBIE_VILLAGER, false);

                if (zombieVillager != null) {
                    zombieVillager.initialize(
                            serverWorld,
                            serverWorld.getLocalDifficulty(zombieVillager.getBlockPos()),
                            SpawnReason.CONVERSION,
                            null
                    );

                    world.playSound(null, zombieVillager.getBlockPos(), SoundEvents.ENTITY_ZOMBIE_INFECT, SoundCategory.HOSTILE, 1.0f, 1.0f);
                }
            }
        }
        return true;
    }
}
