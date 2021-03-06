package KinomotoSakuraMod.Powers;

import KinomotoSakuraMod.KSMOD;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.random.Random;

import java.util.ArrayList;

public class KSMOD_DarkPower_SakuraCard extends KSMOD_CustomPower
{
    public static final String POWER_ID = "KSMOD_DarkPower_SakuraCard";
    private static final String POWER_NAME;
    private static final String[] POWER_DESCRIPTIONS;
    private static final String POWER_IMG_PATH = "img/powers/dark_power_sakuracard.png";
    private static final AbstractPower.PowerType POWER_TYPE = AbstractPower.PowerType.BUFF;
    private static final float RARE_CARD_RATE = 0.1F;
    private static final float UNCOMMON_CARD_RATE = 0.3F;

    static
    {
        PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
        POWER_NAME = powerStrings.NAME;
        POWER_DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }

    public KSMOD_DarkPower_SakuraCard()
    {
        this(AbstractDungeon.player, 1);
    }

    public KSMOD_DarkPower_SakuraCard(AbstractCreature target, int amount)
    {
        super(POWER_ID, POWER_NAME, POWER_IMG_PATH, POWER_TYPE, target, amount, true);
        this.updateDescription();
    }

    public void updateDescription()
    {
        this.description = POWER_DESCRIPTIONS[0];
    }

    public void atEndOfTurn(boolean isPlayer)
    {
        if (isPlayer && !AbstractDungeon.player.hand.isEmpty())
        {
            int count = AbstractDungeon.player.hand.size();
            for (AbstractCard card : AbstractDungeon.player.hand.group)
            {
                AbstractDungeon.actionManager.addToBottom(new ExhaustSpecificCardAction(card, AbstractDungeon.player.hand));
            }
            for (int i = 0; i < count; i++)
            {
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(GetRandomClowCard(), 1));
            }
        }
    }

    private AbstractCard GetRandomClowCard()
    {
        ArrayList<AbstractCard> commonList = new ArrayList<>();
        ArrayList<AbstractCard> uncommonList = new ArrayList<>();
        ArrayList<AbstractCard> rareList = new ArrayList<>();

        for (AbstractCard card : KSMOD.GetClowCardList())
        {
            switch (card.rarity)
            {
                case COMMON:
                    commonList.add(card);
                    break;
                case UNCOMMON:
                    uncommonList.add(card);
                    break;
                case RARE:
                    rareList.add(card);
                    break;
                default:
                    break;
            }
        }

        float randNum = new Random().random(0F, 1F);
        AbstractCard card;
        if (randNum <= RARE_CARD_RATE)
        {
            card = GetRandomListElement(rareList);
        }
        else if (randNum <= RARE_CARD_RATE + UNCOMMON_CARD_RATE)
        {
            card = GetRandomListElement(uncommonList);
        }
        else
        {
            card = GetRandomListElement(commonList);
        }
        card.upgrade();
        return card;
    }

    private <T> T GetRandomListElement(ArrayList<T> arrayList)
    {
        return arrayList.get(new Random().random(0, arrayList.size() - 1));
    }
}
