package Archive;

import java.util.*; //Import utilities

public class RecipeConverter0_1{

    //scanner for user input
    static Scanner myObj = new Scanner(System.in);
    
        //instance variables
        private int numIngredients;
        private int batchNum;
        private int batchNumAlt;
        private String ingredients[];
        private double quant[];
        private double quantAlt[];
        private String measurements[];
        private String measurementsAlt[];
    
        //constructor
        public RecipeConverter0_1(int numIngredients, int batchNum, String ingredients[], double quant[], String measurements[]){
    
            this.numIngredients = numIngredients;
            this.batchNum = batchNum;
            this.ingredients = ingredients;
            this.quant = quant;
            this.measurements = measurements;
    
        }//end constructor
    
        //reduces the batch by the specified amount and adds the new values to a seperate list
        public void reduce(double factor){
    
            for(int i = 0; i <= numIngredients; i++){
    
                quantAlt[i] = quant[i]*factor;
    
            }//end for
    
            batchNumAlt = (int)(batchNum*factor);
    
            System.out.print("\nProcessing");
                        try
                        {Thread.sleep(300);}
                        catch(InterruptedException ex)
                        {Thread.currentThread().interrupt();}
                        
                        int delay = 0;
                        int min = numIngredients;
                        int max = numIngredients+1;
                        int dots = (int)Math.floor(Math.random()*(max-min+1)+min);
                        
                        while (delay < dots)
                        {
                            System.out.print(".");
                            try
                            {Thread.sleep(1000);}
                            catch(InterruptedException ex)
                            {Thread.currentThread().interrupt();}
                            delay++;
                        }//end theatrical delay
    
        }//end reduce
    
        //returns the new quantities in an orderly fashion
        public void output(){
    
            for(int i = 0; i <= numIngredients; i++){
    
                System.out.println(ingredients[i] + ": " + quantAlt[i] + " " + measurements[i]);
    
            }//end for loop
    
            System.out.println("\nWill make " + batchNumAlt + " instead of " + batchNum);
    
        }//end output
    
        public static void main(String[] args){
    
            System.out.print("\nLOADING");
                        try
                        {Thread.sleep(300);}
                        catch(InterruptedException ex)
                        {Thread.currentThread().interrupt();}
                        
                        int delay = 0;
                        int min = 3;
                        int max = 5;
                        int dots = (int)Math.floor(Math.random()*(max-min+1)+min);
                        
                        while (delay < dots)
                        {
                            System.out.print(".");
                            try
                            {Thread.sleep(1000);}
                            catch(InterruptedException ex)
                            {Thread.currentThread().interrupt();}
                            delay++;
                        }//end theatrical delay
    
            System.out.println("\nRecipe Coverter 0.1\n");
            //output current version
            //VERY IMPORTANT. DO NOT FORGET TO UPDATE WHEN PATCHES OR NEW RELEASES ARE MADE. FOLLOW SEMVER SCHEME (MAJOR.MINOR.PATCH)
    
            System.out.println("This is a program for breaking down recipies. It does exactly what it sounds like it does.");
            System.out.println("You can store a total of ten recipies in a single session.");
    
            //status for all of the recipies
            String statusR1 = "EMPTY";
            String statusR2 = "EMPTY";
            String statusR3 = "EMPTY";
            String statusR4 = "EMPTY";
            String statusR5 = "EMPTY";
            String statusR6 = "EMPTY";
            String statusR7 = "EMPTY";
            String statusR8 = "EMPTY";
            String statusR9 = "EMPTY";
            String statusR10 = "EMPTY";
    
            //used to terminate the run loop
            boolean run = true;
    
            while(run = true){
    
                System.out.println("\nRecipe 1 : " + statusR1 + "\nRecipe 2 : " + statusR2 + "\nRecipe 3 : " + statusR3 + "\nRecipe 4 : " + statusR4 + "\nRecipe 5 : " + statusR5 + "\nRecipe 6 : " + statusR6 + "\nRecipe 7 : " + statusR7 + "\nRecipe 8 : " + statusR8 + "\nRecipe 9 : " + statusR9 + "\nRecipe 10 : " + statusR10);
                int rChoice = myObj.nextInt();
                myObj.nextLine();

                if(rChoice != 1 && rChoice != 2 && rChoice != 3 && rChoice != 4 && rChoice != 5 && rChoice != 6 && rChoice != 7 && rChoice != 8 && rChoice != 9 && rChoice != 10){

                    System.out.println("Bad input. Try again.");

                }else if(rChoice == 1 && statusR1.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r1 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r1.reduce(0.5);

                    }else if(factor == 2){

                        r1.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r1.reduce(0.25);

                    }else if(factor == 4){
                        
                        r1.reduce(0.2);

                    }else if(factor == 5){

                        r1.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r1.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r1.reduce(0.125);

                    }else if(factor == 8){

                        r1.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r1.reduce(0.1);

                    }//end if else

                    r1.output();

                    statusR1 = "FULL";

                }else if(rChoice == 2 && statusR2.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r2 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r2.reduce(0.5);

                    }else if(factor == 2){

                        r2.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r2.reduce(0.25);

                    }else if(factor == 4){
                        
                        r2.reduce(0.2);

                    }else if(factor == 5){

                        r2.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r2.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r2.reduce(0.125);

                    }else if(factor == 8){

                        r2.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r2.reduce(0.1);

                    }//end if else

                    r2.output();

                    statusR2 = "FULL";

                }else if(rChoice == 3 && statusR3.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r3 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r3.reduce(0.5);

                    }else if(factor == 2){

                        r3.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r3.reduce(0.25);

                    }else if(factor == 4){
                        
                        r3.reduce(0.2);

                    }else if(factor == 5){

                        r3.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r3.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r3.reduce(0.125);

                    }else if(factor == 8){

                        r3.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r3.reduce(0.1);

                    }//end if else

                    r3.output();

                    statusR3 = "FULL";

                }else if(rChoice == 4 && statusR4.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r4 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r4.reduce(0.5);

                    }else if(factor == 2){

                        r4.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r4.reduce(0.25);

                    }else if(factor == 4){
                        
                        r4.reduce(0.2);

                    }else if(factor == 5){

                        r4.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r4.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r4.reduce(0.125);

                    }else if(factor == 8){

                        r4.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r4.reduce(0.1);

                    }//end if else

                    r4.output();

                    statusR4 = "FULL";

                }else if(rChoice == 5 && statusR5.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r5 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r5.reduce(0.5);

                    }else if(factor == 2){

                        r5.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r5.reduce(0.25);

                    }else if(factor == 4){
                        
                        r5.reduce(0.2);

                    }else if(factor == 5){

                        r5.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r5.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r5.reduce(0.125);

                    }else if(factor == 8){

                        r5.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r5.reduce(0.1);

                    }//end if else

                    r5.output();

                    statusR5 = "FULL";

                }else if(rChoice == 6 && statusR6.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r6 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r6.reduce(0.5);

                    }else if(factor == 2){

                        r6.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r6.reduce(0.25);

                    }else if(factor == 4){
                        
                        r6.reduce(0.2);

                    }else if(factor == 5){

                        r6.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r6.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r6.reduce(0.125);

                    }else if(factor == 8){

                        r6.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r6.reduce(0.1);

                    }//end if else

                    r6.output();

                    statusR6 = "FULL";

                }else if(rChoice == 7 && statusR7.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r7 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r7.reduce(0.5);

                    }else if(factor == 2){

                        r7.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r7.reduce(0.25);

                    }else if(factor == 4){
                        
                        r7.reduce(0.2);

                    }else if(factor == 5){

                        r7.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r7.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r7.reduce(0.125);

                    }else if(factor == 8){

                        r7.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r7.reduce(0.1);

                    }//end if else

                    r7.output();

                    statusR7 = "FULL";

                }else if(rChoice == 8 && statusR8.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r8 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r8.reduce(0.5);

                    }else if(factor == 2){

                        r8.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r8.reduce(0.25);

                    }else if(factor == 4){
                        
                        r8.reduce(0.2);

                    }else if(factor == 5){

                        r8.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r8.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r8.reduce(0.125);

                    }else if(factor == 8){

                        r8.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r8.reduce(0.1);

                    }//end if else

                    r8.output();

                    statusR8 = "FULL";

                }else if(rChoice == 9 && statusR9.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r9 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r9.reduce(0.5);

                    }else if(factor == 2){

                        r9.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r9.reduce(0.25);

                    }else if(factor == 4){
                        
                        r9.reduce(0.2);

                    }else if(factor == 5){

                        r9.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r9.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r9.reduce(0.125);

                    }else if(factor == 8){

                        r9.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r9.reduce(0.1);

                    }//end if else

                    r9.output();

                    statusR9 = "FULL";

                }else if(rChoice == 10 && statusR10.equals("EMPTY")){

                    System.out.print("Number of ingredients: ");
                    int numIngredients = myObj.nextInt();
                    myObj.nextLine();

                    System.out.print("Number of item made: ");
                    int batchNum = myObj.nextInt();
                    myObj.nextLine();

                    String ingredients[] = new String[numIngredients];
                    double quant[] = new double[numIngredients];
                    String measurements[] = new String[numIngredients];

                    for(int i = 0; i < numIngredients; i++){

                        System.out.print("Ingredient " + (i+1) + ": ");
                        ingredients[i] = myObj.nextLine();

                        System.out.print("Quantity: ");
                        quant[i] = myObj.nextDouble();
                        myObj.nextLine();

                        System.out.print("Measurement: ");
                        measurements[i] = myObj.nextLine();

                    }//end for loop

                    RecipeConverter0_1 r10 = new RecipeConverter0_1(numIngredients, batchNum, ingredients, quant, measurements);

                    System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
                    int factor = myObj.nextInt();
                    myObj.nextLine();

                    if(factor == 1){

                        r10.reduce(0.5);

                    }else if(factor == 2){

                        r10.reduce(0.3333333333333333);

                    }else if(factor == 3){

                        r10.reduce(0.25);

                    }else if(factor == 4){
                        
                        r10.reduce(0.2);

                    }else if(factor == 5){

                        r10.reduce(0.1666666666666667);

                    }else if(factor == 6){

                        r10.reduce(0.1428571428571429);

                    }else if(factor == 7){

                        r10.reduce(0.125);

                    }else if(factor == 8){

                        r10.reduce(0.1111111111111111);

                    }else if(factor == 9){

                        r10.reduce(0.1);

                    }//end if else

                    r10.output();

                    statusR10 = "FULL";

                }else{

                    System.out.println("Recipe already full. Please select another recipe.");

                }//end if else

                System.out.print("Run again? [Y/N]: ");
                String runAgain = myObj.nextLine();

                if(runAgain.equals("N")){

                    run = false;

                }//end if

                //clears the console
                System.out.print("\033[H\033[2J");
                System.out.flush();

        }//end run loop

    }//end main

}//end class