package net.jwn.jwncoin.networking;


import net.jwn.jwncoin.networking.packets.CheckCoinC2SPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber
public class ModNetwork {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");
        registrar.playToServer(CheckCoinC2SPacket.TYPE, CheckCoinC2SPacket.STREAM_CODEC, CheckCoinC2SPacket::handle);
    }
}
