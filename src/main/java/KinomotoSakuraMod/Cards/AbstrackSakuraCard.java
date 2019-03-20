package KinomotoSakuraMod.Cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public abstract class AbstrackSakuraCard extends AbstractCard
{
    public AbstrackSakuraCard(String id, String name, String img, int cost, String rawDescription, CardType type, CardColor color, CardRarity rarity, CardTarget target)
    {
        super(id, name, img, cost, rawDescription, type, color, rarity, target);
    }

    public abstract void upgrade();

    public abstract AbstractClowCard makeCopy();

    public abstract void use(AbstractPlayer player, AbstractMonster monster);
}
