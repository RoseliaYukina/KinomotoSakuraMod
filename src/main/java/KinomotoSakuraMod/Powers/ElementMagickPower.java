package KinomotoSakuraMod.Powers;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ElementMagickPower extends AbstractPower
{
    private static final String ID = "ElementMagickPower";
    private static final String NAME;
    private static final String[] DESCRIPTIONS;
    private static final String IMG = "img/powers/ElementMagickPower.png";
    private static final float CORRECTION_RATE = 0.05f;

    private boolean _isElementCardUsed = false;

    static
    {
        PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(ID);
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }


    public static float ElementCorrect(float input)
    {
        EnhancementMagickPower power = (EnhancementMagickPower) AbstractDungeon.player.getPower(ID);
        return MathUtils.floor((power.amount * CORRECTION_RATE + 1f) * input);
    }
}
