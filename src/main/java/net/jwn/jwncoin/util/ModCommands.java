package net.jwn.jwncoin.util;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber
public class ModCommands {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(
                LiteralArgumentBuilder.<CommandSourceStack>literal("코인")
                        .then(Commands.literal("초기화")
                                .executes(context -> {
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    Scoreboard scoreboard = player.getScoreboard();
                                    Objective objective = scoreboard.getObjective("coins");

                                    if (objective != null) {
                                        scoreboard.getOrCreatePlayerScore(player, objective).set(0);
                                        player.sendSystemMessage(Component.literal("코인이 초기화되었습니다."));
                                    } else {
                                        player.sendSystemMessage(Component.literal("코인을 인식할 수 없습니다."));
                                    }

                                    return Command.SINGLE_SUCCESS;
                                })
                        )
        );
    }
}
