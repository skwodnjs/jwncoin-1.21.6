package net.jwn.jwncoin.networking.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record CheckCoinC2SPacket() implements CustomPacketPayload {
    public static final Type<CheckCoinC2SPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("jwncoin", "check_coin"));
    public static final StreamCodec<ByteBuf, CheckCoinC2SPacket> STREAM_CODEC = StreamCodec.unit(new CheckCoinC2SPacket());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(CheckCoinC2SPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) {
                Scoreboard scoreboard = player.getScoreboard();
                Objective objective = scoreboard.getObjective("coins");
                if (objective != null) {
                    int coins = scoreboard.getOrCreatePlayerScore(player, objective).get();
                    player.sendSystemMessage(Component.literal("You have " + coins + " coins."));
                } else {
                    player.sendSystemMessage(Component.literal("No coin scoreboard found."));
                }
            }
        });
    }
}
