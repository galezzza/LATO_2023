package pl.psi.specialFields;

public class ObstacleFactory {
    private static final String EXCEPTION_MESSAGE = "Obstacle with given name wasn't found";

    public Obstacle create(final String aName){
        switch(aName){
            case "Tree":
                return new Obstacle(ObstacleStatistic.TREE);
            case "Rock":
                return new Obstacle(ObstacleStatistic.ROCK);
            case "Boulder":
                return new Obstacle(ObstacleStatistic.BOULDER);
            case "Spikes":
                return new TransparentObstacle(new Obstacle(ObstacleStatistic.SPIKES));
            default:
                throw new IllegalArgumentException( EXCEPTION_MESSAGE );
        }
    }
}
