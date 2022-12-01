import java.util.ArrayList;
import java.util.List;

public class Ph_Expirement {
}

class Experiment{
    int index = 0;
    boolean isFacingRight = true;
    class arm implements MechanicalArm{

        @Override
        public int getCurrentIndex() {
            return index;
        }

        @Override
        public boolean isFacingRight() {
            return isFacingRight;
        }

        @Override
        public void changeDirection() {
            isFacingRight = !isFacingRight;
        }

        @Override
        public void moveForward(int numLocs) {
            if(index>0&&index<solutions.size()){
                if(isFacingRight&&index+numLocs< solutions.size()){
                    index+=numLocs;
                }else if(index-numLocs>0){
                    index-=numLocs;
                }else{
                    System.out.println("Error Out of room");
                }
            }
        }
    }
    /** The mechanical arm used to process the solutions */

    /** the list of solutions */
    private List<Solution> solutions;
//    class tube implements Solution{
//
//        @Override
//        public int getPH() {
//            return PH;
//        }
//
//        @Override
//        public void setPH(int newValue) {
//            PH = newValue;
//        }
//    }

    /** Resets the experiment.
     * Postcondition:
     * - The mechanical arm has a current index of 0.
     * - It is facing right. */
    public void reset(){
        index = 0;
        isFacingRight = true;
        /* to be implemented in part a. */
    }


    /** Finds and returns the index of the most acidic solution.
     * @return index the location of the most acidic solution or -1 if there are no acidic solutions.
     * Postcondition:
     * - the mechanical arm is facing right.
     * - Its current index is at the most acidic solution, or at 0  if there are no acidic soluitions. */
//    public int mostAcidic(){
//        /* to be implemented in part b */
//        for (Solution Ph:solutions) {
//
//        }
//    }
}

interface MechanicalArm{
    /** @return the index of the current locaiton of the mechanical arm */
    int getCurrentIndex();

    /**@return true if the mechanical arm is facing right(toward solutions with larger indexes), false if the mechanical arm is facing left(toward solutions with smaller indexes) */
    boolean isFacingRight();

    /** Changes the current direction of the mechanical arm */
    void changeDirection();

    /** Moves the mechanical arm forward in its current direction by the number of locations specified.
     *@param numLocs the number of locations to move
     *Precondition: numLocs>= 0. */
    void moveForward(int numLocs);
}

interface Solution{
    int PH = 7;
    /** @ return an integer value that ranges from 1(very acidic) to 14(very basic)*/
    int getPH();

    /** Set pH to newValue.
     * @param newValue the new pH value */
    void setPH(int newValue);
}