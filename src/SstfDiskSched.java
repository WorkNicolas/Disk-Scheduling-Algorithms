/**
 * SSTF Disk Scheduling Algorithm
 * Implemented with DiskSched Interface
 *
 * @author 29AjayKumar
 * @author WorkNicolas
 * @version 2023-05-20
 */
public class SstfDiskSched implements DiskSched {
    private Model model;
    public SstfDiskSched(Model model) {
        this.model = model;
    }
    class Node {
        // get distance from head pos minus track number
        int distance = 0;

        // track access
        boolean accessed = false;
    }
    public void calculateDifference (int[] arr, int head, Node[] node) {
        for (int i = 0; i < node.length; i++) {
            node[i].distance = Math.abs(arr[i] - head);
        }
    }

    // find unaccessed track
    // unaccessed track = minimum distance from head
    public int findMin (Node[] node) {
        int index = -1;
        int minimum = Integer.MAX_VALUE;
        for (int i =0; i < node.length; i++) {
            if (!node[i].accessed && minimum > node[i].distance) {
                minimum = node[i].distance;
                index = i;
            }
        }
        return index;
    }

    /**
     * SSTF Disk Scheduling Algorithm
     * Implemented from DiskSched interface
     *
     * @param arr request
     * @param head HDD head representation
     */
    @Override
    public void diskSched(int[] arr, int head) {
        if (arr.length == 0) {
            return;
        }

        /**
         * Determines distance and if the
         * track has been accessed
         *
         */
        Node[] node = new Node[arr.length];

        for (int i = 0; i < arr.length; i++) {
            node[i] = new Node();
        }

        int seekCounter = 0;

        // Output to look for
        int[] seekSequence = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            seekSequence[i] = head;
            // get distance from head pos minus track number
            calculateDifference(arr, head, node);

            // find unaccessed track
            int index = findMin(node);

            // inform Node that track has been accessed
            node[index].accessed = true;

            // increase seekCounter directly according to distance
            seekCounter += node[index].distance;

            // replace head with the currentTrack once used
            head = arr[index];
        }

        // recent track accessed
        seekSequence[seekSequence.length - 1] = head;

        // model setters
        model.setSeekSequence(seekSequence);
        model.setSeekCounter(seekCounter);
    }

    /**
     * Use toString once diskSched method has been initialized
     * Displays the seekSequence and the seekCounter
     *
     * @return String output for seekSequence and seekCounter
     */
    @Override
    public String toString() {
        return "Total Number of Seek Operations = " + model.getSeekCounter()
                + "\nSeek Sequence: " + java.util.Arrays.toString(model.getSeekSequence());
    }

    /**
     * Model getter
     *
     * @return Model for future use case
     */
    @Override
    public Model getModel() {
        return model;
    }
}
