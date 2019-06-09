package KinomotoSakuraMod.Powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

public abstract class KSMOD_CustomPower extends AbstractPower
{
    public KSMOD_CustomPower(String id, String name, String img, PowerType powerType, AbstractCreature target, int amount)
    {
        this.ID = id;
        this.name = name;
        this.img = new Texture(img);
        this.type = powerType;
        this.owner = target;
        this.amount = amount;
    }
}