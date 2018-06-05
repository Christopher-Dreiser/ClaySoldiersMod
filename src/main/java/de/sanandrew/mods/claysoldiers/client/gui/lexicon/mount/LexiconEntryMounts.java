/* ******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/
package de.sanandrew.mods.claysoldiers.client.gui.lexicon.mount;

import de.sanandrew.mods.claysoldiers.api.CsmConstants;
import de.sanandrew.mods.claysoldiers.api.client.lexicon.ILexiconEntry;
import de.sanandrew.mods.claysoldiers.api.client.lexicon.ILexiconEntryCraftingGrid;
import de.sanandrew.mods.claysoldiers.client.gui.lexicon.LexiconRenderStandard;
import de.sanandrew.mods.claysoldiers.client.gui.lexicon.crafting.LexiconRenderCraftingGrid;
import de.sanandrew.mods.claysoldiers.registry.ItemRegistry;
import de.sanandrew.mods.claysoldiers.registry.mount.EnumClayHorseType;
import de.sanandrew.mods.claysoldiers.registry.mount.EnumGeckoType;
import de.sanandrew.mods.claysoldiers.registry.mount.EnumTurtleType;
import de.sanandrew.mods.claysoldiers.registry.mount.EnumWoolBunnyType;
import de.sanandrew.mods.sanlib.lib.XorShiftRandom;
import de.sanandrew.mods.sanlib.lib.util.MiscUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;

public class LexiconEntryMounts
        implements ILexiconEntry
{
    private static final String ID = "title";
    private final ItemStack[] icons;
    private final ResourceLocation prevPic;

    public LexiconEntryMounts() {
        NonNullList<ItemStack> itms = NonNullList.create();
        itms.add(ItemRegistry.DOLL_HORSE.getTypeStack(EnumClayHorseType.DIRT));
        itms.add(ItemRegistry.DOLL_PEGASUS.getTypeStack(EnumClayHorseType.DIRT));
        itms.add(ItemRegistry.DOLL_TURTLE.getTypeStack(EnumTurtleType.COBBLE));
        itms.add(ItemRegistry.DOLL_BUNNY.getTypeStack(EnumWoolBunnyType.BLACK));
        itms.add(ItemRegistry.DOLL_GECKO.getTypeStack(EnumGeckoType.OAK_BIRCH));
        this.icons = itms.toArray(new ItemStack[0]);
        this.prevPic = new ResourceLocation(CsmConstants.ID, "textures/gui/lexicon/page_pics/mounts/" + CsmConstants.ID + "_mounts.png");
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getGroupId() {
        return LexiconGroupMounts.GRP_NAME;
    }

    @Override
    public String getPageRenderId() {
        return LexiconRenderStandard.ID;
    }

    @Nonnull
    @Override
    public ItemStack getEntryIcon() {
        return this.icons[(int) ((System.nanoTime() / 1_000_000_000) % this.icons.length)];
    }

    @Override
    public ResourceLocation getPicture() {
        return this.prevPic;
    }

    @Override
    public boolean divideAfter() {
        return false;
    }
}
