package de.sanandrew.mods.claysoldiers.util.soldier.upgrade.misc.update;

import de.sanandrew.mods.claysoldiers.entity.EntityClayMan;
import de.sanandrew.mods.claysoldiers.util.soldier.upgrade.SoldierUpgradeInst;
import de.sanandrew.mods.claysoldiers.util.soldier.upgrade.SoldierUpgrades;
import de.sanandrew.mods.claysoldiers.util.soldier.upgrade.misc.AUpgradeMisc;
import net.minecraft.util.DamageSource;
import org.apache.commons.lang3.mutable.MutableFloat;

/**
 * @author SanAndreas
 * @version 1.0
 */
public class UpgradeWool
    extends AUpgradeMisc
{
    @Override
    public boolean onUpdate(EntityClayMan clayMan, SoldierUpgradeInst upgradeInst) {
        if( !clayMan.hasUpgrade(SoldierUpgrades.getUpgrade(SoldierUpgrades.UPG_LEATHER)) ) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onSoldierHurt(EntityClayMan clayMan, SoldierUpgradeInst upgradeInst, DamageSource source, MutableFloat damage) {
        if( source.isUnblockable() ) {
            return true;
        }

        if( damage.floatValue() >= 1.0F ) {
            damage.subtract(1.0F);
        } else {
            damage.setValue(0.0F);
        }

        return true;
    }
}
