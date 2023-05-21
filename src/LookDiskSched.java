import java.util.Collections;
import java.util.Vector;

public class LookDiskSched implements DiskSched {
    private Model model;
    public LookDiskSched (Model model) {
        this.model = model;
    }
    public void diskSched(int[] arr, int head) {

    }
    /**
     * Look Disk Scheduling Algorithm method
     *
     * @param arr request
     * @param head HDD head representation
     */
    public void diskSched(int arr[], int head, boolean isRight) {
        int seekCounter = 0;
        int distance, currentTrack;

        Vector<Integer> left = new Vector<>();
        Vector<Integer> right = new Vector<>();
        Vector<Integer> seekSequence = new Vector<>();

        // Sort left and right vectors
        Collections.sort(left);
        Collections.sort(right);

        /**
         * Service the requests on the
         * right side of the head first
         *
         */
        int run = 2;
        while (run-- > 0) {
            if (!isRight) {
                head = 0;
            }
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
