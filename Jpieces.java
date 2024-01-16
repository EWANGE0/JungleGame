/*  The Jungle Game (I don't know why it's translated this way because most of
 *                         the animals in the game do not belong to the jungle)
 *  By Evangeline Wang
 *  
 *  January 20, 2021
 *
 *  PROJECT DESCRIPTION:
 *          See the JChessBoard file for more insight!
 *
 *  IF I HAD TO DO THIS OVER AGAIN:
 *
 *          1) I would definitly take much less time dealing with the image
 *          since I found out ways to process them faster. I would also avoid
 *          the extra steps that I put in. I turned the picture into png right
 *          away and then inverting it, then screenshot and turn into png again 
 *          and again... Now I know I can avoid those steps.
 *          
 *          2) While looking for tutorial, I would first watch the whole thing
 *          before following it since I picked a series of video that kind of
 *          left me in the middle of nowhere, and expected myself with barely
 *          no javaswing experience to figure it out.
 *
 *          3) I should have written out my thoughts. I think it's a great way
 *          to figure out where I'm confused and stucked. There were also a few
 *          times when I wanted to do research on something but when I searched
 *          it up I lost tract of what I'm actually looking for.
 *
 *          4) I would do notes while I am writing the code instead of adding it
 *          later on since it's a great way to check if things made sense and
 *          where I can improve.
 *
 *  CODE I'M NOT HAPPY WITH:
 *
 *          1) When I select the piece, the mouse is not at the middle of the 
 *          piece, instead, it's at the top center of the piece. I tried to play
 *          around at the code where it's supposed to center the mouse onto the
 *          pieces but it didn't work as intended, so I switched it back.
 *          
 *          2) There are many codes for the animal pieces that repetes. I think
 *          there might be simply way to conclude them stead of having to type
 *          out everything everytime. (Although I copy && pasted them they still
 *          look very long) 
 *          
 *  UPGRADES I MIGHT MAKE:
 *          
 *          1) The trap! If an animal is in the trap, the rank automatically
 *          creases to zero which means any animal can attack it no matter the
 *          ranking. 
 *          I thought about this quite a bit and would definitely code it out if
 *          I had a little more time. If the px and py for the move function
 *          equals one of the trap's coordinate, the ranking of the animal will
 *          minues eight(since there are only eight animal ranks).
 *          But then I have to change some of the ranking code for killing since
 *          some of them are hard coded in such as the mouse can only kill
 *          the other mouse and the elephant, I can add && JChessBoard.getPiece
 *          (px * 64, py * 64).rank < 0.
 *          When they move out of the trap, their rank would turn back to normal
 *          with an additional 8 added back.
 *
 *          2) The player. I tried to have two sides so that one side can go
 *          before the other. Right now, eventhough the steps are restricted we
 *          still need the player to keep track of who went and who's turn it
 *          is.
 *
 *          3) Winning! If I had a little more time I would definitly looking
 *          into how I can do this. I think we can use if a chess of the other
 *          side went into the cave, it shows that side as the winner with a pop
 *          up screen. I can make two more Jpanels to repaint it when one side
 *          wins the game.
 *          
 *          4) Mouse blocked! There are many variations of the same game. I used
 *          to play by the version that if there is the mouse in the river in 
 *          the same lane that the other animal wants to leap, it blocks the way
 *          of the other animal. However, another version is that the animal
 *          can leap over and kill the mouse (I have no idea if I made this up
 *          or not). And another version says that the mouse does not effect the
 *          jump, so I'll stick with that.
 *
 *  CODE I'M PROUD OF AND WHY:
 *          
 *          1) The color scheme for the board and the board itself. Color might
 *          seem like a trivial thing for others, but I can't bear with colors
 *          color that doesn't match. I also try to change the color in many
 *          different ways. The first one is to use the given plain color, but
 *          they are just too sharp and disturbing. Then I tried to use the HBS
 *          (hue - brightness - saturation? I can't remeber the order) but the 
 *          color was never even close to the color I wanted. I gave up and used
 *          our good old friend RGB and it worked perfectly. 
 *
 *          2) Graphics for each chess. You might think inserting the image is
 *          the hard part, but no!!! Finding, editing, and scaling is even more
 *          complecated. As I mentioned somewhere above I did many extra steps, 
 *          but the end result was worth the time and effort. I spent no less
 *          than five hours collecting the pictures, inverting it, shaping it
 *          into circles, putting them in line, scaling them from the tiny
 *          window and finally making their background transparent and turning
 *          the file into png. It was a lot of work, especially when 2/3 of the
 *          work are trials and errors meaning that it didn't really helped
 *          with the final result.
 *
 *          3) The killing ranking. Unlike most of the other chess that you 
 *          might see that can kill the piece if it's within their legal move,
 *          the Jungle Game is different, each piece are ranked and can only 
 *          kill a few specific other animal that usually are ranked lower than 
 *          them.
 *          Due to the mouse-elephant exception, I can't overly generalize it.
 *          
 *          4) The movements. This is probably my proudest part of my code. I
 *          never expected that I can code the legal moves. At first my pieces
 *          flies around and can go anywhere on the board freely, I couldn't
 *          restrain them to move one step at a time. I thought of using the 
 *          Math.abs() for a long time, but I couldn't seem to find a right
 *          place to insert it. 
 *          After many times of telling myself that "It's alright" "I already
 *          met the criteria" "I give up" I kept trying and it finally worked.
 *          (those thoughts, especally the "I give up" one is so temperary. Even
 *          when I say it outloud I still can't stay true to it)
 *          After making the "moving one step at a time" I started the more
 *          challenging one which is the one leap for the leopard and the tiger,
 *          then the two leaps for the lion. One by one I coded all movements
 *          for all the animals. Either for their special power of leap or the 
 *          fact that only the mouse can be in the river.
 * 
 *          5) Finally, I'm proud of the fact that chose a challenging project
 *          I have learnt so much and had so many ah-ha moments of enlightenment
 *          that I wouldn't trade anything for. I am proud of the fact that I
 *          always push myself to work harder, make more progress, and not give 
 *          up (well... those temperarily ones doesn't really count)
 *          I'm proud that I had a lot of fun and I really enjoyed the project!
 *          
 */

package JungleGame;
import java.util.LinkedList;

/*
 * @author evangelinewang
 */

//this is what the Jpieces should have, the coordinates, light or dark, name,
//picture, and ranking.
public class Jpieces 
{
    int px;
    int py;
    
    int x;
    int y;
    
    int rank;
    
    boolean isLight;
    String name;
    LinkedList<Jpieces> ps;
//this stores information into the pieces
    public Jpieces(int px, int py, boolean isLight, String n, 
            LinkedList<Jpieces> ps, int rank){
        this.px = px;
        this.py = py;
        
        x = px * 64;
        y = py * 64;
        
        this.isLight = isLight;
        this.name = n;
        this.rank = rank;
        this.ps = ps;
        ps.add(this);
    }
    //this moves the pieces
    public void move(int px, int py){    
        /*ps.stream().filter((p) -> (p.px == px && p.py == py)).
        forEachOrdered((p) -> {
            p.kill();
        });*/

        //this is the code for mouse, I gave each animal a ranking so that it's
        //easier for me to orginize them.
        if(this.rank == 0){
            //this restricts where the piece can go and how many steps it can
            //take. Since all the pieces normally can only take one piece at a
            //time, either forward or backward, this code ensures it (later for
            //other animal pieces I will not explain it again since they are
            //the same
            if(px < 7 && py < 9 && Math.abs(this.px - px) + 
                    Math.abs(this.py - py) == 1){
                //if there is no piece at the landing place the piece can move
                //there
                if(JChessBoard.getPiece(px * 64, py * 64) == null){
                    //this updates the location of the piece
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                //However, if there is a piece at the place we need to see if
                //they are on the same team since it's no fun to kill ur team-
                //mate. We also need to consider the ranking since the mouse
                //can only eat the elephant or the other mouse
                else if(JChessBoard.getPiece(px * 64, py * 64) != null &&
                        JChessBoard.getPiece(px * 64, py * 64).isLight != 
                        isLight && (JChessBoard.getPiece(px * 64, py * 64).rank
                        == 0 ||JChessBoard.getPiece(px * 64, py * 64).rank ==
                        7)){
                    //if all the criterias meets the mouse may kill the piece
                    //and take it's place
                    JChessBoard.getPiece(px * 64, py * 64).kill();
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                //else the mouse will pop back to the original position
                else{
                    x = this.px * 64;
                    y = this.py * 64;
                }
            }
            else{
                x = this.px * 64;
                y = this.py * 64;
            }
        }
        
        //this code is for dog, cat, and wolf, they are the only animal that
        //totally follows the original rules or in other word without special
        //power. They can only eat animal of equal or less rank be eaten by 
        //animal of higher rank. They can only move one space at a time and 
        //they cannot go into the river
        else if(this.rank < 4 && this.rank > 0){ //this gets the cat, dog, wolf
            //this give them the condition that they cannot go into the rivers
            if(px < 7 && py < 9 && Math.abs(this.px - px) + 
                    Math.abs(this.py - py) == 1 && !(px > 0 && px < 6 && 
                    px != 3 && py > 2 && py < 6)){
                //If there is no piece (same as above in the mouse class)
                if(JChessBoard.getPiece(px * 64, py * 64) == null){
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                //If there is a piece, it gives condition that if satisfied may
                //result in the other piece being killed
                else if(JChessBoard.getPiece(px * 64, py * 64) != null &&
                        JChessBoard.getPiece(px * 64, py * 64).isLight != 
                        isLight && (JChessBoard.getPiece(px * 64, py * 64).rank
                        <= this.rank)){
                    JChessBoard.getPiece(px * 64, py * 64).kill();
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                //else plop back to the original spot
                else{
                    x = this.px * 64;
                    y = this.py * 64;
                }
            }
            //plop back if conditions above not met
            else{
                x = this.px * 64;
                y = this.py * 64;
            }
        }
        
        //this code is for leopard. Different from the animals above leopard
        //can leap across the river horizontally (2 spaces) which is shorter 
        //than the vertical distance (3 spaces)
        //It still can't go into the river.
        else if(this.rank == 4){ //identifying animal
            //first I wrote out all the cases possible for the leopard to jump
            if(px < 7 && py < 9 && this.py == py && py > 2 && py < 6 && (this.px == 0 && px == 3 || 
                    this.px == 3 && px == 6 || this.px == 6 && px == 3 || 
                    this.px == 3 && px == 0)){
                //if the criterias are all satified we can identify if there is
                //a piece there or not, in this case there isn't so it can just
                //jump over and land
                if(JChessBoard.getPiece(px * 64, py * 64) == null){
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                //In this case there is originally a piece there, so we have to
                //consider if we can kill the piece. If we can, then the other
                //piece is being removed and the location of the leopard is
                //being updated
                else if(JChessBoard.getPiece(px * 64, py * 64) != null &&
                        JChessBoard.getPiece(px * 64, py * 64).isLight != 
                        isLight && (JChessBoard.getPiece(px * 64, py * 64).rank
                        <= this.rank)){
                    JChessBoard.getPiece(px * 64, py * 64).kill();
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                //else plops back
                else{
                    x = this.px * 64;
                    y = this.py * 64;
                }
            }
            //then we have to consider cases for the leopard to make normal
            //moves which is in anyother cases that it's not leaping, just like
            //others, it can only take one step at a time.
            //It can't swim either.
            else if(px < 7 && py < 9 && Math.abs(this.px - px) + 
                    Math.abs(this.py - py) == 1 && !(px > 0 && px < 6 && 
                    px != 3 && py > 2 && py < 6)){
                //repeated see explination above
                if(JChessBoard.getPiece(px * 64, py * 64) == null){
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else if(JChessBoard.getPiece(px * 64, py * 64) != null &&
                        JChessBoard.getPiece(px * 64, py * 64).isLight != 
                        isLight && (JChessBoard.getPiece(px * 64, py * 64).rank
                        <= this.rank)){
                    JChessBoard.getPiece(px * 64, py * 64).kill();
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else{
                    x = this.px * 64;
                    y = this.py * 64;
                }
            }
            else{
                x = this.px * 64;
                y = this.py * 64;
            }
        }
        
        //This code is for tiger. Tiger is a little different from the leopard
        //It can only jump vertically. Just like the code for leopard, I listed 
        //all the possible cases. It cannot walk into the river either.
        //(see above for more specific explination)
        else if(this.rank == 5){
            if(px < 7 && py < 9 && this.px == px && px != 0 && px != 3 && 
                    px != 6 && (this.py == 2 && py == 6 || this.py == 6 &&
                    py == 2)){
                if(JChessBoard.getPiece(px * 64, py * 64) == null){
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else if(JChessBoard.getPiece(px * 64, py * 64) != null &&
                        JChessBoard.getPiece(px * 64, py * 64).isLight != 
                        isLight && (JChessBoard.getPiece(px * 64, py * 64).rank
                        <= this.rank)){
                    JChessBoard.getPiece(px * 64, py * 64).kill();
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else{
                    x = this.px * 64;
                    y = this.py * 64;
                }
            }
            else if(px < 7 && py < 9 && Math.abs(this.px - px) + 
                    Math.abs(this.py - py) == 1 && !(px > 0 && px < 6 && 
                    px != 3 && py > 2 && py < 6)){
                if(JChessBoard.getPiece(px * 64, py * 64) == null){
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else if(JChessBoard.getPiece(px * 64, py * 64) != null &&
                        JChessBoard.getPiece(px * 64, py * 64).isLight != 
                        isLight && (JChessBoard.getPiece(px * 64, py * 64).rank
                        <= this.rank)){
                    JChessBoard.getPiece(px * 64, py * 64).kill();
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else{
                    x = this.px * 64;
                    y = this.py * 64;
                }
            }
            else{
                x = this.px * 64;
                y = this.py * 64;
            }
        }
        
        //this code is for lion. The lion can leap over the river however it
        //wishes, thus I combined all the cases from both the tiger and leopard
        else if(this.rank == 6){
            if(px < 7 && py < 9 && ((this.py == py && py > 2 && py < 6 && (this.px == 0 && px == 3 
                    || this.px == 3 && px == 6 || this.px == 6 && px == 3 || 
                    this.px == 3 && px == 0))||(this.px == px && px != 0 && px 
                    != 3 && px != 6 && (this.py == 2 && py == 6 || this.py == 6 
                    && py == 2)))){
                if(JChessBoard.getPiece(px * 64, py * 64) == null){
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else if(JChessBoard.getPiece(px * 64, py * 64) != null &&
                        JChessBoard.getPiece(px * 64, py * 64).isLight != 
                        isLight && (JChessBoard.getPiece(px * 64, py * 64).rank
                        <= this.rank)){
                    JChessBoard.getPiece(px * 64, py * 64).kill();
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else{
                    x = this.px * 64;
                    y = this.py * 64;
                }
            }
            else if(px < 7 && py < 9 && Math.abs(this.px - px) + 
                    Math.abs(this.py - py) == 1 && !(px > 0 && px < 6 && 
                    px != 3 && py > 2 && py < 6)){
                if(JChessBoard.getPiece(px * 64, py * 64) == null){
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else if(JChessBoard.getPiece(px * 64, py * 64) != null &&
                        JChessBoard.getPiece(px * 64, py * 64).isLight != 
                        isLight && (JChessBoard.getPiece(px * 64, py * 64).rank
                        <= this.rank)){
                    JChessBoard.getPiece(px * 64, py * 64).kill();
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else{
                    x = this.px * 64;
                    y = this.py * 64;
                }
            }
            else{
                x = this.px * 64;
                y = this.py * 64;
            }
        }
        
        //This code is for elephant. Elephant cannot go into the river nor jump.
        //It is also special because it cannot kill the mouse which has the
        //lowest ranking, but it can be kill by mouse.
        //basically I said it can kill the other piece unless it's a mouse
        else if(this.rank == 7){
            if(px < 7 && py < 9 && Math.abs(this.px - px) + 
                    Math.abs(this.py - py) == 1 && !(px > 0 && px < 6 && 
                    px != 3 && py > 2 && py < 6)){
                if(JChessBoard.getPiece(px * 64, py * 64) == null){
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else if(JChessBoard.getPiece(px * 64, py * 64) != null &&
                        JChessBoard.getPiece(px * 64, py * 64).isLight != 
                        isLight && (JChessBoard.getPiece(px * 64, py * 64).rank
                        != 0)){
                    JChessBoard.getPiece(px * 64, py * 64).kill();
                    this.px = px;
                    this.py = py;
        
                    x = px * 64;
                    y = py * 64;
                }
                else{
                    x = this.px * 64;
                    y = this.py * 64;
                }
            }
            else{
                x = this.px * 64;
                y = this.py * 64;
            }
        }
    }
    //this kills the piece by removing the piece from the board and I have used
    //it a lot in the codes above
    public void kill(){
        ps.remove(this);
    }
}