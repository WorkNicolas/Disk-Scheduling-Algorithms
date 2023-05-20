/**
 * Disk Scheduling Algorithm Interface
 * Created for code uniformity
 *
 * @author WorkNicolas
 * @version 2023-05-20
 *
 */
public interface DiskSched {
    public void diskSched(int[] arr, int head);
    public String toString();
    public Model getModel();
}
