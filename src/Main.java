public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller ctrl = new Controller(model, view);
        DiskSched ds;
        boolean viewed = false;
        String[] ca = {"NULL", "FFCS", "SSTF", "SCAN", "CSCAN", "LOOK"};
        int index = 0;
        while (true) {
            if (viewed) {
                ctrl.getView().displayMenu(View.CurrentAlgo.valueOf(ca[index]));
            }
        }
    }
}