package net.jwn.jwncoin.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String CATEGORY_TEST_ID = "key.category.jwncoin.tutorial";
    public static final String CHECK_COIN_ID = "key.jwncoin.check_coin";

    public static final KeyMapping CHECK_COIN = new KeyMapping(CHECK_COIN_ID, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, CATEGORY_TEST_ID);

    @EventBusSubscriber
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.CHECK_COIN);
        }
    }
}
