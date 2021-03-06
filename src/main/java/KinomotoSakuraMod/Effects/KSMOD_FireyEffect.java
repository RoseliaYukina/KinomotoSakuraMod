package KinomotoSakuraMod.Effects;

import KinomotoSakuraMod.Utility.KSMOD_Utility;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.vfx.combat.GiantFireEffect;

import java.lang.reflect.Field;

public class KSMOD_FireyEffect extends GiantFireEffect
{
    public KSMOD_FireyEffect()
    {
        super();
        try
        {
            Field vX = KSMOD_Utility.GetFieldByReflect(GiantFireEffect.class, "vX");
            Field vY = KSMOD_Utility.GetFieldByReflect(GiantFireEffect.class, "vY");
            vX.set(this, MathUtils.random(-70.0F, 70.0F) * Settings.scale);
            vY.set(this, MathUtils.random(500.0F, 900.0F) * Settings.scale);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
