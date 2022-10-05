package sweeper;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Ranges;

public class Game {

    private Bomb bomb;
    public Game(int col, int row, int bombs){

        Ranges.setSize(new Coord(col, row));
        bomb = new Bomb(bombs);

    }

    public void start(){

        bomb.start();

    }
    public Box getBox(Coord coord){
        return bomb.get(coord);

    }

}
