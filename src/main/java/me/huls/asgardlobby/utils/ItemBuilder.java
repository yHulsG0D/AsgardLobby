package me.huls.asgardlobby.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.inventory.ItemFlag;

public class ItemBuilder {
    private ItemStack is;

    public ItemBuilder(Material m) {
        this(m, 1, (short) 0);
    }

    public ItemBuilder(ItemStack is) {
        this.is = is.clone();
    }

    public ItemBuilder(Material m, int amount, short data) {
        this.is = new ItemStack(m, amount, data);
    }

    public ItemBuilder clone() {
        return new ItemBuilder(this.is);
    }

    public ItemBuilder durability(int dur) {
        this.is.setDurability((short) dur);
        return this;
    }

    public ItemBuilder flag(ItemFlag flag) {
        ItemMeta im = this.is.getItemMeta();
        im.addItemFlags(flag);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder glow() {
        ItemMeta im = this.is.getItemMeta();
        im.addEnchant(Enchantment.LURE, 1, false);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder name(String name) {
        ItemMeta im = this.is.getItemMeta();
        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder unsafeEnchantment(Enchantment ench, int level) {
        this.is.addUnsafeEnchantment(ench, level);
        return this;
    }

    public ItemBuilder enchant(Enchantment ench, int level) {
        ItemMeta im = this.is.getItemMeta();
        im.addEnchant(ench, level, true);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment ench) {
        this.is.removeEnchantment(ench);
        return this;
    }

    public ItemBuilder owner(String owner) {
        try {
            SkullMeta im = (SkullMeta) this.is.getItemMeta();
            im.setOwner(owner);
            this.is.setItemMeta((ItemMeta) im);
        } catch (ClassCastException classCastException) {
        }
        return this;
    }

    public ItemBuilder infinityDurabilty() {
        this.is.setDurability(Short.MAX_VALUE);
        return this;
    }

    public ItemBuilder lore(String... lore) {
        ItemMeta im = this.is.getItemMeta();
        List<String> out = (im.getLore() == null) ? new ArrayList<>() : im.getLore();
        byte b;
        int i;
        String[] arrayOfString;
        for (i = (arrayOfString = lore).length, b = 0; b < i;) {
            String string = arrayOfString[b];
            out.add(ChatColor.translateAlternateColorCodes('&', string));
            b++;
        }
        im.setLore(out);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder listLore(List<String> lore) {
        ItemMeta im = this.is.getItemMeta();
        List<String> out = (im.getLore() == null) ? new ArrayList<>() : im.getLore();
        for (String string : lore)
            out.add(ChatColor.translateAlternateColorCodes('&', string));
        im.setLore(out);
        this.is.setItemMeta(im);
        return this;
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder dyeColor(DyeColor color) {
        this.is.setDurability(color.getDyeData());
        return this;
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder woolColor(DyeColor color) {
        if (!this.is.getType().equals(Material.WOOL))
            return this;
        this.is.setDurability(color.getDyeData());
        return this;
    }

    public ItemBuilder amount(int amount) {
        if (amount > 64)
            amount = 64;
        this.is.setAmount(amount);
        return this;
    }

    public ItemBuilder removeAttributes() {
        ItemMeta meta = this.is.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        this.is.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return this.is;
    }

    public ItemBuilder color(Color color) {
        if (!this.is.getType().name().contains("LEATHER_"))
            return this;
        LeatherArmorMeta meta = (LeatherArmorMeta) this.is.getItemMeta();
        meta.setColor(color);
        this.is.setItemMeta((ItemMeta) meta);
        return this;
    }

    public ItemBuilder head(String texture) {
        if (texture == null || texture.isEmpty())
            return this;

        SkullMeta skullMeta = (SkullMeta) this.is.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", texture).getBytes());

        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));

        Field profileField = null;

        try {

            profileField = skullMeta.getClass().getDeclaredField("profile");

        } catch (NoSuchFieldException | SecurityException e) {

            e.printStackTrace();

        }

        profileField.setAccessible(true);

        try {

            profileField.set(skullMeta, profile);

        } catch (IllegalArgumentException | IllegalAccessException e) {

            e.printStackTrace();

        }

        this.is.setItemMeta((ItemMeta) skullMeta);

        return this;
    }
}