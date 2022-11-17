import java.util.Arrays;

public class GreyImageRepl {

    public static void main(String[] args){
//        GrayImage img = new GrayImage(new int[][]{ {255,184,178,84,129},{84,255,255,130,84},{78,255,0,0,78},{84,130,255,130,84} });
        GrayImage img = new GrayImage(new int[][]{{221,184,178,84,135},{84,255,255,130,84},{78,255,0,0,78},{84,130,255,130,84}});
        System.out.println(Arrays.deepToString(img.processImage()));

    }
}

class GrayImage {
    public static final int BLACK = 0;
    public static final int WHITE = 255;
    private int[][] pixelValues;
    /** The 2-dimensional representation of this image.
     *  Guaranteed not to be null.
     *  All values in the array are within the range
     *  [BLACK, WHITE], inclusive.
     */

    public GrayImage(int[][] array2D){
        /* to be implemented  */
        pixelValues = array2D;
    }
    /** @return the total number of white pixels in
     *    this image.
     * Postcondition: this image has not been changed.
     */
    public int countWhitePixels(){
        int count =0;
        /* to be implemented in part (a) */
        for(int y=0;y<pixelValues.length;y++){
            for(int x=0;x<pixelValues[y].length;x++){
                if(pixelValues[y][x] == WHITE){
                    count++;
                }
            }
        }
        return count;
    }

    public int[][] processImage(){
        /* to be implemented in part (b) */
        for(int y=0;y<pixelValues.length-2;y++){
            for(int x=0;x<pixelValues[y].length-2;x++){
                if(pixelValues[y][x]>pixelValues[y+2][x+2]){
                    pixelValues[y][x]=pixelValues[y][x]-pixelValues[y+2][x+2];
                }else{
                    pixelValues[y][x]=BLACK;
                }

            }
        }
        return pixelValues;
    }
}
