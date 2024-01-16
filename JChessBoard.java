/*
 * The Jungle Game or 斗兽棋 had been one of my favourite board game of all 
 * times.
 * My parents would play a few rounds with me after dinner and I would cry if 
 * I lose:( 
 * Traditionally the chess pieces are either dark blue or dark red with blue 
 * going first.
 * 
 * Jungle Game tries to bring the hierchy of animal onto the chessboard. 
 * Here are what's on the board:
 *  - The two blue rectangle in the middle are river that sadly flows nowhere
 *  - The three yellow squares on each side are traps that make every animal 
 * vulnerable
 *  - The red square on each end are the cave and each player should try to 
 * reach the cave of others while protecting their own cave.
 * 
 * Here's the ranking:
 * Elephant > Lion > Tiger > Leopard > Wolf > Cat > Mouse 
 * (but elephant can't eat mouse, but mouse can eat elephant, long story)
 * you can eat the same ranking animal of your opponent Ex.lLion >< dLion
 *
 * All pieces can move one square horizontally or vertically (x diagonally)
 *
 * Here's some super power of some animal:
 * - mouse is the only animal that may go onto the river
 * - Lion and tiger can leap over a river vertically; 
 * - Lion and leopard can leap over a river horizontally. 
 * - If that square contains an enemy piece of equal or lower rank, the lion or 
 *   tiger capture it as part of their jump.
 * - A jump is blocked (not permitted) if a rat of either color currently 
 *   occupies any of the intervening water squares.(It depends)d
 * 
 * There are many variation of the same game, 
 * but since I'm coding it, you get to play by my rules hehe.
 *
 * Enjoy~
 */

package JungleGame;

/*
 * @author evangelinewang
 */

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class JChessBoard 
{   
    //Harmonious colors I like, I used the RGB code to mix out the color that
    //fits well together
    public static final Color BOARD_COLOR = new Color(218, 242, 223);
    public static final Color LINE_COLOR = new Color(188, 190, 235);
    public static final Color TRAP_COLOR = new Color(255, 243, 201);
    public static final Color CAVE_COLOR = new Color(252, 209, 222);
    public static final Color RIVER_COLOR = new Color(197, 225, 232);
    
    public static LinkedList<Jpieces> ps = new LinkedList<>();
    public static Jpieces selectedPiece = null;
    public static void main(String[] args) throws IOException
    {   
        //I want each character to have an avatar, so I put them all together
        //into one png file and inserted here
        BufferedImage all = ImageIO.read(new
         File("/Users/evangelinewang/NetBeansProjects/finalProject/src/Jung"
                 + "leGame/Jpieces copy.png"));
        //There are 8 animals in total and a light chess and a dark chess for
        //each animal
        Image imgs[] = new Image[16];
        int ind = 0;
        //The for loop cuts out the 200 pix x 200 pix chess pieces and scale it
        //to 64 by 64
        for(int y = 0; y < 400; y += 200){
            for(int x = 0; x < 1600; x += 200){
                imgs[ind] = all.getSubimage(x, y, 200,
                        200).getScaledInstance(64, 64,
                        BufferedImage.SCALE_SMOOTH);
                ind ++;
            }
        }
        //This initializes a Jpiece for all the characters with their starting
        //coordinates, player, name, picture, and ranking.
        //light pieces
        Jpieces wMouse = new Jpieces(0, 2, true, "mouse", ps, 0);
        Jpieces wCat = new Jpieces(5, 1, true, "cat", ps, 1);
        Jpieces wDog = new Jpieces(1, 1, true, "dog", ps, 2);
        Jpieces wWolf = new Jpieces(4, 2, true, "wolf", ps, 3);
        Jpieces wLeopard = new Jpieces(2, 2, true, "leopard", ps, 4);
        Jpieces wTiger = new Jpieces(6, 0, true, "tiger", ps, 5);
        Jpieces wLion = new Jpieces(0, 0, true, "lion", ps, 6);
        Jpieces wElephant = new Jpieces(6, 2, true, "elephant", ps, 7);
        
        //dark peices
        Jpieces dMouse = new Jpieces(6, 6, false, "mouse", ps, 0);
        Jpieces dCat = new Jpieces(1, 7, false, "cat", ps, 1);
        Jpieces dDog = new Jpieces(5, 7, false, "dog", ps, 2);
        Jpieces dWolf = new Jpieces(2, 6, false, "wolf", ps, 3);
        Jpieces dLeopard = new Jpieces(4, 6, false, "leopard", ps, 4);
        Jpieces dTiger = new Jpieces(0, 8, false, "tiger", ps, 5);
        Jpieces dLion = new Jpieces(6, 8, false, "lion", ps, 6);
        Jpieces dElephant = new Jpieces(0, 6, false, "elephant", ps, 7);

        
        //drawing the frame. The frame will pop out once you run the code.     
        JFrame frame = new JFrame();
        frame.setBounds(10,10,450,600);
        JPanel pn;
        //I created a Jpanel here to draw the chess board
        pn = new JPanel(){
            @Override   
            //This code is for drawing the game board used for the chess, it
            //is 7 x 9 with two rivers in the middle, six traps: three on
            //either side, and finally two caves: one on either side
            public void paint(Graphics g){
                for(int row = 0; row < 7; row ++){
                    for(int col = 0; col < 9; col ++){
                        //this paints the two rivers mentioned above, they are
                        //both 2 x 3 rivers
                        if(row > 0 && row < 6 && row != 3 && col > 2 &&
                                col < 6){
                            g.setColor(RIVER_COLOR);
                        }
                        //this paints the trap, they surrounds the cave 
                        //creating a T shape.
                        else if((row == 2 || row == 4)&& (col == 0 ||
                                col == 8)){
                            g.setColor(TRAP_COLOR);
                        }
                        else if(row == 3 && (col == 1 || col == 7)){
                            g.setColor(TRAP_COLOR);
                        }
                        //this paints the cave
                        else if(row == 3 && (col == 0 || col == 8)){
                            g.setColor(CAVE_COLOR);
                        }
                        //this paints the rest of the board with a light green
                        else{
                            g.setColor(BOARD_COLOR);
                        }
                        g.fillRect(row * 64, col * 64, 64, 64);
                        //Since it's a hard to tell from block to block I 
                        //decided to add lines to make the boxes, this draws 
                        //the line between the space
                        g.setColor(LINE_COLOR);
                        g.drawRect(row * 64, col * 64, 64, 64);
                    }
                }
                //When I made the animal avatar picture, I purposefully put 
                //them in order from the highest ranking to the lowest ranking 
                //so that I know the first chess piece avatar will be elephant 
                //then lion and so on... this allows me to insert the picture 
                //in to the Jpieces of each animal object.
                for(Jpieces p: ps){
                    int ind = 0;
                    if(p.name.equalsIgnoreCase("elephant")){
                        ind = 0;
                    }
                    if(p.name.equalsIgnoreCase("lion")){
                        ind = 1;
                    }
                    if(p.name.equalsIgnoreCase("tiger")){
                        ind = 2;
                    }
                    if(p.name.equalsIgnoreCase("leopard")){
                        ind = 3;
                    }
                    if(p.name.equalsIgnoreCase("wolf")){
                        ind = 4;
                    }
                    if(p.name.equalsIgnoreCase("dog")){
                        ind = 5;
                    }
                    if(p.name.equalsIgnoreCase("cat")){
                        ind = 6;
                    }
                    if(p.name.equalsIgnoreCase("mouse")){
                        ind = 7;
                    }
                    //This allows me to insert the picture into the right
                    //object since I know that the dark piece are above the
                    //light one in the same order I can simply add the number
                    //of total animals in this case there are eight.
                    if(p.isLight){
                        ind += 8;
                    }
                    //This graphs the image onto the board at the correct x
                    //and y coordinate
                    g.drawImage(imgs[ind], p.x, p.y, this);
                }
            }
        };
        //this runs the thing we drew above
        frame.add(pn);
        //these listen to the movement of the mouse
        frame.addMouseMotionListener(new MouseMotionListener(){
            @Override
            //If the mouse is dragged and there is a piece where the mouse is, 
            //it selects the piece and move it following the direction of the 
            //mouse.
            //The reason why there is "-32" for the x and y is because we want
            //the mouse to be at the center of the piece not a corner
            public void mouseDragged(MouseEvent e){
                if(selectedPiece != null){
                    selectedPiece.x = e.getX() - 32;
                    selectedPiece.y = e.getY() - 32;
                    frame.repaint();
                }
            }
            
            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        //these listen to the action of the mouse such as pressing or releasing   
        frame.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
            }
            @Override
            //When the mouse is pressed, the piece at the location of the mouse
            //is selected
            public void mousePressed(MouseEvent e){
                //System.out.println((getPiece(e.getX(), e.getY()).isLight?"
                //light ":"dark ")+getPiece(e.getX(),e.getY()).name);
                selectedPiece = getPiece(e.getX(), e.getY());
            }
            @Override
            //When the mouse is released the selected piece go throught the
            //move method in Jpieces class to see if they can move to the
            //location where the mouse released, if so their location will be
            //updated
            public void mouseReleased(MouseEvent e){
                selectedPiece.move(e.getX()/64, e.getY()/64);
                frame.repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e){
            }
            @Override
            public void mouseExited(MouseEvent e){  
            }
        });
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
    //this function gets the piece so that by going through all the pieces to
    //see if any of the piece matches what we want to get.
    //we need a getPiece function or else we can't conviently access a Jpiece
    //btw Jpiece just means an animal piece in jungle game
    public static Jpieces getPiece(int x, int y){
        int px = x/64;
        int py = y/64;
        for(Jpieces p: ps){
            if(p.px == px && p.py == py){
                return p;
            }
        }
        return null;
    }
}