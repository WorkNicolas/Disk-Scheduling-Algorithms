import java.util.Collections;
import java.util.Vector;

public class CscanDiskSched implements DiskSched {
    final int DISK_SIZE = 200;
    private Model model;
    public CscanDiskSched (Model model) {
        this.model = model;
    }
    /**
     * FCFS Disk Scheduling Algorithm method
     *
     * @param arr request
     * @param head HDD head representation
     */
    public void diskSched(int arr[], int head) {
        int seekCounter = 0;
        int distance, currentTrack;

        Vector<Integer> left = new Vector<>();
        Vector<Integer> right = new Vector<>();
        Vector<Integer> seekSequence = new Vector<>();

        /**
         * end values has to be visited
         * before direction is reversed
         *
         */
        left.add(0);
        right.add(DISK_SIZE -1 );

        /**
         * left tracks will be serviced when
         * the head comes back to the beginning
         *
         */
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < head) {
                left.add(arr[i]);
            }
            if (arr[i] > head) {
                right.add(arr[i]);
            }
        }

        // Sort left and right vectors
        Collections.sort(left);
        Collections.sort(right);

        /**
         * Service the requests on the
         * right side of the head first
         *
         */
        boolean isRight = true;
        int run = 2;
        while (run-- > 0) {
            for (int i = 0; i < (isRight ? right.size() : left.size()); i++) {
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
        }


        /**
         * Model setters
         *
         * arr is used for seekSequence
         * instead of seekSequence itself
         *
         */
        model.setSeekSequence(arr);
        model.setSeekCounter(seekCounter);
    }
    /**
     * Use toString once diskSched method has been initialized
     * Displays the seekSequence and the seekCounter
     *
     * @return String output for seekSequence and seekCounter
     */
    public String toString() {
        return "Total Number of Seek Operations = " + model.getSeekCounter()
                + "\nSeek Sequence: " + java.util.Arrays.toString(model.getSeekSequence());
    }
    /**
     * Model getter
     *
     * @return Model for future use case
     */
    public Model getModel() {
        return model;
    }

}
