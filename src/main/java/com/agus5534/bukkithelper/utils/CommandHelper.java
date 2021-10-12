package com.agus5534.bukkithelper.utils;

import com.google.common.annotations.Beta;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;


public abstract class CommandHelper  {
  public boolean onSpectator(Player player) {
      if(player.getGameMode() == GameMode.SPECTATOR) {
          return true;
      } else {
          return false;
      }
  }
  public boolean onSurvival(Player player) {
      if(player.getGameMode() == GameMode.SURVIVAL) {
          return true;
      } else {
          return false;
      }
  }
  public boolean onAdventure(Player player){
      if(player.getGameMode() == GameMode.ADVENTURE) {
          return true;
      } else {
          return false;
      }
  }
  public boolean onCreative(Player player) {
      if(player.getGameMode() == GameMode.CREATIVE) {
          return true;
      } else {
          return false;
      }
  }

  public void sethealth(Player player, double health) {
     player.setHealth(health);
  }

  public void setName(Player player,@NotNull String name) {
      if(name.isEmpty()) {
          throw new StringIndexOutOfBoundsException("You need to put a String name");
      } else {
          if(name.length() >= 30) {
              throw new StringIndexOutOfBoundsException("You can not exceed 30 characters on String");
          } else {
              player.setPlayerListName(name);
          }
      }

  }

  public void addEffect(Player player, PotionEffectType effect, int duration, int amplifier) {
      player.addPotionEffect((new PotionEffect(effect, duration, amplifier)));
  }
  public UUID getUUID(Player player) {
      return player.getUniqueId();
  }
  public void setGamemode(Player player, GameMode gamemode) throws InvalidGameModeException{
     if(gamemode == GameMode.CREATIVE) {
         player.setGameMode(GameMode.CREATIVE);
     } else {
         if(gamemode == GameMode.SPECTATOR) {
             player.setGameMode(GameMode.SPECTATOR);
         } else if(gamemode == GameMode.ADVENTURE) {
             player.setGameMode(GameMode.ADVENTURE);
         } else if(gamemode == GameMode.SURVIVAL) {
             player.setGameMode(GameMode.SURVIVAL);
         } else {
             throw new InvalidGameModeException("Invalid GameMode");
         }
     }
  }

    /**
     *
     *
     * {@code ItemStack is = new ItemStackHelper(Material.LEATHER_BOOTS).amount(1).data(4).durability(2).enchants(Enchantment.PROTECTION_ENVIRONMENTAL, 2).name(ChatColor.GREEN + "Test").lore(ChatColor.GOLD + "Lore")}
     */
  public void giveItem(Player player, ItemStack is) {
   player.getInventory().addItem(is);

  }

    /**
     *
     * @param player
     * @param reason Kick reason line 1
     * @param reasonline2 Kick reason line 2
     * @param reasonline3 Kick reason line 3
     * @param reasonline4 Kick reason line 4
     * @param reasonline5 Kick reason line 5
     */
  public void kick(Player player, @Nullable String reason,@Nullable String reasonline2,@Nullable String reasonline3, @Nullable String reasonline4, @Nullable String reasonline5) {
      String total = reason + "\n " + reasonline2 + "\n " + reasonline3 + "\n " + reasonline4 + "\n " + reasonline5;
      player.kickPlayer(total);
  }










  //DEPRECATED ZONE
    /**
     * Minecraft 1.13 removed GameMode id's
     *
     * @deprecated use {@link #onSpectator(Player)} instead.
     */
    @Deprecated
    public boolean ongm3(Player player) {
        if(player.getGameMode() == GameMode.SPECTATOR) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Minecraft 1.13 removed GameMode id's
     *
     * @deprecated use {@link #onSurvival(Player)} instead.
     */
    @Deprecated
    public boolean ongm0(Player player) {
        if(player.getGameMode() == GameMode.SURVIVAL) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Minecraft 1.13 removed GameMode id's
     *
     * @deprecated use {@link #onAdventure(Player)} instead.
     */
    @Deprecated
    public boolean ongm2(Player player){
        if(player.getGameMode() == GameMode.ADVENTURE) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Minecraft 1.13 removed GameMode id's
     *
     * @deprecated use {@link #onCreative(Player)} instead.
     */
    @Deprecated
    public boolean ongm1(Player player) {
        if(player.getGameMode() == GameMode.CREATIVE) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Bukkit has an updated API for this
     *
     * @deprecated use {@link org.bukkit.entity.LivingEntity#removePotionEffect(PotionEffectType)} instead.
     */
  @Deprecated
  public void removeEffect(Player player, PotionEffectType effect) {
      player.removePotionEffect(effect);
  }
    /**
     *
     * @param player
     * @param title
     * @param subtitle
     * @param fadeIn
     * @param stay
     * @param fadeOut
     * @apiNote Not supports actionbars titles
     * @deprecated Use {@link org.bukkit.entity.Player#sendTitle(String, String, int, int, int)} instead
     */
    @Deprecated
    public void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }
    /**
     *
     *
     * @param gamemodeid 0 = SURVIVAL | 1 = CREATIVE | 2 = ADVENTURE | 3 = SPECTATOR
     * @throws InvalidGameModeException
     * @deprecated Use {@link #setGamemode(Player, GameMode)} instead
     */
    @Deprecated
    public void setGameMode(Player player, int gamemodeid) throws InvalidGameModeException {
        if(gamemodeid == 0) {
            player.setGameMode(GameMode.SURVIVAL);
        } else {
            if(gamemodeid == 1) {
                player.setGameMode(GameMode.CREATIVE);
            } else {
                if(gamemodeid == 2) {
                    player.setGameMode(GameMode.ADVENTURE);
                } else {
                    if(gamemodeid == 3) {
                        player.setGameMode(GameMode.SPECTATOR);
                    } else {
                        throw new InvalidGameModeException("GameMode ID is not valid, only allow from 0 to 3. You used the id: " + gamemodeid);
                    }
                }
            }
        }
    }



}
