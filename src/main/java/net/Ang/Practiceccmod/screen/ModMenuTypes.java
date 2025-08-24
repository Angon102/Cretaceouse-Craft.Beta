package net.Ang.Practiceccmod.screen;

import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.screen.custom.CleaningStationMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
        DeferredRegister.create(Registries.MENU, Practiceccmod.MOD_ID);

    public static final RegistryObject<MenuType<CleaningStationMenu>> CLEANING_STATION_MENU =
            MENUS.register("cleaning_station_menu", () -> IForgeMenuType.create(CleaningStationMenu::new));


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
