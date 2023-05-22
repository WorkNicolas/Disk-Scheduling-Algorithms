import java.util.Scanner;

public class View {
    private Model model;
    enum CurrentAlgo {
        NULL,
        FFCS,
        SSTF,
        SCAN,
        CSCAN,
        LOOK;
    }
    public View (Model model) {
        this.model = model;
        displayMenu(CurrentAlgo.NULL);
    }
    public void displayMenu(CurrentAlgo ca) {
        System.out.println("Current Disk Scheduling Algorithm: " + ca);
        System.out.println("[1] FFCS");
        System.out.println("[2] SSTF");
        System.out.println("[3] SCAN");
        System.out.println("[4] CSCAN");
        System.out.println("[5] LOOK");
        System.out.println("[6] Preset Values");
        System.out.println("[7] Initialize Values");
        System.out.print("User Input: ");
        initVal();
    }

    /**
     * initalize int array and int head
     *
     */
    private void initVal() {
        System.out.println("Initalizing Values...");
        int[] arr;
        while (true) {
            System.out.print("[IN IN IN ...] Request Array: ");
            try {
                arr = inIntArray();
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input: " + ex);
            }
        }
        int head;
        while (true) {
            System.out.print("[IN] Head: ");
            try {
                head = inInt();
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input: " + ex);
            }
        }
        model.setArr(arr);
        model.setHead(head);
    }

    /**
     * User input for int value
     *
     * @return
     */
    private int inInt() {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        return in;
    }
    /**
     * Space-separated user input
     * for int arrays
     *
     * @return
     */
    private int[] inIntArray() {
        // space-separated user input
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] e = in.split(" ");

        // int conversion
        int[] arr = new int[e.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(e[i]);
        }
        return arr;
    }
    private void initAlgo(CurrentAlgo ca) {
        System.out.println("Initializing Disk Scheduling Algorithm: " + ca);
    }
    // setters
    public void setModel(Model model) {
        this.model = model;
    }
    // getters
    public Model getModel() {
        return model;
    }
}
