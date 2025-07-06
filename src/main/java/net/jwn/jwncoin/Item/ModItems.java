package net.jwn.jwncoin.Item;

import net.jwn.jwncoin.JWNCOIN;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(JWNCOIN.MODID);

    public static final DeferredItem<Item> COIN =
            ITEMS.registerItem("coin", CoinItem::new, new CoinItem.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
