
package randomchargenerator;
import java.util.Random;
import java.io.PrintWriter;
/**
 *
 * @author Clayton
 */
public class RandomCharGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        char[] chars = new char[255];
        Random ran = new Random();
        PrintWriter writer = new PrintWriter("RandomInts.txt");
        for (int i =0; i < 255; i++)
        {
            char = ran.nextInt(25)
            writer.printf("%d%n", char);
        }
        writer.close();
    }
    
}
