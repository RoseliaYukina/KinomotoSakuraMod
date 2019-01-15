package KinomotoSakuraMod.Cards;

import KinomotoSakuraMod.Patches.AbstractClowCard;
import KinomotoSakuraMod.Patches.CardColorEnum;
import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ClowCardTheSword extends AbstractClowCard
{
    private static final String ID = "ClowCardTheSword";
    private static final String NAME;
    private static final String IMAGE_PATH;
    private static final int COST;
    private static final String DESCRIPTION;
    private static final CardType CARD_TYPE;
    private static final CardColor CARD_COLOR;
    private static final CardRarity CARD_RARITY;
    private static final CardTarget CARD_TARGET;

    static
    {
//        CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
//        NAME = cardStrings.NAME;
//        DESCRIPTION = cardStrings.DESCRIPTION;
        NAME = "剑";
        DESCRIPTION = "造成 !D! 点伤害。";
        IMAGE_PATH = "img/cards/ClowCardTheSword.png";
        COST = 1;
        CARD_TYPE = CardType.ATTACK;
        CARD_COLOR = CardColorEnum.CLOWCARD_COLOR;
        CARD_RARITY = CardRarity.COMMON;
        CARD_TARGET = CardTarget.ENEMY;
    }


    public ClowCardTheSword()
    {
        super(ID, NAME, IMAGE_PATH, COST, DESCRIPTION, CARD_TYPE, CARD_COLOR, CARD_RARITY, CARD_TARGET);
        this.tags.add(BaseModCardTags.BASIC_STRIKE);
        this.baseDamage = 6;
    }

    public void upgrade()
    {
        if (!this.upgraded)
        {
            upgradeName();
            upgradeDamage(3);
        }
    }

    public AbstractCard makeCopy()
    {
        return new ClowCardTheSword();
    }

    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        AbstractDungeon.actionManager.addToBottom(
                new DamageAction(monster, new DamageInfo(player, this.damage, this.damageTypeForTurn),
                AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }
}
