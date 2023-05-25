package pl.psi.creatures;

import pl.psi.converter.SkillsInterface;

import java.util.List;
import java.util.Random;

public class OffenceSkill extends DefaultDamageCalculator implements SkillsInterface {

    public enum OffenceEnum {
        BASIC(1.1),
        ADVANCED(1.2),
        EXPERT(1.3);

        private final double value;

        OffenceEnum(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }
    private final OffenceEnum offenceEnum;
    public OffenceSkill(OffenceEnum offenceEnum) {

        super(new Random());
        this.offenceEnum = offenceEnum;
    }

    @Override
    public int applyDamageStrategy(int i)
    {
        return (int)(i * (offenceEnum.getValue()));
    }

    @Override
    public void apply(List<Creature> creatures) {
        creatures.forEach(s  -> s.setDemageCalculator(this));
    }

}


