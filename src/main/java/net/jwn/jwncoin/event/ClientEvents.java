package net.jwn.jwncoin.event;

import net.jwn.jwncoin.networking.packets.CheckCoinC2SPacket;
import net.jwn.jwncoin.util.KeyBinding;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber
public class ClientEvents {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if(KeyBinding.CHECK_COIN.consumeClick()) {
            PacketDistributor.sendToServer(new CheckCoinC2SPacket());
        }
    }
}
