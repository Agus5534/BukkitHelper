package com.agus5534.bukkithelper.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemStackHelper extends ItemStack {
   public ItemStackHelper(final Material material) {
       super(material);
   }
   public ItemStackHelper(final ItemStack is) {
       super(is);
   }
   public ItemStackHelper amount(final int amount) {
       setAmount(amount);
       return this;
   }
   public ItemStackHelper name(final String name) {
       final ItemMeta meta = getItemMeta();
       meta.setDisplayName(name);
       setItemMeta(meta);
       return this;
   }
   public ItemStackHelper lore(final String txt){
       final ItemMeta meta = getItemMeta();
       List<String> lore = meta.getLore();
       if (lore == null) {
           lore = new ArrayList<String>();
       }
       lore.add(txt);
       meta.setLore(lore);
       setItemMeta(meta);
       return this;
   }
   public ItemStackHelper durability(final int durability) {
       setDurability((short) durability);
       return this;
   }


    public ItemStackHelper data(final int data) {
       setData(new MaterialData(getType(), (byte) data));
       return this;
   }

   public ItemStackHelper enchants(final Enchantment enchantment) {
       addUnsafeEnchantment(enchantment, 1);
       return this;
   }
   public ItemStackHelper type(final Material material) {
       setType(material);
       return this;
   }
   public ItemStackHelper removeLore() {
       final ItemMeta meta = getItemMeta();
       meta.setLore(new ArrayList<String>());
       setItemMeta(meta);
       return this;
   }

   public ItemStackHelper removeEnchantments() {
       for (final Enchantment e : getEnchantments().keySet()) {
           removeEnchantment(e);
       }
       return this;
   }
   public ItemStackHelper color(Color color) {
       if (getType() != Material.LEATHER_BOOTS && getType() != Material.LEATHER_CHESTPLATE
               && getType() != Material.LEATHER_HELMET && getType() != Material.LEATHER_LEGGINGS) {
           throw new IllegalArgumentException("Only for leather armor!");
       }
       LeatherArmorMeta meta = (LeatherArmorMeta) getItemMeta();
       meta.setColor(color);
       setItemMeta(meta);
       return this;
   }



}
