public class FcfsDiskSched implements DiskSched {
    /**
     * Logical block
     *
     * @param arr
     * @param head
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
        }
    }

}
