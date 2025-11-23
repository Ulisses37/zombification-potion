# Zombification Potion (Fabric)

![Fabric](https://img.shields.io/badge/Loader-Fabric-important) ![MC Version](https://img.shields.io/badge/Minecraft-1.21.1-green) ![Java](https://img.shields.io/badge/Java-21-orange)

A lightweight Fabric mod that adds a brewable **Potion of Zombification**.

This mod solves a specific gameplay bottleneck for modpacks that disable hostile mobs or for players on **Peaceful** difficulty, allowing access to Villager curing mechanics (discounted trades) without needing a Zombie to attack the villager.

## ✨ Features
* **New Potion Effect:** Instantly converts a Villager into a Zombie Villager.
* **Safety First:** The effect is "Instant" (like Harming/Healing). If a player accidentally drinks it or gets splashed, the effect is applied and cleared immediately, preventing lingering UI icons.
* **Vanilla-Friendly:** Uses standard brewing mechanics and integrates seamlessly with the vanilla game loop.
* **Splash Support:** Works with Splash and Lingering potions for mass-converting trading halls.

## ⚗️ Brewing Recipe
You can brew the Potion of Zombification using a **Brewing Stand**:

| Ingredient | Base Potion | Result |
| :--- | :--- | :--- |
| **Rotten Flesh** | **Splash Potion of Weakness** | **Splash Potion of Zombification** |

*(Note: The logic also supports Drinkable, Lingering, and Tipped Arrow variants automatically.)*

## 🛠️ Technical Details
* **Loader:** Fabric Loader (0.16.9+)
* **Minecraft Version:** 1.21.1
* **Implementation:** * Instead of using a projectile hit event, this mod registers a custom `StatusEffect`.
    * The effect logic checks for `VillagerEntity` instances via `applyUpdateEffect`.
    * It utilizes the native `villager.convertTo(EntityType.ZOMBIE_VILLAGER)` method to ensure NBT data (trades, gossip, reputation) is preserved during transformation.

## 📦 Installation
1.  Download the latest `.jar` from the [Releases](https://github.com/ulisses37/zombification-potion/releases) tab (or CurseForge/Modrinth).
2.  Install [Fabric Loader](https://fabricmc.net/).
3.  Place the `.jar` file into your Minecraft `mods` folder.
4.  Ensure you have the [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) installed.

## 👨‍💻 Building from Source
If you are a developer or want to inspect the code:

1.  Clone the repository:
    ```bash
    git clone [https://github.com/odysseus37/zombification-potion.git](https://github.com/ulisses37/zombification-potion.git)
    ```
2.  Navigate to the directory and build using Gradle:
    ```bash
    # Windows
    ./gradlew build

    # Linux/Mac
    ./gradlew build
    ```
3.  The compiled artifact will be located in `build/libs/`.

## 📄 License
This project is available under the MIT License. Feel free to include it in modpacks.

---
*Created by [Odysseus37](https://github.com/ulisses37)*
