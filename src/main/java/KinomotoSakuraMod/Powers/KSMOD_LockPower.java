package KinomotoSakuraMod.Powers;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;

public class KSMOD_LockPower extends KSMOD_CustomPower
{
    public static final String POWER_ID = "KSMOD_LockPower";
    private static final String POWER_NAME;
    private static final String[] POWER_DESCRIPTIONS;
    private static final String POWER_IMG_PATH = "img/powers/lock_power.png";
    private static final PowerType POWER_TYPE = PowerType.BUFF;

    static
    {
        PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
        POWER_NAME = powerStrings.NAME;
        POWER_DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }

    public KSMOD_LockPower(AbstractCreature target, int amount)
    {
        super(POWER_ID, POWER_NAME, POWER_IMG_PATH, POWER_TYPE, target, amount, true);
        this.updateDescription();
    }

    public void updateDescription()
    {
        this.description = POWER_DESCRIPTIONS[0] + this.amount + POWER_DESCRIPTIONS[1];
    }

    public void atEndOfTurn(boolean isPlayer)
    {
        if (this.amount > 1)
        {
            AbstractDungeon.actionManager.addToTop(new ReducePowerAction(this.owner, AbstractDungeon.player, this, 1));
        }
        else
        {
            AbstractDungeon.actionManager.addToTop(new RemoveSpecificPowerAction(this.owner, AbstractDungeon.player, this));
        }
    }
}
