/**
 * Disk Scheduling Algorithm Interface
 * Created for code uniformity
 *
 * @author WorkNicolas
 * @version 2023-05-22
 *
 */
public interface DiskSched {
    public void diskSched(int[] arr, int head);
    public default void diskSched(int[] arr, int head, boolean direction) {
        
    }
    public String toString();
    public Model getModel();
    public void setModel(Model model);
}
