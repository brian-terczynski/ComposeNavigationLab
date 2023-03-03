package com.example.plants.repository

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import com.example.plants.R
import com.example.plants.model.DictionaryTerm
import com.example.plants.model.Plant

object PlantRepository {
    private val dictionary = listOf(
        DictionaryTerm(
            "herbaceous", "of, denoting, or relating to herbs (in the botanical sense)"
        ),
        DictionaryTerm(
            "deciduous", "(of a tree or shrub) shedding its leaves annually."
        )
    )

    private val plants = listOf(
        Plant(
            id = 1422,
            name = "Hibiscus",
            description = """
                Hibiscus is a genus of flowering plants in the mallow family, Malvaceae.
                The genus is quite large, comprising several hundred species that are native
                to warm temperate, subtropical and tropical regions throughout the world.
                Member species are renowned for their large, showy flowers and those species are
                commonly known simply as "hibiscus", or less widely known as rose mallow.
                Other names include hardy hibiscus, rose of sharon, and tropical hibiscus.
                
                The genus includes both annual and perennial --[D]herbaceous-- plants, as well as
                woody --[L]shrub--s and small trees. The generic name is derived from the Greek name
                ἰβίσκος (ibískos) which Pedanius Dioscorides gave to Althaea officinalis
                (c. 40–90 AD).
            """.trimIndent(),
            imageId = R.drawable.hibiscus,
        ),
        Plant(
            id = 8192,
            name = "shrub",
            description = """
                A shrub (often also called a bush) is a small-to-medium-sized perennial woody
                plant. Unlike herbaceous plants, shrubs have persistent woody stems above the
                ground. Shrubs can be either deciduous or evergreen. They are distinguished from
                trees by their multiple stems and shorter height, less than 6–10 m (20–33 ft) tall.
                Small shrubs, less than 2 m (6.6 ft) tall are sometimes termed as subshrubs.
                Many botanical groups have species that are shrubs, and others that are trees and
                --[D]herbaceous-- plants instead.
            """.trimIndent(),
            imageId = R.drawable.shrub,
        ),
        Plant(
            id = 23,
            name = "rhododendron",
            description = """
                Rhododendron; from Ancient Greek ῥόδον rhódon "rose" and δένδρον déndron "tree")
                is a very large genus of about 1,024 species of woody plants in the heath family
                (Ericaceae). They can be either evergreen or --[D]deciduous--. Most species are native
                to eastern Asia and the Himalayan region, but smaller numbers occur elsewhere in
                Asia, and in North America, Europe and Australia. It is the national flower of
                Nepal, the state flower of Washington and West Virginia in the United States, the
                state flower of Nagaland in India, the provincial flower of Jiangxi in China and the
                state tree of Sikkim and Uttarakhand in India. Most species have brightly colored
                flowers which bloom from late winter through to early summer.

                --[L]Azalea--s make up two subgenera of Rhododendron. They are distinguished from "true"
                rhododendrons by having only five anthers per flower.
            """.trimIndent(),
            imageId = R.drawable.rhododendron,
        ),
        Plant(
            id = 55732,
            name = "azalea",
            description = """
                Azaleas are flowering --[L]shrub--s in the genus Rhododendron, particularly the
                former sections Tsutsusi (evergreen) and Pentanthera --[D]deciduous--. Azaleas bloom in
                the spring (April and May in the temperate Northern Hemisphere, and October and
                November in the Southern Hemisphere), their flowers often lasting several weeks.
                Shade tolerant, they prefer living near or under trees. They are part of the family
                Ericaceae.
            """.trimIndent(),
            imageId = R.drawable.azalea,
        )
    )

    fun getPlant(id: Int): Plant {
        return plants.find { it.id == id } ?: throw IllegalArgumentException("Plant $id not found")
    }

    fun getPlantByName(name: String): Plant {
        return plants.find {
            it.name.toLowerCase(Locale.current) == name.toLowerCase(Locale.current)
        } ?: throw IllegalArgumentException("Plant $name not found")
    }

    fun getDictionary(name: String): DictionaryTerm {
        return dictionary.find {
            it.term == name
        } ?: throw IllegalArgumentException("Term $name not found")
    }

    fun getAllPlants() = plants
}
