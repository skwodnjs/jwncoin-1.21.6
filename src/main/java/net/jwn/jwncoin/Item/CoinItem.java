package net.jwn.jwncoin.Item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.ScoreAccess;
import net.minecraft.world.scores.Scoreboard;

public class CoinItem extends Item {
    public CoinItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (level instanceof ServerLevel) {
            Scoreboard scoreboard = level.getScoreboard();
            Objective objective = scoreboard.getObjective("coins");
            ScoreAccess score = scoreboard.getOrCreatePlayerScore(player, objective);

            score.add(1);
            System.out.println(score.get());

            ItemStack itemstack = player.getItemInHand(hand);
            itemstack.consume(1, player);
            player.awardStat(Stats.ITEM_USED.get(this));
        }

        return InteractionResult.SUCCESS_SERVER;
    }
}
