
public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        solveMethod(model.getHeight(), 0, 2, 1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    public void solveMethod(int height, int start, int end, int placeholder) {
        if (height > 0) {
            solveMethod(height - 1, start, placeholder, end);
            model.move(start, end);
            solveMethod(height - 1, placeholder, end, start);
        }
    } 
    //

}
