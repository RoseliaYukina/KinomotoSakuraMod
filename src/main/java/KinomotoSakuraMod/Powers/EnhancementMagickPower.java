package KinomotoSakuraMod.Powers;

import KinomotoSakuraMod.Patches.CustomTag;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;

public class EnhancementMagickPower extends CustomPower
{
    public static final String POWER_ID = "EnhancementMagickPower";
    private static final String POWER_NAME;
    private static final String[] POWER_DESCRIPTIONS;
    private static final String POWER_IMG_PATH = "img/powers/default_power.png";
    private static final PowerType POWER_TYPE = PowerType.BUFF;
    public static final float CORRECTION_RATE = 0.025f;

    static
    {
        PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
        POWER_NAME = powerStrings.NAME;
        POWER_DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }

    public EnhancementMagickPower(AbstractCreature target, int amount)
    {
        super(POWER_ID, POWER_NAME, POWER_IMG_PATH, POWER_TYPE, target, amount);
        updateDescription();
    }


    public void updateDescription()
    {
        this.description = POWER_DESCRIPTIONS[0] + this.amount * (CORRECTION_RATE * 100) + POWER_DESCRIPTIONS[1];
    }

    public void onUseCard(AbstractCard card, UseCardAction action)
    {
        if (card.tags.contains(CustomTag.PHYSICS_CARD))
        {
            flash();
        }
    }
}
