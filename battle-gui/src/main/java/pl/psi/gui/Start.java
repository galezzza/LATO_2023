package pl.psi.gui;

import java.io.IOException;
import java.util.List;

import pl.psi.Hero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.psi.creatures.NecropolisFactory;
import pl.psi.creatures.Spell;
import pl.psi.creatures.SpellStatistic;

public class Start extends Application
{

    public Start()
    {

    }

    static void main( final String[] args )
    {
        launch( args );
    }

    @Override
    public void start( final Stage primaryStage )
    {
        Scene scene = null;
        try
        {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation( Start.class.getClassLoader()
                .getResource( "fxml/main-battle.fxml" ) );
            loader.setController( new MainBattleController( createP1(), createP2() ) );
            scene = new Scene( loader.load() );
            primaryStage.setScene( scene );
            primaryStage.setX( 5 );
            primaryStage.setY( 5 );
            primaryStage.show();
        }
        catch( final IOException aE )
        {
            aE.printStackTrace();
        }
    }

    private Hero createP2()
    {
        final Hero ret = new Hero( List.of( new NecropolisFactory().create( true, 1, 5 ) ), List.of(new Spell.spellBuilder().statistic(SpellStatistic.ICE_BOLT).build(), new Spell.spellBuilder().statistic(SpellStatistic.FIREBALL).build(),
                new Spell.spellBuilder().statistic(SpellStatistic.BLOODLUST).build(),
                new Spell.spellBuilder().statistic(SpellStatistic.SHIELD).build(),
                new Spell.spellBuilder().statistic(SpellStatistic.FLY).build(),
                new Spell.spellBuilder().statistic(SpellStatistic.BLIND).build(),
                new Spell.spellBuilder().statistic(SpellStatistic.WEAKNESS).build()
        ));
        return ret;
    }

    private Hero createP1()
    {
        final Hero ret = new Hero( List.of(
                new NecropolisFactory().create( false, 1, 5 ) ),
                List.of( new Spell.spellBuilder().statistic(SpellStatistic.LIGHTNING_BOLT).build(),
                        new Spell.spellBuilder().statistic(SpellStatistic.FLY).build(),
                        new Spell.spellBuilder().statistic(SpellStatistic.BLIND).build(),
                        new Spell.spellBuilder().statistic(SpellStatistic.WEAKNESS).build(),
                        new Spell.spellBuilder().statistic(SpellStatistic.CURE).build()) );
        return ret;
    }

}