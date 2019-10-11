package KinomotoSakuraMod.Powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.ImageMaster;
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
        this.updateDescription();
    }

    public KSMOD_CustomPower(String id, String name, String reg48, PowerType powerType, AbstractCreature target, int amount, boolean overrideMark)
    {
        this.ID = id;
        this.name = name;
        Texture image48 = ImageMaster.loadImage(reg48);
        this.region48 = new TextureAtlas.AtlasRegion(image48, 0, 0, image48.getWidth(), image48.getHeight());
        Texture image128 = ImageMaster.loadImage(reg48.replaceAll(".png", "_p.png"));
        this.region128 = new TextureAtlas.AtlasRegion(image128, 0, 0, image128.getWidth(), image128.getHeight());
        this.type = powerType;
        this.owner = target;
        this.amount = amount;
        this.updateDescription();
    }

    protected void loadRegion(String fileName)
    {

    }
}
