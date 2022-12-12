import java.util.Scanner;

//TODO
// MAKE THE ACTUAL GAME
public class Grid {

    // Define some characteristics of the grid
    int height;
    int width;
    int difficulty;

    int[][] BackArray;
    int[][] FrontArray;



    Grid(){
        Tile tileobject = new Tile();
        //Create a scanner to take input from player
        Scanner gridReader = new Scanner(System.in);
        
        //Taking input from the player
        System.out.println("Enter the height of the Grid as an int: ");
        int h = gridReader.nextInt();

        System.out.println("Enter the width of the Grid as an int: ");
        int w = gridReader.nextInt();
        
        System.out.println("Enter the difficuly of the Grid between 1-99: ");
        int d = gridReader.nextInt();

        gridReader.close();

        //Assign the input to grid characteristics
        height = h;
        width = w;
        difficulty = d;

        //create a new grid defined by the characteristics of width and height
        BackArray = new int[width][height];
    }

    void BlankTile(){
        //Fill the entire array with 0
        for(int i=0; i<BackArray.length; i++){
            for(int j=0; j<BackArray[i].length; j++){
                BackArray[i][j] = 0;
            }
        }
    }
    
    void MineTile(){
        //Calculating the number of mines as a percent of the total area of the grid by rounding up
        int numMines = (int) Math.round(difficulty*width*height/100.0);
    
        //TEMPORARY TEST TO MAKE SURE IT WORKS
        System.out.println("These are the number of mines: " + numMines);

        int RemainingMinesToPlace = numMines;

        //TEMPORARY TEST TO MAKE SURE IT WORKS
        System.out.println("Remaning Number of Mines: " + RemainingMinesToPlace);

        //Creating variables that will give me a random hegiht and a random width at which I will place the mines
        int randomHeight;
        int randomWidth;

        /*
            While there are mines left to place, give me a random height and width. 
            Check if the location is 0 in order to prevent overlapping mines that 
            would decrease the desired difficulty. After placing the mine,
            decrease the RemainingMinesToPlace by one.
        */
        while(RemainingMinesToPlace>0){
            randomWidth = (int) Math.floor(Math.random() * width);
            randomHeight = (int) Math.floor(Math.random() * height);

            System.out.println("Da random width: " + randomWidth);
            System.out.println("Da random height: " + randomHeight);

            if(BackArray[randomWidth][randomHeight] == 0){
                BackArray[randomWidth][randomHeight] = -1;
                RemainingMinesToPlace--;
            }
        }
    }
    
    //Check and assign values to the array for how many mines next to it
    void MinesAroundTile(){
        
        int checkHeight;
        int checkWidth;
        int start_x;
        int start_y;
        int end_x;
        int end_y;
        int numMinesAroundTile;

        for(int a=0; a<BackArray.length; a++){
            for(int b=0; b<BackArray[a].length; b++){
                if(BackArray[a][b]!=-1){
                    checkHeight = a;
                    checkWidth = b;
                    
                    start_x = checkHeight-1;
                    start_y = checkWidth-1;
                    end_x = checkHeight+1;
                    end_y = checkWidth+1;
                    numMinesAroundTile = 0;
            
                    if(checkHeight-1<0){
                        start_x = checkHeight;
                    }
            
                    if(checkWidth-1<0){
                        start_y = checkWidth;
                    }
            
                    if(checkHeight+1>=BackArray.length){
                        end_x = checkHeight;
                    }
            
                    if(checkWidth+1>=BackArray[0].length){
                        end_y = checkWidth;
                    }
                    
                    System.out.println("\n");
                    System.out.println(checkHeight + " " + checkWidth);

                    for(int x = start_x; x<=end_x; x++){
                        for(int y = start_y; y<=end_y; y++){
                            if(BackArray[x][y]==-1){
                                numMinesAroundTile++;
                            }
                        }
                    }
    
                    BackArray[checkHeight][checkWidth] = numMinesAroundTile;
                }

                else{
                    System.out.println("Your mom could not check this tile b/c it was mine");
                }

            }
        }

        for(int a=0; a<BackArray.length; a++){
            for(int b=0; b<BackArray[a].length; b++){
                System.out.print(BackArray[a][b]);
            }
            System.out.println();
        }
        

    }
    

    void Game(){
        for(int a=0; a<BackArray.length; a++){
            for(int b=0; b<BackArray[a].length; b++){
                FrontArray[a][b] = 
        }
        
        // Create player grid with special objects
        // Make input from flipping tiles and flipping flags
        // Make function that opens the tiles next to it
        // Make exceptions to flipping flags and mines
        // Make win conditions and losing parts
        
        /*
        To use a method from another class in Java, you will need to use the class name followed by the dot operator (.) and the method name. For example, if you have a class called MyClass with a method called myMethod(), you can call this method from another class using the following syntax:

        Copy code
        MyClass.myMethod();
        Alternatively, you can create an instance of the MyClass class and call the method on the instance, like this:

        Copy code
        MyClass myClassObject = new MyClass();
        myClassObject.myMethod();
        Note that in order for the method to be accessible from other classes, it must either be declared as public or have the protected or default access modifier.

        I hope this helps! Let me know if you have any other questions.
        */

    }

    
}