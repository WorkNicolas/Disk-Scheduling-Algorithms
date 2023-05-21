/**
 * FCFS Disk Scheduling Algorithm
 * Implemented with DiskSched interface
 *
 * @author 29AjayKumar
 * @author WorkNicolas
 * @version 2023-05-20
 */
public class FcfsDiskSched implements DiskSched {
    private Model model;
    public FcfsDiskSched (Model model) {
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

        for (int j : arr) {
            currentTrack = j;

            // get distance from currentTrack minus head
            distance = Math.abs(currentTrack - head);

            // increase seekCounter directly according to distance
            seekCounter += distance;

            // replace head with the currentTrack once used
            head = currentTrack;
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
