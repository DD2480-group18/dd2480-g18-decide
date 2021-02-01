import java.util.stream.IntStream;

public class Launch {
    public static boolean launch(boolean[] FUV) {
        return FUV.length > 0 ? IntStream.range(0, FUV.length).allMatch(i -> FUV[i]) : false;
    }
}