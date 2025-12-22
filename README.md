# Mob Talismans
A NeoForged mod that adds talisman accessories (curios) that provide utilities against specific mobs.

<br>

### Idea:
- [P1] Accessories that are somewhat expensive to make that make mobs less annoying or offer other utilities tied to mobs
    - [P1] Durability that is slowly used up, only while activated
    - [P1] Configurable whether they recharge or need to be repaired
- [P4] Pedestals that activate talismans without a player needing to wear them
    - Configurable FE power draw or item consumption to keep them active
    - Configurable effect range multiplier
- [P1] Talismans:
    - [P1] **Conduit**: hurts aggressive aquatic mobs in the vicinity
    - [P1] **Creeper**: prevents nearby creepers from doing block damage
    - [P1] **Enderman**: prohibits nearby endermen from picking up blocks
    - [P1] **Silverfish**: converts infested blocks nearby to their non-infested variant
    - [P2] **Phantom**: deters phantoms, just like cats do
    - [P2] **Vex**: makes vex despawn faster (or smaller radius around their summoning evoker)
    - [P2] **Wandering Trader**: prevents wandering traders from spawning in a big radius
- [P3] Conjuring Catalysts:
    - **Evoker**: used on beds & respawn anchors to make them a single-use fallback spawnpoint
        - Any other bed can be used as a temporary spawnpoint, but if they're broken, the player will respawn at their fallback bed/anchor
        - Chat message when the charmed bed/anchor is used or broken to inform the player

Installation information
=======

This template repository can be directly cloned to get you started with a new
mod. Simply create a new repository cloned from this one, by following the
instructions provided by [GitHub](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template).

Once you have your clone, simply open the repository in the IDE of your choice. The usual recommendation for an IDE is either IntelliJ IDEA or Eclipse.

If at any point you are missing libraries in your IDE, or you've run into problems you can
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything 
{this does not affect your code} and then start the process again.

Mapping Names:
============
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/NeoForged/NeoForm/blob/main/Mojang.md

Additional Resources: 
==========
Community Documentation: https://docs.neoforged.net/  
NeoForged Discord: https://discord.neoforged.net/
