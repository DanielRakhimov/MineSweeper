package sweeper;

class Bomb {

    private Matrix bombMap;
    private int totalBombs;

    public Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    void start(){

        bombMap = new Matrix(Box.ZERO);
        placeBomb();

    }

    private void placeBomb(){

        bombMap.set(new Coord(4,4 ), Box.BOMB);

    }

    Box get(Coord coord){

        return bombMap.get(coord);

    }

}
