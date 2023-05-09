package pl.psi.creatures;

import com.google.common.collect.Range;
import lombok.Getter;

@Getter
public enum SpellStatistic implements SpellStatisticIf
{
    FIREBALL( "Fireball", 5, 5, 1,
            "FIREBALLS!!!");//


    private final String name;
    private final int attack;
    private final  int damage;
    private final int tier;
    private final String description;


    SpellStatistic( final String aName, final int aAttack, final int aDamage,
                    final int aTier, final String aDescription)
    {
        name = aName;
        attack = aAttack;
        damage = aDamage;
        tier = aTier;
        description = aDescription;
    }
}
