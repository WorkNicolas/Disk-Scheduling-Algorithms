/**
 * Scan Disk Scheduling Algorithm
 * Implemented with DiskSched interface
 *
 * @author 29AjayKumar
 * @author WorkNicolas
 * @version 2023-05-22
 */

import java.util.Collections;
import java.util.Vector;

public class ScanDiskSched implements DiskSched {
    private Model model;
    private final int DISK_SIZE = 200;
    public ScanDiskSched (Model model) {
        this.model = model;
    }
    public void diskSched(int[] arr, int head) {

    }

    /**
     * Scan Disk Scheduling Algorithm method
     *
     * @param arr
     * @param head
     * @param isRight [direction ? right : left]
     */
    public void diskSched(int[] arr, int head, boolean isRight) {
        int seekCounter = 0;
        int distance;
        int currentTrack;
        Vector<Integer> left = new Vector<>();
        Vector<Integer> right = new Vector<>();
        Vector<Integer> seekSequence = new Vector<Integer>();

        /**
         * end values has to be visited
         * before direction is reversed
         *
         */
        if (isRight == false) {
            left.add(0);
        } else if (isRight == true) {
            right.add(DISK_SIZE - 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < head) {
                left.add(arr[i]);
            }
            if (arr[i] > head) {
                right.add(arr[i]);
            }
        }

        // sort left and right vectors
        Collections.sort(left);
        Collections.sort(right);

        /**
         * scan loop twice from left and right
         * of the head
         *
         * modifed the original author's work
         * to use ternary operator for salient
         * code
         */
        int run = 2;
        while (run-- > 0) {
            for (int i = (isRight ? right.size() : left.size()) - 1; i >= 0; i--) {
                currentTrack = (isRight ? right.get(i) : left.get(i));

                // append currentTrack to seekSequence
                seekSequence.add(currentTrack);

                // get distance from currentTrack minus head
                distance = Math.abs(currentTrack - head);

                // increase seekCounter directly according to distance
                seekCounter += distance;

                // replace head with the currentTrack once used
                head = currentTrack;
            }
            isRight = !isRight;
        }

        /**
         * Model setters
         *
         * Convert Integer seekSequence to primitive int
         *
         */
        model.setSeekSequence(java.util.Arrays.stream(
                seekSequence.toArray(
                        new Integer[seekSequence.size()]
                )
            ).mapToInt(
                Integer::intValue
            ).toArray(

            )
        );
        model.setSeekCounter(seekCounter);
    }
    public String toString() {
        return "Total Number of Seek Operations = " + model.getSeekCounter()
                + "\nSeek Sequence: " + java.util.Arrays.toString(model.getSeekSequence());
    }

    /**
     * Model getter
     *
     * @return
     */
    public Model getModel() {
        return model;
    }
    /**
     * Model setter
     *
     * @param model
     */
    public void setModel(Model model) {
        this.model = model;
    }
}
