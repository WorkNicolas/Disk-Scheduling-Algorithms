public class FcfsDiskSched implements DiskSched {
    private Model model;
    public FcfsDiskSched (Model model) {
        this.model = model;
    }
    /**
     * FCFS Disk Scheduling Algorithm
     * Implemented from DiskSched interface
     *
     * @param arr request
     * @param head HDD head representation
     */
    @Override
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

            // model setters
            model.setSeekSequence(arr);
            model.setSeekCounter(seekCounter);
        }
    }
    @Override
    public String toString() {
        return "Total Number of Seek Operations = " + model.getSeekCounter()
                + "\nSeek Sequence: " + java.util.Arrays.toString(model.getSeekSequence());
    }
    @Override
    public Model getModel() {
        return model;
    }

}
