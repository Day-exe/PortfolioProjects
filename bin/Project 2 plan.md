Basic Idea: Convert recipies into smaller batches\
Comissioned by: Ms. Howard



Larger Scale:
The user will be able to input all of the ingredients with how much of each is required, then how 
many of the desert the provided recipe should make. Then it will prompt the user for how much smaller of a 
batch the user wants to make (probably prompting the user with pre-defined options). From there, the
program will take all of the provided values for the different ingredients and divide them, possibly
converting the units if necessary(?), then return them in a coherent manner.

Checklist:
- Make necessary methods
    - ~~A recipe class to store all of the recipes as objects~~
        - ~~A new recipe method (constructor)~~
        - ~~A method for dividing all of the quantities that the user inputs~~
        - A method for returning new values in a neat way
    - Possibly methods for converting units?
    - If we have time, maybe make a UI? {NOPE. UIS IN JAVA ARE GROSS}

Additional features added:
- Persistance (recipies are stored even after session closes)
- A login feature so that multiple users can have their data saved seperate from one another
- Archive for old versions
- A changelog for new versions