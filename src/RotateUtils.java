public class RotateUtils {

    // this is a check for when distance is bigger than the list size
    // if it is set distance to the either the remainder (modulo)
    // or the list size itself
    public static int adjustDistanceIfNeeded(int distance, int listSize) {
        if (distance > listSize) {
            if (listSize % distance > 0) {
                distance = distance % listSize;
            } else {
                distance = listSize;
            }
        }
        return distance;
    }

    // if there is no distance
    // or the distance is the same length as the list size
    // just return because there is nothing needed to do
    public static boolean distanceNotZeroOrSize(int distance, int listSize) {
        return distance == 0 || distance == listSize;
    }

}
