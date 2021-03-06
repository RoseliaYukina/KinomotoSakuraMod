package KinomotoSakuraMod.Powers;

import KinomotoSakuraMod.Relics.KSMOD_SealedBook;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;

public class KSMOD_WavePower extends KSMOD_CustomPower
{
    public static final String POWER_ID = "KSMOD_WavePower";
    private static final String POWER_NAME;
    private static final String[] POWER_DESCRIPTIONS;
    private static final String POWER_IMG_PATH = "img/powers/wave_power.png";
    private static final PowerType POWER_TYPE = PowerType.BUFF;

    static
    {
        PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
        POWER_NAME = powerStrings.NAME;
        POWER_DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }

    public KSMOD_WavePower(int amount)
    {
        this(AbstractDungeon.player, amount);
    }

    public KSMOD_WavePower(AbstractCreature target, int amount)
    {
        super(POWER_ID, POWER_NAME, POWER_IMG_PATH, POWER_TYPE, target, amount, true);
        this.updateDescription();
    }

    public void updateDescription()
    {
        this.description = POWER_DESCRIPTIONS[0] + this.amount + POWER_DESCRIPTIONS[1];
    }

    public void onUseCard(AbstractCard card, UseCardAction action)
    {
        if (card.type == AbstractCard.CardType.ATTACK)
        {
            AbstractDungeon.actionManager.addToTop(new GainBlockAction(this.owner, this.owner, this.amount));
        }
    }
}
