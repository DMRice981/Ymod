package com.ymod.registry;

import com.ymod.YMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CITRINE = registerItem("citrine",new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registerItem("raw_citrine",new Item(new FabricItemSettings()));


    public static Item registerItem(String name, Item item, ItemGroup... itemGroups){
        Item registerItem = Registry.register(Registries.ITEM,new Identifier(YMod.MOD_ID,name),item);
        for(ItemGroup itemGroup:itemGroups){
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registerItem));
        }
        return registerItem;
    }
    public static void registerModItems(){
        YMod.LOGGER.debug("registering mod items for" +YMod.MOD_ID);
    }
}
