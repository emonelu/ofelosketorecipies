package com.example.reciperadar.ui.explore

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.reciperadar.R // Import your R class for resources

class ExploreFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var recipeArrayList: ArrayList<Recipe>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val exploreViewModel =
            ViewModelProvider(this).get(ExploreViewModel::class.java)

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_explore, container, false)

        // Get the reference to the ListView
        listView = root.findViewById(R.id.recipe_list_view)

        // Sample data for the ListView
        val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        val imageId = intArrayOf(
            R.drawable.beef,
            R.drawable.brocoli,
            R.drawable.cake,
            R.drawable.chapati,
            R.drawable.chicken,
            R.drawable.pork,
            R.drawable.rice,
            R.drawable.ugali
        )
        val recipe_title = arrayOf(
            "Beef Stew",
            "Brocolli",
            "Cake",
            "Chapati",
            "Chicken Stew",
            "Pork Stew",
            "Rice",
            "Ugali"
        )
        val meal_type = arrayOf(
            "Lunch/Supper",
            "Breakfast",
            "Breakfast",
            "Supper",
            "Dinner",
            "Brunch",
            "Supper",
            "Lunch"
        )
        val difficulty = arrayOf(
            "Intermediate",
            "Beginner",
            "Advanced",
            "Intermediate",
            "Intermediate",
            "Beginner",
            "Beginner",
            "Beginner"
        )
        val people_served = intArrayOf(
            10,12,12,3,5,6,8,1
        )
        val ingredients= arrayOf(
            "2 pounds boneless beef sirloin steak, cut into 1-inch cubes\n" +
                    "3 tablespoons flour\n" +
                    "2 tablespoons vegetable oil, divided\n" +
                    "1 package Royco® Classic Beef Stew Seasoning Mix\n" +
                    "3 cups water\n" +
                    "5 cups frozen vegetables for stew",
            "600 gms broccoli15 ml oil100 gms onion, sliced2 Green chillies (slit)1 sprig curry leaves2 Bay leaves5 gms cardamom400 ml coconut milkto taste salt",
            "1 ½ cups sifted pastry flour\n" +
                    "\n" +
                    "1 cup white sugar\n" +
                    "\n" +
                    "¼ cup unsweetened cocoa powder\n" +
                    "\n" +
                    "1 teaspoon baking powder\n" +
                    "\n" +
                    "1 teaspoon baking soda\n" +
                    "\n" +
                    "¼ teaspoon salt\n" +
                    "\n" +
                    "1 cup water\n" +
                    "\n" +
                    "⅓ cup vegetable oil\n" +
                    "\n" +
                    "¼ cup white vinegar\n" +
                    "\n" +
                    "1 teaspoon vanilla extract",
            "2 1/2 cup whole wheat flour\n" +
                    "salt as required\n" +
                    "water as required\n" +
                    "1 tablespoon ghee",
            "2 tbsp. butter\n" +
                    "2 large carrots, peeled and sliced into coins\n" +
                    "1 stalk celery, chopped\n" +
                    "Kosher salt\n" +
                    "Freshly ground black pepper\n" +
                    "3 cloves garlic, minced\n" +
                    "1 tbsp. all-purpose flour",
            "2 pounds boneless pork shoulder, trimmed and cut into 1 1/2-inch cubes\n" +
                    "\n" +
                    "3 tablespoons all-purpose flour\n" +
                    "\n" +
                    "2 teaspoons kosher salt, divided\n" +
                    "\n" +
                    "1 teaspoon ground pepper\n" +
                    "\n" +
                    "3 tablespoons extra-virgin olive oil\n" +
                    "\n" +
                    "1 medium sweet onion, chopped\n" +
                    "\n" +
                    "4 large cloves garlic, finely chopped\n" +
                    "\n" +
                    "1 tablespoon finely chopped packed fresh mixed herbs (such as sage, thyme and/or rosemary)\n" +
                    "\n" +
                    "1 tablespoon tomato paste\n" +
                    "\n" +
                    "¾ cup dry white wine\n" +
                    "\n" +
                    "4 cups unsalted chicken stock\n" +
                    "\n" +
                    "2 bay leaves\n" +
                    "\n" +
                    "1 pound baby red potatoes, quartered (or halved if very small)\n" +
                    "\n" +
                    "1 pound medium carrots, peeled and sliced (3/4-inch)\n" +
                    "\n" +
                    "12 ounces parsnips, peeled and sliced (3/4-inch)\n" +
                    "\n" +
                    "1 (8 ounce) package cremini mushrooms, washed, trimmed and quartered (or halved if small)\n" +
                    "\n" +
                    "1 tablespoon cornstarch\n" +
                    "\n" +
                    "1 cup frozen peas\n" +
                    "\n" +
                    "1 tablespoon balsamic vinegar\n" +
                    "\n" +
                    "Chopped fresh parsley for garnish",
            "½ cup short-grain rice (preferably sushi rice), washed well\n" +
                    "\n" +
                    "¾ cup water",
            "4\n" +
                    "cups finely ground cornmeal (If you can find the kind that is so finely ground as to be like flour, grab it!!)\n" +
                    "8\n" +
                    "cups water"
        )
        val preparation_steps = arrayOf(
            "Coat beef with flour. Heat 1 tablespoon of the oil in large nonstick skillet or Dutch oven on medium-high heat. Add 1/2 of the beef; brown on all sides. Repeat with left over beef, adding remaining 1 tablespoon oil. Return all beef to skillet.\n" +
                    "2\tStir in Beef Stew Seasoning Mix and water. Add vegetables; bring to boil. Reduce heat to low; cover and simmer 15 minutes or until vegetables are tender.",
            "1.Clean and cut the broccoli into small pieces.2.Put oil in a pan and add sliced onion, slit green chilly, curry leaves, cinnamon stick and cardamom.3.Saute till the onion gets translucent.4.Add little water and coconut milk and stir in the broccoli.5.When the broccoli is almost done, add rest of the coconut milk turn off heat after a nice stir.6.Garnish with curry leaves and serve hot",
            "Preheat oven to 350 degrees F (175 degrees C). Have ready an un-greased 8 inch square pan.\n" +
                    "\n" +
                    "Sift together the flour, sugar, cocoa, baking powder, baking soda and salt into an un-greased pan. Make a well in the center and pour in the water, oil, vinegar and vanilla. Mix until blended.\n" +
                    "\n" +
                    "Bake in the preheated oven for 25 to 30 minutes, or until a toothpick inserted into the center of the cake comes out clean. Allow to cool.",
            "Step 1 Knead a smooth dough\n" +
                    "To begin with, take a large-sized bowl. Put two cups of flour along with a cup of water, salt and ghee in it. Mix well and start kneading a dough. Make sure that the dough is not too thick nor too thin. It has to be of a soft and pliable consistency. Add water to get the consistency right. Keep kneading for a while.\n" +
                    "\n" +
                    "bhatura\n" +
                    "Step 2 Flatten the dough balls\n" +
                    "Now roll out few balls from the prepared dough. Place them on a flat surface, flatten them further with the help of a rolling pin. Keep using the flour in order to prevent the rolls from sticking to the surface. Once the chapatis get the perfect round shape, place a pan on medium flame.\n" +
                    "\n" +
                    "roti\n" +
                    "Step 3 Cook the chapati\n" +
                    "Once heated enough, put the chapati on the pan and cook from both sides. Use a pair of tongs to flip over to the other side. Keep the flame to medium as too much heat might burn the chapati. Check for the little brown spots. Once they start appearing, the chapati will start to puff, indicating that it's completely cooked. Once done, transfer in a kitchen towel to keep them warm. Serve along any gravy or curry of your choice.\n" +
                    "\n" +
                    "Step 4 Note\n" +
                    "If you are someone who loves the richness of Ghee, then you can add some ghee while kneading the dough and with a pinch of salt this adds a nice aroma and taste to the Chapatis.",
            "In a large pot over medium heat, melt butter. Add carrots and celery and season with salt and pepper. Cook, stirring often, until vegetables are tender, about 5 minutes. Add garlic and cook until fragrant, about 30 seconds.\n" +
                    "Step 2\n" +
                    "Add flour and stir until vegetables are coated, then add chicken, thyme, bay leaf, potatoes, and broth. Season with salt and pepper. Bring mixture to a simmer and cook until the chicken is no longer pink and potatoes are tender, 15 minutes.\n" +
                    "Step 3\n" +
                    "Remove from heat and transfer chicken to a medium bowl. Using two forks, shred chicken into small pieces and return to pot. \n" +
                    "Step 4\n" +
                    "Garnish with parsley before serving.",
            "Toss pork cubes with flour, 1 teaspoon salt and pepper in a large bowl until evenly coated.\n" +
                    "\n" +
                    "Heat oil in a large Dutch oven over medium-high heat. Add half of the pork; cook, undisturbed, until browned on the bottom, about 3 minutes. Stir and continue cooking, stirring occasionally, until browned on all sides, about 3 minutes. Transfer the meat to a clean bowl; repeat with the remaining pork.\n" +
                    "\n" +
                    "Reduce heat to medium. Add onion to the pot; cook, stirring often, until softened, 3 to 5 minutes. Add garlic and herbs; cook, stirring constantly, until fragrant, about 1 minute. Add tomato paste; cook, stirring constantly, until the tomato paste darkens, about 1 minute. Add wine; cook, scraping the bottom of the pot, until reduced by about half, about 1 minute. Add stock, bay leaves and the remaining 1 teaspoon salt; return the browned pork and any accumulated juices to the pot. Increase heat to medium-high and bring to a boil; reduce heat to low, cover and cook until the pork is almost tender, 30 to 40 minutes.\n" +
                    "\n" +
                    "Stir in potatoes, carrots, parsnips and mushrooms. Cover and cook, stirring occasionally, until the vegetables are tender, 30 to 40 minutes. Transfer 1/4 cup of the liquid to a small bowl; whisk in cornstarch to make a slurry. Stir the slurry back into the stew; increase heat to medium. Stir in peas; cook until the peas are bright green and the liquid is slightly thickened, about 2 minutes. Remove from heat; stir in vinegar and remove and discard bay leaves. Garnish with chopped parsley, if desired.",
            "Place rice and water in a small pot with a tight-fitting lid and bring to a boil over high heat. Reduce heat, cover, and simmer until rice is almost tender, about 15 minutes. Remove pot from heat but do not remove lid. Let rice steam 10 minutes, then fluff with a fork.",
            "Heat water to boiling in a saucepan. Slowly pour the corn flour into boiling water. Avoid forming lumps.\n" +
                    "Stir continuously and mash any lumps that do form. Add more corn flour until it is thicker than mashed potatoes.\n" +
                    "Cook for three or four minutes, continue to stir. (Continuing to stir as the ugali thickens is the secret to success, i.e., lump-free ugali.)\n" +
                    "Top with a pat of butter or margarine, if desired.\n" +
                    "Cover and keep warm.\n" +
                    "Serve immediately with any meat or vegetable stew, or any dish with a sauce or gravy."
        )
        // Create an ArrayAdapter to populate the ListView with data
        recipeArrayList=ArrayList()
        for (i in meal_type.indices){
            val recipe = Recipe(meal_type[i],recipe_title[i], people_served[i], difficulty[i], ingredients[i], preparation_steps[i], imageId[i] )
            recipeArrayList.add(recipe)
        }

        listView.isClickable = true
        listView.adapter = RecipeAdapter(requireContext() as Activity, recipeArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->
            val meal_type = meal_type[position]
            val difficulty = difficulty[position]
            val imageId = imageId[position]
            val recipe_title = recipe_title[position]
            val people_served = people_served[position]
            val ingredients = ingredients[position]
            val preparation_steps = preparation_steps[position]


            val i = Intent(requireContext() as Activity, RecipeActivity::class.java)
            i.putExtra("meal_type", meal_type)
            i.putExtra("difficulty", difficulty)
            i.putExtra("image_id", imageId)

            i.putExtra("recipe_title", recipe_title)
            i.putExtra("people_served", people_served)
            i.putExtra("ingredients", ingredients)
            i.putExtra("preparation_steps", preparation_steps)


            startActivity(i)

        }
//        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, data)
//
//        // Set the adapter to the ListView
//        listView.adapter = adapter

        return root
    }
}
