public class TowerModel {

    // 2d array storing game state
    private IntegerStack[] towers;

    // Final tower height
    private int towerHeight = 0;

    // Debug metrics
    private int printCounter = 0;
    private int moveCounter = 0;

    /* This class implements a model of a tower of Hanoi game.

        |    |    |
        =    |    |
       ===   |    |
      =====  |    |
     ------------------
        0    1    2

     Example of a game of height three in the starting position.

    */
    public TowerModel(int height)
    {
        towerHeight = height;
        towers = new IntegerStack[3];
        towers[0] = new IntegerStack(height);
        towers[1] = new IntegerStack(height);
        towers[2] = new IntegerStack(height);

        for (int i=0; i<height; i++)
        {
            towers[0].push(height - i);
        }
    }

    // get the total number of disks
    public int height()
    {
        return towerHeight;
    }


    // Move one disk from the source stack to the destination stack.
    public void move(int source, int destination)
    {
        System.out.println("Move #" + ++moveCounter + " from " + source + " to " + destination);
        // TODO!!
        //source and destination ints are 0, 1, and 2
        /* if (towers[destination].peek() > towers[source].peek()){
            int start = towers[source].pop();
            towers[destination].push(start);
        } */
        if (source > 2 || destination < 0) {
            return;
        }

        int placeholderDisk = towers[source].pop();
        if (placeholderDisk == 0 || 
        (towers[destination].peek() != 0 && towers[destination].peek() < placeholderDisk)) {
            if (placeholderDisk != 0) {
                towers[source].push(placeholderDisk);
            }
            return;
        }

        towers[destination].push(placeholderDisk);
    }

    // Helper method to nicely print the current model state.
    public void print()
    {
        System.out.print("Print #" + ++printCounter + " Towers of Hanoi\n");

        for (int layer = towerHeight-1; layer >= 0; layer--){
            System.out.print("\n");
            for (int tower = 0; tower < towers.length; tower++) {
                int value = towers[tower].get(layer);
                if (value == 0)
                {
                    System.out.print(" |");
                } else
                {
                    System.out.print(" " + value);
                }
            }
        }
        System.out.println();
        for (int i = 0; i < towers.length; i++) {
            System.out.print(" =");
        }
        System.out.println();
    }

    // Test instrumentation
    public IntegerStack[] getTowers()
    {
        return towers;
    }

    public int getHeight()
    {
        return towerHeight;
    }
}
