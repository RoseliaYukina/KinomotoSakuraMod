package KinomotoSakuraMod.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;

public class KSMOD_MoveAction extends AbstractGameAction
{
    public static final String ACTION_ID = "KSMOD_MoveAction";
    private static final String[] TEXT;
    private static final float DURATION = Settings.ACTION_DUR_FASTER;
    private AbstractPlayer player;

    static
    {
        UIStrings uiStrings = CardCrawlGame.languagePack.getUIString(ACTION_ID);
        TEXT = uiStrings.TEXT;
    }

    public KSMOD_MoveAction(int amount)
    {
        this.player = AbstractDungeon.player;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = DURATION;
        this.amount = amount;
    }

    public void update()
    {
        if (AbstractDungeon.getCurrRoom().isBattleEnding())
        {
            this.isDone = true;
        }
        else
        {
            if (this.duration == DURATION)
            {
                if (this.player.discardPile.isEmpty())
                {
                    this.isDone = true;
                    return;
                }

                if (this.player.discardPile.size() == this.amount)
                {
                    AbstractCard tmp = this.player.discardPile.getTopCard();
                    this.player.discardPile.removeCard(tmp);
                    this.player.discardPile.moveToDeck(tmp, false);
                }

                if (this.player.discardPile.group.size() > this.amount)
                {
                    AbstractDungeon.gridSelectScreen.open(this.player.discardPile, this.amount, TEXT[0], false, false, false, false);
                    this.tickDuration();
                    return;
                }
            }

            if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty())
            {
                for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards)
                {
                    this.player.discardPile.removeCard(c);
                    this.player.hand.moveToDeck(c, true);
                }
                AbstractDungeon.gridSelectScreen.selectedCards.clear();
                AbstractDungeon.player.hand.refreshHandLayout();
            }

            this.tickDuration();
        }
    }
}