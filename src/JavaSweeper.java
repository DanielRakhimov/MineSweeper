import javax.swing.*;
import java.awt.*;
import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame{

    private final int Col = 9;
    private final int Row = 9;
    private final int Bomb = 10;
    private final int ImageSize = 50;
    private JPanel panel;
    private Game game;

    public static void main(String[] args) {
        new JavaSweeper();
    }
    private JavaSweeper(){
        game = new Game(Col, Row, Bomb);
        game.start();
        setImages();
        initPanel();
        initFrame();

    }

    private void initFrame(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // остановить программу на крестик
        setTitle("Mine Sweeper");
        setLocationRelativeTo(null); // установка окна по центру
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
        pack(); // задать минимальные нужные размеры  окна

    }

    private void  initPanel(){

        panel = new JPanel(){ // ананомный класс с перегрузкой функции вывода картинок

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for(var coord : Ranges.getAllCoords()){
                    g.drawImage((Image) game.getBox(coord).image, coord.x * ImageSize, coord.y * ImageSize, this);

                }
            }
        };
        panel.setPreferredSize(new Dimension(Ranges.getSize().x * ImageSize, Ranges.getSize().y * ImageSize)); // задать размеры панели
        add(panel); // добавить панель в форму

    }

    private Image getImage (String name){

        String filename = "img/" +  name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename)); // обращение к папке ресурса
        return icon.getImage();

    }

    private void setImages(){ // установка иконок полям Box

        for(var box : Box.values()){

            box.image = getImage(box.name().toLowerCase());

        }

    }

}
