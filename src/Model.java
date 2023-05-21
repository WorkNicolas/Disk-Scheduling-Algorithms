/**
 * Model for Disk Scheduler
 * Relevant getters and setters
 *
 * @author WorkNicolas
 * @version 2023-05-20
 */
public class Model {
    int[] arr;
    int head;
    int seekCounter;
    int[] seekSequence;
    DiskSched ds;
    // getters
    public int[] getArr() {
        return arr;
    }
    public int getHead() {
        return head;
    }
    public int getSeekCounter() {
        return seekCounter;
    }
    public int[] getSeekSequence() {
        return seekSequence;
    }
    public DiskSched getDiskSched() {
        return ds;
    }
    // setters
    public void setArr(int[] arr) {
        this.arr = arr;
    }
    public void setHead(int head) {
        this.head = head;
    }
    public void setSeekCounter(int seekCounter) {
        this.seekCounter = seekCounter;
    }
    public void setSeekSequence(int[] seekSequence) {
        this.seekSequence = seekSequence;
    }
    public void setDiskSched(DiskSched ds) {
        this.ds = ds;
    }
}
