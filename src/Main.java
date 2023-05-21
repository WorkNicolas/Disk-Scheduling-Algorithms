import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Input Handler
        Scanner sc = new Scanner(System.in);

        // MVC architecture
        Model model = new Model();
        View view = new View(model);
        Controller ctrl = new Controller(model, view);

        // Disk Scheduling Algorithm
        DiskSched ds;

        /**
         * Once ran, viewed is set to true
         * so that displayMenu would not
         * repeat.
         *
         * byte is used as the index to
         * save memory as it only stores
         * 8-bit values compared to int
         * storing 32-bit values.
         *
         * byte and int can be used
         * interchangeably for array
         * index.
         *
         */
        boolean viewed = false;
        byte index = 0;
        String[] ca = {"NULL", "FFCS", "SSTF", "SCAN", "CSCAN", "LOOK"};

        while (true) {
            if (viewed) {
                ctrl.getView().displayMenu(View.CurrentAlgo.valueOf(ca[index]));
            }
            viewed = true;
            int in = 0;
            try {
                in = sc.nextInt();
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input: " + ex);
                continue;
            }
            switch (in) {
                case 1:
                    index = 1;
                    ds = new FcfsDiskSched(model);
                    model.setDiskSched(ds);
                    break;
                case 2:
                    index = 2;
                    ds = new SstfDiskSched(model);
                    model.setDiskSched(ds);
                    break;
                case 3:
                    index = 3;
                    ds = new ScanDiskSched(model);
                    model.setDiskSched(ds);
                    break;
                case 4:
                    ds = new CscanDiskSched(model);
                    model.setDiskSched(ds);
                    index = 4;
                    break;
                case 5:
                    ds = new LookDiskSched(model);
                    model.setDiskSched(ds);
                    index = 5;
                    break;
                case 6:
                    index = 6;
                    System.exit(0);
                    System.out.println("System.exit(Status: 0)");
                    break;
                default:
                    System.out.println("Invalid Input: Option " + in + " does not exist");
                    break;
            }
        }
    }
}