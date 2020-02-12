public class Menu {

    private int decorationSpace;
    private int lineSpacer = 80;
    private int screenNumber;

    public Menu()
    {
    }

    public void display()
    {
        boolean run=true;
        while (run)
        {
            screenNumber = 1;
            switch (screenNumber)
            {
                case 1:
                {
                    header("FOOTBALL CLUB");
                }
            }
        }


    }
    public void header(String header)
    {
        decorationSpace = (lineSpacer-header.length())/2;
        for (int i=0;i<lineSpacer;i++)
        {
            System.out.print("-");
        }
        System.out.println();
        blankSpace(decorationSpace);
        System.out.print(header);
        blankSpace(decorationSpace);
        System.out.println();
        for (int i=0; i<lineSpacer; i++)
        {
            System.out.print("-");
        }
        System.out.println();
    }

    public void blankSpace( int amount )
    {
        for (int i =0; i< amount; i++)
        {
            System.out.print(" ");
        }
    }


}
