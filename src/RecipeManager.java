
// Recipe Manager program with user system and recipe persistence
// Features include user login, recipe storage, and batch size reduction
// Recipes are stored in a map with the user's username as the key
// User data is stored in a separate map with the username and password
// Both maps are serialized to files for persistence across program runs

// Version update: Recipe Converter Program v0.2
// New feature: User system with login and sign-up options

import java.util.*;
import java.io.*;

public class RecipeManager {

    public static void main(String[] args) {

        // Version update
        System.out.println("Recipe Converter Program v0.2");

        Scanner myObj = new Scanner(System.in);
        boolean run = true;

        // New feature: User system
        Map<String, String> userDatabase = loadUserDatabase(); // Load existing users
        String currentUser = null;
        Map<String, RecipeConverter[]> userRecipes = loadRecipes(); // Load stored recipes

        while (currentUser == null) {

            System.out.println("Do you have an account? [Y/N]");
            String hasAccount = myObj.nextLine();

            if (hasAccount.equalsIgnoreCase("Y")) {

                // Login process
                System.out.print("Enter username: ");
                String username = myObj.nextLine();
                System.out.print("Enter password: ");
                String password = myObj.nextLine();

                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {

                    System.out.println("Login successful!");
                    currentUser = username;

                } else {

                    System.out.println("Invalid credentials. Try again.");

                }

            } else {
                // Sign-up process
                System.out.print("Choose a username: ");
                String username = myObj.nextLine();
                System.out.print("Choose a password: ");
                String password = myObj.nextLine();

                if (!userDatabase.containsKey(username)) {

                    userDatabase.put(username, password);
                    saveUserDatabase(userDatabase); // Save the new user
                    System.out.println("Account created! Please log in.");

                } else {

                    System.out.println("Username already taken. Try again.");

                }
            }
        }

        // Initialize the user's recipes if they don't already exist
        userRecipes.putIfAbsent(currentUser, new RecipeConverter[10]);
        RecipeConverter[] recipes = userRecipes.get(currentUser);

        while (run) {

            System.out.println("Choose a recipe slot (1-10): ");
            int rChoice = myObj.nextInt() - 1;
            myObj.nextLine();

            if (rChoice < 0 || rChoice >= 10) {

                System.out.println("Invalid slot. Please select between 1 and 10.");
                continue;

            }

            if (recipes[rChoice] != null) {

                System.out.println("Slot already filled. Overwrite? [Y/N]");
                String overwrite = myObj.nextLine();
                if (overwrite.equalsIgnoreCase("N")) {

                    System.out.println("Choose another slot.");
                    continue;

                }
                
            }

            System.out.print("Number of ingredients: ");
            int numIngredients = myObj.nextInt();
            myObj.nextLine();

            System.out.print("Number of items made: ");
            int batchNum = myObj.nextInt();
            myObj.nextLine();

            String[] ingredients = new String[numIngredients];
            double[] quant = new double[numIngredients];
            String[] measurements = new String[numIngredients];

            for (int i = 0; i < numIngredients; i++) {
                System.out.print("Ingredient " + (i + 1) + ": ");
                ingredients[i] = myObj.nextLine();

                System.out.print("Quantity: ");
                quant[i] = myObj.nextDouble();
                myObj.nextLine();

                System.out.print("Measurement: ");
                measurements[i] = myObj.nextLine();
            }

            RecipeConverter newRecipe = new RecipeConverter(numIngredients, batchNum, ingredients, quant, measurements);

            System.out.print("Reduce by: \n[1] 1/2\n[2] 1/3\n[3] 1/4\n[4] 1/5\n[5] 1/6\n[6] 1/7\n[7] 1/8\n[8] 1/9\n[9] 1/10\n");
            int factor = myObj.nextInt();
            myObj.nextLine();

            double[] factors = {0.5, 0.333333, 0.25, 0.2, 0.166666, 0.142857, 0.125, 0.111111, 0.1};
            if (factor > 0 && factor <= factors.length) {
                newRecipe.reduce(factors[factor - 1]);
            } else {
                System.out.println("Invalid factor. No reduction applied.");
            }

            newRecipe.output();
            recipes[rChoice] = newRecipe;

            // Save recipes to file
            saveRecipes(userRecipes);

            System.out.print("Run again? [Y/N]: ");
            String runAgain = myObj.nextLine();
            if (runAgain.equalsIgnoreCase("N")) {
                run = false;
            }

            // Clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        myObj.close();
    }

    // Utility methods for user and recipe persistence

    // Save user database to a file
    private static void saveUserDatabase(Map<String, String> userDatabase) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userDatabase.dat"))) {
            oos.writeObject(userDatabase);
        } catch (IOException e) {
            System.out.println("Error saving user database: " + e.getMessage());
        }
    }

    // Load user database from a file
    private static Map<String, String> loadUserDatabase() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userDatabase.dat"))) {
            return (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    // Save recipes to a file
    private static void saveRecipes(Map<String, RecipeConverter[]> userRecipes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("recipes.dat"))) {
            oos.writeObject(userRecipes);
        } catch (IOException e) {
            System.out.println("Error saving recipes: " + e.getMessage());
        }
    }

    // Load recipes from a file
    private static Map<String, RecipeConverter[]> loadRecipes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("recipes.dat"))) {
            return (Map<String, RecipeConverter[]>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }
}

// RecipeConverter class with fraction conversion
class RecipeConverter implements Serializable {
    private int numIngredients;
    private int batchNum;
    private String[] ingredients;
    private double[] quantities;
    private String[] measurements;

    public RecipeConverter(int numIngredients, int batchNum, String[] ingredients, double[] quantities, String[] measurements) {
        this.numIngredients = numIngredients;
        this.batchNum = batchNum;
        this.ingredients = ingredients;
        this.quantities = quantities;
        this.measurements = measurements;
    }

    public void reduce(double factor) {
        for (int i = 0; i < quantities.length; i++) {
            quantities[i] *= factor;
        }
    }

    public void output() {
        System.out.println("Reduced Recipe:");
        for (int i = 0; i < numIngredients; i++) {
            System.out.printf("%s: %s %s\n", ingredients[i], toFraction(quantities[i]), measurements[i]);
        }
    }

    // Convert decimals to fractions
    private String toFraction(double value) {
        int numerator = (int) Math.round(value * 100);
        int denominator = 100;
        int gcd = gcd(numerator, denominator);
        //gcd stands for greatest common divisor

        numerator /= gcd;
        denominator /= gcd;

        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
