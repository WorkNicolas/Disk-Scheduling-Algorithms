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
    // getters
    public Model getModel() {
        return model;
    }
    public View getView() {
        return view;
    }
    // setters
    public void setModel(Model model) {
        this.model = model;
    }
    public void setView(View view) {
        this.view = view;
    }
}
