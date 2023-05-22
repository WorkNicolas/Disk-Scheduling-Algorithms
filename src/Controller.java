public class Controller {
    private Model model;
    private View view;
    public Controller (Model model, View view) {
        this.model = model;
        this.view = view;
    }
    /**
     * Update view with current model
     *
     * @param model
     */
    public void updateView(Model model) {
        view.setModel(model);
    }
    // methods
    public void presetValues() {
        System.out.println("Initializing preset values...");
        int arr[] = {176, 79, 34, 60, 92, 11, 41, 114};
        int head = 50;
        model.setArr(arr);
        model.setHead(head);
        System.out.println("Request: " + java.util.Arrays.toString(arr));
        System.out.println("Head: " + head);
    }
    // getters
    public Model getModel() {
        return model;
    }
    public View getView() {
        return view;
    }
    public DiskSched getDiskSched() {
        return model.getDiskSched();
    }
    // setters
    public void setModel(Model model) {
        this.model = model;
    }
    public void setView(View view) {
        this.view = view;
    }
    public void setDiskSched(DiskSched ds) {
        model.setDiskSched(ds);
    }
}
