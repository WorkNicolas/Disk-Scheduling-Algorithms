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
        System.out.print("User Input: ");
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
