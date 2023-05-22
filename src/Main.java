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
                    ctrl.setDiskSched(ds);
                    ctrl.getView().displayMenu(View.CurrentAlgo.valueOf(ca[index]));
                    break;
                case 2:
                    index = 2;
                    ds = new SstfDiskSched(model);
                    ctrl.setDiskSched(ds);
                    ctrl.getView().displayMenu(View.CurrentAlgo.valueOf(ca[index]));
                    break;
                case 3:
                    index = 3;
                    ds = new ScanDiskSched(model);
                    ctrl.setDiskSched(ds);
                    ctrl.updateView(ctrl.getModel());
                    ctrl.getView().displayMenu(View.CurrentAlgo.valueOf(ca[index]));
                    break;
                case 4:
                    index = 4;
                    ds = new CscanDiskSched(model);
                    ctrl.setDiskSched(ds);
                    ctrl.updateView(ctrl.getModel());
                    ctrl.getView().displayMenu(View.CurrentAlgo.valueOf(ca[index]));
                    break;
                case 5:
                    ds = new LookDiskSched(model);
                    ctrl.setDiskSched(ds);
                    ctrl.updateView(ctrl.getModel());
                    ctrl.getView().displayMenu(View.CurrentAlgo.valueOf(ca[index]));
                    index = 5;
                    break;
                case 6:
                    ctrl.presetValues();
                    ctrl.updateView(ctrl.getModel());
                    break;
                case 7:
                    ctrl.updateView(ctrl.getModel());
                    ctrl.getView().initVal();
                    break;
                case 8:
                    ctrl.getView().displayValues();
                    break;
                case 9:
                    if (index != 0) {
                        ctrl.updateView(ctrl.getModel());
                        ctrl.getDiskSched().diskSched(ctrl.getModel().getArr(), ctrl.getModel().getHead());
                    } else {
                        System.out.println("Invalid Input: " + "NULL Index");
                        continue;
                    }
                case 10:
                    System.out.println("System.exit(Status: 0)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input: Option " + in + " does not exist");
                    break;
            }
        }
    }
}